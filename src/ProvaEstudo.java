import java.util.Arrays;
import java.util.Random;

public class ProvaEstudo {

    public static void main(String[] args) {
        // 1. Criando um array grande com números aleatórios para conseguirmos ver a diferença de tempo
        int tamanho = 10000; // Altere para 100.000 se quiser ver o Bubble Sort "sofrer"
        int[] arrayOriginal = gerarArrayAleatorio(tamanho);

        System.out.println("Ordenando array de " + tamanho + " elementos...\n");

        // --- TESTANDO BUBBLE SORT ---
        int[] arrBubble = arrayOriginal.clone(); // Clonamos para todos usarem os mesmos números
        long inicioBubble = System.nanoTime();
        bubbleSort(arrBubble);
        long fimBubble = System.nanoTime();
        double tempoBubble = (fimBubble - inicioBubble) / 1_000_000.0;
        System.out.println("Bubble Sort tempo    : " + tempoBubble + " ms");

        // --- TESTANDO SELECTION SORT ---
        int[] arrSelection = arrayOriginal.clone();
        long inicioSelection = System.nanoTime();
        selectionSort(arrSelection);
        long fimSelection = System.nanoTime();
        double tempoSelection = (fimSelection - inicioSelection) / 1_000_000.0;
        System.out.println("Selection Sort tempo : " + tempoSelection + " ms");

        // --- TESTANDO INSERTION SORT ---
        int[] arrInsertion = arrayOriginal.clone();
        long inicioInsertion = System.nanoTime();
        insertionSort(arrInsertion);
        long fimInsertion = System.nanoTime();
        double tempoInsertion = (fimInsertion - inicioInsertion) / 1_000_000.0;
        System.out.println("Insertion Sort tempo : " + tempoInsertion + " ms");

        // --- TESTANDO QUICKSORT ---
        int[] arrQuick = arrayOriginal.clone();
        long inicioQuick = System.nanoTime();
        quickSort(arrQuick, 0, arrQuick.length - 1);
        long fimQuick = System.nanoTime();
        double tempoQuick = (fimQuick - inicioQuick) / 1_000_000.0;
        System.out.println("QuickSort tempo      : " + tempoQuick + " ms");
    }

    // ==========================================
    // FUNÇÕES DE ORDENAÇÃO (Transformadas em static)
    // ==========================================

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = chave;
        }
    }

    public static void quickSort(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = partition(arr, inicio, fim);
            quickSort(arr, inicio, indicePivo - 1);
            quickSort(arr, indicePivo + 1, fim);
        }
    }

    private static int partition(int[] arr, int inicio, int fim) {
        int pivo = arr[fim];
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            if (arr[j] <= pivo) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fim];
        arr[fim] = temp;
        return i + 1;
    }

    // ==========================================
    // FUNÇÃO AUXILIAR
    // ==========================================

    // Preenche um array com valores aleatórios para o teste ser justo e visível
    public static int[] gerarArrayAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        Random gerador = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = gerador.nextInt(100000); // Números de 0 a 99.999
        }
        return array;
    }
}
