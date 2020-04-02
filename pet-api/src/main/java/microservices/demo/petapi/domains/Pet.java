package microservices.demo.petcore.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PetDTO {

  private Integer id;
  private String name;
  private Integer number;
  private Boolean price;
  private TypeDTO type;

}
