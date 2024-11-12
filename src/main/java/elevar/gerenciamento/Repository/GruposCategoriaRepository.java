package elevar.gerenciamento.Repository;

import elevar.gerenciamento.Model.GruposCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruposCategoriaRepository extends JpaRepository<GruposCategoria, Long> {
}
