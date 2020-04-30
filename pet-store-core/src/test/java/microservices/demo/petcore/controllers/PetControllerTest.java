package microservices.demo.petcore.controllers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.restassured.RestAssured;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
public class PetControllerTest {

    @Inject
    private EmbeddedServer embeddedServer;

    @BeforeEach
    public void setUp() {
        RestAssured.port = embeddedServer.getPort();
    }

    @Test
    public void should_retrieve_pets() {
        given()
                .when()
                .get("/pet")
                .then()
                .body("[0].id", equalTo(1),
                        "[0].type.id", equalTo(1),
                        "[0].type.type", equalTo("chat"),
                        "[0].price", equalTo(2.99f),
                        "[0].name", equalTo("chat persan")
                );
    }


    @Test
    public void should_delete_pets() {
        given()
                .when()
                .delete("/pet/{id}", 2)
                .then()
                .statusCode(200);


      /*  given()
                .when()
                .post("/pet")
                .then()
                .body("id", equalTo(3),
                        "type.id", equalTo(1),
                        "type.type", equalTo("chat"),
                        "price", equalTo(30f),
                        "name", equalTo("cheval")
                );


        /* given()
              .when()
              .post("/pet")
              .then()

      given()
              .when()
              .delete("/pet")
              .then()
              .statusCode(200);

              "id.size", equalTo(null),*/
    }


}
