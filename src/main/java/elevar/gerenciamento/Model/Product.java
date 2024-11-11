package elevar.gerenciamento.Model;

import elevar.gerenciamento.Model.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
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
    @Column(name = "nome",length = 50)
    private String nome;
    @Column(name = "descricao",length = 100)
    private String descricao;
    @Column(name="valor")
    private Double valor;
    @Column(name = "status")
    private Status status;
}
