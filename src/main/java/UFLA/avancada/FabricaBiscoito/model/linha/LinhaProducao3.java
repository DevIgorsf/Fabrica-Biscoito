package UFLA.avancada.FabricaBiscoito.model.linha;

import UFLA.avancada.FabricaBiscoito.model.forno.Forno;
import UFLA.avancada.FabricaBiscoito.model.forno.Forno2;
import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;

public class LinhaProducao3 implements Linha{
    private Biscoito biscoito;
    private Forno2 forno;

    public void montar() {
        try {
            System.out.println("Processando biscoito linha 3");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Forno getForno() {
        return this.forno;
    }
}
