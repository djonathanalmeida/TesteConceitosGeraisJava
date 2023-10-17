package services;

public class TaxaEUA implements TaxaService {

	@Override
	public Double taxa(Double valorTaxa) {
		return 10.0;
	}

}
