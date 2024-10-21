import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

class JogoDeCartas {
    private LinkedList<Integer> mao;
    private Random random;

    public JogoDeCartas() {
        this.mao = new LinkedList<>();
        this.random = new Random();
    }

    public void adicionarCarta() {
        int carta = random.nextInt(7) + 1;
        mao.add(carta);
        System.out.println("Carta " + carta + " adicionada à mão.");
    }

    public void removerCarta(int carta) {
        if (mao.remove(Integer.valueOf(carta))) {
            System.out.println("Carta " + carta + " removida da mão.");
        } else {
            System.out.println("Você não possui essa carta, selecione outra.");
        }
    }

    public void exibirMao() {
        if (mao.isEmpty()) {
            System.out.println("Mão vazia.");
        } else {
            System.out.println("Cartas na mão:");
            for (Integer carta : mao) {
                System.out.println(carta);
            }
        }
    }

    public void reorganizarCarta(int carta, int novaPosicao) {
        if (novaPosicao < 1 || novaPosicao > mao.size()) {
            System.out.println("Posição inválida.");
            return;
        }

        ListIterator<Integer> iterator = mao.listIterator();
        boolean cartaEncontrada = false;

        while (iterator.hasNext()) {
            if (iterator.next().equals(carta)) {
                iterator.remove();
                cartaEncontrada = true;
                break;
            }
        }

        if (cartaEncontrada) {
            mao.add(novaPosicao - 1, carta);
            System.out.println("Carta " + carta + " movida para a posição " + novaPosicao + ".");
        } else {
            System.out.println("Você não possui essa carta, selecione outra.");
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        JogoDeCartas jogo = new JogoDeCartas();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n=== Jogo de Cartas ===");
            System.out.println("1. Adicionar Carta");
            System.out.println("2. Remover Carta");
            System.out.println("3. Exibir Mão");
            System.out.println("4. Reorganizar Carta");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    jogo.adicionarCarta();
                    break;
                case "2":
                    System.out.print("Digite o número da carta a remover (1 a 7): ");
                    int cartaRemover = Integer.parseInt(scanner.nextLine());
                    jogo.removerCarta(cartaRemover);
                    break;
                case "3":
                    jogo.exibirMao();
                    break;
                case "4":
                    System.out.print("Digite o número da carta a mover (1 a 7): ");
                    int cartaMover = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite a nova posição: ");
                    int posicao = Integer.parseInt(scanner.nextLine());
                    jogo.reorganizarCarta(cartaMover, posicao);
                    break;
                case "5":
                    System.out.println("Encerrando o jogo.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("5"));

        scanner.close();
    }
}
