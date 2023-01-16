package UFLA.avancada.FabricaBiscoito.model.linha;

import UFLA.avancada.FabricaBiscoito.model.forno.Forno;
import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.model.forno.Forno1;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LinhaProducao1 implements Linha{
    private Biscoito biscoito;
    private Forno1 forno;

    public void montar() {
        try {
            System.out.println("Processando biscoito linha 1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Forno getForno() {
        return this.forno;
    }
}
