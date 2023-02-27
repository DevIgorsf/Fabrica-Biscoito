package UFLA.avancada.FabricaBiscoito.domain.biscoito;

public record BiscoitoDTO( boolean ehRecheado, int ingrediente1, int ingrediente2, int ingrediente3) {

    public BiscoitoDTO (Biscoito biscoito) {
        this(biscoito.getEhRecheado(), biscoito.getIngrediente1(), biscoito.getIngrediente2(), biscoito.getIngrediente3());
    }
}
