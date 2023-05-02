public class carroteste {
   public static void main(String[] args) {
    
    carro a = new carro();
    a.ligar();
    System.out.println(a.estaligado());
    a.acelerar();
    a.acelerar();
    a.acelerar();
    System.out.println(a.m.giros());
    a.acelerar();
    System.out.println(a.m.giros());
    a.frear();
    a.frear();
    a.frear();
    a.frear();
    a.frear();
    System.out.println(a.m.giros());
    a.desligar();
    System.out.println(a.estaligado());
   } 
}
