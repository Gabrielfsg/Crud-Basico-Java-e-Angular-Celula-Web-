package com.backendestudo.backend.Resource;


import com.backendestudo.backend.Util.ExportacaoUtil;
import com.backendestudo.backend.dto.PessoaDTO;
import com.backendestudo.backend.service.PessoaService;
import com.backendestudo.backend.service.RelatorioService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
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
@RequestMapping("/api/pessoa")
public class PessoaResource {


    private PessoaService pessoaService;
    private RelatorioService relatorioService;

    /** Método para criar pessoas */
    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@RequestBody PessoaDTO pessoaDto){
        return new ResponseEntity<>(pessoaService.cadastrarPessoa(pessoaDto), HttpStatus.CREATED);
    }

    /** Método para listar todas as pessoas */
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarTodasCidades(){
        return new ResponseEntity<>(pessoaService.listarTodasPessoas(), HttpStatus.OK);
    }

    /** Método para listar por codigo */
    @GetMapping("/{codigoPessoa}")
    public ResponseEntity <PessoaDTO> listarPessoaPorCodigo(@PathVariable Long codigoPessoa){
        return new ResponseEntity<>(pessoaService.listarPessoaPorCodigo(codigoPessoa), HttpStatus.OK);
    }

    /** Método para deletar cidades */
    @DeleteMapping("/{codigoPessoa}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long codigoPessoa){
        pessoaService.deletarPessoa(codigoPessoa);
        return ResponseEntity.noContent().build();
    }



    /** Método para alterar por codigo */
    @PutMapping("/{codigoPessoa}")
    public ResponseEntity <PessoaDTO> editarPorCodigo(@RequestBody PessoaDTO dto, @PathVariable Long codigoPessoa){
        return new ResponseEntity<>(pessoaService.editarPorCodigo(dto,codigoPessoa),HttpStatus.OK);
    }

    /** Método para salvar em pdf pelo codigo */
    @GetMapping("/{codigoPessoa}/relatorio")
    public ResponseEntity<InputStreamResource> salvarEmPDF(@PathVariable Long codigoPessoa){
     return ExportacaoUtil.output(relatorioService.gerarPDF(codigoPessoa), pessoaService.listarNomePessoa(codigoPessoa));

    }


}
