package UFLA.avancada.FabricaBiscoito.service;

import UFLA.avancada.FabricaBiscoito.model.fila.*;
import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.model.biscoito.BiscoitoDTO;
import UFLA.avancada.FabricaBiscoito.model.biscoito.DadosBiscoito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricaService {

    @Autowired
    private FilaBuilder filaBuilder;

    public BiscoitoDTO fabricaBiscoito(DadosBiscoito dadosBiscoito) {
        Biscoito biscoito = new Biscoito(dadosBiscoito);

        Fila fila = filaBuilder.AdicionaBiscoito(biscoito);

        new Thread(fila).start();

        return new BiscoitoDTO(biscoito);
    }
}
