package br.com.dnos.Ponto.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API do Projeto Ponto",
                description = "É um projeto que visa gravar dados de tempo para registro analizes de tempo dedicado a algo ou semplesmente o registro de tempo trabalhado em algo.",
                contact = @Contact(name = "Lucas G. Feldmann", email = "lucasgfeldmann@gmail.com"),
                version = "0.0.1"
        )
)
public class DocsConfig {
}
