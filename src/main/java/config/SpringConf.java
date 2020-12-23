package config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

@Configuration
public class SpringConf {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String password;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.jedis.pool.max-total}")
    private int maxTotal;

    @Value("${redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${redis.jedis.pool.min-idle}")
    private int minIdle;


    /**
     * Create jedis client with pool configuration
     * @return
     */
    @Bean
    public JedisClientConfiguration getJedisClientConfiguration() {
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder JedisPoolingClientConfigurationBuilder = (
                JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(maxTotal);
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);

        return JedisPoolingClientConfigurationBuilder.poolConfig(genericObjectPoolConfig).build();
    }

    /**
     * create jedis conn factory
     * @return
     */
    @Bean
    public JedisConnectionFactory getJedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        if (!StringUtils.isEmpty(password)) {
            redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        }
        redisStandaloneConfiguration.setPort(port);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    /**
     * create redis template
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //noinspection SpringConfigurationProxyMethods
        template.setConnectionFactory(getJedisConnectionFactory());
        return template;
    }
}
