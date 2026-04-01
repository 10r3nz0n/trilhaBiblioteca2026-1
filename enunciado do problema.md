# Trilha de atividade prática da disciplina

Algoritmos e programação OO Java
Professor Lorenzon
2026.1

Código de base autoral, com revisão de IA para suporte de organização de etapas.
Inclusões intencionais de partida: Design Pattern, Exceções (acabou sendo obrigatório ter por persistência) e Persistência nativa binária JAVA.

## Como proceder inicialmente 

Forme um grupo com 2 alunos.

Baixe o arquivo .zip da aplicação indicado pelo professor no material da Minha Uno. Faça a análise sobre ele.

Após concluir a análise, continue com as orientações para implementações.

As etapas do trabalho serão:

1 - Revisão do código atual, com análise de abstração e encapsulamento.
Nesta etapa, o grupo deverá identificar como o sistema foi modelado, onde há boa abstração, onde há encapsulamento fraco e quais pontos precisam ser melhor organizados antes da evolução do projeto.

```text
Etapa com início em 01/04/2026 e término via commit antes de 15/04/2026.
```

2 - Refatoração para camadas, com separação entre aplicação, controller, service, repository e domínio.
Nesta etapa, o foco principal será a organização arquitetural e a separação de responsabilidades, observando especialmente o princípio da responsabilidade única (SRP). O objetivo é reduzir concentração excessiva de comportamentos em poucas classes e tornar o sistema mais claro para manutenção.

```text
Esta etapa e demais etapas serão lançadas em datas pelo professsor em sala de aula.
```

3 - Aplicação de herança, classes abstratas e interfaces.
Nesta etapa, o grupo deverá observar onde a herança realmente faz sentido no domínio, evitando hierarquias artificiais. Também deverá analisar onde classes abstratas e interfaces ajudam a organizar melhor o projeto. Aqui começa a aparecer com mais clareza o princípio aberto para extensão e fechado para modificação (OCP), pois a ideia é permitir evolução do sistema com menos alterações destrutivas no código já existente.

4 - Tratamento de exceções.
Nesta etapa, o grupo deverá reorganizar o tratamento de falhas do sistema, distinguindo melhor erros de entrada, erros técnicos e erros de regra de negócio. O objetivo é melhorar robustez e clareza do fluxo da aplicação, sem misturar tratamento de erro com lógica principal.

5 - Aplicação de polimorfismo e injeção de dependência.
Nesta etapa, o grupo deverá utilizar interfaces e implementações concretas para permitir substituição de comportamentos sem alterar a regra de negócio. Aqui deverão ser observados os princípios de substituição de Liskov (LSP), segregação de interfaces (ISP), quando necessário, e inversão de dependência (DIP). A injeção de dependência será usada como técnica para reduzir acoplamento entre as partes do sistema.

6 - Substituição da persistência.
Nesta etapa, o grupo deverá trocar a persistência atual por outra forma de persistência, mantendo a aplicação funcional. O objetivo é comprovar, na prática, o uso de abstrações, polimorfismo, OCP e DIP, mostrando que a infraestrutura pode ser substituída com impacto reduzido sobre a regra de negócio.

Em todas as etapas, o grupo deverá justificar tecnicamente as decisões tomadas, mostrar a evolução por commits e demonstrar que as mudanças aplicadas melhoraram organização, legibilidade, manutenção e capacidade de evolução do sistema.

Ao longo das etapas, o grupo deverá também observar:

- onde a herança realmente se justifica;
- onde interfaces pequenas e bem definidas fazem mais sentido do que contratos muito amplos;
- como o polimorfismo permite trocar implementações sem alterar a regra de negócio;
- como a arquitetura evolui para reduzir acoplamento e melhorar manutenção.

<div style="page-break-before: always;"></div>

# Etapa 1

Aplicação selecionada: Biblioteca de empréstimos de livros para alunos.

Analise o código da aplicação de biblioteca e responda às questões a seguir com base na implementação existente.
Ao responder, procure justificar usando nomes de classes, atributos, métodos e relações entre objetos observadas no código.
Evite responder apenas com definição teórica. Relacione cada resposta com o que aparece no programa.

```text
Abra o markdown e faça suas repostas, salvando-o com outro nome. Abra um text para responder o item da etapa.
```

As etapas estão relacionadas com estas macro perguntas:

