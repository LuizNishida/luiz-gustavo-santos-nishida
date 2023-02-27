 import java.util.*;

class Main {
  public static void main(String[] args) {

    Scanner ler = new Scanner(System.in);

    // VARIÁVEIS
    int cont = 1, pontoP1 = 0, pontoP2 = 0, time = -1;
    String altenResposta = "";

    fun();

    System.out.print("\nJogador 1: "); // IDENTIFICAR PLAYER 1
    String player1 = ler.nextLine().toUpperCase();

    System.out.print("\nJogador 2: "); // IDENTIFICAR PLAYER 2
    String player2 = ler.nextLine().toUpperCase();

    while (pontoP2 <= 53 && pontoP1 <= 53) {

      int dadoP1 = (int) (Math.random() * (7 - 1) + 1);
      int dadoP2 = (int) (Math.random() * (7 - 1) + 1);
      int dadoResul = (int) (Math.random() * (7 - 1) + 1); // NUMERO ALEATORIO PARA DEFINIR OS PONTOS

      // ALTERNAR OS JOGADORES;
      time++;

      // CHAMAR A FUNÇÃO COM AS STRINGS P1 E P2.
      String jogadores = funJogadores(time, player1, player2);

      // CONDICIONAL PARA DEFINIR A JOGADA E A MENSAGEM.
      if (jogadores.equals("P1")) {

        System.out.println("\nAgora é a vez de " + player1); // PLAYER 1
        System.out.println("------------------------------");

        System.out.println("\nRolando o dado 🎲...\n");

        pontoP1 = pontoP1 + dadoP1;

        System.out.println(player1+" Você está na casa 🏠" + pontoP1);

        String respostaP1 = funPerguntas(pontoP1, altenResposta);

        if (respostaP1.equals("certo")) {
          System.out.println("\nA resposta está CORRETA!!  (⁠•⁠‿⁠•⁠)\n");
          pontoP1 = pontoP1 + dadoResul;
          System.out.println("Você ganhou " + dadoResul + " pontos, agora você está na casa 🏠: " + pontoP1);

        } else if (pontoP1 >= 7 && respostaP1.equals("errado")) {
          System.out.println(" Resposta esta incorreta!! (>_<)\n ");
          pontoP1 = pontoP1 - dadoResul;
          System.out
              .println(player1 + " Você perdeu " + dadoResul + " pontos, agora você retorna para casa 🏠: " + pontoP1);

        } else if (pontoP1 < 7 && respostaP1.equals("errado")) {
          System.out.println("Resposta incorreta!! (>_<)\n ");
          System.out.println("Por motivo de estar com poucos pontos continuara na mesma casa 🏠");
        }

        System.out.println("\n------- PLACAR ------\n");
        System.out.println(player1 + " = " + pontoP1);
        System.out.println(player2 + " = " + pontoP2);
        continuar();

      } else {
        System.out.println("\nAgora é a vez de " + player2); // PLAYER 2
        System.out.println("------------------------------");

        System.out.println("\nRolando o dado 🎲...\n");

        pontoP2 = pontoP2 + dadoP2;

        System.out.println(player2+" Você está na casa 🏠" + pontoP2);

        String respostaP2 = funPerguntas(pontoP2, altenResposta); // pedi a resposta do usuario

        if (respostaP2.equals("certo")) {
          System.out.println("\nA resposta está CORRETA!! (⁠•⁠‿⁠•⁠)\n");
          pontoP2 = pontoP2 + dadoResul;
          System.out.println("Você ganhou " + dadoResul + " pontos, agora você está na casa 🏠: " + pontoP2);

        } else if (pontoP2 >= 7 && respostaP2.equals("errado")) {
          System.out.println(" Resposta esta incorreta!! (>_<)\n ");
          pontoP2 = pontoP2 - dadoResul;
          System.out
              .println(player2 + " Você perdeu " + dadoResul + " pontos, agora você retorna para casa 🏠: " + pontoP2);

        } else if (pontoP2 < 7 && respostaP2.equals("errado")) {
          System.out.println("Resposta incorreta!! (>_<)\n ");
          System.out.println("Por motivo de estar com poucos pontos continuara na mesma casa 🏠");
        }

        System.out.println("\n------- PLACAR ------\n");
        System.out.println(player1 + " = " + pontoP1);
        System.out.println(player2 + " = " + pontoP2);
        continuar();

      }

      // CONTADOR
      cont++;
    }
    if (pontoP1 >= pontoP2) {
      System.out.println("\nParabéns " + player1 + ", você venceu!!!\n");
      funPremio();
    } else if (pontoP2 >= pontoP1) {
      System.out.println("\nParabéns " + player2 + ", você venceu!!!\n");
      funPremio();
    }
    funDvs();
  }
    

