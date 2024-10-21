import java.util.LinkedList;

class HistoricoDeNavegacao {
    LinkedList<String> urls;
    int limite;

    public HistoricoDeNavegacao(int limite) {
        this.urls = new LinkedList<>();
        this.limite = limite;
    }

    public void visitarUrl(String url) {
        if (urls.size() >= limite) {
            urls.removeFirst();
        }
        urls.add(url);
    }

    public void mostrarHistorico() {
        if (urls.isEmpty()) {
            System.out.println("Histórico vazio.");
        } else {
            System.out.println("Histórico de Navegação:");
            for (String url : urls) {
                System.out.println(url);
            }
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        HistoricoDeNavegacao historico = new HistoricoDeNavegacao(3);

        historico.visitarUrl("https://site1.com");
        historico.visitarUrl("https://site2.com");
        historico.visitarUrl("https://site3.com");
        historico.mostrarHistorico();

        historico.visitarUrl("https://site4.com");
        historico.mostrarHistorico();
    }
}
