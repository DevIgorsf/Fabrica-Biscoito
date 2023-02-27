package UFLA.avancada.FabricaBiscoito.domain.biscoito;

import jakarta.validation.constraints.Min;

public record TempoForno(
        @Min(1)
        Integer tempoForno) {
}
