public class Exercício {
    public static void bubblesort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j+1]){
                    int aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    public static void main(String args []) {
        int [] array = {8, 3, 10, 1, 7, 2, 9, 4, 6, 5};

        System.out.println("Não ordenado: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("\nOrdenado: ");
        bubblesort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println("\nMenor número: ");
        System.out.println(array[0]);

        System.out.println("Maior número: ");
        System.out.println(array[array.length - 1]);
    }
}
