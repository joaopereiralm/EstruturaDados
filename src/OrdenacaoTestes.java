import java.util.Random;

public class OrdenacaoTestes {
  public static void main(String[] args) {
    Random random = new Random();
    //randoms

    int[] aleatorio1 = new int[1000];
    int[] aleatorio2 = new int[1000];
    int[] aleatorio3 = new int[1000];

    for (int i = 0; i < 1000; i++) {
      int numero = random.nextInt(10000);
      aleatorio1[i] = numero;
      aleatorio2[i] = numero;
      aleatorio3[i] = numero;
    }

    // ordenados
    int[] ordenado1 = new int[1000];
    int[] ordenado2 = new int[1000];
    int[] ordenado3 = new int[1000];

    for (int i = 0; i < 1000; i++) {
      ordenado1[i] = i + 1;
      ordenado2[i] = i + 1;
      ordenado3[i] = i + 1;
    }

    // invertidos
    int[] invertido1 = new int[1000];
    int[] invertido2 = new int[1000];
    int[] invertido3 = new int[1000];

    for (int i = 0; i < 1000; i++) {
      invertido1[i] = 1000 - i;
      invertido2[i] = 1000 - i;
      invertido3[i] = 1000 - i;
    }

    // testes

    System.out.println("\n BUBBLE SORT ");
    double t1 = bubbleAleatorio(aleatorio1);
    double t2 = bubbleOrdenado(ordenado1);
    double t3 = bubbleInvertido(invertido1);


    System.out.println("\n SELECAO DIRETA ");
    double t4 = selecaoAleatorio(aleatorio2);
    double t5 = selecaoOrdenado(ordenado2);
    double t6 = selecaoInvertido(invertido2);


    System.out.println("\n INSERCAO DIRETA ");
    double t7 = insercaoAleatorio(aleatorio3);
    double t8 = insercaoOrdenado(ordenado3);
    double t9 = insercaoInvertido(invertido3);

    //soma de todos os ms
    double totalBubble = t1 + t2 + t3;
    System.out.println("");
    System.out.printf(" > TOTAL BUBBLE SORT: %.4f ms%n", totalBubble);

    double totalSelecao = t4 + t5 + t6;
    System.out.printf(" > TOTAL SELECAO DIRETA: %.4f ms%n", totalSelecao);

    double totalInsercao = t7 + t8 + t9;
    System.out.printf(" > TOTAL INSERCAO DIRETA: %.4f ms%n", totalInsercao);


    //obs interna que consta também no txt
    System.out.println("\nObs: O algoritmo de Inserção Direta apresentou o melhor desempenho geral entre os três métodos testados. " +
            "\nEle alcançou o menor tempo de execução no cenário com dados aleatórios, superando o Bubble Sort e a Seleção Direta. " +
            "\nAlém disso, aproveitou com máxima eficiência a estrutura do vetor já ordenado, registrando o tempo mais rápido de todo o teste.");
  }

  public static double bubbleAleatorio(int[] vetor) {
    long inicio = System.nanoTime();
    executarBubbleSort(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Aleatório", inicio, fim);
  }

  public static double bubbleOrdenado(int[] vetor) {
    long inicio = System.nanoTime();
    executarBubbleSort(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Ordenado", inicio, fim);
  }

  public static double bubbleInvertido(int[] vetor) {
    long inicio = System.nanoTime();
    executarBubbleSort(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Invertido", inicio, fim);
  }

  private static void executarBubbleSort(int[] v) {
    boolean trocou;
    for (int i = 0; i < v.length - 1; i++) {
      trocou = false;
      for (int j = 0; j < v.length - 1 - i; j++) {
        if (v[j] > v[j + 1]) {
          int aux = v[j];
          v[j] = v[j + 1];
          v[j + 1] = aux;
          trocou = true;
        }
      }
      if (!trocou) break; // caso já tenha, vai dar break
    }
  }

  public static double selecaoAleatorio(int[] vetor) {
    long inicio = System.nanoTime();
    executarSelecaoDireta(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Aleatório", inicio, fim);
  }

  public static double selecaoOrdenado(int[] vetor) {
    long inicio = System.nanoTime();
    executarSelecaoDireta(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Ordenado", inicio, fim);
  }

  public static double selecaoInvertido(int[] vetor) {
    long inicio = System.nanoTime();
    executarSelecaoDireta(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Invertido", inicio, fim);
  }

  private static void executarSelecaoDireta(int[] v) {
    for (int i = 0; i < v.length - 1; i++) {
      int menor = i;
      for (int j = i + 1; j < v.length; j++) {
        if (v[j] < v[menor]) {
          menor = j;
        }
      }
      int aux = v[i];
      v[i] = v[menor];
      v[menor] = aux;
    }
  }

  public static double insercaoAleatorio(int[] vetor) {
    long inicio = System.nanoTime();
    executarInsercaoDireta(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Aleatório", inicio, fim);
  }

  public static double insercaoOrdenado(int[] vetor) {
    long inicio = System.nanoTime();
    executarInsercaoDireta(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Ordenado", inicio, fim);
  }

  public static double insercaoInvertido(int[] vetor) {
    long inicio = System.nanoTime();
    executarInsercaoDireta(vetor);
    long fim = System.nanoTime();
    return imprimirResultado("Vetor Invertido", inicio, fim);
  }

  private static void executarInsercaoDireta(int[] v) {
    for (int i = 1; i < v.length; i++) {
      int chave = v[i];
      int j = i - 1;
      while (j >= 0 && v[j] > chave) {
        v[j + 1] = v[j];
        j--;
      }
      v[j + 1] = chave;
    }
  }

  private static double imprimirResultado(String caso, long inicio, long fim) {
    double tempoMs = (fim - inicio) / 1_000_000.0;
    System.out.printf(" - %-20s: %.4f ms%n", caso, tempoMs);
    return tempoMs;
  }
}