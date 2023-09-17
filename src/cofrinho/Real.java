package cofrinho;

//Subclasse da classe Moedas
public class Real extends Moedas {

	// Função que define como a Moeda de Subclasse Real será
	// apresentada na listagem
	@Override
	public String info() {
		return "Real - " + valor;
	}

	// Constructor da subclasse Real
	public Real(double valor) {
		super(valor);
	}

}
