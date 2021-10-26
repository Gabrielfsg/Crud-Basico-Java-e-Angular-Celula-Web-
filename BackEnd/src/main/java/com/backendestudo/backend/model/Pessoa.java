package com.backendestudo.backend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pessoa")
    private Long codigoPessoa;
    @Column(name = "nome_pessoa")
    private String nomePessoa;
    @Column(name = "apelido_pessoa")
    private String apelidoPessoa;
    @Column(name = "time_pessoa")
    private String timePessoa;
    @Column(name = "cpf_pessoa")
    private String cpfPessoa;
    @Column(name = "hobbie_pessoa")
    private String hobbiePessoa;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cidade_pessoa")
    private Cidade cidade;
}
