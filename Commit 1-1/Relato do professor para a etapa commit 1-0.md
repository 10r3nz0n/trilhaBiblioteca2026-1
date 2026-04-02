# Relato do Commit 1.1

**Origem do registro:** relato estruturado a partir de **gravação em áudio do professor**, convertida por IA para o formato Markdown.

## 1. Contexto da atividade

A aplicação foi criada por meio do **Spring Initializer**, utilizando **Maven**, conforme orientado no arquivo `dicas.zip`.

Após a geração da estrutura inicial do projeto, foi realizado o transporte, em formato de **de-para**, de todos os arquivos `.java` e pacotes para os locais corretos dentro da **estrutura Maven**, respeitando a organização esperada pelo padrão do projeto.

## 2. Ajustes realizados

Durante a adaptação, foram executadas as seguintes ações:

- reorganização dos **pacotes**
- correção da **localização dos arquivos**
- ajuste dos **imports** dos utilitários, conforme as novas pastas da estrutura Maven
- inclusão de um `pom.xml` com algumas dependências necessárias

## 3. Observação importante sobre a inicialização

Embora a estrutura tenha sido criada com Spring Initializer, a compilação não ficou caracterizada, neste momento, como uma execução efetiva de uma aplicação **Spring Boot**.

Na prática, o projeto acabou assumindo a execução da aplicação principal **App**, e não da classe **Spring Boot App** originalmente criada pelo Spring Initializer.

## 4. Problemas encontrados

Durante o processo, alguns problemas apareceram:

### 4.1. Estrutura de pacotes e arquivos
Foi necessário ajustar a organização dos pacotes e reposicionar arquivos para os diretórios corretos da estrutura Maven.

### 4.2. Imports inválidos ou desatualizados
Os imports dos utilitários precisaram ser revistos e atualizados para refletir a nova disposição dos pacotes.

### 4.3. Necessidade frequente de limpeza do projeto
Houve recorrência de problemas que exigiram limpeza da pasta `target`.

Para resolver, foi feito o seguinte procedimento:

```bash
mvn clean compile
```

Antes da compilação, a pasta `target` foi removida manualmente. Depois disso, com o comando acima executado no terminal do VS Code a partir do `pom.xml`, o Maven recompilou todas as classes e gerou novamente a pasta `target`.

## 5. Interpretação da pasta target

A pasta `target`, dentro da estrutura Maven, funciona de forma equivalente à pasta de saída de compilação do projeto, cumprindo papel semelhante ao de uma pasta **bin** em projetos tradicionais.

## 6. Erros de compilação identificados

Ocorreram erros relacionados ao acesso de **métodos estáticos**.

O problema estava no fato de que alguns métodos estáticos estavam sendo acessados por meio de **objetos**, quando o correto era realizar a chamada diretamente pela **classe**.

### Correção aplicada
Foi feita a substituição das chamadas:
- antes: acesso via objeto
- depois: acesso direto via classe

Após essa correção, os erros de compilação foram resolvidos.

## 7. Resultado obtido

Com os ajustes concluídos, a aplicação conseguiu ser executada com sucesso.

A etapa **1.2** ainda não foi iniciada. Portanto, este relato cobre apenas o trabalho realizado até o fechamento da etapa **1.1**.

## 8. Tempo de execução

As adaptações realizadas consumiram aproximadamente:

- **30 a 40 minutos**

## 9. Síntese técnica

Em visão mais ampla, este trabalho consistiu em:

- criar a base do projeto com **Spring Initializer + Maven**
- migrar os arquivos e pacotes para a estrutura correta
- ajustar imports e referências
- limpar e recompilar o projeto com Maven
- corrigir chamadas inadequadas de métodos estáticos
- validar a execução da aplicação após as correções

## 10. Próximos pontos relacionados ao contexto

Tópicos diretamente relacionados a este relato:

- preparação para a etapa **1.2**
