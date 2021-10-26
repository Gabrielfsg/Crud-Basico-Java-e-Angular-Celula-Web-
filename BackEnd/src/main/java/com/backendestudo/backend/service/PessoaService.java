package com.backendestudo.backend.service;

import com.backendestudo.backend.Map.PessoaMapper;
import com.backendestudo.backend.dto.PessoaDTO;
import com.backendestudo.backend.model.Pessoa;
import com.backendestudo.backend.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaMapper pessoaMapper;

    public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDto){
        Pessoa pessoa = pessoaMapper.pessoaDTOToPessoa(pessoaDto);
            return pessoaMapper.pessoaToPessoaDTO(pessoaRepository.save(pessoa));
    }
    public List<PessoaDTO> listarTodasPessoas(){
        return pessoaRepository.findAll().stream().map(pessoaMapper :: pessoaToPessoaDTO)
                .collect(Collectors.toList());
    }


    public PessoaDTO listarPessoaPorCodigo(Long codigoPessoa){
        Pessoa pessoaSalva = (pessoaRepository.findById(codigoPessoa).get());
        if (pessoaSalva != null) {
            return pessoaMapper.pessoaToPessoaDTO(pessoaSalva);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public String listarNomePessoa(Long codigoPessoa){
        Pessoa pessoaSalva = (pessoaRepository.findById(codigoPessoa).get());
        if (pessoaSalva != null) {
            return pessoaSalva.getNomePessoa();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deletarPessoa(Long codigoPessoa){
        Optional<Pessoa> pessoaSalva = (pessoaRepository.findById(codigoPessoa));
        if(pessoaSalva.isPresent()){
            pessoaRepository.deleteById(codigoPessoa);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    public PessoaDTO editarPorCodigo(PessoaDTO dto, Long codigoPessoa){
     Pessoa pessoaS = pessoaRepository.findById(codigoPessoa).get();
         return Optional.ofNullable(pessoaS)
                 .map(pessoa -> pessoaMapper.pessoaToPessoaDTO(pessoaRepository.save(pessoaMapper.pessoaDTOToPessoa(dto))))
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

}


