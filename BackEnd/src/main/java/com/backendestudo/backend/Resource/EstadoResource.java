package com.backendestudo.backend.Resource;

import com.backendestudo.backend.dto.EstadoDTO;
import com.backendestudo.backend.service.EstadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/estado")
public class EstadoResource {

    EstadoService estadoService;


    /** Método para listar todos os estados */
    @GetMapping
    public ResponseEntity<List<EstadoDTO>> listarTodosEstados(){
        return new ResponseEntity<>(estadoService.listarTodosEstados(), HttpStatus.OK);
    }
}
