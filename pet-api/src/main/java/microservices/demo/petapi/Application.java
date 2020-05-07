package microservices.demo.petapi;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static final String LOG_PREFIX = "API::cart - ";

    public static void main(String[] args) {
        Micronaut.run(microservices.demo.petapi.Application.class);
    }

}
