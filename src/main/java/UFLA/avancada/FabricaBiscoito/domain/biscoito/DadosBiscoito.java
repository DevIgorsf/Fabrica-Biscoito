package UFLA.avancada.FabricaBiscoito.domain.biscoito;

import jakarta.validation.constraints.NotNull;

public record DadosBiscoito(
        @NotNull(message = "Campo obrigatório")
        boolean ehRecheado,
        @NotNull(message = "Campo obrigatório")
        int ingrediente1,
        @NotNull(message = "Campo obrigatório")
        int ingrediente2,
        @NotNull(message = "Campo obrigatório")
        int ingrediente3) {
}
