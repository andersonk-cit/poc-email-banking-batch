package poc.emailbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class EmailBankingApplication {

	public static void main(String[] args) {
		System.exit(
				SpringApplication.exit(
						SpringApplication.run(EmailBankingApplication.class, args)
				)
		);
	}

}
