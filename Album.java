import java.util.ArrayList;
import java.util.Scanner;

public class Album {
    private String titulo;
    private String artista;
    private int qtdMus;
    private ArrayList<Musica> musicas = new ArrayList<>();

    public Album(String titulo, String artista, int qtdMus, ArrayList<Musica> musicas) {
        this.titulo = titulo;
        this.artista = artista;
        this.qtdMus = qtdMus;
        this.musicas = musicas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getQtdMus() {
        return qtdMus;
    }

    public void setQtdMus(int qtdMus) {
        this.qtdMus = qtdMus;
    }

    public boolean checarMusica(String nome) {
        for (int i = 0; i < qtdMus; i++) {
            if (nome.equals(musicas.get(i).getNome())) {

                return true;
            }
        }
        return false;
    }

    public String obterMusica(int n) {
        if (n >= 0 && n <= qtdMus) {
            return musicas.get(n - 1).getNome();
        } else {
            return "Musica não encontrada";
        }
    }

    public void imprimirDados() {
        System.out.printf("Titulo: %s\n", this.titulo);
        System.out.printf("Artista: %s\n", this.artista);
        System.out.println("Lista de músicas: ");
        for (int i = 0; i < qtdMus; i++) {
            System.out.printf("%d. %s\n", i + 1, musicas.get(i).getNome());
        }
    }

    public void alterarPosicao(int pos1, int pos2) {
        Musica aux = musicas.get(pos1 - 1);
        musicas.set(pos1 - 1, musicas.get(pos2 - 1));
        musicas.set(pos2 - 1, aux);
    }

    public void adicionaMusica(Musica novaMusica) {
        musicas.add(novaMusica);
        qtdMus++;
    }

    public void removerMusica(int n) {

        musicas.remove(n - 1);
        qtdMus--;

    }
}
