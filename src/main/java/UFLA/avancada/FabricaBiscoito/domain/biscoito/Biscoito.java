package UFLA.avancada.FabricaBiscoito.domain.biscoito;

import UFLA.avancada.FabricaBiscoito.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Biscoito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ehRecheado;
    private int ingrediente1;
    private int ingrediente2;
    private int ingrediente3;
    private int tempoProducao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Biscoito(DadosBiscoito dadosBiscoito) {
        this.ehRecheado = dadosBiscoito.ehRecheado();
        this.ingrediente1 = dadosBiscoito.ingrediente1();
        this.ingrediente2 = dadosBiscoito.ingrediente2();
        this.ingrediente3 = dadosBiscoito.ingrediente3();
    }

    public int calcularIngredientes() {
        return this.ingrediente1 + this.ingrediente2 + this.ingrediente3;
    }

    public void setTempoProducao (int tempoProducao) {
        if(this.ehRecheado) {
            this.tempoProducao = (int) 1.2 * (tempoProducao * calcularIngredientes());
        } else {
            this.tempoProducao = tempoProducao * calcularIngredientes();
        }

    }

    public boolean getEhRecheado() {
        return this.ehRecheado;
    }
}
