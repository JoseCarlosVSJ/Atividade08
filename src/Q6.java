import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class FilaBanco {
    private Queue<String> fila;

    public FilaBanco() {
        this.fila = new LinkedList<>();
    }

    public void entrarNaFila(String cliente) {
        fila.add(cliente);
        System.out.println("Cliente " + cliente + " entrou na fila.");
    }

    public void chamarProximo() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum cliente na fila.");
        } else {
            String proximoCliente = fila.poll();
            System.out.println("Atendendo o cliente: " + proximoCliente);
        }
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Clientes na fila:");
            for (String cliente : fila) {
                System.out.println(cliente);
            }
        }
    }
}

public class Q6 {
    public static void main(String[] args) {
        FilaBanco filaBanco = new FilaBanco();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n=== Fila de Atendimento do Banco ===");
            System.out.println("1. Entrar na Fila");
            System.out.println("2. Chamar Próximo Cliente");
            System.out.println("3. Exibir Fila");
            System.out.println("4. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();
                    filaBanco.entrarNaFila(cliente);
                    break;
                case "2":
                    filaBanco.chamarProximo();
                    break;
                case "3":
                    filaBanco.exibirFila();
                    break;
                case "4":
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("4"));

        scanner.close();
    }
}
