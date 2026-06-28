package com.claudiodeveloper.processosjuridicos.controller;

import com.claudiodeveloper.processosjuridicos.model.Processo;
import com.claudiodeveloper.processosjuridicos.service.ProcessoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {

    @Autowired
    private ProcessoService service;

    // POST: Criar um novo processo (AGORA COM VALIDAÇÃO)
    @PostMapping
    public ResponseEntity<Processo> criar(@Valid @RequestBody Processo processo) {
        Processo novoProcesso = service.salvar(processo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProcesso);
    }

    // GET: Listar todos os processos
    @GetMapping
    public ResponseEntity<List<Processo>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // GET: Buscar um processo específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Processo> buscarPorId(@PathVariable Long id) {
        Optional<Processo> processo = service.buscarPorId(id);
        if (processo.isPresent()) {
            return ResponseEntity.ok(processo.get());
        }
        return ResponseEntity.notFound().build();
    }

    // PUT: Atualizar um processo existente (AGORA COM VALIDAÇÃO)
    @PutMapping("/{id}")
    public ResponseEntity<Processo> atualizar(@PathVariable Long id, @Valid @RequestBody Processo processoAtualizado) {
        Optional<Processo> processoExistente = service.buscarPorId(id);
        if (processoExistente.isPresent()) {
            processoAtualizado.setId(id);
            return ResponseEntity.ok(service.salvar(processoAtualizado));
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Apagar um processo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Processo> processoExistente = service.buscarPorId(id);
        if (processoExistente.isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}