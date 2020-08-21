package com.elasticsearch;

import com.elasticsearch.config.ElasticSearchConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by gyq on 2020/08/21.
 */
@SpringBootApplication
public class App {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        logger.info(" application running...");
    }


}
