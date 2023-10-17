package entities;

import entities.enums.TipoConta;
import services.TaxaService;

public abstract class Conta {

	private Integer numero;
	private String nome;
	private Double saldo;
	private TipoConta tipo;
	private TaxaService taxaService;
	public static final String BemVindo = "Seja bem-vindo ao APPMINHACONTA"; // Estatico (static) e Constante (final)

	public Conta() {

	}

	public Conta(Integer numero, String nome, Double saldo, TipoConta tipo, TaxaService taxa) {

		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.tipo = tipo;
		this.taxaService = taxa;

	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		Double taxa = taxaService.taxa(saldo);
		return saldo - taxa;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public TaxaService getTaxa() {
		return taxaService;
	}

	public void setTaxa(TaxaService taxa) {
		this.taxaService = taxa;
	}

	public abstract Double retornaSaldo();

	public String testeSobreposicao() {
		return "texto_classepai";
	}

}
