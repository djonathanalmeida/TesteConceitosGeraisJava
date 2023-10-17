package entities;

import entities.enums.TipoConta;
import services.TaxaService;

public class Juridica extends Conta {

	private String cnpj;

	public Juridica() {
		super();
	}

	public Juridica(Integer numero, String nome, Double saldo, TipoConta tipo, String cnpj, TaxaService taxa) {
		super(numero, nome, saldo, tipo, taxa);
		this.cnpj = cnpj;

	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public Double retornaSaldo() {
		return getSaldo();
	}

	@Override
	public String toString() {
		return "Conta: " + getNumero() + ", Tipo: " + getTipo() + ", Nome: " + getNome() + ", CNPJ: " + getCnpj()
				+ ", Saldo: R$" + retornaSaldo() + ", Sobreposição: " + testeSobreposicao();
	}

}
