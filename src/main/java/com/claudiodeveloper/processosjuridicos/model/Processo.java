package com.claudiodeveloper.processosjuridicos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tb_processos")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do processo é obrigatório!")
    @Column(nullable = false, unique = true, length = 25)
    private String numeroProcesso;

    @NotBlank(message = "O nome do autor não pode ficar em branco!")
    @Size(min = 3, max = 100, message = "O nome do autor deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String autor;

    @NotBlank(message = "O nome do réu não pode ficar em branco!")
    @Column(nullable = false, length = 100)
    private String reu;

    @Column(columnDefinition = "TEXT")
    private String resumoPeticao;

    @NotNull(message = "A data de distribuição é obrigatória!")
    private LocalDate dataDistribuicao;

    @Column(length = 50)
    private String status;

    public Processo() {
    }

    // --- GETTERS E SETTERS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getReu() {
        return reu;
    }

    public void setReu(String reu) {
        this.reu = reu;
    }

    public String getResumoPeticao() {
        return resumoPeticao;
    }

    public void setResumoPeticao(String resumoPeticao) {
        this.resumoPeticao = resumoPeticao;
    }

    public LocalDate getDataDistribuicao() {
        return dataDistribuicao;
    }

    public void setDataDistribuicao(LocalDate dataDistribuicao) {
        this.dataDistribuicao = dataDistribuicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}