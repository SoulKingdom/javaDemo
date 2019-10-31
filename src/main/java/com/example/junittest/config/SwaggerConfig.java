package com.example.junittest.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 *  @dept 上海软件研发中心
 *  @description Swagger配置中心
 *   Swagger能成为最受欢迎的REST APIs文档生成工具之一，有以下几个原因：
 *   Swagger 可以生成一个具有互动性的API控制台，开发者可以用来快速学习和尝试API。
 *   Swagger 可以生成客户端SDK代码用于各种不同的平台上的实现。
 *   Swagger 文件可以在许多不同的平台上从代码注释中自动生成。
 *   Swagger 有一个强大的社区，里面有许多强悍的贡献者
 *
 *  @author HaoXin.Liu
 *  @date 2019/9/29 9:53
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String VERSION = "1.0.0";

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwagger)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eliteai.smartiot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("XXXX软件接口")
                .description("Restful 风格接口")
                //服务条款网址
                //.termsOfServiceUrl("http://xxxx")
                .version(VERSION)
                //.contact(new Contact("wesker", "url", "email"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
