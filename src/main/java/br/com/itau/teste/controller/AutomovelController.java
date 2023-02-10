package br.com.itau.teste.controller;

import br.com.itau.teste.dto.request.AutomovelRequest;
import br.com.itau.teste.dto.response.AutomovelResponse;
import br.com.itau.teste.mapper.AutomovelMapper;
import br.com.itau.teste.usecases.BuscarAutomovel;
import br.com.itau.teste.usecases.CadastrarAutomovel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class AutomovelController {

    private final CadastrarAutomovel cadastrarAutomovel;
    private final BuscarAutomovel buscarAutomovel;

    public AutomovelController(CadastrarAutomovel cadastrarAutomovel, BuscarAutomovel buscarAutomovel) {
        this.cadastrarAutomovel = cadastrarAutomovel;
        this.buscarAutomovel = buscarAutomovel;
    }

    @PostMapping("/cadastroAutomoveis")
    public ResponseEntity<Void> save(@RequestBody AutomovelRequest automovelRequest) {
        log.info("Inicializando insercao de automovel no banco de dados");
        cadastrarAutomovel.execute(automovelRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/automoveis")
    public ResponseEntity<List<AutomovelResponse>> findAll() {
        log.info("Buscando todos automoveis no banco de dados");
        List<AutomovelResponse> automoveis = buscarAutomovel.execute()
                .stream().map(AutomovelMapper.INSTANCE::toAutomovelResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(automoveis);
    }
}
