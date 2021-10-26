package com.backendestudo.backend.Resource;


import com.backendestudo.backend.dto.CidadeDTO;
import com.backendestudo.backend.service.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/city")
public class CidadeResource {

    private CidadeService cidadeService;


    /** Método para criar cidades */
    @PostMapping
    public ResponseEntity<CidadeDTO> cadastrarCidade(@RequestBody CidadeDTO dto){
        return new ResponseEntity<>(cidadeService.cadastrarCidade(dto), HttpStatus.CREATED);
    }

    /** Método para deletar cidades */
    @DeleteMapping("/{codigoCidade}")
    public ResponseEntity deletarCidade(@PathVariable Long codigoCidade){
        cidadeService.deletarCidade(codigoCidade);
        return ResponseEntity.noContent().build();
    }
    /** Método para listar tudo */
    @GetMapping
    public ResponseEntity<List<CidadeDTO>> listarTodasCidades(){
        return new ResponseEntity<>(cidadeService.listarTodasCidades(), HttpStatus.OK);
    }

    /** Método para listar por codigo */
    @GetMapping("/{codigoCidade}")
    public ResponseEntity <CidadeDTO> listarCidadePorCod(@PathVariable Long codigoCidade){
        return new ResponseEntity<>(cidadeService.listarCidadePorCodigo(codigoCidade), HttpStatus.OK);
    }


    /** Método para alterar por codigo */
    @PutMapping("/{codigoCidade}")
    public ResponseEntity <CidadeDTO> editarPorCodigo(@RequestBody CidadeDTO dto, @PathVariable Long codigoCidade){
        return new ResponseEntity<>(cidadeService.editarPorCodigo(dto,codigoCidade),HttpStatus.OK);
    }
}
