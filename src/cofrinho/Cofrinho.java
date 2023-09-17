package cofrinho;

import java.util.ArrayList;

public class Cofrinho {

	// Define array de Moedas
	ArrayList<Moedas> listaMoedas = new ArrayList<Moedas>();

	// Adiciona a moeda passada como parâmetro a array listaMoedas
	public void adicionar(Moedas moeda) {
		listaMoedas.add(moeda);
	}

	// Remove a moeda passada como parâmetro a array listaMoedas
	public void remover(Moedas moeda) {
		listaMoedas.remove(moeda);
	}

	// Lista todas as moedas contidas na array listaMoedas
	public void listarMoedas() {
		// Itera pela array listaMoedas
		for (Moedas moeda : listaMoedas) {
			// Para cada moeda da lista chama moeda.info() para que um
			// print formatado de acordo com cada subclasse seja apresentado
			System.out.println(moeda.info());
		}
	}

	// O método totalConvertido() retorna o total dos valores
	// de todas a moedas (de todas as subclasses) convertido para Real
	public void totalConvertido() {
		double total;
		total = 0;
		double valorEmReal;
		// Itera pela array listaMoedas convertendo o valor de cada moeda
		// para Real e depois o soma a variável total que será
		// mostrada no console depois do loop
		for (Moedas moeda : listaMoedas) {
			valorEmReal = 0;
			valorEmReal = moeda.converter(moeda);
			total = total + valorEmReal;
		}
		System.out.println("O total convertido em reais é " + total);
	}

	// Método para checar se o objeto moeda passado como parâmetro é null
	// para que não seja adicionado ou removido da lista se for o caso
	public boolean ehNull(Moedas moeda) {
		if (moeda == null)
			return true;
		return false;
	}

}
