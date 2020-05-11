package microservices.demo.petapi.controllers;

import static org.hamcrest.core.IsEqual.equalTo;


import java.util.Collections;
import java.util.List;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import microservices.demo.petapi.clients.PetClient;
import microservices.demo.petapi.domains.Pet;
import microservices.demo.petapi.domains.Type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;


@MicronautTest
public class PetControllerTest{

    private static final PetClient PET_CLIENT = Mockito.mock(PetClient.class);

    @Inject
    private EmbeddedServer embeddedServer;

    @BeforeEach
    public void setUp() {
        RestAssured.port = embeddedServer.getPort();
    }

    @Inject
    private ApplicationContext context;


    @MockBean (PetClient.class)
    public PetClient getPetClient(){
        return PET_CLIENT;
    }

    @Test
    public void main() throws Exception {
        List<Pet> pets = Collections.singletonList(
                Pet.builder()
                        .id(1)
                        .name("caniche")
                        .number(10)
                        .price(25.99)
                        .type(Type.builder().id(2).type("chien").build())
                        .build());
        Mockito.doReturn(pets).when(PET_CLIENT).retrievePets();

        ResultActions resultActions = mockMvc.perform(get("/pet"))
                .andExpect(status().isOk())
                .andExpect(view().name("pet"))
                .andExpect(model().attribute("pets", equalTo(pets)));

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();
    }

}


/*
package microservices.demo.petapi.controllers;

        import static org.hamcrest.core.IsEqual.equalTo;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

        import java.util.Collections;
        import java.util.List;
        import microservices.demo.petapi.clients.PetClient;
        import microservices.demo.petapi.domains.Pet;
        import microservices.demo.petapi.domains.Type;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.Mockito;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.context.ApplicationContext;
        import org.springframework.test.context.junit4.SpringRunner;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.MvcResult;
        import org.springframework.test.web.servlet.ResultActions;
        import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PetControllerTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetClient client;

    @Test
    public void main() throws Exception {
        List<Pet> pets = Collections.singletonList(
                Pet.builder()
                        .id(1)
                        .name("caniche")
                        .number(10)
                        .price(25.99)
                        .type(Type.builder().id(2).type("chien").build())
                        .build());
        Mockito.doReturn(pets).when(client).retrievePets();

        ResultActions resultActions = mockMvc.perform(get("/pet"))
                .andExpect(status().isOk())
                .andExpect(view().name("pet"))
                .andExpect(model().attribute("pets", equalTo(pets)));

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();
    }

}

 */