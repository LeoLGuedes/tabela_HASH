# Tabelas Hash - Relatório de Performance
Este projeto analisa o desempenho de diferentes implementações de tabelas hash, explorando como o tamanho da tabela (**T**) e a quantidade de dados (**D**) afetam o número de colisões e o tempo de inserção.

## 🧪 Como Executar (Caso queira)

Para compilar e executar o projeto:

```bash
mvn native:compile exec:java
```

## 🧩 Parâmetros Importantes

* **T** – Tamanho da tabela hash.
* **D** – Quantidade total de dados inseridos.
* **H** – Função hash (*mod*, *mult*, *fold*).
* **EncadeadaCheatada** – Insere no final da lista sem a percorrer, mas contabiliza colisões.

## 🛠️ Implementações Testadas

* **Hash com Rehashing**: Reaplica função hash em caso de colisão e duplica o tamanho quando cheia.
* **Hash Encadeada**: Lista encadeada em cada posição da tabela.
* **Hash Encadeada Cheatada**: Versão otimizada que insere direto no fim.
* **Hash com Árvore Binária**: Cada posição é uma árvore balanceada.

## 📊 Comparando os Resultados


Maquina que foi usada para os testes:

```
$ neofetch
                                ..,   Nina@DESKTOP-7FHLKK2
                    ....,,:;+ccllll   --------------------
      ...,,+:;  cllllllllllllllllll   OS: Windows 10 Home Single Language x86_6
,cclllllllllll  lllllllllllllllllll   Host: Gigabyte Technology Co., Ltd. A320M
llllllllllllll  lllllllllllllllllll   Kernel: 10.0.19045
llllllllllllll  lllllllllllllllllll   Uptime: 16 hours, 27 mins
llllllllllllll  lllllllllllllllllll   Packages: 2 (scoop)
llllllllllllll  lllllllllllllllllll   Shell: bash 5.2.37
llllllllllllll  lllllllllllllllllll   Resolution: 1920x1080
                                      DE: Aero
llllllllllllll  lllllllllllllllllll   Terminal: mintty
llllllllllllll  lllllllllllllllllll   CPU: AMD Ryzen 5 1600 (12) @ 3.200GHz
llllllllllllll  lllllllllllllllllll   GPU: Caption
llllllllllllll  lllllllllllllllllll   GPU: NVIDIA GeForce GTX 1070 Ti
llllllllllllll  lllllllllllllllllll   GPU
`'ccllllllllll  lllllllllllllllllll   Memory: 6520MiB / 8140MiB
       `' \*::  :ccllllllllllllllll
                       ````''*::cll
                                 ``
```

A seguir, gráficos organizados para comparação direta entre as implementações **com o mesmo T e D**.

### Para T1_000 e D100_000

> asdasdasd
> sadasddsa
> asddsasd
> afsafsf
> fsafsafs
> saffsafas
> saffsafas
> fsafsafas

![TabelaHashRehashing\_T1000\_D100000\_Hmod.png](graphs/TabelaHashRehashing_T1000_D100000_Hmod.png)
![TabelaHashEncadeada\_T1000\_D100000\_Hmod.png](graphs/TabelaHashEncadeada_T1000_D100000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T1000\_D100000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T1000_D100000_Hmod.png)
![TabelaHashArvoreBinaria\_T1000\_D100000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T1000_D100000_Hmod.png)

### Para T1_000 e D1_000_000

![TabelaHashRehashing\_T1000\_D1000000\_Hmod.png](graphs/TabelaHashRehashing_T1000_D1000000_Hmod.png)
![TabelaHashEncadeada\_T1000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeada_T1000_D1000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T1000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T1000_D1000000_Hmod.png)
![TabelaHashArvoreBinaria\_T1000\_D1000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T1000_D1000000_Hmod.png)

### Para T1_000 e D10_000_000

![TabelaHashRehashing\_T1000\_D10000000\_Hmod.png](graphs/TabelaHashRehashing_T1000_D10000000_Hmod.png)
![TabelaHashEncadeada\_T1000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeada_T1000_D10000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T1000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T1000_D10000000_Hmod.png)
![TabelaHashArvoreBinaria\_T1000\_D10000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T1000_D10000000_Hmod.png)

### Para T10_000 e D100_000

![TabelaHashRehashing\_T10000\_D100000\_Hmod.png](graphs/TabelaHashRehashing_T10000_D100000_Hmod.png)
![TabelaHashEncadeada\_T10000\_D100000\_Hmod.png](graphs/TabelaHashEncadeada_T10000_D100000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T10000\_D100000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T10000_D100000_Hmod.png)
![TabelaHashArvoreBinaria\_T10000\_D100000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T10000_D100000_Hmod.png)

### Para T10_000 e D1_000_000

![TabelaHashRehashing\_T10000\_D1000000\_Hmod.png](graphs/TabelaHashRehashing_T10000_D1000000_Hmod.png)
![TabelaHashEncadeada\_T10000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeada_T10000_D1000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T10000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T10000_D1000000_Hmod.png)
![TabelaHashArvoreBinaria\_T10000\_D1000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T10000_D1000000_Hmod.png)

### Para T10_000 e D10_000_000

![TabelaHashRehashing\_T10000\_D10000000\_Hmod.png](graphs/TabelaHashRehashing_T10000_D10000000_Hmod.png)
![TabelaHashEncadeada\_T10000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeada_T10000_D10000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T10000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T10000_D10000000_Hmod.png)
![TabelaHashArvoreBinaria\_T10000\_D10000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T10000_D10000000_Hmod.png)

### Para T100_000 e D100_000

![TabelaHashRehashing\_T100000\_D100000\_Hmod.png](graphs/TabelaHashRehashing_T100000_D100000_Hmod.png)
![TabelaHashEncadeada\_T100000\_D100000\_Hmod.png](graphs/TabelaHashEncadeada_T100000_D100000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T100000\_D100000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T100000_D100000_Hmod.png)
![TabelaHashArvoreBinaria\_T100000\_D100000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T100000_D100000_Hmod.png)

### Para T100_000 e D1_000_000

![TabelaHashRehashing\_T100000\_D1000000\_Hmod.png](graphs/TabelaHashRehashing_T100000_D1000000_Hmod.png)
![TabelaHashEncadeada\_T100000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeada_T100000_D1000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T100000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T100000_D1000000_Hmod.png)
![TabelaHashArvoreBinaria\_T100000\_D1000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T100000_D1000000_Hmod.png)

### Para T100_000 e D10_000_000

![TabelaHashRehashing\_T100000\_D10000000\_Hmod.png](graphs/TabelaHashRehashing_T100000_D10000000_Hmod.png)
![TabelaHashEncadeada\_T100000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeada_T100000_D10000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T100000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T100000_D10000000_Hmod.png)
![TabelaHashArvoreBinaria\_T100000\_D10000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T100000_D10000000_Hmod.png)


### Coisas a fazer:
2. Escolha três variações da função hash, por exemplo: resto da divisão, multiplicação. (pesquisar e escolher a que achar melhor) (para rehashing sugere-se hash duplo e hash linear/quadrático por exemplo).
3. Encontre as 3 maiores listas encadeadas geradas.
4. Encontre as 3 maiores arvores binarias geradas.
5. Encontre os o menor gap o maior e a média de gap entre elementos no vetor.( gap = espaço )
