package udemy;

import java.util.*;

public class Compra {
 List<Item> itens = new ArrayList<>();


 void adicionaritem(Produto p,int quantidade){
  this.itens.add(new Item(p,quantidade));
 }

 void adicionaritem(String nome,double preco,int quantidade){
  Produto produto = new Produto(nome,preco);
  this.itens.add(new Item(produto,quantidade));
 }

 double obtervalortotal(){
  double total = 0;
    for(Item item : itens){
      total += item.quantidade * item.produto.preco;
    }

  return total;
 }
}
