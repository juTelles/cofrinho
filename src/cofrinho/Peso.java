package cofrinho;

public class Peso extends Moedas {
	
	// Função que define como a Moeda de Subclasse Dólar será
	// apresentada na listagem
	@Override
	public String info() {
		return "Peso - " + valor;
	}

	// Constructor da subclasse Dólar
	public Peso(double valor) {
		super(valor);
	}

	// Função converter específica para Moedas de subclasse Dólar
	public double converter(Moedas moeda) {
		double valor;
		valor = moeda.valor * 4;
		return valor;
	}

}
