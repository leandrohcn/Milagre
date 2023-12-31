
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

        private int opcao;
        ArrayList<Album> albuns = new ArrayList<>();


        public void lerMenu(){
            System.out.println("O que deseja fazer? ");
            System.out.println("(1) Checar se há uma música no álbum ");
            System.out.println("(2) Verificar o nome da música x no álbum ");
            System.out.println("(3) Imprimir os dados do álbum ");
            System.out.println("(4) Alterar a posição de uma música ");
            System.out.println("(5) Adicionar álbum");
            System.out.println("(6) Remover música");
            System.out.println("(7) Adicionar música");
            System.out.println("(0) Sair do programa ");
        }

        Scanner scan = new Scanner(System.in);

        public void lerOpcao(){
            do{
                lerMenu();
                System.out.println("\nOpção: ");
                opcao = Integer.parseInt(scan.nextLine());
                switch(opcao){
                    case 1:
                        checarMusica();
                        break;
                    case 2:
                        obterMusica();
                        break;
                    case 3:
                        imprimirDados();
                        break;
                    case 4:
                        alterarPosicao();
                        break;
                    case 5:
                        lerNovoAlbum();
                        break;
                    case 6:
                        removeMusica();
                        break;
                    case 7:
                        adicionarMusica();
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        break;
                }
            }while(opcao != 0);
        }

        public void lerNovoAlbum(){
            ArrayList<Musica> musicas = new ArrayList<>();

            System.out.println("Novo Album\n");
            System.out.println("Titulo: ");
            String titulo = scan.nextLine();
            System.out.println("Artista: ");
            String artista = scan.nextLine();
            System.out.println("Quantidade de musicas: ");
            int qtdMus = Integer.parseInt(scan.nextLine());
            System.out.println("Lista de músicas: ");
            for(int i = 0; i < qtdMus; i++){
                System.out.print("Nome da música: ");
                String nome = scan.nextLine();
                System.out.print("Artista: ");
                artista = scan.nextLine();
                System.out.print("Duração da música (seg): ");
                int duracao = Integer.parseInt(scan.nextLine());

                musicas.add(new Musica(nome, artista, duracao));
            }

            this.albuns.add(new Album(titulo, artista, qtdMus, musicas));
        }

        public Album lerAlbum(){
            System.out.println("Nome do album deseja?");
            String nomeAlbum = scan.nextLine();
            for(Album a : this.albuns){
                if(a.getTitulo().equals(nomeAlbum)){
                    return a;
                }
            }
            System.out.println("Album não existente");
            return null;
        }

        private void checarMusica(){
            Album album = lerAlbum();

            if(album != null){
                System.out.println("Qual música voce deseja buscar? ");
                String musica = scan.nextLine();
                for (int i = 0; i < album.getQtdMus(); i++) {
                    if(album.checarMusica(musica)){
                        System.out.println("A musica esta no album");
                        break;
                    }
                        i = album.getQtdMus();
                       System.out.println("Musica não encontrada");
                }
            }
        }

        private void imprimirDados(){
            System.out.println("Insira o album que deseja: ");
            Album album = lerAlbum();
            if(album != null){
                album.imprimirDados();
            }
        }

        private void  alterarPosicao(){
            System.out.println("Insira o album que deseja: ");
            Album album = lerAlbum();
            if(album!=null){
                System.out.println("Insira a posição da musica que deseja alterar: ");
                int posicao1 = Integer.parseInt(scan.nextLine());
                System.out.println("Insira a posicao para qual deseja que vá: ");
                int posicao2 = Integer.parseInt(scan.nextLine());
                album.alterarPosicao(posicao1, posicao2);
            }
        }

        public void obterMusica(){
            Album album = lerAlbum();

            if(album != null){
                System.out.println("Qual música você deseja verificar? ");
                int nMusica = Integer.parseInt(scan.nextLine());
                System.out.println(album.obterMusica(nMusica));
            }
        }

        public void removeMusica(){
            Album album = lerAlbum();

            if (album != null){
                System.out.println("Digite a musica que você deseja remover");
                int nMusica = Integer.parseInt(scan.nextLine());
                album.removerMusica(nMusica);
            }
        }

       public void adicionarMusica(){
            Album album = lerAlbum();

            if (album != null){
                System.out.println("Musica: ");
                String nome = scan.nextLine();
                System.out.println("Artista: ");
                String artista = scan.nextLine();
                System.out.println("Duração: ");
                int duracao = Integer.parseInt(scan.nextLine());
                Musica novaMusica = new Musica(nome, artista, duracao);
                album.adicionaMusica(novaMusica);
            }
       }

}
