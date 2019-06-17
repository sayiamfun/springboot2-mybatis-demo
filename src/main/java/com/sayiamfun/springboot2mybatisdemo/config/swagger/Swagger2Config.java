package com.sayiamfun.springboot2mybatisdemo.config.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {



    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("springboot2-mybatis-demo")//组名
                .apiInfo(adminApiInfo())// 调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .select()//开启选择
                .apis(RequestHandlerSelectors.basePackage("com.sayiamfun.springboot2mybatisdemo.controller"))
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//排除error下的多所有接口方法
                .build();
    }
    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("springboot2整合mybatis")//大标题
                .description("此文档描述了学习springboot2整合mybatis")//详细描述
                .version("1.0")//版本
                .contact(new Contact("李文杰", "http://127.0.0.1:8080", "liwenjieemail@163.com"))//作者
                .build();
    }
}
