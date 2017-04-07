package com.niuchaoqun;

import com.niuchaoqun.other.Other;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.niuchaoqun.config")
public class AppConfig {

    @Bean(name="myOther")
    public Other other() {
        return new Other();
    }
}
