package com.backendestudo.backend.service;


import com.backendestudo.backend.dto.PessoaDTO;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


@AllArgsConstructor
@Service
public class RelatorioService {

    private PessoaService pessoaService;

    public byte[] gerarPDF(Long codigoPessoa) {

        PessoaDTO pessoaDTO = pessoaService.listarPessoaPorCodigo(codigoPessoa);

        if(pessoaDTO != null) {

            ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();//duvida
            templateResolver.setSuffix(".html");
            templateResolver.setPrefix("/templates/");
            templateResolver.setCharacterEncoding("UTF-8");
            templateResolver.setTemplateMode(TemplateMode.HTML);

            TemplateEngine templateEngine = new TemplateEngine();// criam a engine da interface
            templateEngine.setTemplateResolver(templateResolver);

            Context context = new Context();
            context.setVariable("codigoPessoa", pessoaDTO.getCodigoPessoa());
            context.setVariable("nomePessoa", pessoaDTO.getNomePessoa());
            context.setVariable("apelidoPessoa", pessoaDTO.getApelidoPessoa());
            context.setVariable("timePessoa", pessoaDTO.getTimePessoa());
            context.setVariable("cpfPessoa", pessoaDTO.getCpfPessoa());
            context.setVariable("hobbiePessoa", pessoaDTO.getHobbiePessoa());
            context.setVariable("nomeCidade", pessoaDTO.getCidade().getNomeCidade());
            String html = templateEngine.process("/pessoaRelatorio", context);
            ByteArrayOutputStream alvo = new ByteArrayOutputStream();
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setBaseUri("http://localhost:8080");
            HtmlConverter.convertToPdf(html, alvo, converterProperties);
            byte[] bytes = alvo.toByteArray();
            return bytes;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
