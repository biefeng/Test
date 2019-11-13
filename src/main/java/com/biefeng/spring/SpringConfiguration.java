package com.biefeng.spring;

import com.biefeng.spring.aop.Audience;
import org.springframework.context.annotation.*;

/**
 * @Author BieFeNg
 * @Date 2018-06-09 13:30
 * @Desc 对于使用javaConfig进行bean加载时，ApplicationContext的实现为AnnotationConfigApplicationContext,对于web应用，使用配置文件进行
 */
@Configuration
@EnableAspectJAutoProxy//开启aop注解
@ComponentScan //开启组建扫描，配合@Component/@Controller等组件注解使用
//@ImportResource  //可引入其他的spring配置文件
//@Import()  //可以引用其他的spring配置类
public class SpringConfiguration {

    @Bean
    public Audience getAudience() {
        return new Audience();
    }

}
