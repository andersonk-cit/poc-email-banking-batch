package poc.emailbanking.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import poc.emailbanking.model.MessageEntity;
import poc.emailbanking.model.RequisicaoRelatorio;
import poc.emailbanking.repository.RequisicaoRelatorioRepository;

@Configuration
public class PublishStep {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private RequisicaoRelatorioRepository repository;

    @Bean
    public ItemReader<RequisicaoRelatorio> itemReader() {
        return new IteratorItemReader<RequisicaoRelatorio>(repository.getAll());
    }

    @Bean
    public ItemProcessor<RequisicaoRelatorio, String> itemProcessor() {
        return new CustomItemProcessor();
    }

    @Bean
    public ItemWriter<String> itemWriter() {
        return new CustomItemWriter();
    }

    @Bean
    protected Step step(ItemReader<RequisicaoRelatorio> itemReader,
                        ItemProcessor<RequisicaoRelatorio, String> itemProcessor,
                        ItemWriter<String> itemWriter) {
        return stepBuilderFactory.get("step")
                                 .<RequisicaoRelatorio, String>chunk(10)
                                 .reader(itemReader)
                                 .processor(itemProcessor)
                                 .writer(itemWriter)
                                 .build();
    }
}
