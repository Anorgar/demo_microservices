package microservices.sales.cart;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "Cart REST API",
        description =
            "Soumet la création d’un panier dans l’applicatif en prenant en paramètre le produit ou les produits et leur quantité. \n"
                +
                "L'utilisation de cette API est soumise aux règles RGPD  \n" +
                "host:'[recette-|preprod-]api.cultura.intra':basePath: '/rest/cart' \n" +
                "gitRepo: 'https://gitlab.cultura.intra/microservices/api/cart.git' \n" +
                "client : Cultur@pp, SCO"
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Developpment only"),
        @Server(url = "http://recette-api.cultura.intra/rest/cart", description = "recette environment"),
        @Server(url = "http://preprod-api.cultura.intra/rest/cart", description = "preprod environment")
    }
)
public class Application {

  public static final String LOG_PREFIX = "API::cart - ";

  public static void main(String[] args) {
    Micronaut.run(Application.class);
  }
}
