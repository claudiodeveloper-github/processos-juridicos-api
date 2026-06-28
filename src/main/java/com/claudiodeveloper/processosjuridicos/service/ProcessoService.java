package com.claudiodeveloper.processosjuridicos.service;

import com.claudiodeveloper.processosjuridicos.model.Processo;
import com.claudiodeveloper.processosjuridicos.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository repository;

    // C - Create (ou Update)
    public Processo salvar(Processo processo) {
        return repository.save(processo);
    }

    // R - Read (Todos)
    public List<Processo> listarTodos() {
        return repository.findAll();
    }

    // R - Read (Por ID)
    public Optional<Processo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // D - Delete
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}