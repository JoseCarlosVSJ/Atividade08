import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class EditorTextoComRedo {
    private String textoAtual;
    private LinkedList<String> historico;
    private ListIterator<String> iterador;

    public EditorTextoComRedo() {
        this.textoAtual = "";
        this.historico = new LinkedList<>();
        this.iterador = historico.listIterator();
    }

    public void escrever(String texto) {
        while (iterador.hasNext()) {
            iterador.next();
            iterador.remove();
        }
        iterador.add(texto);
        textoAtual += texto;
        System.out.println("Texto atual: " + textoAtual);
    }

    public void desfazer() {
        if (iterador.hasPrevious()) {
            String textoRemovido = iterador.previous();
            textoAtual = textoAtual.substring(0, textoAtual.length() - textoRemovido.length());
            System.out.println("Desfazer: " + textoRemovido);
            System.out.println("Texto atual: " + textoAtual);
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void refazer() {
        if (iterador.hasNext()) {
            String textoAdicionado = iterador.next();
            textoAtual += textoAdicionado;
            System.out.println("Refazer: " + textoAdicionado);
            System.out.println("Texto atual: " + textoAtual);
        } else {
            System.out.println("Nada para refazer.");
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        EditorTextoComRedo editor = new EditorTextoComRedo();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n=== Editor de Texto com Undo e Redo ===");
            System.out.println("1. Escrever Texto");
            System.out.println("2. Desfazer");
            System.out.println("3. Refazer");
            System.out.println("4. Sair");
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
                    editor.refazer();
                    break;
                case "4":
                    System.out.println("Encerrando o editor.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("4"));

        scanner.close();
    }
}
