package com.olaoye.klasha.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerConfiguration {
    @Value("${api.info.title: Klasha Assessment}")
    private String title;
    @Value("${api.info.description: Backend API for Online Bookstore}")
    private String description;
    @Value("${api.info.version: v1}")
    private String version;
    @Value("${api.info.contact.name: Oyekunle Johnson}")
    private String contactName;
    @Value("${api.info.contact.email: }")
    private String contactEmail;
    @Value("${api.info.contact.url: }")
    private String contactUrl;
    @Value("${api.info.licence.name: Licence 2.0}")
    private String licenceName;
    @Value("${api.info.licence.url: https://www.apache.org/licenses/LICENSE-2.0}")
    private String licenceUrl;
    @Bean
    public OpenAPI productApi() {
        return new OpenAPI()
                .info(getApiInfo());
    }
    private Info getApiInfo() {
        Contact contact = new Contact().name(contactName).email(contactEmail).url(contactUrl);
        License licence = new License().name(licenceName).url(licenceUrl);
        return new Info()
                .title(title)
                .description(description)
                .version(version)
                .contact(contact)
                .license(licence);
    }
}

