import java.util.*;

class main {
  public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);

  System.out.println("Informe a quantidade de linhas e colunas:");
    int t = entrada.nextInt();

   int[][] matriz = criar(t);
    int r = soma(matriz);
    System.out.println("A soma da diagonal secundaria é " + r);
    System.out.println("Os numeros da matriz são:");
    exibir(matriz);

    int diagonalp = primaria(matriz);
    int diagonals = secundaria(matriz);

    System.out.println("O maior numero é " + diagonalp);
    System.out.println("O menor numero é " + diagonals);

  }
  public static int[][] criar(int tamanho){
    Scanner entrada = new Scanner(System.in);
    int[][] matrix = new int[tamanho][tamanho];
    for(int i = 0;i < tamanho;i++){
      for(int j = 0;j < tamanho;j++){
        System.out.println("Informe um numero:");
        matrix[i][j] = entrada.nextInt();
      }
    }
    return matrix;
  }
  public static int soma(int[][] matrix){
    int soma = 0;
    for(int i = 0;i < matrix.length;i++){
      for(int j = 0;j < matrix.length;j++){
        if(matrix.length-1 == (l + c)){
          soma += matrix[i][j]; 
        }
      }
    }
    return soma;
  }
  public static void exibir(int[][] array){
    for(int i = 0;i < array.length;i++){
      for(int j = 0;j < array.length;j++){
        System.out.print(" " + array[i][j]);
      }
      System.out.println();
    }
  }
  public static int primaria(int[][] array){
    int maior = Integer.mim_value;
    for(int i = 0;i < array.length;i++){
      for(int j = 0;j < array.length;j++){
        if(j == i){
          if(array[i][j] > maior){
          maior = array[i][j];
        }
      }
    }
    return maior;
  }
  public static int secundaria(int[][] matrix){
    int menor = Integer.max_value;
    for(int i = 0;i < matrix.length;i++){
      for(int j = 0;j < matrix.length;j++){
          if(matrix.length-1 == (i+j)){
            if(matrix[i][j] < menor){
               menor = matrix[i][j];
            }
          }
      }
    }
    return menor;
  }
  }
