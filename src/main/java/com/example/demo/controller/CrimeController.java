package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Crime;
import com.example.demo.repository.CrimeRepository;


@RestController
@RequestMapping("/")
public class CrimeController {
  
  @Autowired
  private CrimeRepository repository;
  
  @PostMapping
  public void salvarCrimes() throws FileNotFoundException {
    List<Crime> crimes = this.criar(); //Retorna uma lista com todos os crimes na planilha.
    try {
      crimes = repository.saveAll(crimes);
      System.out.printf("Foram adicionadas {} linhas", crimes.size());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public List<Crime> criar() throws FileNotFoundException{
    
    List<Crime> crimes = new ArrayList<Crime>();
    
    try {
      //Lendo o arquivo
      FileInputStream file = new FileInputStream("src/main/resources/MICRODADOS_DE_VIOLÊNCIA_DOMÉSTICA_JAN_2015_A_OUT_2021.xlsx");
      Workbook workbook = new XSSFWorkbook(file);      
      //Setando a aba
      Sheet sheet = workbook.getSheetAt(0);
      
      //Setando as linhas
      List<Row> rows = (List<Row>) toList(sheet.iterator());   
      
      //Remove os cabeçalhos
      rows.remove(0);
      
      //Setando as celulas(colunas)
      rows.forEach(row -> {
        List<Cell> cells = (List<Cell>) toList(row.cellIterator());
        
        String faixaEtariaFormatada = cells.get(6).toString();
        faixaEtariaFormatada = faixaEtariaFormatada.substring(3);
        
        if(faixaEtariaFormatada.equals("zio)")) {
          faixaEtariaFormatada = "Não informada";
        }
        
        Crime crime = new Crime();
        
        crime.setMunicipioDoFato(cells.get(0).toString());
        crime.setRegiaoGeografica(cells.get(1).toString());
        crime.setNatureza(cells.get(2).toString());
        crime.setDataDoFato(cells.get(3).getDateCellValue());
        crime.setAno((int)cells.get(4).getNumericCellValue());
        crime.setSexo(cells.get(5).toString());
        crime.setFaixaEtaria(faixaEtariaFormatada);
        crime.setTotalDeEnvolvidos((int)cells.get(7).getNumericCellValue());
        
        crimes.add(crime);
      });
      workbook.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return crimes;
  }
  
  public List<?> toList(Iterator<?> iterator){
    return IteratorUtils.toList(iterator);
  }

}
