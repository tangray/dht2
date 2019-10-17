package bupt.fnl.dht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {"bupt.fnl.dht"})
//@MapperScan("bupt.fnl.dht.dao")
public class DhtApplication {
    public static void main(String[] args) {
        SpringApplication.run(DhtApplication.class, args);
    }
}
