package UFLA.avancada.FabricaBiscoito.model.forno;

import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;

public class Forno2 implements Forno{

    public void assar(Biscoito biscoito) {
        if(biscoito.getEhRecheado()) {
            long time = (long) (1000 * 1.2 * biscoito.calcularIngredientes());
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            long time = 100 * biscoito.calcularIngredientes();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
