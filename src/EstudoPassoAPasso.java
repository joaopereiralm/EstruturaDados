import java.util.Arrays;

public class EstudoPassoAPasso {

    public static void main(String[] args) {
        // Vetor pequeno e desordenado para conseguirmos ler no console
        int[] vetorOriginal = {24, 9, 8, 1, 10, 3};

        System.out.println("=== TESTE BUBBLE SORT ===");
        int[] arrBubble = vetorOriginal.clone();
        System.out.println("Inicial: " + Arrays.toString(arrBubble));
        bubbleSortPassoAPasso(arrBubble);
        long inicioBubble = System.nanoTime();
        long fimBubble = System.nanoTime();
        double tempoBubble = (fimBubble - inicioBubble) / 1_000_000.0;
        System.out.println("Bubble Sort tempo    : " + tempoBubble + " ms");

        System.out.println("\n=== TESTE SELECTION SORT ===");
        int[] arrSelection = vetorOriginal.clone();
        System.out.println("Inicial: " + Arrays.toString(arrSelection));
        selectionSortPassoAPasso(arrSelection);
        long inicioSelection = System.nanoTime();
        long fimSelection = System.nanoTime();
        double tempoSelection = (fimSelection - inicioSelection) / 1_000_000.0;
        System.out.println("Bubble Sort tempo    :" + tempoSelection + " ms");


        System.out.println("\n=== TESTE INSERTION SORT ===");
        int[] arrInsertion = vetorOriginal.clone();
        System.out.println("Inicial: " + Arrays.toString(arrInsertion));
        insertionSortPassoAPasso(arrInsertion);
        long inicioInsertion = System.nanoTime();
        long fimInsertion = System.nanoTime();
        double tempoInsertion = (fimInsertion - inicioInsertion) / 1_000_000.0;
        System.out.println("Bubble Sort tempo    : " + tempoInsertion + " ms");
    }

    // ==========================================
    // 1. BUBBLE SORT (Passo a Passo)
    // ==========================================
    public static void bubbleSortPassoAPasso(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // Imprime como o vetor ficou APÓS "flutuar" o maior número da rodada
            System.out.println("Passo " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    // ==========================================
    // 2. SELECTION SORT (Passo a Passo)
    // ==========================================
    public static void selectionSortPassoAPasso(int[] arr) {
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

            // Imprime como o vetor ficou APÓS colocar o menor número da rodada no início
            System.out.println("Passo " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    // ==========================================
    // 3. INSERTION SORT (Passo a Passo)
    // ==========================================
    public static void insertionSortPassoAPasso(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = chave;

            // Imprime como o vetor ficou APÓS inserir a "chave" atual no lugar certo
            System.out.println("Passo " + i + ": " + Arrays.toString(arr));
        }
    }

    private static double imprimirResultado(String caso, long inicio, long fim) {
        double tempoMs = (fim - inicio) / 1_000_000.0;
        System.out.printf(" - %-20s: %.4f ms%n", caso, tempoMs);
        return tempoMs;
    }
}