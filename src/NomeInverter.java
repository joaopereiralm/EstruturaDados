import java.util.Stack;

public class NomeInverter {
    public static String Inversao(String texto) {
        Stack<Character> pilha = new Stack<>();

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != ' ') {
                pilha.push(c);
            } else {
                while (!pilha.isEmpty()) {
                    resultado.append(pilha.pop());
                }
                resultado.append(' ');
            }
        }
        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop());
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        String textoEntrada = "EXERCICIO MUITO COMPLICADO";

        System.out.println("Texto de entrada: " + textoEntrada);
        System.out.println("Texto de saída: " + Inversao(textoEntrada));

    }
}
