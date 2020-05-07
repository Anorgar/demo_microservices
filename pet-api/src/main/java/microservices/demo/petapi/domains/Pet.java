package microservices.demo.petapi.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Pet {

    private Integer id;
    private String name;
    private Integer number;
    private Double price;
    private Type type;

}
