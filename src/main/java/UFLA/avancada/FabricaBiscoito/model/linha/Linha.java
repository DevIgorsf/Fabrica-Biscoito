package UFLA.avancada.FabricaBiscoito.model.linha;

import UFLA.avancada.FabricaBiscoito.model.forno.Forno;

public interface Linha {

    public void montar();

    public Forno getForno();
}
