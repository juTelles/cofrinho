package cofrinho;

//Subclasse da classe Moedas
public class Euro extends Moedas {

	// Função que define como a Moeda de Subclasse Euro será
	// apresentada na listagem
	@Override
	public String info() {
		return "Euro - " + valor;
	}

	// Constructor da subclasse Euro
	public Euro(double valor) {
		super(valor);
	}

	// Função converter específica para Moedas de subclasse Euro
	public double converter(Moedas moeda) {
		double valor;
		valor = moeda.valor * 5;
		return valor;
	}

}
