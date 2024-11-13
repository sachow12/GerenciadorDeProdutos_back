package elevar.gerenciamento.Controller;

import elevar.gerenciamento.Model.Product;
import elevar.gerenciamento.Repository.ProductRepository;
import elevar.gerenciamento.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @GetMapping
    public List<Product> read() {
        return productService.readProducts();
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/filter")
    public Page<Product> filterProducts(
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) Double precoPromocional,
            @RequestParam(required = false) Boolean promocao,
            @RequestParam(required = false) Integer qtdEstoque,
            @RequestParam(required = false) Boolean status,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Double valor,
            @RequestParam(required = false) String referencia,
            @RequestParam(required = false) Boolean destaque,
            @RequestParam(required = false) List<String> imgTopo,
            Pageable pageable) {

        return productService.filterProducts(
                codigo, descricao, precoPromocional, promocao, qtdEstoque, status,
                titulo, valor, referencia, destaque, imgTopo, pageable);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}