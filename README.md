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
    ├── Josephus.java
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
### 5. 📚 ProvaEstudo
* Descrição: Programa focado na preparação para provas, reunindo os quatro principais algoritmos de ordenação (Bubble, Selection, Insertion e Quicksort) em um único arquivo executável.

* Objetivo: Servir como material de estudo estruturado (folha de consulta), medindo o tempo de execução (em milissegundos) de cada algoritmo com um volume maior de dados aleatórios.

---

### 6. 🔁 Josephus
* **Descrição:** Trabalho de Estrutura de Dados do **3º semestre — Parte 2** (conteúdo de Alocação Dinâmica de Memória e Listas). Resolve o **problema de Josephus** de duas maneiras, com **lista encadeada circular** e com **vetor**, e discute as vantagens e desvantagens de cada uma.
* **O problema:** forma-se um círculo de **N** pessoas numeradas de 1 a N. Percorrendo a roda a partir da pessoa 1, elimina-se **cada M-ésima pessoa** até restar apenas uma. O programa devolve o número da pessoa que sobrou.
* **Arquivo:** `src/Josephus.java` (um único programa, com todos os métodos implementados como funções).

**O que foi feito:**
* `josephusLista(n, m)`: monta a roda como lista circular (o último nó aponta para o primeiro). Um ponteiro `anterior` fica sempre um nó antes de quem vai ser contado. A cada rodada ele anda M−1 nós e a pessoa seguinte é eliminada religando o ponteiro.
* `josephusVetor(n, m)`: guarda as pessoas em um vetor e calcula quem sai por `(posicao + M - 1) % restantes`. Para eliminar, os elementos à direita são deslocados uma casa para a esquerda.
* `sortearN()`: sorteia a quantidade de pessoas (N), de 1 a 500, com `Random`.
* `main`: o usuário escolhe **digitar** N ou **sortear** N e informa o M. O programa resolve pelos dois métodos, mostra a pessoa que sobrou em cada um e confere se os resultados **concordam**.
* **Validações:** N e M precisam ser maiores que zero (`IllegalArgumentException` nas funções). A leitura trata letras, decimais, zero, negativos e fim da entrada.

**Como executar:**
```text
javac src/Josephus.java
java -cp src Josephus
```

**Exemplo (N = 7 e M = 3):**
```text
Lista encadeada: sobrou a pessoa 4
Vetor: sobrou a pessoa 4
Os dois metodos concordam: SIM
```
As pessoas são eliminadas na ordem 3, 6, 2, 7, 5, 1 e sobra a pessoa 4.

**Sobre o vetor:**
* `restantes` diz quantas pessoas ainda estão na roda (só as posições de 0 a `restantes - 1` valem) e `posicao` é o ponto de onde a contagem continua.
* O `% restantes` faz a contagem voltar ao começo ao passar do fim. Por isso o vetor encontra a M-ésima pessoa em **O(1)**.
* Como não dá para "apagar" uma posição do meio, os elementos à direita são deslocados uma casa para a esquerda: **O(N)** por eliminação e **O(N²)** no total.
* Se a pessoa eliminada era a última da roda, a próxima contagem recomeça na posição 0.
* O vetor é alocado uma única vez, com N posições contíguas, e nada é alocado durante a simulação.

**Complexidade:**

| | Lista encadeada | Vetor |
|---|---|---|
| Achar a M-ésima pessoa | percorre até M−1 nós | O(1) |
| Eliminar a pessoa | O(1) | O(N) |
| **Custo total** | **O(N · M)**, no pior caso O(N²) | **O(N²)** |

**Vantagens e desvantagens:**
* **Lista encadeada circular**
  * **Vantagens:**
    * Eliminar uma pessoa é só religar um ponteiro, sem mover dados.
    * O último nó apontando para o primeiro já representa o círculo do problema.
    * Com M pequeno, cada eliminação percorre poucos nós.
    * Em Java, o nó eliminado é liberado pelo coletor de lixo (o que em C seria feito com `free()`).
  * **Desvantagens:**
    * Não há acesso direto: é preciso andar M−1 nós a cada eliminação.
    * Cada nó guarda o dado e uma referência (em torno de 24 bytes por pessoa numa JVM típica, contra 4 bytes no vetor) e fica espalhado na memória.
    * A vantagem de crescer e diminuir sob demanda quase não é usada, porque N é conhecido desde o início.
* **Vetor**
  * **Vantagens:**
    * Acesso direto pelo índice, sem percorrer nada.
    * Código mais curto e mais simples.
    * Memória contígua: deslocar elementos é rápido na prática.
  * **Desvantagens:**
    * Remover do meio exige deslocar os elementos seguintes (O(N²) no total).
    * O tamanho é fixo: o vetor não encolhe, só a variável `restantes` diminui.
    * Exige o `%` e o ajuste da posição quando se elimina o último elemento.

**Conclusão:**
* Com **M pequeno e N grande**, a lista é bem melhor: o custo cresce com N · M, contra N² do vetor. Com N = 100.000 e M = 3, a lista percorre cerca de 200 mil nós e o vetor desloca cerca de 3 bilhões de elementos.
* Com **M grande** (da ordem de N ou maior), as contagens ficam parecidas e o vetor costuma empatar ou até ganhar, porque deslocar elementos contíguos custa menos do que seguir ponteiros espalhados na memória.
* Com **N pequeno** (como no sorteio de 1 a 500), a diferença é desprezível e o vetor vence pela simplicidade.

**Testes realizados:** os resultados das duas funções foram comparados com uma simulação direta e com a recorrência de Josephus (J(1) = 0 e J(i) = (J(i−1) + M) mod i, resposta J(N) + 1). Foram testados valores clássicos (N = 7 e M = 3 → 4; N = 41 e M = 3 → 31), todas as combinações de N = 1..60 com M = 1..60 (3.600 casos), bordas (N = 1, M = 1, M = N, M = 2.147.483.647), 400 pares aleatórios, N até 100.000, parâmetros inválidos e 200.000 sorteios de N (todos entre 1 e 500). Todos passaram.

## 📝 Resumo da complexidade

| Algoritmo        | Melhor caso | Caso médio | Pior caso | Estável |
|------------------|:-----------:|:----------:|:---------:|:-------:|
| Bubble Sort      | O(n)        | O(n²)      | O(n²)     | Sim     |
| Seleção Direta   | O(n²)       | O(n²)      | O(n²)     | Não     |
| Inserção Direta  | O(n)        | O(n²)      | O(n²)     | Sim     |
