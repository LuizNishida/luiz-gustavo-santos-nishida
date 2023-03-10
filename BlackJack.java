import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

  System.out.println("Jogo do blackjack");
    int pontosj1 = 0;
    int opcao;
    int pontosj2 = 0;
    opcao = menu();
    while(opcao == 1){
      int carta = numerocarta();
      String naipe = naipe();
        mostrarcarta(carta,naipe);
        if(carta > 10){
          pontosj1 = pontosj1 + 10;
        }else{
          pontosj1 = pontosj1 + carta;
        }
      opcao = menu();
      }
    limpartela();
    System.out.println("é a vez do jogador 2");
    opcao = menu();
      while(opcao == 1){
       int carta = numerocarta();
       String naipe = naipe();
      mostrarcarta(carta,naipe);
        if(carta > 10){
          pontosj2 = pontosj2 + 10;
        }else{
          pontosj2 = pontosj2 + carta;
        }
        opcao = menu();
      }
    String ganhador = vencedor(pontosj1,pontosj2);
    System.out.println("O vencedor é " + ganhador);
    System.out.println("Pontos jogador 1: "+ pontosj1);
    System.out.println("Pontos jogador 2: "+ pontosj2);
  }
  public static int menu(){
    Scanner entrada = new Scanner(System.in);
    System.out.println("1-Comprar carta");
    System.out.println("2-Parar");
    int opcao = entrada.nextInt();
    return opcao;
  }
public static void limpartela(){
  System.out.println("Pressione <enter> para limpar a tela");
  new Scanner(System.in).nextLine();
  System.out.println("\033[H\033[2J");
  System.out.flush();
}
  public static String naipe(){
    Random rand = new Random();
    String naipe = "";
    int numero = rand.nextInt(1,5);
    switch (numero){
      case 1:
        naipe = "$";
        break;
      case 2:
        naipe = "%";
        break;
      case 3:
        naipe = "*";
        break;
      case 4:
        naipe = "#";
        break;
    }
    return naipe;
  }
  public static int numerocarta(){
   Random rand = new Random();
    int numero = rand.nextInt(1,14);
    return numero;
    }
  public static void mostrarcarta(int carta,String naipe){
    String r = "";
    if(carta <= 10){
      r = ("" + carta);
    }else{
      if( carta == 11){
        r = "J";
      }else if(carta == 12){
        r = "Q";
      }else if(carta == 13){
        r = "K";
      }
    }
  System.out.println("Sua carta " + r + naipe);
  }
  public static String vencedor(int j1,int j2){
    String r = "";
    if(j1 > 21){
      j1 = 0;
    }else if(j2 > 21){
      j2 = 0;
    }else{
    if(j1 == j2 || j1 > 21 && j2 > 21){
      r = "empate";
    }else if(j1 > j2){
      r = "Jogador 1 venceu";
    }else{
      r = "Jogador 2 venceu";
    }
  }
    return r;
  }
}