  // FUNÇÃO PARA JOGADORES.
  public static String funJogadores(int time, String player1, String player2) {

    String msg = "";

    if (time % 2 == 0) {
      msg = "P1"; // VALOR QUE IRÁ DEFINIR O PLAYER 1
    } else {
      msg = "P2"; // VALOR QUE IRÁ DEFINIR O PLAYER 2
    }

    return msg;
  }

  // FUNCAO DAS POSICOES DAS CASAS E DAS PERGUNTAS DO PLAY1
  public static String funPerguntas(int ponto, String resposta) {

    Scanner ler = new Scanner(System.in);
    int pontoP2 = 0;
    resposta = "";
    String altenResposta = "";
    int dadoResul = (int) (Math.random() * (7 - 1) + 1);

    if (ponto == 4 || ponto == 7 || ponto == 9 ||
        ponto == 12 || ponto == 15 || ponto == 18 ||
        ponto == 20 || ponto == 22 || ponto == 28 ||
        ponto == 33 || ponto == 37 || ponto == 43 ||
        ponto == 45 || ponto == 47 || ponto == 49) {

      switch (ponto) {

        case 4:

          int selecPergunta = (int) (Math.random() * 3);

          String[] case4 = new String[3];
          case4[0] = "\nDevera responder a seguinte pergunta:\n\nO JAVA diferencia letras maiúsculas de minúsculas. Por exemplo, a letra 'T' e 't' possuem o mesmo significado mas são diferentes. O nome que se dá a isso é?\nA: upperCase;\nB: lowerCase;\nC: Indentação;\nD: camelCase;\n";
          case4[1] = "\nDevera responder a seguinte pergunta:\n\nQuantas palavras reservadas possui o JAVA?\nA:48\nB:53\nC:52\nD:50\n";
          case4[2] = "\nDevera responder a seguinte pergunta:\n\nEm Java, a estrutura de repetição que um conjunto de instruções não seja executada nenhuma vez é representada por:\nA:Do... While.\nB:Switch.\nC:While.\n";

          System.out.println(case4[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("D")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("C")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("A")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 7:

          selecPergunta = (int) (Math.random() * 3);

          String[] case7 = new String[3];
          case7[0] = "\nDevera responder a seguinte pergunta:\n\nQuantos tipos primitivos o java possui?\nA: 8\nB: 7\nC: 10\nD: 9";
          case7[1] = "\nDevera responder a seguinte pergunta:\n\nO que é VARIÁVEL na programação?\nA: Uma variável é uma área de memória, associada a um nome, que pode armazenar valores de um determinado tipo;\nB: Uma variável é um espaço na memória que não pode ser alterado;\nC: Uma variável é uma área na memória, associada a um nome que pode armazenar valores do tipo e é estável.\nD: Uma variável pode armazenar somente caracteres e números.";
          case7[2] = "\nDevera responder a seguinte pergunta:\n\nQual o significado das chaves “{ }” no código?\nA: As chaves marcam o começo de um bloco de código.\nB: As chaves marcam o início e o fim de um bloco de código.\nC: As chaves não servem para delimitar um bloco de código, todo seu conteúdo é acessível.\nD:As chaves são utilizadas para manter o bloco de código organizado e guardar variáveis no bloco.";

          System.out.println(case7[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("A"))
            altenResposta = "certo";
          else if (selecPergunta == 2 && resposta.equals("B")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 9:

          selecPergunta = (int) (Math.random() * 3);

          String[] case9 = new String[3];
          case9[0] = "\nDevera responder a seguinte pergunta:\n\nQual alternativa é a correta para operadores aritméticos:\nA: :=, !=\nB:  %; >= \nC: &&; || \nD: =:; +.";
          case9[1] = "\nDevera responder a seguinte pergunta:\n\nQual a utilização do método lastIndexOf( );\nA: Retorna a posição do último caractere especificado em uma String.\nB: Retorna a posição da última e da primeira ocorrência encontrada de caracteres especificados em uma String.\nC: Retorna a posição da primeira ocorrência de caracteres encontrada em uma String.\nD: Não retorna nada em uma String, pois serve apenas para número inteiros.";
          case9[2] = "\nDevera responder a seguinte pergunta:\n\nQual a utilização do método trim ( ):\nA: Deixa a primeira letra da  palavra em maiúsculo.\nB: Deixa toda frase em maiúscula\nC: Tira todos os caracteres de espaço em branco em uma String.\nD: Remove espaços em branco de ambas as extremidades de uma String.";

          System.out.println(case9[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("C")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("D")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 12:

          selecPergunta = (int) (Math.random() * 3);

          String[] case12 = new String[3];
          case12[0] = "\nDevera responder a seguinte pergunta:\n\nQual a utilização do método Math.pow( ):\nA: O método retorna o resultado de um número elevado a uma determinada multiplicação.\nB: O método retorna o resultado de um número elevado a uma determinada potência.\nC: O método retorna o resultado de um número multiplicado por 2.\nD: O método retorna o resultado de um número elevado ao denominador.";
          case12[1] = "\nDevera responder a seguinte pergunta:\n\nQual a diferença entre PARAMETRO e ARGUMENTO .\nA: Em um parâmetro os valores já estão pré-definidos em uma função.\nB: Argumento é a variável que irá receber um valor em uma função. Já o parâmetro é um valor já definido em uma função.\nC: Em um argumento os valores ainda serão definidos, já no parâmetro os valores estão pré-definidos.\nD: O parâmetro é a variável que irá receber um valor em uma função. Já o Argumento é um valor já definido em uma função.";
          case12[2] = "\nDevera responder a seguinte pergunta:\n\nQual a utilização do método equals ( ):\nA: Compara uma strings. Retorna true mesmo se elas tiverem letras maiúsculas ou não.\nB: Compara duas strings. Retorna true se as strings forem iguais e false se não:\nC: Utilizado como um método de comparação String e não é de tipo booleano.\nD: equals( ) serve para comparar números e caracteres no mesmo parâmetro";

          System.out.println(case12[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("B")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("D")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("B")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 15:

          selecPergunta = (int) (Math.random() * 3);

          String[] case15 = new String[3];
          case15[0] = "\nDevera responder a seguinte pergunta:\n\nO que é uma função, e para que serve:\nA: A função serve para fazer a definição de um número.\nB: Função usada para fazer o cálculo;\nC: É basicamente uma coleção de instruções que executam uma tarefa específica.\nD: É basicamente uma coleção de instruções que executam uma tarefa específica e não podem ser utilizadas em outras tarefas.";
          case15[1] = "\nDevera responder a seguinte pergunta:\n\nQual a utilização do método replace( )\nA: Pesquisa uma string por um valor especificado e retorna uma nova string onde os valores especificados são substituídos.\nB: Pesquisa uma double por um valor especificado e retorna um novo double onde os valores especificados são substituídos.\nC: Pesquisa uma int por um valor especificado e retorna uma nova string onde os valores especificados são substituídos.\nD: Pesquisa uma string por um valor especificado e retorna uma nova boleano onde os valores especificados são substituídos.";
          case15[2] = "\nDevera responder a seguinte pergunta:\n\nOs Membros de uma superclasse definidos com o modificador protected da linguagem Java podem ser acessados por:\nA: Membros dessa superclasse e somente por membros definidos como estáticos na subclasse.\nB: Membros dessa superclasse e por membros da subclasse.\nC: Membros dessa superclasse, membros da subclasse e membros de outras classes no mesmo pacote.\nD: Membros dessa superclasse.";

          System.out.println(case15[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("C")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("C")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("C")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 18:

          selecPergunta = (int) (Math.random() * 3);

          String[] case18 = new String[3];
          case18[0] = "\nDevera responder a seguinte pergunta:\n\nO que é um vetor?\nA-O vetor é uma variavel que pode guarda mais de uma informação\nB-é uma ferramenta de repetição\nC-é uma variavelque guarda um caracter especifico\nD-uma variavel que guarda numeros reais";
          case18[1] = "\nDevera responder a seguinte pergunta:\n\nQual o limite de numeração que o int pode guardar?\nA: De -1000 a 1000\nB: De -100000 a 100000\nC: De -2.147.483.648 a 2.147.483.648\nD: De -10000000 a 10000000";
          case18[2] = "\nDevera responder a seguinte pergunta:\n\nUma variavel float pode guardar ate quantas casas decimais?\nA-12\nB-10\nC-4\nD-6";

          System.out.println(case18[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("C")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("D")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 20:

          selecPergunta = (int) (Math.random() * 3);

          String[] case20 = new String[3];
          case20[0] = "\nDevera responder a seguinte pergunta:\n\nUma variavel double pode guardar ate quntas casas decimais?\nA-10\nB-11\nC-8\nD-7";
          case20[1] = "\nDevera responder a seguinte pergunta:\n\nUma variavel char quarda qual tipo de informação\nA-um caracter retirado de uma posicão\nB-a posicão de um caracter\nC-Numeros Inteiros\nD-Numeros Decimais";
          case20[2] = "\nDevera responder a seguinte pergunta:\n\nUma variavel long guarda qual tipo de informação?\nA-Numeros com maiores que com uma capacidade maior que -1000 a 1000\nB-Numeros com maiores que com uma capacidade maior que -2.147.483.648 a 2.147.483.648\nC-Numeros com maiores que com uma capacidade maior que -100000 a 100000\nD-Numeros com maiores que com uma capacidade maior que -10000000 a 10000000";

          System.out.println(case20[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("A"))
            altenResposta = "certo";
          else if (selecPergunta == 2 && resposta.equals("B")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 22:

          selecPergunta = (int) (Math.random() * 3);

          String[] case22 = new String[3];
          case22[0] = "\nDevera responder a seguinte pergunta:\n\nAssinale a alternativa que represente variaveis de repetição:\nA-if,else,else if\nB-while,do while,for\nC-swicth,case,if\nD-||,&&,%%";
          case22[1] = "\nDevera responder a seguinte pergunta:\n\nQual a principal diferença do while  para o For:\nA: -O while é usado principalmente para repetir enquanto uma condição for verdadeira.Já o for é usado para contar o numero de vezes que uma variavel irá repetir\nB: -O for é uma ferramenta de repetição e o while serve para criar uma condição\nC: -não existe diferença\nD: -O while serve para criar condição e o for é apenas uma variavel";
          case22[2] = "\nDevera responder a seguinte pergunta:\n\nAssinale a alternativa que o java não é usado para programar?\nA-programar em front-end\nB-programar jogos e estrutura de um site\nC-Apps web\nD-Usado para API's";

          System.out.println(case22[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("B")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("A")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 28:

          selecPergunta = (int) (Math.random() * 3);

          String[] case28 = new String[3];
          case28[0] = "\nDevera responder a seguinte pergunta:\n\nO que uma variavel booleano armazena que tipo de resposta?\nA-Um texto\nB-Numeros inteiros\nC-Números decimais\nD-respostas com veradeiro ou falso";
          case28[1] = "\nDevera responder a seguinte pergunta:\n\nO que é uma matriz?\nA-Uma variavel que guarda numeros inteiros\nB-Uma variavel que guarda numeros decimais\nC-Uma variavel que pode guardar mais de uma informação dentro de linhas e colunas\nD-Uma variavel que guarda respostas dentro de verdadeiro ou falso";
          case28[2] = "\nDevera responder a seguinte pergunta:\n\nPara que serve o metodo contains?\nA- Cortar uma string\nB- Verificar se uma variavel possui determinado elemento\nC- retornar o caracter de uma posição\nD- restringir os espaços do começo e do fim de uma string";

          System.out.println(case28[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("D")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("C")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("B")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 33:

          selecPergunta = (int) (Math.random() * 3);

          String[] case33 = new String[3];
          case33[0] = "\nDevera responder a seguinte pergunta:\n\npara que serve o metodo split?\nA-Divide uma string em substrings\nB- pega a posição de um caracter\nC-retorna a posição de um caracter\nD-Retorna a potência de um número";
          case33[1] = "\nDevera responder a seguinte pergunta:\n\nPara que serve o Math.ceil?A-Arrendonda um numero para baixo\nB-Arredonda um número pra cima\nC-Retorna a potencia de um número\nD-Retorna a posição de um caracter";
          case33[2] = "\nDevera responder a seguinte pergunta:\n\nO que o Math.sqrt faz?\nA-Retorna a raiz de um número\nB- Retorna a pôtencia de um número\nC-Retorna um número arrendondado\nD-Retorna a soma de um número";

          System.out.println(case33[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("B")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("A")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 37:

          selecPergunta = (int) (Math.random() * 3);

          String[] case37 = new String[3];
          case37[0] = "\nDevera responder a seguinte pergunta:\n\nNa linguagem Java, a palavra-chave que deve ser usada para especificar que uma variável não pode ser modificada é\nA: Static\nB: Final\nC: Const\nD: Constant";
          case37[1] = "\nDevera responder a seguinte pergunta:\n\nO if, o else e o if else são usados para:\nA: Uma condição\nB: uma variavel\nC: Sortear um número\nD: Mandar uma mensagem para o usuário.";
          case37[2] = "\nDevera responder a seguinte pergunta:\n\nQuais são os comandos Java, tomada de decisões?\nA: Break, continue, retun.\nB: for, while, do-while.\nC: if-else,switch-case.\nD: random, equals.";

          System.out.println(case37[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("B")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("C")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 43:

          selecPergunta = (int) (Math.random() * 3);

          String[] case43 = new String[3];
          case43[0] = "\nDevera responder a seguinte pergunta:\n\nQual variável é usada para guardar números inteiros:\nA: Boolean\nB: Double\nC: String\nD: Int";
          case43[1] = "\nDevera responder a seguinte pergunta:\n\nO equals é usado para:\nA: Substituir uma letra por outra\nB: Identificar se uma palavra é igual a outra\nC: Recortar os espaços\nD: Nenhuma das alternativas anteriore";
          case43[2] = "\nDevera responder a seguinte pergunta:\n\nO toUpperCase é usado para:\nA: Deixar tudo em maiúsculo\nB: Deixar tudo em minúsculo\nC: retornar a posição de um texto\nD: retornar o caracter de uma posição";

          System.out.println(case43[selecPergunta]);

          System.out.print("Qual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("D")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("B")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("A")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";

          }

          selecPergunta = 0;

          break;

        case 45:

          selecPergunta = (int) (Math.random() * 3);

          String[] case45 = new String[3];
          case45[0] = "\nDevera responder a seguinte pergunta:\n\nO Math.random é usado para:\nA: Sortear um número\nB: Elevar a potência de um número\nC: Recortar os espaços\nD: Nenhuma das alternativas anteriores";
          case45[1] = "\nDevera responder a seguinte pergunta:\n\nNa hierarquia de exceções em Java, é correto afirmar que:\nA: A classe RuntimeException é uma subclasse da classe Exception.\nB: A classe Error herda da classe Exception.\nC: As classes NullPointerException e IndexOutOfBoundsException não são válidas no tratamento de exceção em Java.\nD: A classe Exception é uma subclasse da classe IOException";
          case45[2] = "\nDevera responder a seguinte pergunta:\n\nO que é um softwares?\nA: softwares nada mais é que um sisitema operacional.\nB: é um conjunto de caracteres capazes de armazenar informação basica.\nC: Uma lingugem de programação.\nD: Em termos praticos, o softwares é uma coleção de dados ou instruções que informam a um mecanismo como trabalhar.";

          System.out.println(case45[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("D")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 47:

          selecPergunta = (int) (Math.random() * 3);

          String[] case47 = new String[3];
          case47[0] = "\nDevera responder a seguinte pergunta:\n\nO que é um framework?\nA: São estruturas compostas por um conjunto de códigos genéricos que permite o desenvolvimento de sistemas e aplicações.\nB: É um ambiente de desenvolvimento.\nC: É uma biblioteca de repetitivas funções e requisitos.\nD: São estruturas de codigos.";
          case47[1] = "\nDevera responder a seguinte pergunta:\n\nQual a função do void?\nA: É uma estrutura de codigos.\nB: É tipo de retorno de métodos. Os metodos podem retornar qualquer tipo do seu projeto.\nC: É um metodo relacionado a classe e não a um objeto.\nD: Void é como ponto de partida para a execução do programa.";
          case47[2] = "\nDevera responder a seguinte pergunta:\n\nO que são função em java?\nA: É um pedaço de codigo organizado e reutilizavel.\nB: É uma varizel de execulsão.\nC: função é todo procedimento que não retorna nada.\nD: Funçao é uma relação entre dois conjuntos.";

          System.out.println(case47[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("B")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("B")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        case 49:

          selecPergunta = (int) (Math.random() * 3);

          String[] case49 = new String[3];
          case49[0] = "\nDevera responder a seguinte pergunta:\n\nPor que Java não é 100% orientado a objetos?A: Java não é 100% orientado a objetos porque faz uso de oito tipos de dados primitivos como boolean, byte, char, int, float, double, long, short que não são objetos.\nB: java é 100% orientado a objeto.C: java não é orientado a objeto por que não usa o tipos de dados primitivos.\nD: java é orinetado a objeto, pos sues tipos primitivos são double.";
          case49[1] = "\nDevera responder a seguinte pergunta:\n\n";
          case49[2] = "\nDevera responder a seguinte pergunta:\n\n";

          System.out.println(case49[selecPergunta]);

          System.out.print("\nQual a sua resposta? ");
          resposta = ler.next().toUpperCase();

          if (selecPergunta == 0 && resposta.equals("A")) {
            altenResposta = "certo";
          } else if (selecPergunta == 1 && resposta.equals("B")) {
            altenResposta = "certo";
          } else if (selecPergunta == 2 && resposta.equals("C")) {
            altenResposta = "certo";
          } else {
            altenResposta = "errado";
          }

          selecPergunta = 0;

          break;

        default:
          break;
      }
    } else {
      System.out.println("\nNenhuma pergunta, continue rolando o dado   🎲🎲🎲");
    }
    return altenResposta;
  }

  public static void continuar() {
    System.out.print("\n\nContinuar < Enter > ");
    new Scanner(System.in).nextLine();
    System.out.print("\033[H\033[\2J");
    System.out.flush();
  }

  public static void fun() {
    System.out.println("          ================================");
    System.out.println("          ==========🎲 JABELA 🎲==========");
    System.out.println("          ================================\n");
    System.out.println("UM JOGO ONDE SEU CONHECIMENTO DEFINE SE VOCÊ SERA O VENCEDOR\n");
    System.out.println("              <<<<< BOA SORTE!!! >>>>>\n");
    System.out.println(" ");
    System.out.println("Que comece o jogo!");
  }
  public static void funPremio(){
    Scanner ler=  new Scanner(System.in);
       
    System.out.println("Escolha o seu prêmio!");
    System.out.println("1° Prêmio\n2° Prêmio\n3° Prêmio\n4° Prêmio");
    System.out.print("==>>_");
    int esc= ler.nextInt();

    switch(esc){
      case 1:  System.out.println("Seu prêmio será uma viagem.");
         break;
      case 2: System.out.println("Você ganhou um iPhone.");
         break;
      case 3: System.out.println("Seu prêmio foi uma bolsa de estudos no Senac.");
         break;
      case 4: System.out.println("Ganhou um vale compras de 15.000.");
         break;
      default: System.out.println("Digito invalido, você ficará sem prêmio.");   
    }

  }
  public static void funDvs(){
    System.out.println("\nDesenvolvedores:\nJonas\nDanilo\nBruna\nLuiz");
  }

}
