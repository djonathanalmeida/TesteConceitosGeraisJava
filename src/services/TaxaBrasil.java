package services;

public class TaxaBrasil implements TaxaService {

	@Override
	public Double taxa(Double valorTaxa) {
		return valorTaxa * 0.05;

	}

}
