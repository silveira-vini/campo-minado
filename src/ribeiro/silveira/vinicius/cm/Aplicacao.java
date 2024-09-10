package ribeiro.silveira.vinicius.cm;

import ribeiro.silveira.vinicius.cm.modelo.Tabuleiro;
import ribeiro.silveira.vinicius.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);

		new TabuleiroConsole(tabuleiro);
		
		

	}
}