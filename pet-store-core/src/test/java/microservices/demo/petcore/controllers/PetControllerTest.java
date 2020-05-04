package microservices.demo.petcore.controllers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.restassured.RestAssured;

import javax.inject.Inject;

import io.restassured.http.ContentType;
import microservices.demo.petcore.domains.entities.Pet;
import microservices.demo.petcore.domains.entities.Type;
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
               .accept(ContentType.JSON)
               .contentType(ContentType.JSON)
               .when()
               .body(Pet.builder()
                       .name("Bojack")
                       .number(50)
                       .price(70d)
                       .type(Type.builder()
                               .id(1)
                               .type("chat")
                               .build())
                       .build())
               .post("/pet")
               .then()
               .body("id", equalTo(2),
                       "name", equalTo("Bojack"),
                       "number", equalTo(50),
                       "price", equalTo(70f),
                       "type.id", equalTo(1),
                       "type.type", equalTo("chat")

               );

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


   /* @Test
    public void should_delete_pets() {
        given()
                .when()
                .delete("/pet/{id}", 2)
                .then()
                .statusCode(200);

    }*/

   /* {
        "name": "Bojack",
            "number": 50,
            "price": 400,
            "type": {
        "id": 3,
                "type": "cheval"
    }*/


   @Test
    public void should_create_pets() {

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .body(Pet.builder()
                        .name("Bojack")
                        .number(50)
                        .price(70d)
                        .type(Type.builder()
                                .id(1)
                                .type("chat")
                                .build())
                        .build())
                .post("/pet")
                .then()
                .body("id", equalTo(2),
                        "name", equalTo("Bojack"),
                        "number", equalTo(50),
                        "price", equalTo(70f),
                        "type.id", equalTo(1),
                        "type.type", equalTo("chat")

                );
        /*.body(equalTo(""));*/

    }

    /*@Test
    public void should_read_pets() {

        given()
                .when()
                .get("/pet")
                .then()
                .body("[0].id", equalTo(1));

    }*/
}

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




