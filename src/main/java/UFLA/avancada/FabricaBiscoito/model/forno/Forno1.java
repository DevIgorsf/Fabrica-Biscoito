package UFLA.avancada.FabricaBiscoito.model.forno;

import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;

public class Forno1 implements Forno{

    private boolean ocupado = false;

    public void assar(Biscoito biscoito) {
        if(biscoito.getEhRecheado()) {
            long time = (long) (1000 * 1.2 * biscoito.calcularIngredientes());
            try {
                Thread.sleep(time);
                setOcupado(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            long time = 100 * biscoito.calcularIngredientes();
            try {
                Thread.sleep(time);
                setOcupado(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean getOcupado() {
        return this.ocupado;
    }

    public boolean setOcupado(boolean ocupado) {
        return this.ocupado;
    }
}
