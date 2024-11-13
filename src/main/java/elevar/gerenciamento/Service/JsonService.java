package elevar.gerenciamento.Service;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import elevar.gerenciamento.Model.Product;
import elevar.gerenciamento.Repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class JsonService {

    private static final String jsonPath = "C:/Users/salom/IdeaProjects/gerenciamentodeprodutos/src/main/resources/products_test.json";

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        try {
            System.out.println("Iniciando carga de produtos...");
            loadProducts();
            System.out.println("Carga de produtos concluída.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadProducts() throws IOException {
        System.out.println("Entrei no loadProducts!");
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        List<Product> products = mapper.readValue(
                new File(jsonPath),
                mapper.getTypeFactory().constructCollectionType(List.class, Product.class)
        );

        products.forEach(product -> {
            if (!productRepository.existsByCodigo(product.getCodigo())) {
                productRepository.save(product);
            }
        });
    }
}
