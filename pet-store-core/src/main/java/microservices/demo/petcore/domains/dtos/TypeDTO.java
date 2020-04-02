package microservices.demo.petcore.domains.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Entity
@Table(name = "type")
public class Type {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "type")
  private String type;

}
