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

Implementamos também autenticação no projeto usando Spring Security e JWT. 

O Spring Security é um framework de autenticação e autorização para aplicações Java. Ele oferece recursos para lidar com autenticação de usuários, controle de acesso baseado em papéis, prevenção contra ataques de segurança. Ja o JWT, ou JSON Web Token, é um formato compacto e seguro para transferir informações entre duas partes de forma estruturada. Ele é comumente usado como um mecanismo de autenticação em aplicativos web e serviços. Quando combinados, o Spring Security e JWT podem oferecer uma camada robusta de segurança para suas aplicações, permitindo autenticação e autorização de maneira eficiente e escalável. Para fazer os dois trabalharem juntos, fizemos um controller de autenticação, com login e senha como parâmetros principais.

Nossos usuários devem ter perfis ROLE que seria a autenticação de perfil, esses perfis envolve a atribuição de diferentes conjuntos de permissões ou autorizações a usuários com base em seus papéis ou perfis dentro do sistema. No contexto do Spring Security, os papéis (roles) são utilizados para definir o que um usuário específico pode fazer dentro da aplicação. Esses papéis são associados aos usuários durante o processo de autenticação e são usados para controlar o acesso a recursos e funcionalidades, por exemplo, um sistema pode ter diferentes tipos de usuários, como usuários normais, administradores e moderadores. Cada um desses tipos pode ter permissões diferentes dentro da aplicação. O Spring Security permite atribuir roles aos usuários autenticados e então proteger recursos com base nessas roles, desse modo fazendo com que seja possível controlar o que cada usuário pode fazer dentro da aplicação, garantindo a segurança e a integridade do sistema.

Para finalizar, como mencionado acima para manter a integridade do nosso sistema, criamos também controle de acesso, para usuários e administradores. Assim, usuários terão acesso a uma especificidade e o administrador a outra. Nesse caso, o usuário acessa uma lista de filmes/séries, podendo ter uma lista dos mesmo para manipular, no sentido de adicionar ou remover no seu perfil, não no sistema como um todo. Já os administradores, poderão remover/adicionar filmes e/ou séries do catálogo, colocar avisos de lançamento de determinado filme, quando determinada série sairá do catálogo e etc. Fazendo com que cada um tenha sua “função” dentro do sistema
