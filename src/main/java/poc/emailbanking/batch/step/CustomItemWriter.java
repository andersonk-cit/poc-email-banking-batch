package poc.emailbanking.batch.step;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poc.emailbanking.model.MessageEntity;
import poc.emailbanking.publisher.ExamplePublisher;

import java.util.List;

@Component
public class CustomItemWriter implements ItemWriter<String> {
    @Autowired
    private ExamplePublisher publisher;

    @Override
    public void write(List<? extends String> list) {
        list.forEach((item)-> publisher.publish(item));
    }
}
