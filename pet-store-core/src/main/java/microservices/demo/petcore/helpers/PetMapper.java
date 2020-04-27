package microservices.demo.petcore.helpers;

import java.util.List;
import java.util.stream.Collectors;

import microservices.demo.petcore.domains.dtos.PetDTO;
import microservices.demo.petcore.domains.entities.Pet;

public final class PetMapper {

    private PetMapper() {
    }

    public static List<PetDTO> mapEntitiesToDTOs(List<Pet> pets) {
        return pets.stream()
                .map(PetMapper::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public static PetDTO mapEntityToDTO(Pet pet) {
        return PetDTO.builder()
                .id(pet.getId())
                .name(pet.getName())
                .number(pet.getNumber())
                .price(pet.getPrice())
                .type(TypeMapper.mapEntityToDTO(pet.getType()))
                .build();
    }

}
