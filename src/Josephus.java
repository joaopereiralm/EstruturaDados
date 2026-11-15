import java.util.Random;
import java.util.Scanner;

public class Josephus {

    //no da lista encadeada circular
    static class No {
        int pessoa;
        No proximo;

        No(int pessoa) {
            this.pessoa = pessoa;
        }
    }

    /** Resolve por simulacao em uma lista circular encadeada. */
    public static int josephusLista(int n, int m) {
        validarParametros(n, m);

        //monta a roda: 1 -> 2 -> ... -> n e o ultimo volta pro 1
        No primeiro = new No(1);
        No ultimo = primeiro;
        for (int pessoa = 2; pessoa <= n; pessoa++) {
            ultimo.proximo = new No(pessoa);
            ultimo = ultimo.proximo;
        }
        ultimo.proximo = primeiro;

        //anterior fica sempre um no antes de quem vai ser contado
        No anterior = ultimo;
        int restantes = n;
        while (restantes > 1) {
            //o % evita dar voltas completas inuteis na roda
            int passos = (int) (((long) m - 1) % restantes);
            for (int i = 0; i < passos; i++) {
                anterior = anterior.proximo;
            }
            //pula (elimina) a pessoa seguinte
            anterior.proximo = anterior.proximo.proximo;
            restantes--;
        }
        return anterior.pessoa;
    }

    /** Resolve por simulacao em um vetor. */
    public static int josephusVetor(int n, int m) {
        validarParametros(n, m);

        int[] roda = new int[n];
        for (int i = 0; i < n; i++) {
            roda[i] = i + 1;
        }

        int restantes = n;
        int posicao = 0;
        while (restantes > 1) {
            //posicao de quem sera eliminado (o % faz voltar pro comeco da roda)
            posicao = (int) ((posicao + (long) m - 1) % restantes);

            //puxa todo mundo da direita uma casa pra esquerda
            for (int i = posicao; i < restantes - 1; i++) {
                roda[i] = roda[i + 1];
            }
            restantes--;

            //se eliminou o ultimo, a contagem recomeca no primeiro
            if (posicao == restantes) {
                posicao = 0;
            }
        }
        return roda[0];
    }

    private static void validarParametros(int n, int m) {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException("N e M devem ser maiores que zero.");
        }
    }

    //sorteia a quantidade de pessoas (de 1 a 500)
    public static int sortearN() {
        return new Random().nextInt(500) + 1;
    }

    //devolve null se a entrada acabar antes de o usuario digitar um valor valido
    private static Integer lerInteiroPositivo(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (!sc.hasNext()) {
                System.out.println("\nEntrada encerrada.");
                return null;
            }
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                if (valor > 0) {
                    return valor;
                }
                System.out.println("Digite um valor maior que zero.");
            } else {
                System.out.println("Entrada invalida. Digite um numero inteiro.");
                sc.next();
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("1 - Digitar N");
            System.out.println("2 - Sortear N (de 1 a 500)");
            Integer opcao = lerInteiroPositivo(sc, "Escolha: ");
            if (opcao == null) {
                return;
            }

            int n;
            if (opcao == 1) {
                Integer lido = lerInteiroPositivo(sc, "Quantidade de pessoas (N): ");
                if (lido == null) {
                    return;
                }
                n = lido;
            } else if (opcao == 2) {
                n = sortearN();
                System.out.println("N sorteado: " + n);
            } else {
                System.out.println("Opcao invalida.");
                return;
            }

            Integer m = lerInteiroPositivo(sc, "Eliminar a cada quantas pessoas (M): ");
            if (m == null) {
                return;
            }

            int sobreviventeLista = josephusLista(n, m);
            int sobreviventeVetor = josephusVetor(n, m);

            System.out.println("\nLista encadeada: sobrou a pessoa " + sobreviventeLista);
            System.out.println("Vetor: sobrou a pessoa " + sobreviventeVetor);
            System.out.println("Os dois metodos concordam: "
                    + (sobreviventeLista == sobreviventeVetor ? "SIM" : "NAO"));
        }
    }
}