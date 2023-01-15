package UFLA.avancada.FabricaBiscoito.model.biscoito;

import UFLA.avancada.FabricaBiscoito.model.ProcessoEnum;

public record BiscoitoDTO( boolean ehRecheado, int ingrediente1, int ingrediente2, int ingrediente3) {

    public BiscoitoDTO (Biscoito biscoito) {
        this(biscoito.getEhRecheado(), biscoito.getIngrediente1(), biscoito.getIngrediente2(), biscoito.getIngrediente3());
    }
}
