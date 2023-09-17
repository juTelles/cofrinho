package cofrinho;

//Subclasse da classe Moedas
public class Dolar extends Moedas {

	// Função que define como a Moeda de Subclasse Dólar será
	// apresentada na listagem
	@Override
	public String info() {
		return "Dólar - " + valor;
	}

	// Constructor da subclasse Dólar
	public Dolar(double valor) {
		super(valor);
	}

	// Função converter específica para Moedas de subclasse Dólar
	public double converter(Moedas moeda) {
		double valor;
		valor = moeda.valor * 4;
		return valor;
	}
}
