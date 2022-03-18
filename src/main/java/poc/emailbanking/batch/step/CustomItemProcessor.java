package poc.emailbanking.batch.step;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import poc.emailbanking.model.RequisicaoRelatorio;

@Component
public class CustomItemProcessor implements ItemProcessor<RequisicaoRelatorio, String> {
    public String process(RequisicaoRelatorio item) {
//        return new MessageEntity(item);
        return item.toString();
    }
}
