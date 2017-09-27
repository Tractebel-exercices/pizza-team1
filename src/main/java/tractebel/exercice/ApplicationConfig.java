package tractebel.exercice;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

/**
 * @author Tractebel - PSC
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ApplicationConfig.class);

    public static void main(String... args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class, args);
        LOG.info("discovering spring boot beans");
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            LOG.info(beanName);
        }
        LOG.info("Server is ready!");
    }

    @Bean
    public DatabaseConfiguration databaseConfiguration() {
        if (System.getenv("RDS_HOSTNAME") != null) {
                String driver = "org.postgresql.Driver";
                String dbName = System.getenv("RDS_DB_NAME");
                String userName = System.getenv("RDS_USERNAME");
                String password = System.getenv("RDS_PASSWORD");
                String hostname = System.getenv("RDS_HOSTNAME");
                String port = System.getenv("RDS_PORT");
                String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
                return new DatabaseConfiguration(driver, dbName, userName, password, hostname, port, jdbcUrl);
        }
        return null;
    }
}

