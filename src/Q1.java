import java.util.LinkedList;

class Tarefa {
    String descricao;
    boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public void marcarConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return descricao + (concluida ? " [Concluída]" : " [Pendente]");
    }
}

class GerenciadorDeTarefas {
    LinkedList<Tarefa> tarefas;

    public GerenciadorDeTarefas() {
        this.tarefas = new LinkedList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
    }

    public void removerTarefa(String descricao) {
        tarefas.removeIf(tarefa -> tarefa.descricao.equals(descricao));
    }

    public void marcarTarefaComoConcluida(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.descricao.equals(descricao)) {
                tarefa.marcarConcluida();
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa adicionada.");
        } else {
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();

        gerenciador.adicionarTarefa("Comprar pão");
        gerenciador.adicionarTarefa("Estudar Java");
        gerenciador.listarTarefas();

        gerenciador.marcarTarefaComoConcluida("Estudar Java");
        gerenciador.listarTarefas();

        gerenciador.removerTarefa("Comprar pão");
        gerenciador.listarTarefas();
    }
}