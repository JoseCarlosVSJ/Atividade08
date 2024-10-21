import java.util.LinkedList;
import java.util.Scanner;

class EditorTexto {
    private String textoAtual;
    private LinkedList<String> historico;

    public EditorTexto() {
        this.textoAtual = "";
        this.historico = new LinkedList<>();
    }

    public void escrever(String texto) {
        historico.addLast(texto);
        textoAtual += texto;
        System.out.println("Texto atual: " + textoAtual);
    }

    public void desfazer() {
        if (!historico.isEmpty()) {
            String textoRemovido = historico.removeLast();
            textoAtual = textoAtual.substring(0, textoAtual.length() - textoRemovido.length());
            System.out.println("Desfez a última ação. Texto atual: " + textoAtual);
        } else {
            System.out.println("Nada para desfazer.");
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n=== Editor de Texto ===");
            System.out.println("1. Escrever Texto");
            System.out.println("2. Desfazer Última Ação");
            System.out.println("3. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o texto a adicionar: ");
                    String texto = scanner.nextLine();
                    editor.escrever(texto);
                    break;
                case "2":
                    editor.desfazer();
                    break;
                case "3":
                    System.out.println("Encerrando o editor.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("3"));

        scanner.close();
    }
}