1. Identifique padrões de projeto presentes no código e justifique.
2. Identifique o uso de métodos estáticos e explique por que eles podem ter sido utilizados.
3. Analise onde há abstração no código.
4. Analise onde há encapsulamento no código.
5. Discuta se o encapsulamento observado é forte ou fraco, indicando melhorias possíveis.
6. Avalie a responsabilidade das classes com base na ideia de SRP.
7. Identifique relações de associação, agregação e, se houver, composição.
8. Avalie se os critérios usados nas operações do sistema identificam corretamente os registros de negócio em todos os cenários.
9. Aponte oportunidades de refatoração sem alterar a proposta geral do sistema.
10. Indique como a adição de novos atributos em Livro ou Pessoa impactaria o projeto.

<div style="page-break-before: always;"></div>

## 1 Padrões de projetos

1. Existe algum padrão de projeto explicitamente aplicado no código? Qual?
2. Em que classe esse padrão aparece?
3. Qual problema esse padrão tenta resolver dentro da aplicação?
4. Quais vantagens essa decisão trouxe para o projeto?
5. Para que outras funções este padrão poderia ser útil no projeto?

```text
Responda aqui!
```
<div style="page-break-before: always;"></div>

### 2 Métodos estaticos

1. Quais classes usam métodos estáticos de forma predominante?
2. Cite algum exemplo concretos de método estático encontrado no código. Um exemplo muito pertinente.
3. Por que métodos estáticos podem ter sido escolhidos nessa aplicação?
4. Há caso de uso de método estático que pode estar excessivo?
5. Qual diferença conceitual existe entre um método estático utilitário e um método de instância ligado ao estado do objeto?

```text
Responda aqui!
```
<div style="page-break-before: always;"></div>

### 3 Abstração

1. Quais classes representam conceitos de entidades do domínio do problema?
2. Quais classes representam apoio técnico da aplicação, e não o domínio em si?
3. Há alguma classe que parece representar mais de uma ideia ao mesmo tempo?

```text
Responda aqui!
```
<div style="page-break-before: always;"></div>

### 4 Encapsulamento

1. Onde o encapsulamento está claramente aplicado no código?
2. Quais atributos estão protegidos por modificador `private`?
3. Em quais classes existem getters e setters?
4. O código apresenta exemplos de encapsulamento forte ou apenas parcial? Justifique.
5. Há casos em que o atributo é privado, mas o estado interno continua muito exposto? Onde?
6. Há setters públicos que permitem alterar estado sensível demais do objeto?
7. A classe `BibliotecaDados` protege bem seus dados internos ou apenas os expõe por getters e setters?
8. Que melhorias simples você faria para fortalecer o encapsulamento?

```text
Responda aqui!
```
<div style="page-break-before: always;"></div>

## 5 SRP

1. A classe `App` tem responsabilidade única?
2. A classe `BibliotecaSingleton` tem responsabilidade única?
3. A classe `BibliotecaPersistencia` respeita SRP? Por quê?
4. O método `main` está apenas orquestrando o fluxo ou também concentra regras de negócio?
5. Quais classes estão mais próximas de respeitar SRP?
6. Quais classes parecem concentrar muitas decisões diferentes?
7. Cite um método que poderia ser quebrado em dois ou mais métodos menores.

```text
Responda aqui!
```

<div style="page-break-before: always;"></div>

### 6 Associação, agregação e composição

1. Quais classes se relacionam diretamente entre si?
2. A relação entre `BibliotecaSingleton` e os objetos `Livro`, `Pessoa` e `Emprestimo` pode ser vista como agregação? Por quê?
3. Existe algum caso no código que possa ser interpretado como composição? Justifique com cuidado.
4. Se um empréstimo for removido, o livro deixa de existir? E a pessoa?

```text
Responda aqui!
```

<div style="page-break-before: always;"></div>

### 7 Regras de negócio

1. O sistema trata a identidade de um exemplar emprestado de maneira suficientemente precisa?
2. Em um cenário com registros muito parecidos, existe risco de o sistema atuar sobre o registro errado?
3. Que informação adicional poderia tornar a identificação de um empréstimo mais segura?
4. A devolução deveria localizar um livro, um empréstimo ou outro identificador mais específico? Argumente.

```text
Responda aqui!
```

<div style="page-break-before: always;"></div>

### 8 Manutenção e evolução

1. Se fosse necessário adicionar um novo atributo `anoPublicacao` em `Livro`, quais classes e métodos provavelmente precisariam ser alterados?
2. Se fosse necessário adicionar `email` em `Pessoa`, onde o impacto apareceria?
3. O que seria mais fácil de modificar: o menu ou a persistência? Justifique.


