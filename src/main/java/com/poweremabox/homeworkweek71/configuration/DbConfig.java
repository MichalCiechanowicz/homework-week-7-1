package com.poweremabox.homeworkweek71.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    public void createDataBase() {
        String sql = "CREATE TABLE IF NOT EXISTS cars(car_id int NOT NULL AUTO_INCREMENT," +
                " make varchar(20),model varchar(20), " +
                "color varchar(15), manufacture_year int, PRIMARY KEY (car_id))";
        jdbcTemplate().update(sql);

    }
}
