import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

  System.out.println("Programa do Numero sorteado");
    String resultado;
    int tentativa = 1;
    int numerosorteado;
    int n;
do{
  numerosorteado = sortearNum();
  System.out.println("Informe um numero:");
  n = entrada.nextInt();
  resultado = ganhador(numerosorteado,n,tentativa);
  System.out.println(resultado);
  tentativa++;
}while((resultado.equalsIgnorecase("Maior") || resultado.equalsIgnoreCase("Menor")) && tentativa  <= 10);

  
  }
  public static int sortearNum(){
    Random rand = new Random();
    int n;
    n = rand.nextInt(0,1000);
    return n;
  }
  public static String ganhador(int maquina,int digitado,int tentativa){
    String r;
    if(maquina == digitado && tentativa <= 10){
      r = "Ganhou";
    }else if(maquina != digitado && tentativa == 10){
      r = "Perdeu";
    }else if(maquina > digitado && tentativa <= 10){
      r = "Maior";
    }else{
      r = "Menor";
    }
    return r;
  }
}
