package UFLA.avancada.FabricaBiscoito.service;

import UFLA.avancada.FabricaBiscoito.model.biscoito.BiscoitoRepository;
import UFLA.avancada.FabricaBiscoito.model.fila.*;
import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.model.biscoito.BiscoitoDTO;
import UFLA.avancada.FabricaBiscoito.model.biscoito.DadosBiscoito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricaService {

    @Autowired
    private FilaBuilder filaBuilder;  //Instancia classe de fila das 3 filas

    @Autowired
    private BiscoitoRepository biscoitoRepository; // Instancia classe que faz a ponte com o banco de dados

    // método que fabrica biscoito
    public BiscoitoDTO fabricaBiscoito(DadosBiscoito dadosBiscoito) {
        Biscoito biscoito = new Biscoito(dadosBiscoito); //cria biscoito

        biscoitoRepository.save(biscoito); //salva no banco

        Fila fila = filaBuilder.AdicionaBiscoito(biscoito); // adiciona biscoito em alguma fila

        new Thread(fila).start();

        return new BiscoitoDTO(biscoito);
    }


    // método para obter dados da fabrica
    public String getDadosfabricaBiscoito() {
        List<Biscoito> listaBiscoito = biscoitoRepository.findAll();

        int quantidadeBiscoito = listaBiscoito.size();
        List<Integer> tempoGasto = listaBiscoito.stream().map(biscoito -> {
            if( biscoito.getEhRecheado()) {
                return (1000 + biscoito.calcularIngredientes()*120);
            } else {
                return ( 1000 + biscoito.calcularIngredientes()*100);
            }
        }).toList();

        return "QuantidadeBiscoito: " + quantidadeBiscoito + " Tempo por biscoito: " +  tempoGasto;
    }
}
