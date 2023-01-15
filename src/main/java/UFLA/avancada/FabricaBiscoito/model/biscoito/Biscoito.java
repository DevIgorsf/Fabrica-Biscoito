package UFLA.avancada.FabricaBiscoito.model.biscoito;

import UFLA.avancada.FabricaBiscoito.model.ProcessoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Biscoito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ehRecheado;
    private int ingrediente1;
    private int ingrediente2;
    private int ingrediente3;
    private ProcessoEnum processo;

    public Biscoito(DadosBiscoito dadosBiscoito) {
        this.ehRecheado = dadosBiscoito.ehRecheado();
        this.ingrediente1 = dadosBiscoito.ingrediente1();
        this.ingrediente2 = dadosBiscoito.ingrediente2();
        this.ingrediente3 = dadosBiscoito.ingrediente3();
        this.processo = ProcessoEnum.FILA;
    }

    public int calcularIngredientes() {
        return this.ingrediente1 + this.ingrediente2 + this.ingrediente3;
    }

    public boolean getEhRecheado() {
        return this.ehRecheado;
    }
}
