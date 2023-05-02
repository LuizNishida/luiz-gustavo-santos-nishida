package udemy;

import java.util.*;

public class Cliente{
List<Compra> compras = new ArrayList<>();
String nome;
Cliente(String nome){
  this.nome = nome;
}
void adicionarCompra(Compra compra){
this.compras.add(compra);
}

double obtervalortotal(){
  double total = 0;
   for(Compra compra : compras){
    total += compra.obtervalortotal();
   }

  return total;
}
}