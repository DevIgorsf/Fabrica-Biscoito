package UFLA.avancada.FabricaBiscoito.domain.linha;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno2;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LinhaProducao3c implements Linha{
    private Biscoito biscoito;
    private Forno2 forno;

    public void montar() {
        try {
            System.out.println("Processando biscoito linha 3  ingrediente 3");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Forno getForno() {
        return this.forno;
    }
}
