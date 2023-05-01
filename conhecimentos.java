import java.util.*;

public class jabela2{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
       
        int pontosj1 = 0;
        int pontosj2 = 0;

        System.out.println("Jogo de conhecimentos gerais");

        System.out.println("Informe o nome do primeiro Jogador:");
        String j1 = entrada.nextLine();

        System.out.println("Informe o nome do Segundo Jogador:");
        String j2 = entrada.nextLine();

        Random rand = new Random();

        int time = rand.nextInt(1);
        while(pontosj1 <= 60 && pontosj2 <= 60){
        int dado = rand.nextInt(5);
        int pontosganhados = rand.nextInt(5);
       String res = vezdojogador(time);
       if(res.equals("P1")){
      System.out.println("é a vez do jogador " +j1);
      pontosj1 += dado;
      System.out.println("Você esta na casa " + pontosj1);
      String resultado = funperguntas(pontosj1);
      if(resultado.equals("certo")){
         System.out.println("Parabens! " + j1 + " Você acertou");
         pontosj1 += pontosganhados;
         System.out.println("Pulou para casa " + pontosj1);
      }else if(resultado.equals("errado") && pontosj1 >= 5){
          System.out.println(":( " + j1 + " você errou a pergunta");
         pontosj1 -= pontosganhados;
         System.out.println("Você perdeu " + pontosganhados + " agora está na casa " + pontosj1);
      }else if(resultado.equals("errado") && pontosj1 < 5){
         System.out.println("Você errou!!");
       System.out.println("Por motivos de estar com poucos pontos\nVocê continuara na mesma casa");
       System.out.println("Seus pontos " + pontosj1);
      }
      if(pontosj1 >= 20){
         System.out.println("Parabéns!!! " + j1 + " Você chegou na dificuldade Média");
         pontosj1 += dado;
         System.out.println("Você está na casa " + pontosj1);
         resultado = funpergunMedia(j1,pontosj1);
         if(resultado.equals("certo")){
        System.out.println("Você acertou ");
        pontosj1 += dado;
        System.out.println("Você ganhou " + pontosganhados + " Você está na casa " + pontosj1);
         }else{
         System.out.println("Você errou");
         pontosj1 -= pontosganhados;
         System.out.println("Você perdeu " + pontosganhados + " Você está na casa " + pontosj1);
         }
      }else if(pontosj1 >= 40){
         System.out.println("Parabéns!!! " + j1 + "Você chegou na dificuldade dificil");
         pontosj1 += dado;
         System.out.println("Você está na casa " + pontosj1);
      resultado = funpergunMedia(j1,pontosj1);
      if(resultado.equals("certo")){
         System.out.println("Você acertou");
         pontosj1 += pontosganhados;
         System.out.println("Você ganhou " + pontosganhados + " Agora está na casa " + pontosj1);
      }else{
         System.out.println("Você errou");
         pontosj1 -= pontosganhados;
         System.out.println("Você perdeu " + pontosganhados + " Agora está na casa " + pontosj1);
      }
   }
    }else{
     System.out.println("é a vez do jogador " + j2);
     pontosj2 += pontosganhados;
     System.out.println(j2 + " Você esta na casa " + pontosj2);
       String resultado = funperguntas(pontosj2);
       if(resultado.equals("certo")){
         System.out.println("Parabéns " + j2 + " Você acertou ");
         pontosj2 += pontosganhados;
         System.out.println("Você ganhou " + pontosganhados + " agora está na casa " + pontosj2);
       }else if(resultado.equals("errado") && pontosj2 >= 5){
         System.out.println("Você errou a pergunta");
         pontosj2 -= pontosganhados;
         System.out.println("Agora Você perdeu " + pontosganhados + " pontos,agora você está na casa " +pontosj2);
       }else if(resultado.equals("errado") && pontosj2 <= 5){
         System.out.println("Você errou,por motivos de estar com poucos pontos");
         System.out.println("Você continuará na mesma casa");
      }
if(pontosj2 >= 20){
pontosj2 += dado;
System.out.println(j2 + " Você está na casa " + pontosj2);
resultado = funpergunMedia(j2,pontosj1);
if(resultado.equals("certo")){
System.out.println("Você acertou");
pontosj2 += pontosganhados;
System.out.println("Você ganhou " + pontosganhados + " Você está na casa " + pontosj2);
}else{
   System.out.println("Você errou a pergunta ");
   pontosj2 -= pontosganhados;
   System.out.println("Você perdeu " + pontosganhados + " você está na casa " + pontosj2);
}

} if(pontosj2 >= 40){
   System.out.println("Parabéns!!! " + j2 + " Você chegou na dificuldade dificil");
   pontosj2 += dado;
   System.out.println("Você está na casa " + pontosj2);
   resultado = funperguntadificil(j2,pontosj2);
   if(resultado.equals("certo")){
      System.out.println("Você acertou ");
      pontosj2 += pontosganhados;
      System.out.println("Você ganhou " + pontosganhados + " Agora está na casa " + pontosj2);
   }else{
      System.out.println("Você errou");
      pontosj2 -= pontosganhados;
      System.out.println("Você perdeu " + pontosganhados + " Agora está na casa " + pontosj2);
   }
}



    }
    System.out.println(j1 + " = " + pontosj1 + " pontos");
    System.out.println(j2 + " = " + pontosj2 + " pontos");

    limpartela();
    time++;
    if(pontosj1 >= 60 || pontosj2 >= 60){
      break;
    }
        }
        if(pontosj1 > pontosj2){
         System.out.println("Parábens " + j1 + " Você venceu");
         premio();
        }else if(pontosj2 > pontosj1){
         System.out.println("Parábens " + j2 + " Você ganhou");
         premio();
        }
        System.out.println("Obrigado por Jogar :)");
    }
    public static String vezdojogador(int time){
        String vez = "";
        if(time % 2 == 0){
         vez = "P1";
        }else{
         vez = "P2";
        }
        return vez;
    }
    public static void premio(){
Scanner entrada = new Scanner(System.in);
System.out.println("Informe um numero de 1 a 3");
int n = entrada.nextInt();
switch(n){
   case 1:
   System.out.println("Você ganhou R$1000 em compras");
   break;
   case 2:
   System.out.println("Você ganhou um carro zero quilomêtro");
   break;
   case 3:
   System.out.println("Você ganhou uma viagem pra Bahia");
   break;
   default:
   System.out.println("Opcão Invalida Você não ganhou nada");
   break;
    }
   }
   
   public static String funperguntas(int pontos){
        Random rand = new Random();
        Scanner entrada = new Scanner(System.in);
        String resposta = "";
if(pontos == 0 ||pontos == 3 || pontos == 6 || pontos == 9 || pontos == 12 || pontos == 15 || pontos == 18){
    switch(pontos){
        case 0:
        int perguntassorteadas = rand.nextInt(2);
     String[] casa0 = new String[3];
     casa0[0] = "Quem descobriu a america?\nA-Pedro alvares cabral\nB-Cristovão colombo\nC-Tiradentes";
     casa0[1] = "Quantas copas o pele ganhou?\nA-3\nB-4\nC-1";
     casa0[2] = "O HTML é considerado uma linguagem de?A-Estilição\nB-Marcação\nC-Programação";

     System.out.println(casa0[perguntassorteadas]);
     System.out.println("Qual é a sua resposta");
     String r = entrada.nextLine().toUpperCase();

     if(perguntassorteadas == 0 && r.equals("B")){
        resposta = "certo";
     }else if(perguntassorteadas == 1 && r.equals("A")){
        resposta = "certo";
     }else if(perguntassorteadas == 2 && r.equals("B")){
        resposta = "certo";
     }else{
        resposta = "errado";
     }
     perguntassorteadas = 0;
     break;
     case 3:
     perguntassorteadas = rand.nextInt(2);
     String[] casa3 = new String[3];
     casa3[0] = "Assinale a alternativa onde as linguagens são orientadas a objetos!\nA-Java,C#\nB-html,JavaScript\nC-css,swift";
     casa3[1] = "quantas copas o brasil já ganhou?\nA-3\nB-6\nC-5";
     casa3[2] = "Quem é o atual presidente do Brasil?\nA-Bolsonaro\nB-lula\nC-Fernando Henrique Cardoso";
     System.out.println(casa3[perguntassorteadas]);

     System.out.println("Qual é a sua Resposta?");
     r = entrada.nextLine().toUpperCase();

     if(perguntassorteadas == 0 && r.equals("A")){
        r = "certo";
     }else if(perguntassorteadas == 1 && r.equals("C")){
        r = "certo";
     }else if(perguntassorteadas == 2 && r.equals("B")){
        r = "certo";
     }else{
        r = "errado";
     }
     perguntassorteadas = 0;
     break;
     case 6:
     perguntassorteadas = rand.nextInt(2);
     String[] casa6 = new String[3];
     casa6[0] = "Qual é o coletivo de lobos?\nA-Cardume\nB-Alcateia\nC-Inchame";
     casa6[1] = "Quantos 0 tem 1 milhão?\nA-4\nB-6\nC-5";
     casa6[2] = "Como fazer a Cor Laranja?\nA-Misturando vermelho e amarelo\nB-Misturando roxo e azul\nC-Misturando cinza e preto";

     System.out.println(casa6[perguntassorteadas]);

     System.out.println("Qual é a sua resposta?");
     r = entrada.nextLine().toUpperCase();

     if(perguntassorteadas == 0 && r.equals("B")){
      resposta = "certo";
     }else if(perguntassorteadas == 1 && r.equals("B")){
      resposta = "certo";
     }else if(perguntassorteadas == 2 && r.equals("A")){
      resposta = "certo";
     }else{
      resposta = "errado";
     }
     perguntassorteadas = 0;
     break;
     case 9:
      perguntassorteadas = rand.nextInt(2);
      String[] casa9 = new String[3];
   
   casa9[0] = "Qual o maior pais do mundo em territorio?\nA-Brasil\nB-China\nC-Russia";
   casa9[1] = "Qual é o pais com a maior população mundial?\nA-China\nB-India\nC-Inglterra";
   casa9[2] = "Qual é a moeda mais forte do mundo?\nA-Libra Esterlina\nB-Dolar Americano\nC-Dinar kuwaitiano";
    
   System.out.println(casa9[perguntassorteadas]);

   System.out.println("Qual é a sua resposta?");
   r = entrada.nextLine().toUpperCase();

   if(perguntassorteadas == 0 && r.equals("C")){
      resposta = "certo";
   }else if(perguntassorteadas == 1 && r.equals("A")){
      resposta = "certo";
   }else if(perguntassorteadas == 2 && r.equals("C")){
      resposta = "certo";
   }else{
      resposta = "errado";
   }
   perguntassorteadas = 0;
   break;
   case 12:
   perguntassorteadas = rand.nextInt(2);
  String[] casa12 = new String[3];
  casa12[0] = "Qual personagem do folclore que fuma charuto?\nA-Saci pere-pere\nB-Curupira\nC-mula sem cabeça";
  casa12[1] = "Assinale a alternativa que representa o animal mais antigo:\nA-Macaco\nB-Tubarão\nC-Leão";
  casa12[2] = "Quem pintou o quadro da monalisa?\nA-Leonardo da vinci\nB-Pablo picasso\nC-Socrates";

  System.out.println(casa12[perguntassorteadas]);

  System.out.println("Qual é a sua resposta?");
  r = entrada.nextLine().toUpperCase();

  if(perguntassorteadas == 0 && r.equals("A")){
   resposta = "certo";
  }else if(perguntassorteadas == 1 && r.equals("B")){
   resposta = "certo";
  }else if(perguntassorteadas == 2 && r.equals("A")){
   resposta = "certo";
  }else{
   resposta = "errado";
  }
  perguntassorteadas = 0;
  break;
  case 15:
  perguntassorteadas = rand.nextInt(2);
  String[] casa15 = new String[3];
  casa15[0] = "Quem aboliu a escravidão no Brasil?\nA-Princesa Isabel\nB-Santos Dumond\nC-Tiradentes";
  casa15[1] = "Quem inventou o avião?\nA-Platão\nB-Santos Dumond\nC-nietzche";
  casa15[2] = "Qual Oceano banha o Brasil?\nA-Pacifico\nB-Indico\nC-Atlântico";

  System.out.println(casa15[perguntassorteadas]);

  System.out.println("Qual é a sua resposta");
  r = entrada.nextLine().toUpperCase();

  if(perguntassorteadas == 0 && r.equals("A")){
   resposta = "certo";
  }else if(perguntassorteadas == 1 && r.equals("B")){
   resposta = "certo";
  }else if(perguntassorteadas == 2 && r.equals("C")){
   resposta = "certo";
  }else{
   resposta = "errado";
  }
  perguntassorteadas = 0;
  break;
  case 18:
  String[] casa18 = new String[3];
  perguntassorteadas = rand.nextInt(2);
  casa18[0] = "Qual o maior estado do Brasil?\nA-São Paulo\nB-Roraima\nC-Amazonas";
  casa18[1] = "Qual é a capital de Alagoas?\nA-Florianopolis\nB-Rio Branco\nC-Maceio";
  casa18[2] = "Qual cidade ficou conhecida como terra da garoa?\nA-São Paulo\nB-Sergipe\nC-Rondonia";

  System.out.println(casa18[perguntassorteadas]);

  System.out.println("Qual é a sua resposta");
  r = entrada.nextLine().toUpperCase();

  if(perguntassorteadas == 0 && r.equals("C")){
   resposta = "certo";
  }else if(perguntassorteadas == 1 && r.equals("C")){
   resposta = "certo";
  }else if(perguntassorteadas == 2 && r.equals("A")){
   resposta = "certo";
  }else{
   resposta = "errado";
  }
  perguntassorteadas = 0;
  break;
}


    }else{
      System.out.println("Nenhuma pergunta foi Sorteada\n continue rodando o dado");
    }
   return resposta;
   }
