package UFLA.avancada.FabricaBiscoito.model.biscoito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiscoitoRepository extends JpaRepository<Biscoito, Long> {
}
