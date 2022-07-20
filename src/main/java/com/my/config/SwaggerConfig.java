package com.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Classname SwaggerConfig
 * @Description TODO
 * @Date 2022/4/13 16:51
 * @Created by GuoYuan
 */
@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2) //指定api类型为swagger2
                .apiInfo(apiInfo()
                )   //定义api文档配置信息
                .groupName("郭远")
                .select().apis(RequestHandlerSelectors.basePackage("com.my.controller"))  //指定需要扫描的controller包
                .paths(PathSelectors.any())         //所有 xxxController都需要生成
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger接口API文档")                   //文档页标题
                .contact(new Contact("郭远","www.baidu.com","123456@qq.com"))        //联系人信息
                .description("api文档的描述")
                .version("1.0")             //文档版本号
                .termsOfServiceUrl("https://www.shixin.com")   //网站地址
                .build();

    }
}
