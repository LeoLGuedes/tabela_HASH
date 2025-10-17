# Tabelas Hash - Relatório de Performance

Este projeto analisa o desempenho de diferentes implementações de tabelas hash, explorando como o tamanho da tabela (**T
**) e a quantidade de dados (**D**) afetam o número de colisões e o tempo de inserção.

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

## 📊 Resultados

### [GoogleDrive com todos os CVS do resultado](https://drive.google.com/drive/folders/1NEXZyDGQvuuR-P9y6GpbJfn5vmW5pshe?usp=drive_link)

### [Graficos](https://leolguedes.github.io/tabela_HASH/)

## 📊 Comparando os Resultados

Maquina que foi usada para os testes:

```
                                ..,   Nina@DESKTOP-7FHLKK2
                    ....,,:;+ccllll   --------------------
      ...,,+:;  cllllllllllllllllll   OS: Windows 10 Home Single Language x86_6
,cclllllllllll  lllllllllllllllllll   Host: Gigabyte Technology Co., Ltd. A320M
llllllllllllll  lllllllllllllllllll   Kernel: 10.0.19045
llllllllllllll  lllllllllllllllllll   Uptime: 19 hours, 19 mins
llllllllllllll  lllllllllllllllllll   Packages: 2 (scoop)
llllllllllllll  lllllllllllllllllll   Shell: bash 5.2.37
llllllllllllll  lllllllllllllllllll   Resolution: 1920x1080
                                      DE: Aero
llllllllllllll  lllllllllllllllllll   Terminal: mintty
llllllllllllll  lllllllllllllllllll   CPU: AMD Ryzen 5 1600 (12) @ 3.200GHz
llllllllllllll  lllllllllllllllllll   GPU: Caption
llllllllllllll  lllllllllllllllllll   GPU: NVIDIA GeForce GTX 1070 Ti
llllllllllllll  lllllllllllllllllll   GPU
`'ccllllllllll  lllllllllllllllllll   Memory: 5913MiB / 8140MiB
       `' \*::  :ccllllllllllllllll
                       ````''*::cll
                                 ``
```

A seguir, gráficos organizados para comparação direta entre as implementações **com o mesmo T e D**.

### 1) Para T1_000 e D100_000

#### **Ranking de Desempenho (velocidade):**

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 37735700       | TabelaHashEncadeadaCheatada |
| `2º`    | 60903600       | TabelaHashRehashing         |
| `3º`    | 121663700      | TabelaHashArvoreBinaria     |
| `4º`    | 278858300      | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 48571800       | TabelaHashRehashing         |
| `2º`    | 71864900       | TabelaHashArvoreBinaria     |
| `3º`    | 89474800       | TabelaHashEncadeadaCheatada |
| `4º`    | 99568400       | TabelaHashEncadeada         |

![TabelaHashRehashing\_T1000\_D100000\_Hmod.png](graphs/TabelaHashRehashing_T1000_D100000_Hmod.png)
![TabelaHashEncadeada\_T1000\_D100000\_Hmod.png](graphs/TabelaHashEncadeada_T1000_D100000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T1000\_D100000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T1000_D100000_Hmod.png)
![TabelaHashArvoreBinaria\_T1000\_D100000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T1000_D100000_Hmod.png)

### 2) Para T1_000 e D1_000_000

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 332559500      | TabelaHashEncadeadaCheatada |
| `2º`    | 423969100      | TabelaHashRehashing         |
| `3º`    | 1298854400     | TabelaHashArvoreBinaria     |
| `4º`    | 7245535000     | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 240216000      | TabelaHashRehashing         |
| `2º`    | 1115885500     | TabelaHashArvoreBinaria     |
| `3º`    | 6164962500     | TabelaHashEncadeada         |
| `4º`    | 6716189800     | TabelaHashEncadeadaCheatada |

![TabelaHashRehashing\_T1000\_D1000000\_Hmod.png](graphs/TabelaHashRehashing_T1000_D1000000_Hmod.png)
![TabelaHashEncadeada\_T1000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeada_T1000_D1000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T1000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T1000_D1000000_Hmod.png)
![TabelaHashArvoreBinaria\_T1000\_D1000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T1000_D1000000_Hmod.png)

