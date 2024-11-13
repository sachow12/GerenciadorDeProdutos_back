package elevar.gerenciamento.Service;
import elevar.gerenciamento.Model.Product;
import elevar.gerenciamento.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
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
        var entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

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
        return productRepository.save(entity);
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
    public Page<Product> filterProducts(
            String codigo, String descricao, Double precoPromocional, Boolean promocao,
            Integer qtdEstoque, Boolean status, String titulo, Double valor,
            String referencia, Boolean destaque, List<String> imgTopo, Pageable pageable) {

        Product probe = new Product();
        probe.setCodigo(codigo);
        probe.setDescricao(descricao);
        probe.setPrecoPromocional(precoPromocional);
        probe.setPromocao(promocao);
        probe.setQtdEstoque(qtdEstoque);
        probe.setStatus(status);
        probe.setTitulo(titulo);
        probe.setValor(valor);
        probe.setReferencia(referencia);
        probe.setDestaque(destaque);
        probe.setImgTopo(imgTopo);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Product> example = Example.of(probe, matcher);

        return productRepository.findAll(example, pageable);
    }

}