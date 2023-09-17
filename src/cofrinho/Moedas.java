package cofrinho;

public abstract class Moedas {
	double valor;

	// Constructor Moedas
	public Moedas(double valor) {
		super();
		this.valor = valor;
	}

	// Função base de converter - converte Real para Real
	public double converter(Moedas moeda) {
		double valor;
		valor = moeda.valor * 1;
		return valor;
	}

	// Função que define como objetos da classe Moedas serão
	// apresentados na listagem, será substituída pelas funções
	// info() específicas de cada subclasse
	public String info() {
		return "Moeda - " + valor;
	}

	// Função utilizada para verificar e definir qual a moeda que
	// será removida na opção remover
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moedas other = (Moedas) obj;
		if (valor != other.valor)
			return false;
		return true;
	}

}
