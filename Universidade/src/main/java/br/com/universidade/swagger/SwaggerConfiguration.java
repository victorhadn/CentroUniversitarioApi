package br.com.universidade.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket detalheApi() {
 
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.universidade"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build());
 
		return docket;
}


private ApiInfoBuilder informacoesApi() {
	 
	ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

	apiInfoBuilder.title("Universidade UNIESP");
	apiInfoBuilder.description("Api desenvolvido através da criação de um cenário hipotético de uma universidade.");
	apiInfoBuilder.version("4.0");
	apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.");
	apiInfoBuilder.license("Open Source - Uniesp Centro Universitário");
	apiInfoBuilder.licenseUrl("https://www.iesp.edu.br/");
	apiInfoBuilder.build();

	return apiInfoBuilder;
}

}
