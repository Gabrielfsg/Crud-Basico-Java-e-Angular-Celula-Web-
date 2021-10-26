package com.backendestudo.backend.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {

    private Long codigoPessoa;
    private String nomePessoa;
    private String apelidoPessoa;
    private String timePessoa;
    private String cpfPessoa;
    private String hobbiePessoa;
    private CidadeDTO cidade;
}
