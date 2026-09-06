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
    bubbleAleatorio(aleatorio1);
    bubbleOrdenado(ordenado1);
    bubbleInvertido(invertido1);


    System.out.println("\n SELECAO DIRETA ");
    selecaoAleatorio(aleatorio2);
    selecaoOrdenado(ordenado2);
    selecaoInvertido(invertido2);


    System.out.println("\n INSERCAO DIRETA ");
    insercaoAleatorio(aleatorio3);
    insercaoOrdenado(ordenado3);
    insercaoInvertido(invertido3);
  }

  public static void bubbleAleatorio(int[] vetor) {
    long inicio = System.nanoTime();
    executarBubbleSort(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Aleatório", inicio, fim);
  }

  public static void bubbleOrdenado(int[] vetor) {
    long inicio = System.nanoTime();
    executarBubbleSort(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Ordenado", inicio, fim);
  }

  public static void bubbleInvertido(int[] vetor) {
    long inicio = System.nanoTime();
    executarBubbleSort(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Invertido", inicio, fim);
  }

  private static void executarBubbleSort(int[] v) {
    int n = v.length;
    boolean trocou;
    for (int i = 0; i < n - 1; i++) {
      trocou = false;
      for (int j = 0; j < n - 1 - i; j++) {
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

  public static void selecaoAleatorio(int[] vetor) {
    long inicio = System.nanoTime();
    executarSelecaoDireta(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Aleatório", inicio, fim);
  }

  public static void selecaoOrdenado(int[] vetor) {
    long inicio = System.nanoTime();
    executarSelecaoDireta(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Ordenado", inicio, fim);
  }

  public static void selecaoInvertido(int[] vetor) {
    long inicio = System.nanoTime();
    executarSelecaoDireta(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Invertido", inicio, fim);
  }

  private static void executarSelecaoDireta(int[] v) {
    int n = v.length;
    for (int i = 0; i < n - 1; i++) {
      int menor = i;
      for (int j = i + 1; j < n; j++) {
        if (v[j] < v[menor]) {
          menor = j;
        }
      }
      int aux = v[i];
      v[i] = v[menor];
      v[menor] = aux;
    }
  }

  public static void insercaoAleatorio(int[] vetor) {
    long inicio = System.nanoTime();
    executarInsercaoDireta(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Aleatório", inicio, fim);
  }

  public static void insercaoOrdenado(int[] vetor) {
    long inicio = System.nanoTime();
    executarInsercaoDireta(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Ordenado", inicio, fim);
  }

  public static void insercaoInvertido(int[] vetor) {
    long inicio = System.nanoTime();
    executarInsercaoDireta(vetor);
    long fim = System.nanoTime();
    imprimirResultado("Vetor Invertido", inicio, fim);
  }

  private static void executarInsercaoDireta(int[] v) {
    int n = v.length;
    for (int i = 1; i < n; i++) {
      int chave = v[i];
      int j = i - 1;
      while (j >= 0 && v[j] > chave) {
        v[j + 1] = v[j];
        j--;
      }
      v[j + 1] = chave;
    }
  }

  private static void imprimirResultado(String caso, long inicio, long fim) {
    double tempoMs = (fim - inicio) / 1_000_000.0;
    System.out.printf(" - %-20s: %.4f ms%n", caso, tempoMs);
  }
}