import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GerenciadorDeProcessos {
    private Queue<Integer> filaProcessos;
    private int pidCounter;

    public GerenciadorDeProcessos() {
        this.filaProcessos = new LinkedList<>();
        this.pidCounter = 1;
    }

    public void adicionarProcesso() {
        filaProcessos.add(pidCounter);
        System.out.println("Processo PID " + pidCounter + " adicionado à fila.");
        pidCounter++;
    }

    public void executarProcesso() {
        if (filaProcessos.isEmpty()) {
            System.out.println("Nenhum processo na fila.");
        } else {
            int pid = filaProcessos.poll();
            System.out.println("Executando processo PID " + pid + ".");
        }
    }

    public void exibirFila() {
        if (filaProcessos.isEmpty()) {
            System.out.println("A fila de processos está vazia.");
        } else {
            System.out.println("Processos na fila:");
            for (int pid : filaProcessos) {
                System.out.println("PID " + pid);
            }
        }
    }
}

public class Q8 {
    public static void main(String[] args) {
        GerenciadorDeProcessos gerenciador = new GerenciadorDeProcessos();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n=== Gerenciador de Processos ===");
            System.out.println("1. Adicionar Processo");
            System.out.println("2. Executar Processo");
            System.out.println("3. Exibir Fila de Processos");
            System.out.println("4. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    gerenciador.adicionarProcesso();
                    break;
                case "2":
                    gerenciador.executarProcesso();
                    break;
                case "3":
                    gerenciador.exibirFila();
                    break;
                case "4":
                    System.out.println("Encerrando o gerenciador de processos.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("4"));

        scanner.close();
    }
}
