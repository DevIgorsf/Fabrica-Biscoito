package UFLA.avancada.FabricaBiscoito.domain.forno;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;

public class Forno1 implements Forno{

    private boolean ocupado = false;

    public void assar(Biscoito biscoito) {
        setOcupado(true);
        if(biscoito.getEhRecheado()) {
            long time = biscoito.getTempoProducao();
            try {
                Thread.sleep(time);
                setOcupado(false);
                System.out.println("Biscoito pronto forno1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            long time = biscoito.getTempoProducao();
            try {
                Thread.sleep(time);
                setOcupado(false);
                System.out.println("Biscoito pronto forno1");
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
