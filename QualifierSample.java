@Service("emailService")
public class EmailService implements MessageService {
    // ...
}

@Service("smsService")
public class SmsService implements MessageService {
    // ...
}


@Component
public class MyComponent {
    
    @Autowired
    private MessageService messageService; // throws exception
    
    // ...
}


@Component
public class MyComponent {
    
    @Autowired
    @Qualifier("emailService")
    private MessageService messageService;
    
    // ...
}


@Component
public class MyComponent {
    
    private final MessageService messageService;
    
    @Autowired
    public MyComponent(@Qualifier("emailService") MessageService messageService) {
        this.messageService = messageService;
    }
    
    // ...
}
