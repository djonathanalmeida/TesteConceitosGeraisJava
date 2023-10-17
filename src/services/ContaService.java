package services;
import entities.Conta;

public class ContaService {
	
	public Conta saveConta(Conta conta)
	{
		System.out.printf("Conta nº %d foi criada com sucesso", conta.getNumero());
		return conta;
	}
}
