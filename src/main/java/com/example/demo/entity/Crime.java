package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_crimes")
public class Crime implements Serializable{

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String municipioDoFato;
  private String regiaoGeografica;
  private String natureza;
  private LocalDate dataDoFato;
  private int ano;
  private String sexo;
  private String faixaEtaria;
  private int totalDeEnvolvidos;
  
  public Crime(String municipioDoFato, String regiaoGeografica, String natureza,
      LocalDate dataDoFato, int ano, String sexo, String faixaEtaria, int totalDeEnvolvidos) {
    this.municipioDoFato = municipioDoFato;
    this.regiaoGeografica = regiaoGeografica;
    this.natureza = natureza;
    this.dataDoFato = dataDoFato;
    this.ano = ano;
    this.sexo = sexo;
    this.faixaEtaria = faixaEtaria;
    this.totalDeEnvolvidos = totalDeEnvolvidos;
  }
  
  public Crime() {
  }

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getMunicipioDoFato() {
    return municipioDoFato;
  }
  
  public void setMunicipioDoFato(String municipioDoFato) {
    this.municipioDoFato = municipioDoFato;
  }
  
  public String getRegiaoGeografica() {
    return regiaoGeografica;
  }
  
  public void setRegiaoGeografica(String regiaoGeografica) {
    this.regiaoGeografica = regiaoGeografica;
  }
  
  public String getNatureza() {
    return natureza;
  }
  
  public void setNatureza(String natureza) {
    this.natureza = natureza;
  }
  
  public LocalDate getDataDoFato() {
    return dataDoFato;
  }
  
  public void setDataDoFato(LocalDate dataDoFato) {
    this.dataDoFato = dataDoFato;
  }
  
  public int getAno() {
    return ano;
  }
  
  public void setAno(int ano) {
    this.ano = ano;
  }
  
  public String getSexo() {
    return sexo;
  }
  
  public void setSexo(String sexo) {
    this.sexo = sexo;
  }
  
  public String getFaixaEtaria() {
    return faixaEtaria;
  }
  
  public void setFaixaEtaria(String faixaEtaria) {
    this.faixaEtaria = faixaEtaria;
  }
  
  public int getTotalDeEnvolvidos() {
    return totalDeEnvolvidos;
  }
  
  public void setTotalDeEnvolvidos(int totalDeEnvolvidos) {
    this.totalDeEnvolvidos = totalDeEnvolvidos;
  }

  
}
