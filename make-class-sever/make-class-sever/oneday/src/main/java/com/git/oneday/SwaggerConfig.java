package com.git.oneday;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


//Swagger 2 UI �⺻ ���
//http://localhost:8080/swagger-ui/
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		
//		// Gateway���� SessionId -> session-profile�� ���� ����� ���� ��� �Ű�����
//		RequestParameter sessionProfile = new RequestParameterBuilder()
//				.name("session-profile")
//				.description("{\"userId\":\"kdkcom\", \"role\":\"USER\"}")
//				.required(false)
//				.in("header")
//				.build();
//		
//		List<RequestParameter> params = new ArrayList<RequestParameter>();
//		params.add(sessionProfile);
		
		return new Docket(DocumentationType.SWAGGER_2)
//					.globalRequestParameters(params)	// �Ű����� �߰�
					.apiInfo(apiInfo())
					.select()
					// ��ü, actuator, error �� ���� ��
//					.apis(RequestHandlerSelectors.any()) 
					// REST Controller��
					.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
					// ��ü ���
					.paths(PathSelectors.any()) 				
					.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
					.title("Myworkspace")
					.version("1.0")
					.description("API List of Myworkspace Application")
					.license("��Ʈ������ ������Ʈ")
					.build();
	}
}