package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entity.Crime;
import com.example.demo.repository.CrimeRepository;

@Service
public class CrimeService {

  @Autowired
  private CrimeRepository repository;

  @Transactional(readOnly = true)
  public List<String> mostrarCidades() {
    List<String> list = repository.mostrarCidades();
    return list;
  }

  @Transactional(readOnly = true)
  public List<String> mostrarRegioes() {
    List<String> list = repository.mostrarRegioes();
    return list;
  }

  @Transactional(readOnly = true)
  public List<String> mostrarNaturezas() {
    List<String> list = repository.mostrarNaturezas();
    return list;
  }

  @Transactional(readOnly = true)
  public List<String> mostrarAnos() {
    List<String> list = repository.mostrarAnos();
    return list;
  }

  @Transactional(readOnly = true)
  public List<String> mostrarSexos() {
    List<String> list = repository.mostrarSexos();
    return list;
  }

  @Transactional(readOnly = true)
  public List<String> mostrarFaixasEtarias() {
    List<String> list = repository.mostrarFaixasEtarias();
    return list;
  }

  @Transactional(readOnly = true)
  public List<Integer> mostrarTotalDeEnvolvidos() {
    List<Integer> list = repository.mostrarTotalDeEnvolvidos();
    return list;
  }

  @Transactional(readOnly = true)
  public List<Crime> mostrarCrimesPorData(@RequestParam("dataDoFato") LocalDate dataDoFato) {
    List<Crime> list = repository.mostrarCrimesPorData(dataDoFato);
    return list;
  }

  @Transactional(readOnly = true)
  public List<LocalDate> mostrarUltimaData() {
    List<LocalDate> ultimaData = repository.mostrarUltimaData();
    return ultimaData;
  }

  @Transactional(readOnly = true)
  public List<Crime> mostrarDezUltimosCrimes() {
    List<Crime> list = repository.mostrarDezUltimosCrimes(10);
    return list;
  }

  @Transactional(readOnly = true)
  public List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorNatureza(
      @RequestParam("ano") int ano) {
    List<Map<String, Integer>> map = repository.mostrarQuantidadeDeCrimesPorNatureza(ano);
    return map;
  }

  @Transactional(readOnly = true)
  public List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorRegiaoGeografica(
      @RequestParam("ano") int ano) {
    List<Map<String, Integer>> map = repository.mostrarQuantidadeDeCrimesPorRegiaoGeografica(ano);
    return map;
  }

  @Transactional(readOnly = true)
  public List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorMunicipioDoFato(
      @RequestParam("ano") int ano) {
    List<Map<String, Integer>> map = repository.mostrarQuantidadeDeCrimesPorMunicipioDoFato(ano);
    return map;
  }

  @Transactional(readOnly = true)
  public List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorAno() {
    List<Map<String, Integer>> map = repository.mostrarQuantidadeDeCrimesPorAno();
    return map;
  }

  @Transactional(readOnly = true)
  public List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorSexo(@RequestParam("ano") int ano) {
    List<Map<String, Integer>> map = repository.mostrarQuantidadeDeCrimesPorSexo(ano);
    return map;
  }

  @Transactional(readOnly = true)
  public List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorFaixaEtaria(
      @RequestParam("ano") int ano) {
    List<Map<String, Integer>> map = repository.mostrarQuantidadeDeCrimesPorFaixaEtaria(ano);
    return map;
  }

}
