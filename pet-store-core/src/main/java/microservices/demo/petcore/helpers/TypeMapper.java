package microservices.demo.petcore.helpers;

import java.util.List;
import java.util.stream.Collectors;
import microservices.demo.petcore.domains.dtos.TypeDTO;
import microservices.demo.petcore.domains.entities.Type;

public final class TypeMapper {

  private TypeMapper() {}

  public static List<TypeDTO> mapEntitiesToDTOs(List<Type> types) {
    return types.stream()
        .map(TypeMapper::mapEntityToDTO)
        .collect(Collectors.toList());
  }

  public static TypeDTO mapEntityToDTO(Type type) {
    return TypeDTO.builder()
        .id(type.getId())
        .type(type.getType())
        .build();
  }

}
