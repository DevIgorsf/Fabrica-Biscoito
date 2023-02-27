package UFLA.avancada.FabricaBiscoito.domain.forno;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;

public class Forno2 implements Forno{

    public void assar(Biscoito biscoito) {
        if(biscoito.getEhRecheado()) {
            long time = biscoito.getTempoProducao();
            try {
                Thread.sleep(time);
                System.out.println("Biscoito pronto forno 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            long time = biscoito.getTempoProducao();
            try {
                Thread.sleep(time);
                System.out.println("Biscoito pronto forno 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
