package cofrinho;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// Importação e da classe Scanner e sua definição na variável
		// teclado que será usada para receber os inputs do usuário
		Scanner teclado = new Scanner(System.in);

		// Importação classe Cofrinho e sua definição na variável cofre
		// que é do tipo Cofrinho (classe)
		Cofrinho cofre = new Cofrinho();

		// Definição da variável moeda do tipo Moeda (classe)
		Moedas moeda;
		moeda = null;

		// O método que inicializa e finaliza o menu principal
		inicializar(cofre, teclado, moeda);

	}

	public static void inicializar(Cofrinho cofre, Scanner teclado, Moedas moeda) {
		String menu;
		menu = "menu principal";
		int opcao;
		opcao = 0;

		// O método pegarOpcaoMenu() apresenta o menu principal e
		// valida a entrada do usuário
		opcao = pegarOpcaoMenu(opcao, menu, teclado);

		// Estrutura de iteração do Menu Principal
		while (opcao != 0) {

			switch (opcao) {

			case 1: // Adicionar
				// O método inicializarMenuMoedas() retorna a moeda que será adicionada
				moeda = inicializarMenuMoedas(teclado);

				// Tratamento para casos em que inicializarMenuMoedas()
				// retorna null (casos de entrada invalida)
				if (cofre.ehNull(moeda) == false) {
					cofre.adicionar(moeda);
				}

				break;

			case 2: // Remover
				// inicializarMenuMoedas() retorna a moeda que será removida
				moeda = inicializarMenuMoedas(teclado);

				// Tratamento para casos em que inicializarMenuMoedas()
				// retorna null (casos de entrada invalida)
				if (cofre.ehNull(moeda) == false) {
					cofre.remover(moeda);
				}

				break;

			case 3: // Listar
				cofre.listarMoedas();
				break;

			case 4: // Total Convertido
				cofre.totalConvertido();
				break;

			default: // Default para tratar a entrada de outros números
				System.out.println("Entrada invalida, por favor insira uma das opções do Menu a seguir:");
			}

			opcao = pegarOpcaoMenu(opcao, menu, teclado);
		}
		// Finalização do programa caso 0 seja digitado como opção
		System.out.println("Finalizando...");
		teclado.close();
		System.exit(0);
	}

	// Método que inicializa o menu moedas para quando as opções 
	// adicionar ou remover são escolhidas
	public static Moedas inicializarMenuMoedas(Scanner teclado) {
		double valor;
		
		Moedas moeda;
		moeda = null;

		int opcaoMoeda;
		opcaoMoeda = 0;

		String menu;
		menu = "menu moedas";

		// Lista o menu moedas e valida a opcao escolhida
		opcaoMoeda = pegarOpcaoMenu(opcaoMoeda, menu, teclado);
		
		// Tratamento para entradas de opções do menu moedas invalidas
		while(opcaoMoeda>4 || opcaoMoeda<=0) {
			System.out.println("Entrada invalida, por favor insira uma das opções do Menu a seguir:");
			opcaoMoeda = pegarOpcaoMenu(opcaoMoeda, menu, teclado);
		}
		
		switch (opcaoMoeda) {
			case 1: // Real
				valor = pegarValor(teclado);
				moeda = new Real(valor);
				break;
	
			case 2: // Euro
				valor = pegarValor(teclado);
				moeda = new Euro(valor);
				break;
	
			case 3: // Dolar
				valor = pegarValor(teclado);
				moeda = new Dolar(valor);
				break;
			
			case 4: // Peso
				valor = pegarValor(teclado);
				moeda = new Peso(valor);
				break;
	
			case 5: // Voltar ao Menu Principal
				break;
	
			default: // Caso um número invalido seja digitado
				System.out.println("Entrada invalida!");
		}
		
		// Retorna a moeda que será adicionada ou removida
		return moeda;
	}
	
	// Método que lista os menus de acordo com uma string
	// especifíca passada como parâmetro
	public static void listarMenu(String menu) {

		if (menu == "menu principal") {

			System.out.println("Menu");
			System.out.println("1-Adicionar");
			System.out.println("2-Remover");
			System.out.println("3-Listar");
			System.out.println("4-Total Convertido");
			System.out.println("0-Encerrar");

		} else if (menu == "menu moedas") {

			System.out.println("1-Real");
			System.out.println("2-Euro");
			System.out.println("3-Dolar");
			System.out.println("4-Dolar");
			System.out.println("5-Voltar ao Menu Principal");
		}
	}
	
	// Método que abre o menu passado como parâmetro e valida a opção que foi 
	// digitada pelo usuário, caso a entrada não seja do tipo int ela re-lista 
	// o menu até um tipo int ser digitado
	public static int pegarOpcaoMenu(int opcao, String menu, Scanner teclado) {
		do {
			// Tratamento de erros para entrada que não são de tipo int
			try {
				listarMenu(menu);
				opcao = teclado.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Entrada invalida, por favor insira uma das opções do Menu a seguir:");
				teclado.nextLine();
			}
		} while (opcao == (int) opcao);
		return opcao;
	}


	// Método que pega o valor da Moeda a ser adicionada ou removida e
	// valida se é do tipo double, caso a entrada não seja do tipo double 
	// (ou convertível implicitamente para double - como um int por exemplo)
	// ela pede um valor até que um valor valido seja digitado pelo usuário
	public static double pegarValor(Scanner teclado) {
		double valor;
		valor = 0;
		do {
			// Tratamento de erros para entrada que não são de tipo double
			try {
				System.out.println("De qual valor?");
				valor = teclado.nextDouble();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Entrada invalida, por favor insira um valor valido de Moeda!");
				teclado.nextLine();
			}
		} while (valor == (double) valor);
		return valor;
	}
	
}
