package UFLA.avancada.FabricaBiscoito.model.biscoito;

import jakarta.validation.constraints.NotBlank;

public record DadosBiscoito(
        @NotBlank(message = "Campo obrigatório")
        boolean ehRecheado,
        @NotBlank(message = "Campo obrigatório")
        int ingrediente1,
        @NotBlank(message = "Campo obrigatório")
        int ingrediente2,
        @NotBlank(message = "Campo obrigatório")
        int ingrediente3) {
}