public static String funpergunMedia(String j,int pontos){
   Scanner entrada = new Scanner(System.in);
   
   Random rand = new Random();
   String resultado = "";
   System.out.println("Parabens!!! " + j + " Você chegou na dificuldade Dificil");
   if(pontos == 22 || pontos == 25 || pontos == 28 || pontos == 31 || pontos == 34 || pontos == 37){
      switch(pontos){
         case 22:
         int perguntassorteadas = rand.nextInt(2);
         String[] casa22 = new String[3];
         casa22[0] = "Qual é o menor pais do mundo?\nA-Suriname\nB-Vaticano\nC-Costa rica";
         casa22[1] = "De Quem é a frase `penso,logo existo´\nA-Descartes\nB-Socrates\nC-nietzche";
         casa22[2] = "Qual foi a principal causa da morte do inventor do Raio X?\nA-Cancer de pumão\nB-Infarto\n-C-AVC";

         System.out.println(casa22[perguntassorteadas]);

         System.out.println("Qual é a sua resposta?");
         String r = entrada.nextLine().toUpperCase();

         if(perguntassorteadas == 0 && r.equals("B")){
            resultado = "certo";
         }else if(perguntassorteadas == 1 && r.equals("A")){
            resultado = "certo";
         }else if(perguntassorteadas == 2 && r.equals("A")){
            resultado = "certo";
         }else{
            resultado = "errado";
         }
         perguntassorteadas = 0;
         break;
         case 25:
         perguntassorteadas = rand.nextInt(2);
         String[] casa25 = new String[3];
         casa25[0] = "Qual o Segundo livro mais vendido do mundo?\nA-Dom Quixote\nB-O senhor dos Aneis\nC-Harry Potter";
         casa25[1] = "Quantos elementos quimicos possui a tabela periodica\nA-´130\nB-110\nC-118";
         casa25[2] = "Qual é o pais com a menor expectativa de vida do mundo?\nA-Nigeria\nB-Congo\nC-Serra leoa";

         System.out.println(casa25[perguntassorteadas]);

         System.out.println("Qual é a sua resposta?");
          r = entrada.nextLine().toUpperCase();

          if(perguntassorteadas == 0 && r.equals("A")){
            resultado = "certo";
          }else if(perguntassorteadas == 1 && r.equals("C")){
            resultado = "certo";
          }else if(perguntassorteadas == 2 && r.equals("C")){
            resultado = "certo";
          }else{
            resultado = "errado";
          }
          perguntassorteadas = 0;
          break;
          case 28:
          String[] casa28 = new String[3];
          perguntassorteadas = rand.nextInt(2);
          casa28[0] = "Qual é a tradução de legend para português\nA-Legenda\nB-Lenda\nC-Legendario";
          casa28[1] = "Qual a altura da rede de volei profissional?\nA-2M\nB-2.10M\nC-2.43 e 2.24M";
          casa28[2] = "Em qual idade da pedra o fogo foi descoberto?\nA-Neolitico\nB-Paleolitico\nC-Idade dos metais";

          System.out.println(casa28[perguntassorteadas]);

          System.out.println("Qual é a sua resposta?");
          r = entrada.nextLine().toUpperCase();

          if(perguntassorteadas == 0 && r.equals("B")){
            resultado = "certo";
          }else if(perguntassorteadas == 1 && r.equals("C")){
            resultado = "certo";
          }else if(perguntassorteadas == 2 && r.equals("B")){
            resultado = "certo";
          }else{
            resultado = "errado";
          }
          perguntassorteadas = 0;
          break;
          case 31:
          perguntassorteadas = rand.nextInt(2);
          String[] casa31 = new String[3];
          casa31[0] = "Qual pais com a maior densidade demografica do mundo?\nA-Mônaco\nB-India\nC-China";
          casa31[1] = "Qual o maior animal terrestre?\nA-Girafa\nB-Elefante Africano\nC-Rinoceronte";
          casa31[2] = "Qual tipo Sanguineo é considerado doador universal?\nA-tipo A\nB-tipo O \nC- tipo B";

          System.out.println(casa31[perguntassorteadas]);

          System.out.println("Qual é a sua resposta?");
          r = entrada.nextLine().toUpperCase();

          if(perguntassorteadas == 0 && r.equals("A")){
            resultado = "certo";
          }else if(perguntassorteadas == 1 && r.equals("B")){
            resultado = "certo";
          }else if(perguntassorteadas == 2 && r.equals("B")){
            resultado = "certo";
          }else{
            resultado = "errado";
          }
          perguntassorteadas = 0;
          break;
          case 34:
          perguntassorteadas = rand.nextInt(2);
          String[] casa34 = new String[3];
          casa34[0] = "Quem implementou o plano real?\nA-Fernando Henrique Cardoso\nB- Itamar Franco\nC-Lula";
          casa34[1] = "Quem foi considerado o pai dos pobres?\nA-Getulio Vargas\nB-lula\nC-Collor";
          casa34[2] =  "Quais são os cromossomos que determinam o sexo Masculino?\nA-X\nB-Y\nC-Z";

          System.out.println(casa34[perguntassorteadas]);

          System.out.println("Qual é a sua resposta?");
          r = entrada.nextLine().toUpperCase();

          if(perguntassorteadas == 0 && r.equals("B")){
            resultado = "certo";
          }else if(perguntassorteadas == 1 && r.equals("A")){
            resultado = "certo";
          }else if(perguntassorteadas == 2 && r.equals("B")){
            resultado = "certo";
          }else{
            resultado = "errado";
          }
          perguntassorteadas = 0;
          break;
          case 37:
          perguntassorteadas = rand.nextInt(2);
          String[] casa37 = new String[3];
          casa37[0] = "Qual a capital da alemanha?\nA-Moscow\nB-Berlim\nC-Madrid";
          casa37[1] = "Segundo a biblia quem viveu 969 anos?\nA-Abeu\nB-Cain\nC-Matusálem";
          casa37[2] = "Assinale a alternativa que representa um deus egipcio?\nA-Heimdall\nB-Toth\nC-Ares";

          System.out.println(casa37[perguntassorteadas]);

          System.out.println("Qual é a sua resposta?");
          r = entrada.nextLine().toUpperCase();

          if(perguntassorteadas == 0 && r.equals("B")){
            resultado = "certo";
          }else if(perguntassorteadas == 1 && r.equals("C")){
            resultado = "certo";
          }else if(perguntassorteadas == 2 && r.equals("B")){
            resultado = "certo";
          }else{
            resultado = "errado";
          }
          perguntassorteadas = 0;
          break;
      }
   }else{
      System.out.println("Nenhuma pergunta foi sorteada\n continue rodando o dado");
   }
   return resultado;
}
public static String funperguntadificil(String j,int pontos){
   Scanner entrada = new Scanner(System.in);
   Random rand = new Random();
   int sorteada = 0;
   String resultado = "";
   String r = "";
   System.out.println("Parabens!!! " + j + " Você chegou na dificuldade Dificil");
   if(pontos == 42 || pontos == 45 || pontos == 48 || pontos == 51 || pontos == 54 || pontos == 57){
      switch(pontos){
         case 42:
         sorteada = rand.nextInt(2);
         String[] casa42 = new String[3];
         casa42[0] = "O que é um filantropo?\nA-Pessoa que pratica a caridade\nB-Pessoa com excesso de confiança\nC-Pessoa com defici de atenção";
         casa42[1] = "Qual pais asiatico tem o português como lingua oficial?\nA-Moçambique\nB-Macau\nC-Portugal";
         casa42[2] = "Qual substância é expirada pelas plantas?\nA-dioxido de carbono\nB-Oxigênio\nC-Nitrogênio";

         System.out.println(casa42[sorteada]);
         System.out.println("Qual é a sua resposta?");
          r = entrada.next().toUpperCase();

          if(sorteada == 0 && r.equals("A")){
            resultado = "certo";
          }else if(sorteada == 1 && r.equals("B")){
            resultado = "certo";
          }else if(sorteada == 2 && r.equals("A")){
            resultado = "certo";
          }else{
            resultado = "errado";
          }
          sorteada = 0;
         break;
         case 45:
         sorteada = rand.nextInt(2);
         String[] casa45 = new String[3];
         casa45[0] = "Quem foi o primeiro presidente do Brasil?\nA-Deodoro da fonseca\nB-Floriano peixoto\nC-Getulio vargas";
         casa45[1] = "Em qual pais nasceu Clarisse Lispector?\nA-Belgica\nB-Servia\nC-Ucrania";
         casa45[2] = "Qual pais Nelson Mandela governou?\nA-Estados Unidos\nB-Africa do Sul\nC-Moçambique";

         System.out.println(casa45[sorteada]);

         System.out.println("Qual é a sua resposta?");
         r = entrada.nextLine().toUpperCase();

         if(sorteada == 0 && r.equals("A")){
            resultado = "certo";
         }else if(sorteada == 1 && r.equals("C")){
            resultado = "certo";
         }else if(sorteada == 2 && r.equals("B")){
            resultado = "certo";
         }else{
            resultado = "errado";
         }
         sorteada = 0;
         break;
         case 48:
         sorteada = rand.nextInt(2);
         String[] casa48 = new String[3];
         casa48[0] = "Quais destes Acontecimentos fizeram 21 e 31 anos no mundo?\nA-Atentado de 11 de Setembro e Guerra do golfo\nB-Primavera árabe e o fim da guerra fria\nC-Atentado de 11 de Setembro e o fim da guerra fria";
         casa48[1] = "O que é o Brexit?\nA-A Saida da Espanha da união europeia\nB-A saida da Alemanha da união europeia\nC-A saida so reino unido da união europeia";
         casa48[2] = "Qual é o Metal cujo o simbolo é Au?\nA-Ouro\nB-Prata\nC-Bronze";

         System.out.println(casa48[sorteada]);

         System.out.println("Qual é a sua resposta?");
         r = entrada.nextLine().toUpperCase();

         if(sorteada ==  0 && r.equals("A")){
            resultado = "certo";
         }else if(sorteada == 1 && r.equals("C")){
            resultado = "certo";
         }else if(sorteada == 2 && r.equals("A")){
            resultado = "certo";
         }else{
            resultado = "errado";
         }
         sorteada = 0;
         break;
         case 51:
         String[] casa51 = new String[3];
         sorteada = rand.nextInt(2);
         casa51[0] = "Qual presidente do Brasil ficou conhecido com Django?\nA-João Goulart\nB-Janio Quadros\nC-Fidel Castro";
         casa51[1] = "Quem ganhou a copa do mundo de 2010?\nA-Espanha\nB-Alemanha\nC-Ingleterra";
         casa51[2] = "Em que Ano foi a queda do Imperio Romano?\nA-476 D.C\nB-476 A.C\nC-110 D.C";

         System.out.println(casa51[sorteada]);

         System.out.println("Qual é a sua resposta?");
         r = entrada.nextLine().toUpperCase();

         if(sorteada == 0 && r.equals("A")){
            resultado = "certo";
         }else if(sorteada == 1 && r.equals("A")){
            resultado = "certo";
         }else if(sorteada == 2 && r.equals("A")){
            resultado = "certo";
         }else{
            resultado = "errado";
         }
         sorteada = 0;
         break;
         case 54:
         String[] casa54 = new String[3];
         sorteada = rand.nextInt(2);
         casa54[0] = "Qual o Numero minimo de Jogadores em cada time?\nA-9\nB-5\nC-7";
         casa54[1] = "Quem pintou o gradro guernica?\nA-Salvador Dali\nB-Pablo picasso\nC-Leonardo da Vinci";
         casa54[2] = "Qual é a velocidade da luz?\nA-300.000.000 m/s\nB-299.794.486 m/s\nC-100.000.000 m/s";

         System.out.println(casa54[sorteada]);

         System.out.println("Qual é a sua resposta?");
         r = entrada.nextLine().toUpperCase();

         if(sorteada == 0 && r.equals("C")){
            resultado = "certo";
         }else if(sorteada == 1 && r.equals("B")){
            resultado = "certo";
         }else if(sorteada == 2 && r.equals("B")){
            resultado = "certo";
         }else{
            resultado = "errado";
         }
         sorteada = 0;
         break;
         case 57:
         sorteada = rand.nextInt(2);
         String[] casa57 = new String[3];
         casa57[0] = "Qual destes paises é transcontinental?\nA-Russia\nB-Tanzania\nC-Inglaterra";
         casa57[1] = "Qual foi o ano da primeira copa do mundo?\nA-1920\nB-1858\nC-1930";
         casa57[2] = "Jupiter e Plutão são relacionados de quais Deuses gregos?\nA-hercules e posedon\nB-Zeus e Ades\nC-Ares e Tanatos";

        System.out.println(casa57[sorteada]);

         System.out.println("Qual é a sua resposta?");
          r = entrada.nextLine().toUpperCase();

          if(sorteada == 0 && r.equals("A")){
            resultado = "certo";
          }else if(sorteada == 1 && r.equals("C")){
            resultado = "certo";
          }else if(sorteada == 2 && r.equals("B")){
            resultado = "certo";
          }else{
            resultado = "errado";
          }

      }

   }else{
      System.out.println("Nenhuma pergunta foi Sorteada\n continue rodando o dado");
   }
   return resultado;
}
public static void limpartela(){

   System.out.print("pressione <enter> para limpar a tela");
   new Scanner(System.in).nextLine();
   System.out.println("\033[H\033[2J");
   System.out.flush();
}

}
