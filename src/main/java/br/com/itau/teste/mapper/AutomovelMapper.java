package br.com.itau.teste.mapper;

import br.com.itau.teste.domain.Automovel;
import br.com.itau.teste.dto.request.AutomovelRequest;
import br.com.itau.teste.dto.response.AutomovelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AutomovelMapper {

    AutomovelMapper INSTANCE = Mappers.getMapper(AutomovelMapper.class);

    Automovel toAutomovel(AutomovelRequest automovelRequest);

    AutomovelResponse toAutomovelResponse(Automovel automovel);
}
