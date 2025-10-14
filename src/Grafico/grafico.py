import matplotlib.pyplot as plt
import numpy as np

arquivo_txt = "../../tempoImplementacaoEncadeada.txt"

chaves = []
tempos = []

# Ler o arquivo
with open(arquivo_txt, "r") as f:
    for linha in f:
        linha = linha.strip()
        if not linha:
            continue
        partes = linha.split("-")
        if len(partes) != 2:
            continue
        try:
            chave = int(partes[0].strip())
            tempo = int(partes[1].strip())
        except ValueError:
            continue
        chaves.append(chave)
        tempos.append(tempo)

# Converter listas em arrays numpy
chaves_grafico = np.array(chaves)
tempo_grafico = np.array(tempos)

plt.figure(figsize=(10, 6))

# Scatter plot com pontos maiores e borda preta
plt.scatter(tempo_grafico, chaves_grafico, color="red", edgecolors='black', s=80, alpha=0.7, label="Chaves")

# Ajuste linear
coeficientes = np.polyfit(tempo_grafico, chaves_grafico, 1)
linha_tendencia = np.poly1d(coeficientes)

# Valores para linha de tendência
tempo_fit = np.linspace(min(tempo_grafico), max(tempo_grafico), 100)
chave_fit = linha_tendencia(tempo_fit)

# Plotar linha de tendência com destaque
plt.plot(tempo_fit, chave_fit, color='blue', linewidth=2, label='Linha de Tendência')

# Adicionar equação da linha de tendência no canto superior esquerdo
equacao = f' Media '
plt.text(0.05 * max(tempo_grafico), 0.95 * max(chaves_grafico), equacao, fontsize=12, color='blue')

# Configurações do gráfico
plt.title('Tempo de Implementação vs Chaves', fontsize=16)
plt.xlabel('Tempo (ms)', fontsize=14)
plt.ylabel('Chaves', fontsize=14)
plt.grid(True, linestyle='--', alpha=0.5)
plt.legend()
plt.tight_layout()

# Mostrar gráfico
plt.show()
