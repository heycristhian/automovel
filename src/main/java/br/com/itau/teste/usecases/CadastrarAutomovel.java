package br.com.itau.teste.usecases;

import br.com.itau.teste.domain.Automovel;
import br.com.itau.teste.dto.request.AutomovelRequest;
import br.com.itau.teste.mapper.AutomovelMapper;
import br.com.itau.teste.repository.AutomovelRepository;
import org.springframework.stereotype.Component;

@Component
public class CadastrarAutomovel {

    private final AutomovelRepository automovelRepository;

    public CadastrarAutomovel(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    public Automovel execute(AutomovelRequest automovelRequest) {
        Automovel automovel = AutomovelMapper.INSTANCE.toAutomovel(automovelRequest);
        return automovelRepository.save(automovel);
    }
}
