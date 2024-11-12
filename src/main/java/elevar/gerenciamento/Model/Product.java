package elevar.gerenciamento.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import elevar.gerenciamento.Deserializer.Deserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

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
    private List<String> imgTopo;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<GruposCategoria> gruposCategorias;

}
