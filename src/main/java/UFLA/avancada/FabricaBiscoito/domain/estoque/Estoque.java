package UFLA.avancada.FabricaBiscoito.domain.estoque;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ingrediente1;
    private int ingrediente2;
    private int ingrediente3;

    public Estoque(DadosEstoque dadosEstoque) {
        this.ingrediente1 += dadosEstoque.ingrediente1();
        this.ingrediente2 += dadosEstoque.ingrediente2();
        this.ingrediente3 += dadosEstoque.ingrediente3();
    }


}
