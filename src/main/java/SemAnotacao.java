import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {
  public static void main(String[] args) {
    ArrayList<String> tarefas = new ArrayList<>(); 
    ArrayList<Boolean> concluidas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int opcao = 0;
    while (opcao !=5) 
      System.out.println("\n=== LISTA DE TAREFAS ===");
      System.out.println("1 - Adicionar tarefa");
      System.out.println("2 - Listar tarefas");
      System.out.println("3 - Marcar como concluída");
      System.out.println("4 - Remover tarefa");
      System.out.println("5 - Sair");
      System.out.print("Escolha uma opção: ");

      opcao = scanner.nextInt();
      scanner.nextInt();

      if (opcao == 1) {
        System.out.println("Digite a tarefa: ");
        String tarefa = scanner.nextLine();
        tarefas.add(tarefa);
        concluidas.add(false);
        System.out.println("Tarefa adicionada!");

      } else if (opcao == 2) {
          if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("\n--- Suas Tarefas ---");
            for (int i = 0; i < tarefas.size(); i++) {
                String status = concluidas.get(i) ? "[✓]" : "[ ]";
                System.out.println((i + 1) + ". " + status + " " + tarefas.get(i));
          }
        }

      } else if (opcao == 3) {
        if (tarefas.isEmpty()) {
          System.out.println("Nenhuma tarefa para marcar.");
        } else {
          System.out.print("Número da tarefa para marcar: ");
          int numero = scanner.nextInt();
          if (numero > 0 && numero <- tarefas.size()) {
            concluidas.set(numero - 1, true);
            System.out.println("Tarefa marcada como concluída!");
          } else {
            System.out.println("Número inválido.");
          }
        }
      }
  

  }
}
