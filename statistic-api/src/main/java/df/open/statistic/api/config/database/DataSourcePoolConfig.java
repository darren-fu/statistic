package df.open.statistic.api.config.database;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "statistic.jdbc", locations = {"classpath:config/jdbc.properties"})
@Data
public class DataSourcePoolConfig {


    private String driverClassName;

    private String url;

    private String username;

    private String password;

    private String maxActive;

    private String minIdle;

    private String maxIdle;

    private String initialSize;
}
