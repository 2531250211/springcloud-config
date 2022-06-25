package wjx.cloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@SpringBootApplication
@MapperScan("wjx.cloud.mapper")
@EnableCircuitBreaker
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class,args);
    }
}
