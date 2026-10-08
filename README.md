# Projeto de Comparação de Algoritmos de Ordenação em Java

Este projeto executa e compara três métodos de ordenação (**Bubble Sort**, **Seleção Direta** e **Inserção Direta**) em três cenários de vetores com 1.000 elementos inteiros: **Aleatório**, **Ordenado** e **Invertido**.

Para cada combinação método × cenário, o programa mede o **tempo de execução**, o **número de comparações** e o **número de trocas**.

---

## 📁 Estrutura do Repositório

Todo o código-fonte fica dentro da pasta `src/`:

```text
.
└── src/
    ├── IntercalaFilas.java
    ├── NomeInverter.java
    ├── OrdenacaoTestes.java
    ├── Pilha.java
    └── ProvaEstudo.java
    └── TesteOrdenacao.java
```

---

### 1. 🔄 NomeInverter
* **Descrição:** Aplicação focada na manipulação e inversão de nomes/strings.
* **Objetivo:** Exercitar o manuseio de arrays de caracteres, ponteiros e algoritmos simples de inversão lógica.

**Comentários:**
* A inversão é feita **no próprio vetor**, sem criar uma segunda estrutura: complexidade de tempo **O(n)** e de espaço **O(1)** (além do vetor de char).
* O laço roda apenas `n / 2` vezes, pois cada iteração já posiciona dois caracteres.

---

### 2. 📊 OrdenacaoTestes
* **Descrição:** Módulo dedicado ao teste e comparação de desempenho de algoritmos de ordenação (Bubble Sort, Insertion Sort e Selection Sort; o Quick Sort pode ser adicionado seguindo o mesmo padrão).
* **Objetivo:** Analisar a eficiência dos algoritmos através do tempo de execução e contagem de trocas/comparações.

**Comentários:**
* Os três algoritmos são **O(n²)** no pior caso, mas se comportam de forma diferente em cada cenário:
  * **Bubble Sort:** com a flag `trocou`, o vetor **ordenado** termina em uma única passada (≈ n comparações).
  * **Seleção Direta:** faz sempre ≈ n²/2 comparações, **independentemente** da ordem inicial, mas poucas trocas (no máximo n − 1).
  * **Inserção Direta:** é muito rápida no vetor **ordenado** (≈ n comparações) e pior no **invertido**.
* Cada algoritmo trabalha sobre uma **cópia** (`clone()`) do vetor, garantindo comparação justa.
* A semente fixa (`new Random(42)`) torna o cenário aleatório reproduzível. O tempo, porém, varia um pouco entre execuções (JIT, cache, etc.).

---

### 3. 🥞 Pilha
* **Descrição:** Implementação da estrutura de dados linear **Pilha** (*Stack*) seguindo o princípio LIFO (*Last In, First Out*).
* **Funcionalidades:**
  * `push()`: Inserir elemento na pilha.
  * `pop()`: Remover elemento do topo.
  * `top()` / `peek()`: Visualizar o elemento do topo sem remover.
  * Verificação de pilha vazia (`isEmpty`) ou cheia (`isFull`).

**Comentários:**
* `push`, `pop` e `top` são todos **O(1)**.
* O princípio LIFO aparece no `pop()`: o último valor inserido (`30`) é o primeiro a sair.
* Lançar exceção em `push` (cheia) e `pop`/`top` (vazia) evita acessos inválidos ao vetor. Com `isFull()` e `isEmpty()`, quem usa a pilha pode checar antes de operar.

---

### 4. 🧪 TesteOrdenacao
* **Descrição:** Programa de testes e validação para garantir a integridade dos dados ordenados.
* **Objetivo:** Executar casos de teste simples e extremos (vetores já ordenados, ordem inversa, valores duplicados) para verificar a consistência das rotinas de ordenação.

**Comentários:**
* Os algoritmos são reaproveitados de `OrdenacaoTestes`, por isso os dois arquivos precisam estar na mesma pasta (`src/`).
* Para ser considerado correto, o resultado precisa passar em **duas** verificações: estar em ordem crescente **e** ser igual ao gabarito (`Arrays.sort`). Só checar a ordem não detectaria um algoritmo que perdesse ou repetisse valores.
* Os casos de borda (vetor vazio, um elemento, todos iguais, duplicados) são onde implementações de ordenação costumam falhar.
* Saída esperada: todas as linhas com `[OK]`.

---

---
### 5. 📚 ProvaEstudo
* Descrição: Programa focado na preparação para provas, reunindo os quatro principais algoritmos de ordenação (Bubble, Selection, Insertion e Quicksort) em um único arquivo executável.

* Objetivo: Servir como material de estudo estruturado (folha de consulta), medindo o tempo de execução (em milissegundos) de cada algoritmo com um volume maior de dados aleatórios.

## 📝 Resumo da complexidade

| Algoritmo        | Melhor caso | Caso médio | Pior caso | Estável |
|------------------|:-----------:|:----------:|:---------:|:-------:|
| Bubble Sort      | O(n)        | O(n²)      | O(n²)     | Sim     |
| Seleção Direta   | O(n²)       | O(n²)      | O(n²)     | Não     |
| Inserção Direta  | O(n)        | O(n²)      | O(n²)     | Sim     |
