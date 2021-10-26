package com.backendestudo.backend.Map;


import com.backendestudo.backend.dto.EstadoDTO;
import com.backendestudo.backend.model.EnumEstado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface EstadoMapper {

    @Mapping(expression = "java(entity.name())", target ="id")
    EstadoDTO estadoToEstadoDTO(EnumEstado entity);

    List<EstadoDTO> estadoToEstadoDTO(List<EnumEstado> entity);

}
