import java.util.Random;

public class TesteOrdenacao {
    //aux
    public static boolean menor(int a, int b) {
        return a < b;
    }

    public static boolean maior(int a, int b) {
        return a > b;
    }

    public static void trocar(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    //bubblesort
    public static void bubbleSort(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (maior(v[j], v[j + 1])) {
                    trocar(v, j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break; // já está ordenado
            }
        }
    }

    //selec direta
    public static void selecaoDireta(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (menor(v[j], v[indiceMenor])) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                trocar(v, i, indiceMenor);
            }
        }
    }

    //inserc direta
    public static void insercaoDireta(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && maior(v[j], chave)) {
                v[j + 1] = v[j]; // desloca para a direita
                j--;
            }
            v[j + 1] = chave;
        }
    }

    //quicksort
    public static void quickSort(int[] v) {
        if (v.length > 1) {
            ordena(v, 0, v.length - 1);
        }
    }

    public static void ordena(int[] v, int esq, int dir) {
        int i = esq;
        int j = dir;
        int pivo = v[esq + (dir - esq) / 2];

        do {
            while (menor(v[i], pivo)) {
                i++;
            }
            while (maior(v[j], pivo)) {
                j--;
            }
            if (i <= j) {
                trocar(v, i, j);
                i++;
                j--;
            }
        } while (i <= j);

        if (esq < j) {
            ordena(v, esq, j);
        }
        if (i < dir) {
            ordena(v, i, dir);
        }
    }

    //random vet
    static int[] gerarVetor(int n, int cenario, long semente) {
        int[] v = new int[n];
        Random r = new Random(semente);
        for (int i = 0; i < n; i++) {
            v[i] = r.nextInt(n * 10);
        }
        if (cenario == 1) {
            quickSort(v);              // deixa em ordem crescente
        } else if (cenario == 2) {
            quickSort(v);
            for (int i = 0; i < n / 2; i++) { // inverte o vetor
                int aux = v[i];
                v[i] = v[n - 1 - i];
                v[n - 1 - i] = aux;
            }
        }
        return v;
    }

    static int[] copiarVetor(int[] origem) {
        int[] copia = new int[origem.length];
        System.arraycopy(origem, 0, copia, 0, origem.length);
        return copia;
    }

    static boolean estaOrdenado(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            if (v[i] > v[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static String nomeCenario(int cenario) {
        if (cenario == 0) return "ALEATORIA";
        if (cenario == 1) return "CRESCENTE";
        return "DECRESCENTE";
    }

    public static String nomeAlgoritmo(int alg) {
        switch (alg) {
            case 0:  return "Bubblesort";
            case 1:  return "Selecao direta";
            case 2:  return "Insercao direta";
            default: return "Quicksort";
        }
    }

    public static void executar(int alg, int[] v) {
        switch (alg) {
            case 0:  bubbleSort(v);    break;
            case 1:  selecaoDireta(v); break;
            case 2:  insercaoDireta(v); break;
            default: quickSort(v);     break;
        }
    }

    //aquece a JVM para a primeira medicao (n = 100) nao sair distorcida
    public static void aquecer() {
        for (int alg = 0; alg < 4; alg++) {
            for (int k = 0; k < 20; k++) {
                executar(alg, gerarVetor(2000, 0, k));
            }
        }
    }

    public static double tempoMs(int alg, int n, int cenario) {
        int[] original = gerarVetor(n, cenario, 12345L);

        int repeticoes;                       // vetor pequeno = mais repeticoes
        if (n <= 1000)       repeticoes = 20;
        else if (n <= 10000) repeticoes = 3;
        else                 repeticoes = 1;

        long somaTempo = 0;
        for (int r = 0; r < repeticoes; r++) {
            int[] v = copiarVetor(original);  // sempre ordena uma copia do mesmo vetor

            long inicio = System.nanoTime();
            executar(alg, v);
            long fim = System.nanoTime();

            somaTempo += (fim - inicio);
            if (!estaOrdenado(v)) {
                System.err.println("ERRO: " + nomeAlgoritmo(alg) + " nao ordenou!");
            }
        }
        return (somaTempo / (double) repeticoes) / 1_000_000.0;   // ns -> ms
    }

    //uma funcao para cada tamanho de vetor
    public static double vet100(int alg, int cenario) {
        return tempoMs(alg, 100, cenario);
    }

    public static double vet1000(int alg, int cenario) {
        return tempoMs(alg, 1000, cenario);
    }

    public static double vet10000(int alg, int cenario) {
        return tempoMs(alg, 10000, cenario);
    }

    public static double vet100000(int alg, int cenario) {
        return tempoMs(alg, 100000, cenario);
    }

    //main
    public static void main(String[] args) {
        aquecer();

        int[] ordens = {1, 2, 0};   // crescente, decrescente, aleatoria

        System.out.println("TEMPO DE EXECUCAO (ms)");

        for (int k = 0; k < ordens.length; k++) {
            int cenario = ordens[k];

            System.out.println();
            System.out.println("Ordem de entrada: " + nomeCenario(cenario));
            System.out.printf("%-16s %14s %14s %14s %14s%n",
                    "Algoritmo / Tempo Ms", "vet[100]", "vet[1.000]", "vet[10.000]", "vet[100.000]");

            for (int alg = 0; alg < 4; alg++) {
                System.out.printf("%-16s %14.3f %14.3f %14.3f %14.3f%n",
                        nomeAlgoritmo(alg),
                        vet100(alg, cenario),
                        vet1000(alg, cenario),
                        vet10000(alg, cenario),
                        vet100000(alg, cenario));
            }
        }
    }
}