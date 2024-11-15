# Gerenciador de Produtos

## Descrição

Esta é uma aplicação backend desenvolvida com **Spring Boot** que oferece um **CRUD completo** para gerenciamento de dados de produtos, incluindo funcionalidades de **login e registro de usuário**. A aplicação permite realizar as operações básicas de CRUD (Criar, Ler, Atualizar, Excluir) e inclui um **filtro de pesquisa** para facilitar a busca de dados no sistema.

Além disso, a aplicação possui uma funcionalidade que permite **ler dados a partir de um arquivo JSON** e armazená-los diretamente no banco de dados, facilitando a importação de dados em massa para o sistema.

### Funcionalidades principais:
- **CRUD Completo**: Criar, ler, atualizar e excluir registros de dados.
- **Filtro de Pesquisa**: Permite que o usuário realize buscas específicas de dados no banco.
- **Sistema de Autenticação**: Cadastro de novos usuários e login.
- **Importação de Dados via JSON**: A aplicação pode ler dados de um arquivo JSON e inserir esses dados no banco de dados de forma eficiente.


## Requisitos

### Para rodar a aplicação localmente, você precisará de:

- **JDK 21 ou superior** (para rodar o Java)
- **Maven** (para gerenciamento de dependências)
- **Banco de Dados Relacional** (como MySQL, PostgreSQL ou H2)(lembrando que nesta aplicação utilizei MySQL, caso deseja mudar, terá que adicionar a dependecia da banco que deseja utilizar e autenticar-lo no application.properties)
- **IntelliJ IDE** (Você também pode utilizar outras, mas caso queira seguir o projeto inteiro, utilize está IDE)

### Dependências e Versões:
- **Spring Boot**: 3.3.5 
- **Java**: JDK 21 
- **Banco de Dados**: MySQL
- **Maven**: 3.9.9

## Como utilizar a API:

### Com o Postman:
A API foi projetada para ser testada facilmente com ferramentas como o **Postman**. Aqui estão os passos para testar as principais funcionalidades da aplicação:

#### 1. Listagem de produtos:
Selecione a opção GET e adicione **http://localhost:8080/produtos** clique em Send e você receberá os produtos!

#### 2. Listagem de produtos filtrados:
Realize a mesma operação que o GET mas substitua a rota para **http://localhost:8080/produtos/filter** e então em params você coloca os argumentos para sua filtragem.  (obs: lembrando que key é onde você insere o dado de filtragem e Value é o valor do dado que deseja!)

#### 3. Criação de produtos:
Agora iremos criar um produto, selecione a opção de POST e adicione **http://localhost:8080/produtos**, você pode tanto passar no params as keys e valores para o JSON ou se preferir(eu prefiro hehe) pelo Body e em raw você pode inserir o JSON manualmente(lembre de selecionar a opção de JSON se não estiver selecionada) e então clique em Send e pronto, seu produto foi criado!

#### 4. Atualização de produtos:
Agora trocamos a opção para PUT e dessa vez precisamos passar o ID do produto que queremos atualizar como parametro, então vou colocar um ID como exemplo aqui(lembre de colocar o id correto que deseja mudar) **http://localhost:8080/produtos/30** sendo o 30 o ID e então você atualize os atributos que desejar (***LEMBRANDO!*** se você deixar vazio algum atributo na atualização ele retornará como **Null**)

#### 5. Deleção de produtos:
Agora a parte triste... dizer adeus aos produtos. Mas é o mais simples deles! no update passamos um ID na URL, então só preciamos fazer o mesmo! no postman trocamos a opção para DELETE e inserimos **http://localhost:8080/produtos/30** e clicando em Send e pronto, o produto foi deletado (***OBS A RESPEITO DO DELETE!!*** a maneira que o DELETE foi implementado não é a correta, afinal não queremos deletar um dado, apenas manter e desativar-lo, futuramente a lógica será corrigida e o dado do produto não será perdido, apenas desativado!)

#### 6. Cadastro de Usuarios:
Agora seguimos a mesma logica da Criação de produtos e a mesma operação de POST, mas devemos subsistuir a URL para **http://localhost:8080/users/cadastro** e passar os parametros para cadastro do usuario

#### 7. Login de Usuarios:
Agora, apenas trocarmos a URL para **http://localhost:8080/users/login** ainda utilizando a operação de POST, e no body ou no params. Passamos o email e senha, caso não esteja correto com um cadastro de usuario dentro do banco de dados, a operação retornará uma Exception!



## Referência

 - [Documentação SPRING BOOT](https://docs.spring.io/spring-boot/index.html)


## Autores

- [@sachow12](https://github.com/sachow12)