```text
Responda aqui!
```
<div style="page-break-before: always;"></div>

### 9 Qualidade de modelagem

1. O nome `BibliotecaSingleton` expressa o papel do objeto no domínio ou enfatiza demais a técnica usada?
2. O nome `BibliotecaDados` comunica bem sua função?
3. Existe alguma classe cujo nome representa mais a implementação do que a intenção do domínio?
4. O atributo `ESTOQUE` em `Livro` está realmente integrado ao comportamento da classe?
5. Há comentários no código que indicam partes ainda provisórias ou em evolução?
7. A classe `Pessoa` está modelada como entidade genérica ou como aluno? O restante do sistema é coerente com essa escolha?

```text
Responda aqui!
```

<div style="page-break-before: always;"></div>

### 10 Pilares da OO

1. Explique, com base no código, a diferença entre abstração e encapsulamento.
2. Dê um exemplo de abstração presente no sistema.
3. Dê um exemplo de encapsulamento presente no sistema.
4. Dê um exemplo de abstração boa, mas encapsulamento fraco.
5. Dê um exemplo de classe com encapsulamento razoável, mas responsabilidade discutível.
6. É possível uma classe estar bem encapsulada e ainda assim mal dividida em responsabilidades? Mostre no código.
7. É possível uma classe representar bem um conceito do domínio e ainda expor demais seu estado interno? Mostre no código.

```text
Responda aqui!
```

<div style="page-break-before: always;"></div>

# Geração do commit 1.0

A etapa 1 se encerra com a análise do código e com a proposição de melhorias. 

A etapa intermediária é criar o repositório e subir o código inicial do material da disciplina.

Crie um repositório privado no GitHub e envie o código original para esse repositório com o commit inicial:
"Carga de código original".

```bash
echo "# trilhaBiblioteca2026-1" >> README.md
git init
git add README.md
git commit -m "Etapa 1.0 - Carga de código original inicial de base do professor."
git branch -M main
git remote add origin https://github.com/seu-usuario/seu-repo.git
git push -u origin main
```

Atenção ao .gitignore: o .gitignore serve para definir arquivos e diretórios que o Git não deve versionar, e o GitHub mantém uma coleção oficial de templates, incluindo os usados ao criar repositórios e arquivos .gitignore no GitHub. Para um projeto Maven, faz sentido ignorar principalmente target/, arquivos de IDE e alguns artefatos locais. Isso segue a prática comum dos templates do ecossistema GitHub. 

Sugestão de conteúdo do arquivo:

```gitignore
# Maven
target/

# Logs
*.log

# IDEs
.idea/
.vscode/
*.iml
.classpath
.project
.settings/

# OS
.DS_Store
Thumbs.db
```

<div style="page-break-before: always;"></div>

Atenção ao README.md: Este é o arquivo de documentação de abertura do seu repositório. Sugestão de conteúdo do arquivo:

```markdown
# Nome do Projeto

## Integrantes
- Nome 1
- Nome 2
```
O README.md deve ser atualizado ao final de cada etapa com um breve registro do que foi alterado no projeto.

O grupo deverá encaminhar ao professor a URL do repositório privado e garantir que o professor foi adicionado como colaborador com acesso ao projeto. Não criar repositório público. O professor irá criar uma atividade para o aluno responder com a url do repositório no sistema Minha Uno.

Toda etapa realizada pelo grupo deverá ser registrada com commits que permitam ao professor acompanhar a evolução do trabalho ao longo do processo.

Organize as atividades do grupo em tarefas e acompanhe sua execução em quadro Kanban. As tarefas devem ser divididas antes da implementação, de forma que fique visível o planejamento e a evolução do trabalho.

O trabalho será desenvolvido em etapas progressivas. A ideia não é apenas fazer a aplicação funcionar, mas utilizá-la como base para estudo de organização de código, melhoria de encapsulamento, separação de responsabilidades, reutilização, extensão, tratamento de erros, desacoplamento e evolução arquitetural.

A partir daí, inicia-se a implementação da refatoração, registrada nos commits 1.1 e 1.2.

Cada etapa somente será considerada concluída se:
- o código compilar;
- o histórico de commits demonstrar evolução;
- o repositório estiver atualizado;
- o arquivo solicitado da etapa estiver presente na raiz;
- o professor tiver acesso ao repositório privado.

