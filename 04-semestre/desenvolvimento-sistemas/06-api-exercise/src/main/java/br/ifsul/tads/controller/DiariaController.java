package br.ifsul.tads.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.tads.dto.DiariaDTO;
import br.ifsul.tads.service.DiariaService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/diarias")
public class DiariaController {
    private DiariaService ds;

    @GetMapping
    public ResponseEntity<Object> consultarTodos() {
        List<DiariaDTO> diarias = ds.getAll();
        return ResponseEntity.ok(diarias);
    }

    @GetMapping("/valor/{poder}")
    public ResponseEntity<Double> somarValorPorPoder(@PathVariable String poder) {
        Double soma = ds.somarValorPorPoder(poder);
        return ResponseEntity.ok(soma);
    }

    // @PostMapping
    // public ResponseEntity<Object> criar(@RequestBody DiariaDTO novaDiaria) {
    //     DiariaDTO diariaCriada = ds.criar(novaDiaria);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(diariaCriada);
    // }
}
