package UFLA.avancada.FabricaBiscoito.domain.linha;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno1;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno2;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LinhaProducao2c implements Linha{
    private Biscoito biscoito;
    private Forno1 forno1;
    private Forno2 forno2;

    public void montar() {
        try {
            System.out.println("Processando biscoito linha 2  ingrediente 3");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Forno getForno() {
        if(forno1.getOcupado()){
            return this.forno2;
        }
        return this.forno1;
    }
}
