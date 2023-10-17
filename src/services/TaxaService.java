package services;

public interface TaxaService {

	Double taxa(Double valorTaxa);
	
	default String testeDefaultMethods() {
		return "Programa APPMINHACONTA finalizado! Até mais.";
	}

}
