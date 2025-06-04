package org.example.backend.AuthConfigs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact =  @Contact(
                        name = "Mini Projet Independant - Recrutement Stagiaire",
                        email = "pascalinetozoun@gmail.com",
                        url = "test-stage"

                ),
                description = "Mini Projet Independant - Recrutement Stagiaire",
                title = "API- Project Management",
                version = "2.0"

        ),
        servers = @Server(
                description = "Server 1",
                url = "http://localhost:8080"
        )
)
public class OpenApiConfig {

}
