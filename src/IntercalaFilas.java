import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IntercalaFilas {

    public static <T> Queue<T> intercalarFilasComPilha(Queue<T> f1, Queue<T> f2) {
        Stack<T> p1Aux = new Stack<>();
        Stack<T> p2Aux = new Stack<>();
        Stack<T> pIntercalada = new Stack<>();
        Queue<T> filaResultado = new LinkedList<>();

        while (!f1.isEmpty()) {
            p1Aux.push(f1.poll());
        }
        while (!f2.isEmpty()) {
            p2Aux.push(f2.poll());
        }

        while (p1Aux.size() > p2Aux.size()) {
            pIntercalada.push(p1Aux.pop());
        }
        while (p2Aux.size() > p1Aux.size()) {
            pIntercalada.push(p2Aux.pop());
        }

        while (!p1Aux.isEmpty() && !p2Aux.isEmpty()) {
            pIntercalada.push(p2Aux.pop());
            pIntercalada.push(p1Aux.pop());
        }

        while (!pIntercalada.isEmpty()) {
            filaResultado.add(pIntercalada.pop());
        }

        return filaResultado;
    }

    public static void main(String[] args) {
        Queue<Integer> fila1 = new LinkedList<>();
        Queue<Integer> fila2 = new LinkedList<>();

        fila1.add(1);
        fila1.add(3);
        fila1.add(5);

        fila2.add(2);
        fila2.add(4);
        fila2.add(6);
        fila2.add(8);
        fila2.add(10);

        //fila1: [1, 3, 5]
        System.out.println("Fila 1 Original: " + fila1);
        //fila2: [2, 4, 6, 8, 10]
        System.out.println("Fila 2 Original: " + fila2);

        Queue<Integer> resultado = intercalarFilasComPilha(fila1, fila2);

        // saída
        System.out.println("Fila Intercalada: " + resultado);
    }
}