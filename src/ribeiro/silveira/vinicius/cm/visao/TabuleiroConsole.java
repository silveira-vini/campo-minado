package ribeiro.silveira.vinicius.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import ribeiro.silveira.vinicius.cm.excecao.ExplosionException;
import ribeiro.silveira.vinicius.cm.excecao.SairException;
import ribeiro.silveira.vinicius.cm.modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;

		executarJogo();

	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			while (continuar) {

				cicloDoJogo();

				System.out.println("Outra partida? (S/N) ");
				String resposta = entrada.nextLine();
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
					System.out.println("Jogo Fechado");
				} else {
					tabuleiro.reiniciar();
				}

			}
		} catch (Exception e) {
			System.out.println("Tchau!!!");
		} finally {
			entrada.close();
		}
	}

	private void cicloDoJogo() {
		try {
			while (!tabuleiro.objetivoAlcançado()) {
				System.out.println(tabuleiro.toString());
				String digitado = capturarValorDigitado("Digite (Linha,Coluna): ");

				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
						.map(e -> Integer.parseInt(e))
						.iterator();

				digitado = capturarValorDigitado("1- Abrir ou 2- (Des)Marcar");

				if ("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if ("2".equals(digitado)) {
					tabuleiro.alterarMarcacao(xy.next(), xy.next());
				}

			}

			System.out.println(tabuleiro);
			System.out.println("Você Ganhou!!");

		} catch (ExplosionException e) {
			System.out.println(tabuleiro);
			System.out.println("Você perdeu!!");
		}

	}

	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();

		if ("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}

		return digitado;

	}

}
