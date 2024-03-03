package uk.shef.msc8.ewaste;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true)
@SpringBootApplication(
        scanBasePackages = {
                "uk.shef.msc8.ewaste.domain.user.repository.persistence",
                "uk.shef.msc8.ewaste.infrastructure.auth",
                "uk.shef.msc8.ewaste.interfaces.facade",
                "uk.shef.msc8.ewaste.domain.user.service",
                "uk.shef.msc8.ewaste.application",
                "uk.shef.msc8.ewaste.interfaces.facade",
                "uk.shef.msc8.ewaste.infrastructure.auth.config",
                "uk.shef.msc8.ewaste.infrastructure.config"
        },
        exclude = {DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class}
                )
@MapperScan(basePackages = {
        "uk.shef.msc8.ewaste.domain.user.repository.mapper",
        "uk.shef.msc8.ewaste.domain.payment.repository.mapper",
        "uk.shef.msc8.ewaste.domain.order.repository.mapper",
        "uk.shef.msc8.ewaste.domain.device.repository.mapper"
})
public class EwasteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EwasteApplication.class, args);
    }

}
