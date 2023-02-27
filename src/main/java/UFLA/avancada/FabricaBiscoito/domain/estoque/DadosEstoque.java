package UFLA.avancada.FabricaBiscoito.domain.estoque;

import jakarta.validation.constraints.NotNull;

public record DadosEstoque(
        @NotNull(message = "Campo obrigatório")
        int ingrediente1,
        @NotNull(message = "Campo obrigatório")
        int ingrediente2,
        @NotNull(message = "Campo obrigatório")
        int ingrediente3) {
}