<div style="page-break-before: always;"></div>

# Geração do commit 1.1

O Maven é uma ferramenta de automação e organização de projetos Java. Ele ajuda a padronizar a estrutura do projeto, o processo de compilação, a geração de artefatos e o controle de dependências utilizadas pela aplicação.

Ao transformar a aplicação em um projeto Maven, o grupo passa a trabalhar com uma organização mais próxima do padrão usado em projetos profissionais, com separação clara entre código-fonte principal, recursos e demais partes da aplicação.

O arquivo pom.xml fica na raiz do projeto Maven e funciona como o arquivo central de configuração do projeto. É nele que ficam informações como nome do projeto, identificadores do artefato, versão, dependências e configurações de build.

De forma simples, o pom.xml descreve o projeto para o Maven. Assim, ao longo da atividade, ele será importante para identificar o projeto, organizar sua estrutura e permitir sua evolução de forma mais padronizada.

Estrutura mínima esperada de um projeto Maven:

``` text
meu-projeto/
|── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       └── java/
└── README.md
```

As classes da aplicação devem ficar dentro de src/main/java.
Arquivos de configuração ou dados auxiliares podem ficar em src/main/resources, quando necessário.

<div style="page-break-before: always;"></div>

### pom.xml


``` xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>br.uno.biblioteca</groupId>
    <artifactId>trilha-biblioteca</artifactId>
    <version>1.0-SNAPSHOT</version>
</project>

```

Defina groupId, artifactId e version de forma coerente com o projeto do grupo.

Crie um projeto Maven e reorganize o código neste projeto para este novo modelo de projeto.

Até aqui você deve fazer um novo commit "Etapa 1.1 - Refatoração para Maven"

<div style="page-break-before: always;"></div>

# Refactoring - commit 1.2 e commit 1.3

Note que App.Java centraliza todo o fluxo de execução do sistema. A proposta é refatorar isso criando camadas, transportando a aplicação para o formato MAVEN.


<div style="page-break-before: always;"></div>

Seu commit 1.1 já está realizado, com a refatoração do código para padrão MAVEN. Esta nova refatoração trasnportará o código para camaadas. Siga estas orientações e desenvolva pacotes e renomeie e redistribua as classes para que atendam:

- aplicacao - detalhes particulares de aplicação e enrty point main enxuto;
- controller - por onde entram as requisições e saem as respostas. A App exibe menu, mas chama o controller pra responder as opções;
- servive - acionado pelo controller, recebe um pedido e devolve dados, não faz messageria. A messageria é do controller;
- repository - agrega a entidade em coleções. Cada entidade tem seu repositório. É a conexao do físico persistido para com a memoria ("banco" para coleções)
- dominio - onde a entidade fica. 

### Estrutura mínima de pacotes

``` bash
src/main/java/br/uno/biblioteca/aplicacao
src/main/java/br/uno/biblioteca/controller
src/main/java/br/uno/biblioteca/service
src/main/java/br/uno/biblioteca/repository
src/main/java/br/uno/biblioteca/dominio
```

Até aqui você deve fazer um novo commit "Etapa 1.2 - Refatoração para arquitetura de camadas"

Implementações para adicionar nesta refatoração:

1. Adicionar `anoPublicacao` em `Livro`
2. Adicionar `curso` ou `email` em `Pessoa`
3. Criar método para verificar se uma pessoa já possui empréstimo ativo
4. Impedir cadastro duplicado por matrícula
5. Impedir cadastro duplicado por ISBN, se essa for a regra desejada

- revisar critério de identificação de empréstimo
- revisar critério de unicidade de exemplar
- revisar responsabilidade de alteração de disponibilidade do livro

Até aqui você deve fazer um novo commit "Etapa 1.3 - Refatoração de código e increntos iniciais"

Faça subcommits entendendo que o commit 1., 1.2 e 1.3 são a efetivação das etapas, então entre o 1.0 e 1.1 final  você pode fazer commit 1.0.1 com várias descrições intermediárias conforme a distribuição de tarefas que o grupo organizar.

O professor vai observar a evolução e oranização do grupo pelo histórico gradual de commits.

Na organização de commits entre times de desenvolvimento é importante o conhecimento de pull e push, bem como a tratativa de conflitos. Organização de time de trabalho.

## Por fim

O grupo deve subir este markdon respondido e anexado na raiz do repositório git hub com o nome "Análise inicial etapa 1.md".