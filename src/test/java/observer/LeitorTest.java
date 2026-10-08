package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeitorTest {

    @Test
    void deveNotificarUmLeitor() {
        Livro livro = new Livro("Livro A", "Autor A");
        Leitor leitor = new Leitor("Leitor 1");
        leitor.aguardar(livro);
        livro.disponibilizar();
        assertEquals("Leitor 1, livro disponível: Livro{titulo='Livro A', autor='Autor A'}", leitor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarLeitores() {
        Livro livro = new Livro("Livro A", "Autor A");
        Leitor leitor1 = new Leitor("Leitor 1");
        Leitor leitor2 = new Leitor("Leitor 2");
        leitor1.aguardar(livro);
        leitor2.aguardar(livro);
        livro.disponibilizar();
        assertEquals("Leitor 1, livro disponível: Livro{titulo='Livro A', autor='Autor A'}", leitor1.getUltimaNotificacao());
        assertEquals("Leitor 2, livro disponível: Livro{titulo='Livro A', autor='Autor A'}", leitor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarLeitor() {
        Livro livro = new Livro("Livro A", "Autor A");
        Leitor leitor = new Leitor("Leitor 1");
        livro.disponibilizar();
        assertEquals(null, leitor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarLeitorLivroA() {
        Livro livroA = new Livro("Livro A", "Autor A");
        Livro livroB = new Livro("Livro B", "Autor B");
        Leitor leitor1 = new Leitor("Leitor 1");
        Leitor leitor2 = new Leitor("Leitor 2");
        leitor1.aguardar(livroA);
        leitor2.aguardar(livroB);
        livroA.disponibilizar();
        assertEquals("Leitor 1, livro disponível: Livro{titulo='Livro A', autor='Autor A'}", leitor1.getUltimaNotificacao());
        assertEquals(null, leitor2.getUltimaNotificacao());
    }
}
