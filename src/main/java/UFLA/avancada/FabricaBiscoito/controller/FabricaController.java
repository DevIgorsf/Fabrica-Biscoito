package UFLA.avancada.FabricaBiscoito.controller;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.BiscoitoDTO;
import UFLA.avancada.FabricaBiscoito.domain.biscoito.DadosBiscoito;
import UFLA.avancada.FabricaBiscoito.domain.biscoito.DadosFabricaBiscoito;
import UFLA.avancada.FabricaBiscoito.domain.biscoito.TempoForno;
import UFLA.avancada.FabricaBiscoito.domain.estoque.DadosEstoque;
import UFLA.avancada.FabricaBiscoito.domain.estoque.Estoque;
import UFLA.avancada.FabricaBiscoito.service.FabricaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabrica")
public class FabricaController {

    @Autowired
    private FabricaService fabricaService;

    @PostMapping
    public ResponseEntity<BiscoitoDTO> fabricaBiscoito (@RequestBody  @Valid  DadosBiscoito dadosBiscoito) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricaService.fabricaBiscoito(dadosBiscoito));
    }

    @PostMapping("/tempo")
    public ResponseEntity modificaTempoProducao (@RequestBody TempoForno tempoForno) {
        return ResponseEntity.status(HttpStatus.OK).body(fabricaService.modificaTempoProducao(tempoForno));
    }

    @GetMapping
    public ResponseEntity<DadosFabricaBiscoito> getDadosFabricaBiscoito () {
        return ResponseEntity.status(HttpStatus.OK).body(fabricaService.getDadosFabricaBiscoito());
    }

    @GetMapping("/estoque")
    public ResponseEntity<Estoque> getDadosEstoque () {
        return ResponseEntity.status(HttpStatus.OK).body(fabricaService.getDadosEstoque());
    }

    @PostMapping("/estoque")
    public ResponseEntity AdicionarEstoque (@RequestBody @Valid DadosEstoque dadosEstoque) {

        return ResponseEntity.status(HttpStatus.OK).body(fabricaService.AdicionarEstoque(dadosEstoque));
    }
}
