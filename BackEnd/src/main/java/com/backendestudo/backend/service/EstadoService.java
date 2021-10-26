package com.backendestudo.backend.service;

import com.backendestudo.backend.Map.EstadoMapper;
import com.backendestudo.backend.dto.EstadoDTO;
import com.backendestudo.backend.model.EnumEstado;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class EstadoService {

    private EstadoMapper estadoMapper;

    public List<EstadoDTO> listarTodosEstados(){
        return estadoMapper.estadoToEstadoDTO(Arrays.asList(EnumEstado.values()));
    }



}
