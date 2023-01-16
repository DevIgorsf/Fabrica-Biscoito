package UFLA.avancada.FabricaBiscoito.controller;

import UFLA.avancada.FabricaBiscoito.model.biscoito.BiscoitoDTO;
import UFLA.avancada.FabricaBiscoito.model.biscoito.DadosBiscoito;
import UFLA.avancada.FabricaBiscoito.service.FabricaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabrica")
public class fabricaController {

    @Autowired
    private FabricaService fabricaService;

    @PostMapping
    public ResponseEntity<BiscoitoDTO> fabricaBiscoito (@RequestBody  @Valid  DadosBiscoito dadosBiscoito) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricaService.fabricaBiscoito(dadosBiscoito));
    }

    @GetMapping
    public ResponseEntity<String> getDadosfabricaBiscoito () {
        return ResponseEntity.status(HttpStatus.OK).body(fabricaService.getDadosfabricaBiscoito());
    }
}
