package com.generation.escola.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_escola")
public class Escola {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private Long idade;
	
	@NotNull
	private Long notaPrimeiro;
	
	@NotNull
	private Long notaSegundo;
	
	@NotBlank
	private String nomeProf;
	
	@NotNull
	private Long numeroSala;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public Long getNotaPrimeiro() {
		return notaPrimeiro;
	}

	public void setNotaPrimeiro(Long notaPrimeiro) {
		this.notaPrimeiro = notaPrimeiro;
	}

	public Long getNotaSegundo() {
		return notaSegundo;
	}

	public void setNotaSegundo(Long notaSegundo) {
		this.notaSegundo = notaSegundo;
	}

	public String getNomeProf() {
		return nomeProf;
	}

	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}

	public Long getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(Long numeroSala) {
		this.numeroSala = numeroSala;
	}

	
}
