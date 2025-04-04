package br.com.dnos.Ponto.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
        info = @Info(
                title = "API do Projeto Ponto",
                version = "0.0.1",
                description = "API para registro e análise de tempo dedicado a atividades. Ideal para controle de jornada, produtividade ou simples marcação de tempo em projetos.",
                contact = @Contact(name = "Lucas G. Feldmann", email = "lucasgfeldmann@gmail.com")
        ),
        servers = {
                @Server(url = "http://170.79.70.234:3003", description = "Servidor em Produção (exemplo)")
        },
        externalDocs = @ExternalDocumentation(
                description = "Repositório do Projeto",
                url = "https://github.com/lucasgfeldmann/ponto"
        )

)
public class DocsConfig {
}
