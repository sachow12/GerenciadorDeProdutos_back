package elevar.gerenciamento.Service;
import elevar.gerenciamento.Model.Product;
import elevar.gerenciamento.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> readProducts() {
        return productRepository.findAll();
    }
    public Product updateProduct(Long id, Product product) {
        var entity = productRepository.findById(product.getId())
                .orElseThrow(()-> new RuntimeException("Person not found"));

            entity.setCodigo(product.getCodigo());
            entity.setDescricao(product.getDescricao());
            entity.setPrecoPromocional(product.getPrecoPromocional());
            entity.setPromocao(product.getPromocao());
            entity.setQtdEstoque(product.getQtdEstoque());
            entity.setStatus(product.getStatus());
            entity.setTitulo(product.getTitulo());
            entity.setValor(product.getValor());
            entity.setReferencia(product.getReferencia());
            entity.setDestaque(product.getDestaque());
            entity.setImgTopo(product.getImgTopo());
            entity.setGruposCategorias(product.getGruposCategorias());
            return productRepository.save(product);

        }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}