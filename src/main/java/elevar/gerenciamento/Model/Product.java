package elevar.gerenciamento.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import elevar.gerenciamento.Deserializer.Deserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "codigo", length = 20)
    private String codigo;
    @Column(name = "descricao", length = 100)
    private String descricao;
    @Column(name = "precoPromocional")
    private Double precoPromocional;
    @Column(name = "promocao")
    private Boolean promocao;
    @Column(name = "qtdEstoque")
    private Integer qtdEstoque;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "destaque")
    private Boolean destaque;
    @ElementCollection
    @JsonDeserialize(using = Deserializer.class)
    private List<String> imgTopo = new ArrayList<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tb_product_grupos_categoria",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "grupos_categoria_id")
    )
    private Set<GruposCategoria> gruposCategorias = new HashSet<>();



}
