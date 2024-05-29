# EasyNews

EasyNews é um aplicativo inovador que revoluciona a forma como as pessoas consomem notícias, combatendo a desinformação prevalente em nossa sociedade. O foco principal é proporcionar um feed de notícias adaptado à linguagem individual de cada usuário, além de oferecer traduções personalizadas de notícias e artigos.

## Descrição do Projeto

EasyNews foi desenvolvido para mapear a linguagem de cada usuário, oferecendo um feed de notícias completamente adaptado à sua comunicação individual. Além disso, permite aos usuários submeter notícias ou artigos para tradução personalizada. A plataforma também disponibiliza planos de assinatura que desbloqueiam recursos exclusivos.

Este projeto foi desenvolvido como parte da disciplina de Empreendedorismo em Sistemas de Informação.

## Funcionalidades

- **Cadastro e Login:** Registro de novos usuários e acesso à plataforma.
- **Reconhecimento de Linguagem do Usuário:** Personalização do conteúdo de acordo com a linguagem individual do usuário.
- **Feed de Notícias Personalizado:** Exibição de notícias adaptadas à linguagem mapeada do usuário.
- **Envio de Notícias ou Artigos:** Área para envio de notícias ou artigos para tradução personalizada.
- **Planos de Assinatura:** Desbloqueio de recursos exclusivos para assinantes.

## Tecnologias Utilizadas

- **Java 17:** Linguagem de programação principal.
- **Spring Framework:** Framework para desenvolvimento backend.
- **Hibernate:** Framework de mapeamento objeto-relacional.
- **JWT (JSON Web Token):** Utilizado para autenticação segura.
- **MySQL:** Banco de dados relacional.
- **Maven:** Ferramenta de automação de compilação.

## Estrutura do Projeto

- **Controller:** Gerencia as requisições HTTP e envia as respostas adequadas.
- **Service:** Contém a lógica de negócios da aplicação.
- **Repository:** Interage com o banco de dados utilizando o Hibernate.
- **Model:** Representa as entidades do banco de dados.

## Requisitos

- **Java 17**
- **Spring Framework**
- **MySQL**
- **Maven**

## Instalação e Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/caionovaiss/easynews-server.git
2. Navegue até o diretório do projeto:
   ```bash
   cd easynews-server
3. Configure o banco de dados MySQL no arquivo application.properties:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/easynews
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
4. Compile e execute o projeto utilizando Maven:
   ```bash
   mvn spring-boot:run
