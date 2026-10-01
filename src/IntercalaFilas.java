import java.util.ArrayDeque;
import java.util.Queue;

public class IntercalaFilas {
    public static Queue<Integer> intercalar(Queue<Integer> f1, Queue<Integer> f2) {
        Queue<Integer> resultado = new ArrayDeque<>();

        while (!f1.isEmpty() && !f2.isEmpty()) {
            resultado.add(f1.poll());
            resultado.add(f2.poll());
        }

        // if f1 > passa
        while (!f1.isEmpty()) {
            resultado.add(f1.poll());
        }

        // if f2 > passa
        while (!f2.isEmpty()) {
            resultado.add(f2.poll());
        }

        return resultado;
    }

    public static void main(String[] args) {
        Queue<Integer> fila1 = new ArrayDeque<>();
        Queue<Integer> fila2 = new ArrayDeque<>();

        fila1.add(1);
        fila1.add(3);
        fila1.add(5);

        fila2.add(2);
        fila2.add(4);
        fila2.add(6);
        fila2.add(8);
        fila2.add(10);

        //fila1: [1, 3, 5]
        System.out.println("Fila 1: " + fila1);
        //fila2: [2, 4, 6, 8, 10]
        System.out.println("Fila 2: " + fila2);

        Queue<Integer> intercalada = intercalar(fila1, fila2);

        System.out.println("Fila intercalada: " + intercalada);
    }
}