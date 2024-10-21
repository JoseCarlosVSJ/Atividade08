import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GerenciadorDeImpressao {
    private Queue<String> filaImpressao;

    public GerenciadorDeImpressao() {
        this.filaImpressao = new LinkedList<>();
    }

    public void adicionarTrabalho(String documento) {
        filaImpressao.add(documento);
        System.out.println("Documento " + documento + " adicionado à fila de impressão.");
    }

    public void processarTrabalho() {
        if (filaImpressao.isEmpty()) {
            System.out.println("Nenhum trabalho na fila de impressão.");
        } else {
            String documento = filaImpressao.poll();
            System.out.println("Imprimindo documento: " + documento);
        }
    }

    public void exibirFila() {
        if (filaImpressao.isEmpty()) {
            System.out.println("A fila de impressão está vazia.");
        } else {
            System.out.println("Documentos na fila de impressão:");
            for (String documento : filaImpressao) {
                System.out.println(documento);
            }
        }
    }
}

public class Q7 {
    public static void main(String[] args) {
        GerenciadorDeImpressao gerenciador = new GerenciadorDeImpressao();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n=== Gerenciador de Impressão ===");
            System.out.println("1. Adicionar Trabalho de Impressão");
            System.out.println("2. Processar Trabalho de Impressão");
            System.out.println("3. Exibir Fila de Impressão");
            System.out.println("4. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o nome do documento: ");
                    String documento = scanner.nextLine();
                    gerenciador.adicionarTrabalho(documento);
                    break;
                case "2":
                    gerenciador.processarTrabalho();
                    break;
                case "3":
                    gerenciador.exibirFila();
                    break;
                case "4":
                    System.out.println("Encerrando o gerenciador de impressão.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("4"));

        scanner.close();
    }
}
