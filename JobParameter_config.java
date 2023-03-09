@Bean
@JobScope
public Step myStep() {
    return stepBuilderFactory.get("myStep")
        .tasklet((contribution, chunkContext) -> {
            Resource resource = inputFile;
            // ...
            return RepeatStatus.FINISHED;
        })
        .build();
}


@Autowired
private JobLauncher jobLauncher;

@Autowired
private Job myJob;

public void runJob() {
    Map<String, JobParameter> parameters = new HashMap<>();
    parameters.put("inputFile", new JobParameter(new FileSystemResource("data.csv")));
    JobParameters jobParameters = new JobParameters(parameters);
    jobLauncher.run(myJob, jobParameters);
}
