import javax.management.monitor.Monitor;

public class carro {
    
    Motor m = new Motor();
    void acelerar(){
        if(m.motorInjecao < 2.6){
        m.motorInjecao += 0.4;
        }
    }
    void frear(){
        if(m.ligado == true){
        if(m.motorInjecao > 0.5){
        m.motorInjecao -= 0.4;
        }
        }
    }
    void ligar(){
        m.ligado = true;
    }
    void desligar(){
        m.ligado = false;
    }
    boolean estaligado(){
    return m.ligado;
    }
}
