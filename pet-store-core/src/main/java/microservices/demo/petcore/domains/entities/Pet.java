package microservices.demo.petcore.domains.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import microservices.demo.petcore.domains.dtos.PetDTO;
import microservices.demo.petcore.domains.dtos.TypeDTO;
import microservices.demo.petcore.helpers.TypeMapper;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Integer number;

    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn
    private Type type;


}
