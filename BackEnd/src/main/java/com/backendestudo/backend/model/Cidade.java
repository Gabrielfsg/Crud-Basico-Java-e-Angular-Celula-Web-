package com.backendestudo.backend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cidade")
public class Cidade{

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "codigo_cidade")
     private Long codigoCidade;
    @Column(name = "nome_cidade")
     private String nomeCidade;
    @Column(name = "habitantes_cidade")
     private Long habitantesCidade;
    @Column(name = "nome_estado")
    @Enumerated(EnumType.STRING)
     private EnumEstado nomeEstado;
}
