**Projeto de Streaming de Filme/Seires com CRUD em Spring Boot**

Este é um projeto de exemplo que demonstra como criar um sistema de streaming de vídeo com operações CRUD (Create, Read, Update, Delete) usando o Spring Boot. O projeto utiliza as seguintes dependências:

- Spring Data JPA: Para interagir com o banco de dados de forma eficiente.
- Lombok: Para reduzir a verbosidade do código e gerar automaticamente getters, setters e outros métodos.
- Spring Web: Para criar um aplicativo da web usando o Spring MVC.

**Estrutura do Projeto**
  
A estrutura do projeto é a seguinte:
- Controller: Esta classe controla as operações CRUD para as classes, como criação, leitura, atualização e exclusão. Ela mapeia endpoints da API REST.
- Entity: Esta classe representa a entidade da classe que será armazenada no banco de dados. Ela usa anotações do Spring Data JPA para mapear a tabela no banco de dados.
- Repository: Esta interface define métodos de acesso ao banco de dados para a entidade da classe. Não é necessário implementar esses métodos manualmente, pois o Spring Data JPA os implementará automaticamente.
- Service: Esta classe contém a lógica de negócios relacionada as classes e interage com a classeRepository.
- DTO:  Esta classe permite a transformação de dados conforme necessário ao interagir com a camada de serviço ou ao responder às solicitações da API.

**Configuração do Banco de Dados**

O projeto está configurado para usar um banco de dados. Você pode configurar as propriedades do banco de dados no arquivo application.properties.

