package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Crime;

@Repository
public interface CrimeRepository extends JpaRepository<Crime, Long> {

  @Query(
      value = "SELECT DISTINCT obj.municipioDoFato FROM Crime AS obj ORDER BY obj.municipioDoFato")
  List<String> mostrarCidades();

  @Query(
      value = "SELECT DISTINCT obj.regiaoGeografica FROM Crime AS obj ORDER BY obj.regiaoGeografica")
  List<String> mostrarRegioes();

  @Query(value = "SELECT DISTINCT obj.natureza FROM Crime AS obj ORDER BY obj.natureza")
  List<String> mostrarNaturezas();

  @Query(value = "SELECT DISTINCT obj.ano FROM Crime AS obj ORDER BY obj.ano")
  List<String> mostrarAnos();

  @Query(value = "SELECT DISTINCT obj.sexo FROM Crime AS obj ORDER BY obj.sexo")
  List<String> mostrarSexos();

  @Query(value = "SELECT DISTINCT obj.faixaEtaria FROM Crime AS obj ORDER BY obj.faixaEtaria")
  List<String> mostrarFaixasEtarias();

  @Query(
      value = "SELECT DISTINCT obj.totalDeEnvolvidos FROM Crime AS obj ORDER BY obj.totalDeEnvolvidos")
  List<Integer> mostrarTotalDeEnvolvidos();

  @Query(value = "SELECT obj FROM Crime as obj where obj.dataDoFato = :dataDoFato")
  List<Crime> mostrarCrimesPorData(LocalDate dataDoFato);

  @Query(value = "SELECT obj.dataDoFato FROM Crime as obj ORDER BY obj.dataDoFato DESC")
  List<LocalDate> mostrarUltimaData();

  @Query(value = "SELECT * FROM tb_crimes ORDER BY data_do_fato DESC limit :limit",
      nativeQuery = true)
  List<Crime> mostrarDezUltimosCrimes(@Param("limit") int limit);

  @Query(
      value = "SELECT obj.natureza as natureza, count(obj.natureza) as quantidade FROM tb_crimes obj where ano = :ano group by natureza",
      nativeQuery = true)
  List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorNatureza(@Param("ano") int ano);

  @Query(
      value = "SELECT obj.regiao_geografica as regiao, count(obj.regiao_geografica) as quantidade FROM tb_crimes as obj where ano = :ano group by obj.regiao_geografica",
      nativeQuery = true)
  List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorRegiaoGeografica(@Param("ano") int ano);

  @Query(
      value = "SELECT obj.municipio_do_fato as municipio, count(obj.municipio_do_fato) as quantidade FROM tb_crimes as obj where ano = :ano group by obj.municipio_do_fato ORDER BY quantidade DESC",
      nativeQuery = true)
  List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorMunicipioDoFato(@Param("ano") int ano);

  @Query(
      value = "SELECT obj.ano AS ano, COUNT(obj.ano) AS quantidade FROM tb_crimes AS obj GROUP BY obj.ano ORDER BY obj.ano DESC",
      nativeQuery = true)
  List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorAno();

  @Query(
      value = "SELECT obj.sexo AS sexo, COUNT(obj.sexo) AS quantidade FROM tb_crimes AS obj WHERE obj.ano = :ano GROUP BY obj.sexo ORDER BY quantidade DESC ",
      nativeQuery = true)
  List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorSexo(@Param("ano") int ano);

  @Query(
      value = "SELECT obj.faixa_etaria AS FaixaEtaria, COUNT(obj.faixa_etaria) AS quantidade FROM tb_crimes AS obj WHERE obj.ano = :ano GROUP BY obj.faixa_etaria ORDER BY quantidade DESC ",
      nativeQuery = true)
  List<Map<String, Integer>> mostrarQuantidadeDeCrimesPorFaixaEtaria(@Param("ano") int ano);
}
