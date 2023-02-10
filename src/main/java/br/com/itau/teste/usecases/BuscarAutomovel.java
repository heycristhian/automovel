package br.com.itau.teste.usecases;

import br.com.itau.teste.domain.Automovel;
import br.com.itau.teste.repository.AutomovelRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarAutomovel {

    private final AutomovelRepository automovelRepository;

    public BuscarAutomovel(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    public List<Automovel> execute() {
        return automovelRepository.findAll();
    }
}
