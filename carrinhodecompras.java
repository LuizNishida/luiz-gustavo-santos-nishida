import java.util.*;

class main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

  System.out.println("Vamos as compras");

  int quantidadeprodutos = 0;
    double ValorCompra = 0;
    int opcao = menu();
  while(opcao != 0){
    if(opcao == 1){
      System.out.println("Informe o nome do produto:");
      String nome = entrada.nextLine();
      System.out.println("Informe o valor da compra:");
      double valor = entrada.nextDouble();
      System.out.println("Informe a quantidade de itens:");
      int quantidade = entrada.nextInt();
      double precoproduto = valor * quantidade;
      ValorCompra = ValorCompra + precoproduto;
      quantidadeprodutos = quantidadeprodutos + quantidade;
    }else if(opcao == 2){
      exibirsubtotal(quantidadeprodutos,ValorCompra);
    }else if(opcao == 3){
      total(quantidadeprodutos,ValorCompra);
    }else{
      System.out.println("Opcao Invalida");
    }
    opcao = menu();
  }
  }
  public static int menu(){
    Scanner entrada = new Scanner(System.in);
    System.out.println("1-Adicionar ao carrinho:");
    System.out.println("2-Mostrar subtotal:");
    System.out.println("3-Mostrar total:");
    System.out.println("0-Sair:");
    int opcao = entrada.nextInt();
    return opcao;
  }
  public static void exibirsubtotal(int quantidade,double valorcompra){
    System.out.println(quantidade + " itens subtotal: "+valorcompra);
    System.out.println("Continuar comprando:");
    limpartela();
  }
  public static void total(int quantidadeitens,double valorcompra){
    System.out.println(quantidadeitens + " itens Total: " + valorcompra);
    System.out.println("Compra Finalizada:");
    limpartela();
  }
  public static void limpartela(){
    System.out.println("pressione <enter> para limpar a tela:");
    new Scanner(System.in).nextLine();
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }
}
