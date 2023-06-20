package kr.or.connect.reservation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kr.or.connect"))  // 모든 API를 문서화 시키지 않고, 선별적으로 하고 싶을 경우 basePackage 함수 내에 패키지 경로를 입력
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()) // 추가
                .useDefaultResponseMessages(false);  // 기본으로 세팅되는 200, 401, 403, 404 메시지를 표시하지 않음
    }

    private ApiInfo apiInfo() { // 추가
        return new ApiInfoBuilder()
                .title("API Title")
                .description("API Description")
                .version("1.0.0")
                .build();
    }
}
