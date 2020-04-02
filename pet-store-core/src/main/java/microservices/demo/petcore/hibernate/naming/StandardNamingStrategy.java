package microservices.demo.petcore.hibernate.naming;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.data.hibernate.naming.DefaultPhysicalNamingStrategy;
import javax.inject.Singleton;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;

@Replaces(DefaultPhysicalNamingStrategy.class)
@Singleton
public class StandardNamingStrategy extends PhysicalNamingStrategyStandardImpl {

  private static final long serialVersionUID = -1150615028240158324L;
}
