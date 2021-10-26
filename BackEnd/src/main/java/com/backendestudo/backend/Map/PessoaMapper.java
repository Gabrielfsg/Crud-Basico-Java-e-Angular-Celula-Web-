package com.backendestudo.backend.Map;


import com.backendestudo.backend.dto.PessoaDTO;
import com.backendestudo.backend.model.Pessoa;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaDTO pessoaToPessoaDTO(Pessoa pessoa);

    Pessoa pessoaDTOToPessoa(PessoaDTO pessoaDTO);
}
