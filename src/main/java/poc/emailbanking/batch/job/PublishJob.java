package poc.emailbanking.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class PublishJob {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Bean(name = "job")
    public Job job(Step step) {
        return jobBuilderFactory.get("job")
                                .start(step)
                                .build();
    }
}
