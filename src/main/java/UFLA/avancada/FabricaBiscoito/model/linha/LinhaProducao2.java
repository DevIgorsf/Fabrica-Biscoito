package UFLA.avancada.FabricaBiscoito.model.linha;

import UFLA.avancada.FabricaBiscoito.model.forno.Forno;
import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.model.forno.Forno1;
import UFLA.avancada.FabricaBiscoito.model.forno.Forno2;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LinhaProducao2 implements Linha{
    private Biscoito biscoito;
    private Forno1 forno1;
    private Forno2 forno2;

    public void montar() {
        try {
            System.out.println("Processando biscoito linha 2");
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
