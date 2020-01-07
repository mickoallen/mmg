package com.mick.mmg;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Mick's Music Game",
                version = "0.1",
                description = "Sickest party game there is"
        )
)
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}