package UFLA.avancada.FabricaBiscoito.service;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.*;
import UFLA.avancada.FabricaBiscoito.domain.estoque.DadosEstoque;
import UFLA.avancada.FabricaBiscoito.domain.estoque.Estoque;
import UFLA.avancada.FabricaBiscoito.domain.estoque.EstoqueRepository;
import UFLA.avancada.FabricaBiscoito.domain.fila.*;
import UFLA.avancada.FabricaBiscoito.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricaService {

    @Autowired
    private FilaBuilder filaBuilder;  //Instancia classe de fila das 3 filas

    @Autowired
    private EstoqueRepository estoqueRepository;

    private int tempo;

    public FabricaService() {
        this.tempo = 100;
    }

    @Autowired
    private BiscoitoRepository biscoitoRepository; // Instancia classe que faz a ponte com o banco de dados

    // método que fabrica biscoito
    public BiscoitoDTO fabricaBiscoito(DadosBiscoito dadosBiscoito) {
        Biscoito biscoito = new Biscoito(dadosBiscoito); //cria biscoito

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            biscoito.setUsuario(((Usuario)principal));
        } catch (Exception e) {
            throw new RuntimeException("usuário não autenticado");
        }
        biscoito.setTempoProducao(this.tempo);

        Optional<Estoque> estoqueOptional = estoqueRepository.findById(Long.valueOf(1));

        if( estoqueOptional.isEmpty()) {
            throw new RuntimeException("Estoque ainda não registrado");
        }

        Estoque estoque = estoqueOptional.get();

        if(estoque.getIngrediente1() < biscoito.getIngrediente1() ||
                estoque.getIngrediente2() < biscoito.getIngrediente1() ||
                estoque.getIngrediente3() < biscoito.getIngrediente1() ) {
            throw new RuntimeException("Não há estoque para esse pedido");
        }

        estoque.setIngrediente1(estoque.getIngrediente1() - biscoito.getIngrediente1());
        estoque.setIngrediente2(estoque.getIngrediente2() - biscoito.getIngrediente2());
        estoque.setIngrediente3(estoque.getIngrediente3() - biscoito.getIngrediente3());


        biscoitoRepository.save(biscoito); //salva no banco

        Fila fila = filaBuilder.AdicionaBiscoito(biscoito); // adiciona biscoito em alguma fila

        new Thread(fila).start();

        return new BiscoitoDTO(biscoito);
    }


    // método para obter dados da fabrica
    public DadosFabricaBiscoito getDadosFabricaBiscoito() {
        List<Biscoito> listaBiscoito = biscoitoRepository.findAll();

        long totalEhRecheado = 0;
        for(Biscoito biscoito: listaBiscoito) {
            if( biscoito.getEhRecheado()) {
                totalEhRecheado ++;
            }
        }
        long quantidadeBiscoito = (listaBiscoito.size() - totalEhRecheado);

        return new DadosFabricaBiscoito((int) quantidadeBiscoito, totalEhRecheado);
    }

    public int modificaTempoProducao(TempoForno novoTempo) {
        this.tempo = novoTempo.tempoForno();
        return novoTempo.tempoForno();
    }

    public Estoque AdicionarEstoque(DadosEstoque dadosEstoque) {
        List<Estoque> listEstoque = estoqueRepository.findAll();
        Estoque estoque = new Estoque();

        if( !listEstoque.isEmpty()) {
            estoque = listEstoque.get(0);

            estoque.setIngrediente1( estoque.getIngrediente1() + dadosEstoque.ingrediente1());
            estoque.setIngrediente2( estoque.getIngrediente2() + dadosEstoque.ingrediente2());
            estoque.setIngrediente3( estoque.getIngrediente3() + dadosEstoque.ingrediente3());
            estoqueRepository.save(estoque);
        } else {
            estoque = new Estoque(dadosEstoque);
            estoqueRepository.save(estoque);

        }

        return estoque;
    }

    public Estoque getDadosEstoque() {
        List<Estoque> listEstoque = estoqueRepository.findAll();

        Estoque estoque = listEstoque.get(0);

        return estoque;
    }
}
