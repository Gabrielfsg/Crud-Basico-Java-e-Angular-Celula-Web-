package com.backendestudo.backend.dto;


import com.backendestudo.backend.model.EnumEstado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {

    private Long codigoCidade;
    private String nomeCidade;
    private Long habitantesCidade;
    private EnumEstado nomeEstado;


}
