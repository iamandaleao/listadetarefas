// Array que guarda todas as tarefas
// Cada tarefa é um objeto com: id, texto e se está concluída
let tasks = [];

// Contador para gerar IDs únicos para cada tarefa
let taskIdCounter = 0;

// Função que carrega as tarefas salvas no navegador
function loadTasks() {
    // Tenta pegar as tarefas do LocalStorage
    // LocalStorage é um "armário" do navegador que guarda dados
    const savedTasks = localStorage.getItem('tasks');
    const savedCounter = localStorage.getItem('taskIdCounter');

    // Se existem tarefas salvas, carrega elas
    if (savedTasks) {
        // JSON.parse transforma o texto de volta em array
        tasks = JSON.parse(savedTasks);
    }

    // Se existe um contador salvo, carrega ele
    if (savedCounter) {
        taskIdCounter = parseInt(savedCounter);
    }
}

// Função que salva as tarefas no navegador
function saveTasks() {
    // JSON.stringify transforma o array em texto
    // localStorage.setItem salva o texto no navegador
    localStorage.setItem('tasks', JSON.stringify(tasks));
    localStorage.setItem('taskIdCounter', taskIdCounter.toString());
}

// Função que adiciona uma nova tarefa
function addTask() {
    // Pega o elemento do input
    const input = document.getElementById('taskInput');
    // Pega o texto e remove espaços extras
    const taskText = input.value.trim();

    // Se o texto estiver vazio, não faz nada
    if (taskText === '') {
        alert('Por favor, digite uma tarefa!');
        return;
    }

    // Cria um objeto representando a nova tarefa
    const newTask = {
        id: taskIdCounter++,  // ID único
        text: taskText,       // Texto da tarefa
        completed: false      // Começa como não concluída
    };

    // Adiciona a tarefa no array
    tasks.push(newTask);

    // Limpa o campo de input
    input.value = '';

    // IMPORTANTE: Salva as tarefas no navegador
    saveTasks();

    // Atualiza a tela para mostrar a nova tarefa
    renderTasks();
}

// Função que marca/desmarca uma tarefa como concluída
function toggleTask(id) {
    // Procura a tarefa pelo ID
    const task = tasks.find(t => t.id === id);
    // Inverte o status (se era true vira false, e vice-versa)
    if (task) {
        task.completed = !task.completed;
        // IMPORTANTE: Salva as mudanças
        saveTasks();
        // Atualiza a tela
        renderTasks();
    }
}

// Função que deleta uma tarefa
function deleteTask(id) {
    // Remove a tarefa do array usando filter
    // Filter cria um novo array sem a tarefa que tem esse ID
    tasks = tasks.filter(t => t.id !== id);
    // IMPORTANTE: Salva as mudanças
    saveTasks();
    // Atualiza a tela
    renderTasks();
}

// Função que mostra todas as tarefas na tela
function renderTasks() {
    // Pega o elemento da lista
    const taskList = document.getElementById('taskList');

    // Se não tem tarefas, mostra mensagem
    if (tasks.length === 0) {
        taskList.innerHTML = '<div class="empty-message">Nenhuma tarefa cadastrada. Adicione uma!</div>';
        return;
    }

    // Limpa a lista atual
    taskList.innerHTML = '';

    // Para cada tarefa no array, cria um elemento na tela
    tasks.forEach(task => {
        // Cria um elemento <li> (item de lista)
        const li = document.createElement('li');
        // Adiciona a classe 'task-item'
        li.className = 'task-item';
        // Se a tarefa está concluída, adiciona a classe 'completed'
        if (task.completed) {
            li.classList.add('completed');
        }

        // Monta o HTML interno do item
        li.innerHTML = `
            <input
                type="checkbox"
                class="task-checkbox"
                ${task.completed ? 'checked' : ''}
                onchange="toggleTask(${task.id})">
            <span class="task-text">${task.text}</span>
            <button class="btn-delete" onclick="deleteTask(${task.id})">🗑️</button>
        `;

        // Adiciona o item na lista
        taskList.appendChild(li);
    });
}

// Função que permite adicionar tarefa apertando Enter
function handleKeyPress(event) {
    // Se a tecla apertada foi Enter
    if (event.key === 'Enter') {
        addTask();
    }
}

// Quando a página carregar:
// 1. Carrega as tarefas salvas
loadTasks();
// 2. Mostra as tarefas na tela
renderTasks();