### 3) Para T1_000 e D10_000_000

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 3565396800     | TabelaHashEncadeadaCheatada |
| `2º`    | 4569789500     | TabelaHashRehashing         |
| `3º`    | 21163745800    | TabelaHashArvoreBinaria     |
| `4º`    | 309057937400   | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 3467574000     | TabelaHashRehashing         |
| `2º`    | 19748678300    | TabelaHashArvoreBinaria     |
| `3º`    | 624027441900   | TabelaHashEncadeada         |
| `4º`    | 639709962200   | TabelaHashEncadeadaCheatada |

![TabelaHashRehashing\_T1000\_D10000000\_Hmod.png](graphs/TabelaHashRehashing_T1000_D10000000_Hmod.png)
![TabelaHashEncadeada\_T1000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeada_T1000_D10000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T1000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T1000_D10000000_Hmod.png)
![TabelaHashArvoreBinaria\_T1000\_D10000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T1000_D10000000_Hmod.png)

### 4) Para T10_000 e D100_000

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 29564100       | TabelaHashRehashing         |
| `2º`    | 41955900       | TabelaHashEncadeadaCheatada |
| `3º`    | 77526600       | TabelaHashArvoreBinaria     |
| `4º`    | 89870400       | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 24357700       | TabelaHashRehashing         |
| `2º`    | 37870100       | TabelaHashEncadeada         |
| `3º`    | 39826400       | TabelaHashEncadeadaCheatada |
| `4º`    | 43487200       | TabelaHashArvoreBinaria     |

![TabelaHashRehashing\_T10000\_D100000\_Hmod.png](graphs/TabelaHashRehashing_T10000_D100000_Hmod.png)
![TabelaHashEncadeada\_T10000\_D100000\_Hmod.png](graphs/TabelaHashEncadeada_T10000_D100000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T10000\_D100000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T10000_D100000_Hmod.png)
![TabelaHashArvoreBinaria\_T10000\_D100000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T10000_D100000_Hmod.png)

### 5) Para T10_000 e D1_000_000

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 374757600      | TabelaHashRehashing         |
| `2º`    | 460860600      | TabelaHashEncadeadaCheatada |
| `3º`    | 1149050600     | TabelaHashArvoreBinaria     |
| `4º`    | 2659001100     | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 225537300      | TabelaHashRehashing         |
| `2º`    | 841576000      | TabelaHashArvoreBinaria     |
| `3º`    | 1150572200     | TabelaHashEncadeada         |
| `4º`    | 1160965000     | TabelaHashEncadeadaCheatada |

![TabelaHashRehashing\_T10000\_D1000000\_Hmod.png](graphs/TabelaHashRehashing_T10000_D1000000_Hmod.png)
![TabelaHashEncadeada\_T10000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeada_T10000_D1000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T10000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T10000_D1000000_Hmod.png)
![TabelaHashArvoreBinaria\_T10000\_D1000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T10000_D1000000_Hmod.png)

### 6) Para T10_000 e D10_000_000

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 4401351800     | TabelaHashRehashing         |
| `2º`    | 4476799800     | TabelaHashEncadeadaCheatada |
| `3º`    | 18250444500    | TabelaHashArvoreBinaria     |
| `4º`    | 66977892500    | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 3121672500     | TabelaHashRehashing         |
| `2º`    | 17292915800    | TabelaHashArvoreBinaria     |
| `3º`    | 97455806700    | TabelaHashEncadeada         |
| `4º`    | 110350838600   | TabelaHashEncadeadaCheatada |

![TabelaHashRehashing\_T10000\_D10000000\_Hmod.png](graphs/TabelaHashRehashing_T10000_D10000000_Hmod.png)
![TabelaHashEncadeada\_T10000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeada_T10000_D10000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T10000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T10000_D10000000_Hmod.png)
![TabelaHashArvoreBinaria\_T10000\_D10000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T10000_D10000000_Hmod.png)

