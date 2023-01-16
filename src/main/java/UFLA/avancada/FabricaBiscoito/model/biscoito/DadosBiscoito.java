package UFLA.avancada.FabricaBiscoito.model.biscoito;

import jakarta.validation.constraints.NotBlank;
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
