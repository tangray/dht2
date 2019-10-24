package bupt.fnl.dht;

import bupt.fnl.dht.config.ThreadConfiguration.ThreadPoolConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"bupt.fnl.dht"})
@EnableAsync
public class DhtApplication {
    public static void main(String[] args) {
        SpringApplication.run(DhtApplication.class, args);
    }
}