### 7) Para T100_000 e D100_000

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 28516100       | TabelaHashRehashing         |
| `2º`    | 36193700       | TabelaHashEncadeadaCheatada |
| `3º`    | 40034200       | TabelaHashArvoreBinaria     |
| `4º`    | 40409300       | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 21359700       | TabelaHashRehashing         |
| `2º`    | 31773600       | TabelaHashEncadeada         |
| `3º`    | 32689100       | TabelaHashEncadeadaCheatada |
| `4º`    | 34549600       | TabelaHashArvoreBinaria     |

![TabelaHashRehashing\_T100000\_D100000\_Hmod.png](graphs/TabelaHashRehashing_T100000_D100000_Hmod.png)
![TabelaHashEncadeada\_T100000\_D100000\_Hmod.png](graphs/TabelaHashEncadeada_T100000_D100000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T100000\_D100000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T100000_D100000_Hmod.png)
![TabelaHashArvoreBinaria\_T100000\_D100000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T100000_D100000_Hmod.png)

### 8) Para T100_000 e D1_000_000

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 332749800      | TabelaHashRehashing         |
| `2º`    | 498991800      | TabelaHashEncadeadaCheatada |
| `3º`    | 726373800      | TabelaHashArvoreBinaria     |
| `4º`    | 733422900      | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 270722500      | TabelaHashRehashing         |
| `2º`    | 522854900      | TabelaHashEncadeada         |
| `3º`    | 537540600      | TabelaHashEncadeadaCheatada |
| `4º`    | 658217000      | TabelaHashArvoreBinaria     |

![TabelaHashRehashing\_T100000\_D1000000\_Hmod.png](graphs/TabelaHashRehashing_T100000_D1000000_Hmod.png)
![TabelaHashEncadeada\_T100000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeada_T100000_D1000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T100000\_D1000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T100000_D1000000_Hmod.png)
![TabelaHashArvoreBinaria\_T100000\_D1000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T100000_D1000000_Hmod.png)

### 9) Para T100_000 e D10_000_000

#### Inserção

| Posição | Velocidade(ns) | TabelaHash                  |
|---------|----------------|-----------------------------|
| `1º`    | 5354665100     | TabelaHashEncadeadaCheatada |
| `2º`    | 5472532400     | TabelaHashRehashing         |
| `3º`    | 15972125600    | TabelaHashArvoreBinaria     |
| `4º`    | 23665890400    | TabelaHashEncadeada         |

#### Busca:

| Posição | Velocidade(ns)   | TabelaHash                  |
|---------|------------------|-----------------------------|
| `1º`    | 15006378500      | TabelaHashArvoreBinaria     |
| `2º`    | 29527278200      | TabelaHashEncadeada         |
| `3º`    | 37155150100      | TabelaHashEncadeadaCheatada |
| `4º`    | 0(erro, nao sei) | TabelaHashRehashing         |

![TabelaHashRehashing\_T100000\_D10000000\_Hmod.png](graphs/TabelaHashRehashing_T100000_D10000000_Hmod.png)
![TabelaHashEncadeada\_T100000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeada_T100000_D10000000_Hmod.png)
![TabelaHashEncadeadaCheatada\_T100000\_D10000000\_Hmod.png](graphs/TabelaHashEncadeadaCheatada_T100000_D10000000_Hmod.png)
![TabelaHashArvoreBinaria\_T100000\_D10000000\_Hmod.png](graphs/TabelaHashArvoreBinaria_T100000_D10000000_Hmod.png)

### Coisas a fazer:

2. Escolha três variações da função hash, por exemplo: resto da divisão, multiplicação. (pesquisar e escolher a que
   achar melhor) (para rehashing sugere-se hash duplo e hash linear/quadrático por exemplo).
3. Encontre as 3 maiores listas encadeadas geradas.
4. Encontre as 3 maiores arvores binarias geradas.
5. Encontre os o menor gap o maior e a média de gap entre elementos no vetor.( gap = espaço )
6. Tempo errado, valores em ns nao tao batendo com a realidade, 18hrs rodando e a soma de tempo da 35min