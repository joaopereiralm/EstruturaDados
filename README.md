# Projeto de Comparação de Algoritmos de Ordenação em Java

Este projeto executa e compara três métodos de ordenação (**Bubble Sort**, **Seleção Direta** e **Inserção Direta**) em três cenários de vetores com 1.000 elementos inteiros: **Aleatório**, **Ordenado** e **Invertido**.

### 1. 🔄 NomeInverter
* **Descrição:** Aplicação focada na manipulação e inversão de nomes/strings.
* **Objetivo:** Exercitar o manuseio de arrays de caracteres, ponteiros e algoritmos simples de inversão lógica.

### 2. 📊 OrdenacaoTestes
* **Descrição:** Módulo dedicado ao teste e comparação de desempenho de algoritmos de ordenação (ex.: Bubble Sort, Insertion Sort, Selection Sort, Quick Sort).
* **Objetivo:** Analisar a eficiência dos algoritmos através do tempo de execução e contagem de trocas/comparações.

### 3. 🥞 Pilha
* **Descrição:** Implementação da estrutura de dados linear **Pilha** (*Stack*) seguindo o princípio LIFO (*Last In, First Out*).
* **Funcionalidades:**
  * `push()`: Inserir elemento na pilha.
  * `pop()`: Remover elemento do topo.
  * `top()` / `peek()`: Visualizar o elemento do topo sem remover.
  * Verificação de pilha vazia (`isEmpty`) ou cheia (`isFull`).

### 4. 🧪 TesteOrdenacao
* **Descrição:** Programa de testes e validação para garantir a integridade dos dados ordenados.
* **Objetivo:** Executar casos de teste simples e extremos (vetores já ordenados, ordem inversa, valores duplicados) para verificar a consistência das rotinas de ordenação.

---

## 📁 Estrutura do Repositório

O projeto possui todo o código-fonte localizado dentro da pasta `src/`:

```text
.
└── src/
    └── NomeInverter.java
        OrdenacaoTestes.java
        Pilha.java
        TesteOrdenacao.java
