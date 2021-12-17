package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Crime;
import com.example.demo.service.CrimeService;

@RestController
@CrossOrigin
@RequestMapping("/crimes")
public class CrimeController {

  @Autowired
  CrimeService service;

  @GetMapping(value = "/cidades")
  public ResponseEntity<List<String>> mostrarCidades() {
    List<String> list = service.mostrarCidades();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/regioes")
  public ResponseEntity<List<String>> mostrarRegioes() {
    List<String> list = service.mostrarRegioes();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/naturezas")
  public ResponseEntity<List<String>> mostrarNaturezas() {
    List<String> list = service.mostrarNaturezas();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/anos")
  public ResponseEntity<List<String>> mostrarAnos() {
    List<String> list = service.mostrarAnos();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/sexos")
  public ResponseEntity<List<String>> mostrarSexos() {
    List<String> list = service.mostrarSexos();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/faixas-etarias")
  public ResponseEntity<List<String>> mostrarFaixasEtarias() {
    List<String> list = service.mostrarFaixasEtarias();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/total-envolvidos")
  public ResponseEntity<List<Integer>> mostrarTotalEnvolvidos() {
    List<Integer> list = service.mostrarTotalDeEnvolvidos();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/crimes-por-data")
  public ResponseEntity<List<Crime>> mostrarCrimesPorData(
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDoFato) {
    List<Crime> list = service.mostrarCrimesPorData(dataDoFato);
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/ultima-data")
  public ResponseEntity<LocalDate> mostrarUltimaData() {
    LocalDate ultimaData = service.mostrarUltimaData().get(0);
    return ResponseEntity.ok(ultimaData);
  }

  @GetMapping(value = "/dez-ultimos-crimes")
  public ResponseEntity<List<Crime>> mostrarDezUltimosCrimes() {
    List<Crime> listaDezUltimosCrimes = service.mostrarDezUltimosCrimes();
    return ResponseEntity.ok(listaDezUltimosCrimes);
  }

  @GetMapping(value = "/qtd-crimes-natureza-ano")
  public ResponseEntity<List<Map<String, Integer>>> mostrarQuantidadeDeCrimesPorNatureza(int ano) {
    List<Map<String, Integer>> qtdCrimesPorNaturezaEAno =
        service.mostrarQuantidadeDeCrimesPorNatureza(ano);
    return ResponseEntity.ok(qtdCrimesPorNaturezaEAno);
  }

  @GetMapping(value = "/qtd-crimes-regiao-ano")
  public ResponseEntity<List<Map<String, Integer>>> mostrarQuantidadeDeCrimesPorRegiaoGeografica(
      int ano) {
    List<Map<String, Integer>> qtdCrimesPorRegiaoEAno =
        service.mostrarQuantidadeDeCrimesPorRegiaoGeografica(ano);
    return ResponseEntity.ok(qtdCrimesPorRegiaoEAno);
  }

  @GetMapping(value = "/qtd-crimes-municipio-ano")
  public ResponseEntity<List<Map<String, Integer>>> mostrarQuantidadeDeCrimesPorMunicipioDoFato(
      int ano) {
    List<Map<String, Integer>> qtdCrimesPorMunicipioEAno =
        service.mostrarQuantidadeDeCrimesPorMunicipioDoFato(ano);
    return ResponseEntity.ok(qtdCrimesPorMunicipioEAno);
  }

  @GetMapping(value = "/qtd-crimes-ano")
  public ResponseEntity<List<Map<String, Integer>>> mostrarQuantidadeDeCrimesPorMunicipioDoFato() {
    List<Map<String, Integer>> qtdCrimesPorAno = service.mostrarQuantidadeDeCrimesPorAno();
    return ResponseEntity.ok(qtdCrimesPorAno);
  }

  @GetMapping(value = "/qtd-crimes-sexo-ano")
  public ResponseEntity<List<Map<String, Integer>>> mostrarQuantidadeDeCrimesPorSexo(int ano) {
    List<Map<String, Integer>> qtdCrimesPorSexo = service.mostrarQuantidadeDeCrimesPorSexo(ano);
    return ResponseEntity.ok(qtdCrimesPorSexo);
  }

  @GetMapping(value = "/qtd-crimes-faixa-etaria-ano")
  public ResponseEntity<List<Map<String, Integer>>> mostrarQuantidadeDeCrimesPorFaixaEtaria(
      int ano) {
    List<Map<String, Integer>> qtdCrimesPorSexo =
        service.mostrarQuantidadeDeCrimesPorFaixaEtaria(ano);
    return ResponseEntity.ok(qtdCrimesPorSexo);
  }

}
