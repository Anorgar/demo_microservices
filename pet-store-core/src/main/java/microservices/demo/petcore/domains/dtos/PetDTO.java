package microservices.demo.petcore.domains.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Entity
@Table(name = "pet")
public class Pet {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "number")
  private Integer number;

  @Column(name = "price")
  private Boolean price;

  @OneToOne
  @JoinColumn(name = "id")
  private Type type;
}
