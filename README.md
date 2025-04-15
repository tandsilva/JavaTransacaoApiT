Transação API
Este projeto é uma API REST para gerenciar transações e calcular estatísticas das transações realizadas nos últimos 60 segundos. A API foi desenvolvida utilizando Java e Spring Boot.

Variáveis de Ambiente
Para rodar esta aplicação, você precisa de:

Java: JDK 21 ou superior

Maven: Versão 3.8.1 ou superior

Git: Para clonar o repositório

Docker (opcional): Caso queira rodar a aplicação em um container

Como Configurar o Projeto
1. Clone o Repositório
Use o comando abaixo para clonar o repositório:

bash
Copiar
Editar
git clone <url_do_repositorio>
2. Compile o Projeto
Execute o seguinte comando para compilar o projeto:

bash
Copiar
Editar
mvn clean install
3. Execute o Projeto
Após a compilação, você pode executar a aplicação com o comando:

bash
Copiar
Editar
mvn spring-boot:run
Como Rodar em um Container (Opcional)
4.1. Crie a Imagem Docker
Certifique-se de que o Docker está instalado e execute o comando para criar a imagem:

bash
Copiar
Editar
docker build -t api-transacoes .
4.2. Execute o Container
Para rodar a aplicação em um container Docker, execute:

bash
Copiar
Editar
docker run -p 8080:8080 api-transacoes
Documentação da API
Receber Transações
POST /transacao

Parâmetro:

valor (BigDecimal): Obrigatório. O valor da transação.

dataHora (OffsetDateTime): Obrigatório. O horário que a transação ocorreu.

Limpar Transações
DELETE /transacao

Este endpoint remove todas as transações registradas.

Calcular Estatísticas
GET /estatistica

Parâmetro:

intervaloSegundos (integer): Não obrigatório. O padrão é 60 segundos.

