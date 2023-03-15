<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>


spring.kafka.bootstrap-servers=my-kafka-server:9092

@Bean
public KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry(KafkaListenerEndpointRegistryConfigurer configurer) {
    KafkaListenerEndpointRegistry registry = new KafkaListenerEndpointRegistry();
    configurer.configure(registry);
    registry.setListenerContainerFactory(kafkaListenerContainerFactory());
    registry.getListenerContainers().forEach(container -> {
        container.setRestartContainerOnDisconnection(true);
        container.setAutoStartup(true);
    });
    return registry;
}

@Bean
public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
}

@Bean
public ConsumerFactory<String, String> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs());
}

@Bean
public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    // configure other properties as needed
    return props;
}
