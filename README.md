### Enunciado: Análise de Arquivo de Texto com FileReader e BufferedReader

**Objetivo:**

Desenvolver um programa em Java que leia um arquivo de texto utilizando `FileReader` e `BufferedReader`, e realize a contagem de palavras, linhas e caracteres presentes no arquivo. Além disso, o programa deve identificar e exibir as 5 palavras mais frequentes e suas respectivas frequências.

**Instruções:**

1. **Leitura do Arquivo:**
    - O programa deve solicitar ao usuário o caminho de um arquivo de texto (.txt).
    - Utilize `FileReader` e `BufferedReader` para abrir e ler o conteúdo do arquivo.
2. **Contagem e Análise:**
    - Conte o número total de linhas, palavras e caracteres presentes no arquivo.
    - Considera-se como palavra qualquer sequência de caracteres delimitada por espaços em branco ou pontuações.
    - Utilize um `Map<String, Integer>` para armazenar a frequência de cada palavra.
3. **Identificação das Palavras Mais Frequentes:**
    - Após ler o arquivo, identifique as 5 palavras mais frequentes.
    - Exiba essas palavras juntamente com o número de ocorrências de cada uma.
4. **Exibição dos Resultados:**
    - Mostre o número total de linhas, palavras e caracteres no arquivo.
    - Exiba as 5 palavras mais frequentes e suas respectivas contagens.

**Requisitos Adicionais:**

- Lidar com possíveis exceções, como arquivos não encontrados, erros de leitura, etc.
- Ignorar diferenças entre letras maiúsculas e minúsculas ao contar a frequência das palavras (ou seja, "Java" e "java" devem ser consideradas a mesma palavra).
