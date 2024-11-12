package elevar.gerenciamento.Repository;

import elevar.gerenciamento.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.gruposCategorias WHERE p.id = :id")
    Product findByIdWithGruposCategorias(@Param("id") Long id);
    boolean existsByCodigo(String codigo);
}
