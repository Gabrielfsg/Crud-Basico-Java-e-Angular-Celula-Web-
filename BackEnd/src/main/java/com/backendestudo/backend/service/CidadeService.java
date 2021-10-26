package com.backendestudo.backend.service;

import com.backendestudo.backend.Map.CidadeMapper;
import com.backendestudo.backend.dto.CidadeDTO;
import com.backendestudo.backend.model.Cidade;
import com.backendestudo.backend.repository.CidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;
    private CidadeMapper cidadeMap;


    public CidadeDTO cadastrarCidade(CidadeDTO d){
        Cidade cidade = cidadeMap.cidadeDtoToCidade(d);
            return cidadeMap.cidadeToCidadeDTO(cidadeRepository.save(cidade));
    }

    public void deletarCidade(Long codigoCidade){
       Optional <Cidade> cidadeSalva = (cidadeRepository.findById(codigoCidade));
       if(cidadeSalva.isPresent()){
           cidadeRepository.deleteById(codigoCidade);
       }else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }

    public List<CidadeDTO> listarTodasCidades(){
        return cidadeRepository.findAll().stream().map(cidadeMap :: cidadeToCidadeDTO)
                .collect(Collectors.toList());
    }

    public CidadeDTO listarCidadePorCodigo(Long codigoCidade){
        Cidade cidadeSalva = (cidadeRepository.findById(codigoCidade).get());
        if (cidadeSalva != null) {
            return cidadeMap.cidadeToCidadeDTO(cidadeSalva);
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }


        public CidadeDTO editarPorCodigo(CidadeDTO dto, Long codigoCidade){
            Cidade cidadeS = cidadeRepository.findById(codigoCidade).get();
            if(cidadeS != null){
                BeanUtils.copyProperties(dto,cidadeS, "codigoCidade");
                return cidadeMap.cidadeToCidadeDTO(cidadeRepository.save(cidadeS));
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
}
