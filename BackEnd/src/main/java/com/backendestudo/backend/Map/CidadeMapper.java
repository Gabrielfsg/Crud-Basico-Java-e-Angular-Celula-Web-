package com.backendestudo.backend.Map;

import com.backendestudo.backend.dto.CidadeDTO;
import com.backendestudo.backend.model.Cidade;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CidadeMapper {

    CidadeDTO cidadeToCidadeDTO(Cidade cidade);

     Cidade cidadeDtoToCidade(CidadeDTO dto);
}
