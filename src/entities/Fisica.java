package entities;

import entities.enums.TipoConta;
import services.TaxaService;

public class Fisica extends Conta {

	private String cpf;

	public Fisica() {
		super();

	}

	public Fisica(Integer numero, String nome, Double saldo, TipoConta tipo, String cpfd, TaxaService taxa) {
		super(numero, nome, saldo, tipo, taxa);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public Double retornaSaldo() {
		return getSaldo() + 1000.0;
	}

	@Override
	public String testeSobreposicao() {
		return "texto_classefilha";
	}

	public String testeSobrecarga(String texto1) {
		return texto1 + "texto2";
	}

	public double testeSobrecarga(Double texto1) {
		return texto1 + 2.0;
	}

	@Override
	public String toString() {
		return "Conta: " + getNumero() + ", Tipo: " + getTipo() + ", Nome: " + getNome() + ", CPF: " + getCpf()
				+ ", Saldo: R$" + retornaSaldo() + ", Sobreposição: " + testeSobreposicao();
	}

}
