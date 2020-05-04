package microservices.demo.petcore.controllers;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import microservices.demo.petcore.domains.entities.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@MicronautTest
public class TypeControllerTest {

    @Inject
    private EmbeddedServer embeddedServer;

    @BeforeEach
    public void setUp() {
        RestAssured.port = embeddedServer.getPort();
    }

    @Test
    public void should_test_types() {

//CREATE
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .body(Type.builder()
                        .type("chien")
                        .build())
                .post("/type")
                .then()
                .body("id", equalTo(2),
                        "type", equalTo("chien")

                );
//READ
        given()
                .when()
                .get("/type")
                .then()
                .body("[0].id", equalTo(1));

//DELETE
        given()
                .when()
                .delete("/type/{id}", 2)
                .then()
                .statusCode(200);


    }
}
