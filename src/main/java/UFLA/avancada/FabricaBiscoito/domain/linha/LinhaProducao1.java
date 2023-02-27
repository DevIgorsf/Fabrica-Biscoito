package UFLA.avancada.FabricaBiscoito.domain.linha;

import UFLA.avancada.FabricaBiscoito.domain.forno.Forno;
import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno1;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LinhaProducao1 implements Linha{
    private Biscoito biscoito;
    private Forno1 forno;

    public void montar() {
        try {
            System.out.println("Processando biscoito linha 1  ingrediente 1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Forno getForno() {
        return this.forno;
    }
}
