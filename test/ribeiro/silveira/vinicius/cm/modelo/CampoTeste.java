package ribeiro.silveira.vinicius.cm.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ribeiro.silveira.vinicius.cm.excecao.ExplosionException;

class CampoTeste {

	Campo campo = new Campo(3, 3);
	
	
	@Test
	void testeVizinhoRealDistancia1() {
		Campo vizinho = new Campo(4, 4);
		boolean result = campo.adicionarVizinho(vizinho);
		
		assertTrue(result);
	}

	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasVezes() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.setMinado();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.setMinado();
		assertThrows(ExplosionException.class, () -> {campo.abrir();});
	}
	
	@Test
	void testeAbrirComVizinhos() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		Campo campo22 = new Campo(2,2);
		
		campo12.setMinado();
		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
				
		assertTrue(campo22.isAberto() && campo11.isFechado());
		
	}
	
	
}
