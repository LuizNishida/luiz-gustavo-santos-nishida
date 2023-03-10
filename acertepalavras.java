import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

  System.out.println("Informe a quantidade de palvras a serem digitadas:");
    int totalpalavras = entrada.nextInt();

  System.out.println("Digite as palavras conforme aparecem em seguida digite <enter>:");

    int acertos = 0;
    boolean acertou;
    long comeco = new Date().getTime();
  for(int i = 1;i <= totalpalavras;i++){
    String gerada = gerarpalavra();
    System.out.println(gerada);

    System.out.println("Repita a palavra");
    String digitada = entrada.next();
    acertou = Resultado(gerada,digitada);

    if(acertou == true){
      acertos++;
    }
  }
double seg = temposeg(comeco);
precisao(acertos,totalpalavras,seg);



  }
  public static String gerarpalavra(){
    Random rand = new Random();
    String vogais = "aeiou";
    char letra;
    String palavraNova = " ";
    String consoantes = "qwrtypsdfghjklzxcvbnm";
    for(int i = 0;i < 10;i++){
      if(i % 2 == 0){
        letra = consoantes.charAt(rand.nextInt(0,20));
      }else{
        letra = vogais.charAt(rand.nextInt(0,4));
      }
      palavraNova = palavraNova + letra; 
    }
    return palavraNova;
  }
  public static boolean Resultado(String gerado,String digitado){
    boolean a = digitado.equalsIgnoreCase(gerado);
    return a;
  }
  public static double temposeg(long inicio){
    long fim = new Date().getTime();
    double temposeg = (fim - inicio) / 1000;
    return temposeg;
  }
  public static void precisao(int acertos,int palavras,double tempo){
    double precisao = acertos * 100 / palavras;
    System.out.println("Seu teste acabou:");
    System.out.println("Precisao:"+ precisao + " %");
    System.out.println("Tempo: " + tempo + " segundos ");
  }
}
