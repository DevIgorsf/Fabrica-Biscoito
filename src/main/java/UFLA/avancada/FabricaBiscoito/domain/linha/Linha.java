package UFLA.avancada.FabricaBiscoito.domain.linha;

import UFLA.avancada.FabricaBiscoito.domain.forno.Forno;

public interface Linha {

    public void montar();

    public Forno getForno();
}
