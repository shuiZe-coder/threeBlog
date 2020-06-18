package org.three.ourblog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = {
        "org.three.ourblog.user.mapper"
})
public class MybatisConfig {
}
