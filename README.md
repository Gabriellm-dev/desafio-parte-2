# Projeto de Algoritmos de Caminho Mínimo e Árvore Geradora Mínima

Este projeto implementa e avalia três algoritmos fundamentais de grafos: **Dijkstra**, **Kruskal** e **Prim**, com o objetivo de calcular o caminho mínimo (CM) e a árvore geradora mínima (AGM) em grafos representados por redes de estradas. O projeto utiliza arquivos de instância do site **USA-road-d**, com redes de estradas dos EUA.

## Funcionalidades

- **Dijkstra**: Calcula o caminho mínimo a partir de um vértice de origem para todos os outros vértices.
- **Kruskal**: Calcula a árvore geradora mínima utilizando o algoritmo de Kruskal.
- **Prim**: Calcula a árvore geradora mínima utilizando o algoritmo de Prim.
  
Os resultados das execuções de cada algoritmo (Custo e Tempo) são apresentados em uma tabela com a seguinte estrutura:

| Grafo               | Vértices | Arestas | Custo_CM | Tempo_CM | Custo_AGM | Tempo_AGM | Custo_FM | Tempo_FM |
|---------------------|----------|---------|----------|----------|-----------|-----------|----------|----------|
| Nome do Grafo       | Número de vértices | Número de arestas | Custo do Caminho Mínimo | Tempo do Caminho Mínimo | Custo da Árvore Geradora Mínima (Kruskal) | Tempo da Árvore Geradora Mínima (Kruskal) | Custo da Árvore Geradora Mínima (Prim) | Tempo da Árvore Geradora Mínima (Prim) |

## Pré-requisitos

Certifique-se de ter o **Java** instalado em sua máquina. Você pode baixar a versão mais recente do Java [aqui](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

Além disso, será necessário ter os seguintes arquivos de instância do grafo disponíveis para serem carregados:

- **USA-road-d.NY.gr**
- **USA-road-d.COL.gr**
- **USA-road-d.BAY.gr**

Esses arquivos podem ser baixados do site do [Desafio de Grafos](http://www.dis.uniroma1.it/challenge9/download.shtml), especificamente da seção de **redes de distância**.

## Como Rodar o Projeto

1. Clone o repositório ou baixe os arquivos do projeto.
2. Certifique-se de que os arquivos de instância do grafo estão localizados no diretório correto.
3. Compile o projeto com o comando:
   ```bash
   javac Main.java
   ```
4. Execute o programa com:
   ```bash
   java Main
   ```

Durante a execução, o programa exibirá a tabela com os resultados de cada grafo, calculando o custo e o tempo de execução dos algoritmos de Dijkstra, Kruskal e Prim.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

- **Main.java**: Classe principal, onde os arquivos de instância são carregados e os algoritmos são executados. Exibe os resultados em formato tabular.
- **Graph.java**: Contém a representação do grafo e métodos para carregar o grafo a partir de arquivos.
- **Dijkstra.java**: Implementação do algoritmo de Dijkstra para calcular o caminho mínimo.
- **Kruskal.java**: Implementação do algoritmo de Kruskal para calcular a árvore geradora mínima.
- **Prim.java**: Implementação do algoritmo de Prim para calcular a árvore geradora mínima.

## Exemplo de Execução

Após a execução do programa, a saída será semelhante a:

```
Carregando grafo do arquivo: /home/user/USA-road-d.NY.gr
| Grafo              | Vértices  | Arestas   | Custo_CM    | Tempo_CM    | Custo_AGM   | Tempo_AGM   | Custo_FM    | Tempo_FM    |
|--------------------|-----------|-----------|-------------|-------------|-------------|-------------|-------------|-------------|
| USA-road-d.NY.gr   | 264346    | 733846    | 2003049150  | 0.1145      | 261159288   | 0.7629      | 261159288   | 0.2730      |
Carregando grafo do arquivo: /home/user/USA-road-d.COL.gr
| USA-road-d.COL.gr  | 435666    | 1057066   | 1070107496  | 0.1185      | 1323900090  | 0.7501      | 1323900090  | 0.2727      |
Carregando grafo do arquivo: /home/user/USA-road-d.BAY.gr
| USA-road-d.BAY.gr  | 321270    | 800172    | -723308362  | 0.0973      | 435798417   | 0.4559      | 435798417   | 0.2646      |
|--------------------|-----------|-----------|-------------|-------------|-------------|-------------|-------------|-------------|
```

## Conclusão

Este projeto fornece uma implementação eficiente dos algoritmos de **Caminho Mínimo** e **Árvore Geradora Mínima**, utilizando instâncias reais de grafos de redes de estradas. Ele calcula e exibe os custos e os tempos de execução de cada algoritmo, proporcionando uma comparação clara entre os métodos.

--