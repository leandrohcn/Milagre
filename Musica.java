public class Musica {
    private String nome;
    private String artista;
    private int segundos;

    Musica(String nome, String artista, int segundos){
        this.nome = nome;
        this.artista = artista;
        this.segundos = segundos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getSegundos(){
        return segundos;
    }

    public void setSegundos(int segundos){
        this.segundos = segundos;
    }
}

