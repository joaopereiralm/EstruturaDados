import java.util.Stack;

public class Pilha {
    public static void main (String[] args){
        Stack<Integer> pilha = new Stack<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha: " + pilha);
        System.out.println("Topo: " + pilha.peek());
        System.out.println("Removido: " + pilha.pop());

        System.out.println("\nPilha final: " + pilha);

    }
}
