package udemy;

import java.util.*;

public class execucao {
    public static void main(String[] args) {
        

        Compra compra = new Compra();
        compra.adicionaritem("Caneta",1,10);
        compra.adicionaritem(new Produto("Notebook", 2000.00),2);

        
        Compra compra2 = new Compra();
        compra2.adicionaritem("Lapis",2 ,3);
        compra2.adicionaritem(new Produto("Impressora",1000),1);
       
        Cliente cliente = new Cliente("Luiz");
        cliente.adicionarCompra(compra);
        cliente.adicionarCompra(compra2);

        System.out.println("O valor a pagar pelo cliente é:");
        System.out.println(cliente.obtervalortotal());
    }
}
