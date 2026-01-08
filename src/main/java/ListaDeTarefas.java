import java.util.ArrayList; // Importa a classe ArrayList para criar listas dinâmicas
import java.util.Scanner;  // Importa a classe Scanner para ler dados do teclado

public class ListaDeTarefas {
    // Método principal onde o programa inicia
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>(); // Cria uma lista para guardar o texto das tarefas

        // Cria uma lista para guardar se a tarefa está concluída (true) ou não (false)
        ArrayList<Boolean> concluidas = new ArrayList<>();
        // Cria um objeto Scanner para ler o que o usuário digitar
        Scanner scanner = new Scanner(System.in);
        // Variável que guarda a opção escolhida pelo usuário
        int opcao = 0;

        // Loop que continua rodando até o usuário escolher a opção 5 (Sair)
        while (opcao != 5) {
            // Mostra o menu na tela
            System.out.println("\n=== LISTA DE TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Marcar como concluída");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            // Lê o número que o usuário digitou
            opcao = scanner.nextInt();
            // Limpa o buffer (limpa o "Enter" que ficou guardado)
            scanner.nextLine();

            // OPÇÃO 1: Adicionar uma nova tarefa
            if (opcao == 1) {
                System.out.print("Digite a tarefa: ");
                // Lê o texto completo que o usuário digitar
                String tarefa = scanner.nextLine();
                // Adiciona a tarefa na lista de tarefas
                tarefas.add(tarefa);
                // Adiciona false na lista de concluídas (porque a tarefa é nova)
                concluidas.add(false);
                System.out.println("Tarefa adicionada!");

                // OPÇÃO 2: Mostrar todas as tarefas
            } else if (opcao == 2) {
                // Verifica se a lista está vazia
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa cadastrada.");
                } else {
                    System.out.println("\n--- Suas Tarefas ---");
                    // Loop que passa por cada tarefa da lista
                    for (int i = 0; i < tarefas.size(); i++) {
                        // Se concluidas.get(i) for true, mostra [✓], senão mostra [ ]
                        String status = concluidas.get(i) ? "[✓]" : "[ ]";
                        // Mostra: número da tarefa + status + texto da tarefa
                        System.out.println((i + 1) + ". " + status + " " + tarefas.get(i));
                    }
                }

                // OPÇÃO 3: Marcar uma tarefa como concluída
            } else if (opcao == 3) {
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa para marcar.");
                } else {
                    System.out.print("Número da tarefa para marcar: ");
                    int numero = scanner.nextInt();
                    // Verifica se o número é válido (entre 1 e o tamanho da lista)
                    if (numero > 0 && numero <= tarefas.size()) {
                        // Muda o valor para true na posição (numero - 1)
                        // Usamos (numero - 1) porque a lista começa no índice 0
                        concluidas.set(numero - 1, true);
                        System.out.println("Tarefa marcada como concluída!");
                    } else {
                        System.out.println("Número inválido.");
                    }
                }

                // OPÇÃO 4: Remover uma tarefa
            } else if (opcao == 4) {
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa para remover.");
                } else {
                    System.out.print("Número da tarefa para remover: ");
                    int numero = scanner.nextInt();
                    if (numero > 0 && numero <= tarefas.size()) {
                        // Remove a tarefa da lista de tarefas
                        tarefas.remove(numero - 1);
                        // Remove também da lista de concluídas (mesmo índice)
                        concluidas.remove(numero - 1);
                        System.out.println("Tarefa removida!");
                    } else {
                        System.out.println("Número inválido.");
                    }
                }

                // OPÇÃO 5: Sair do programa
            } else if (opcao == 5) {
                System.out.println("Até logo!");

                // Caso o usuário digite um número que não está no menu
            } else {
                System.out.println("Opção inválida!");
            }
        }

        // Fecha o Scanner (boa prática para liberar recursos)
        scanner.close();
    }
}
