package observer;

import java.util.Observable;
import java.util.Observer;

public class Leitor implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Leitor(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void aguardar(Livro livro) {
        livro.addObserver(this);
    }

    public void update(Observable livro, Object arg) {
        this.ultimaNotificacao = this.nome + ", livro disponível: " + livro.toString();
    }
}
