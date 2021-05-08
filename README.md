# Catálogo de Produtos

Microserviço simples de catálogo de produtos com Java e Spring Boot.

### ⚙️ Funcionalidades

- [x] Cadastro de produtos
- [x] Alteração de produtos
- [x] Exclusão de um produto
- [x] Visualização da lista de produtos
- [x] Visualização de um produto passando o id
- [x] Visualização de um produto passando filtro (_name, description, price_)

###  🚀 Endpoints
A aplicação possui 6 Endpoints, conforme listados abaixo:

| Verbo HTTP    | Resource path | Descrição  | Status bem sucedido | Status em caso de Erro | 
| ------------- |:-------------:| :----------:| :----------:| ----------:|
| POST          | /products     | Criação de um produto | HTTP 201 | HTTP 400|
| PUT          | /products/     | Atualização de um produto | HTTP 201 | HTTP 404 |
| GET          | /products/     | Busca de um produto por ID | HTTP 200 | HTTP 404 |
| GET          | /products     | Lista de produtos | HTTP 200 | Retornar lista vazia |
| GET          | /products/search     | Lista de produtos filtrados | HTTP 200 | Retornar lista vazia |
| DELETE          | /products/     | Deleção de um produto | HTTP 200 | HTTP 404 |

O formato esperado de um produto é o seguinte:
```json	
	{ 
		"id": "string", 
		"name": "string", 
		"description": "string", 
		"price": 59.99  
	}
```
Este formato, **com exceção do "id"**, deverá ser passado para os métodos POST e PUT que realizam a inserção e alteração de um produto.

O microserviço poderá ser acessado através da porta 9999, ex. http://localhost:9999/products.

### ✅ Validações

Durante a criação e alteração, os campos _name, description_ e _price_ são obrigatórios. Em relação ao campo _price_ o valor deve ser positivo.
Para o endpoint /products/search, os query parameters aceitos serão: _q, min_price_ e _max_price_, porém, nenhum deles deverá ser obrigatório na requisição.


### 🛠️ Ferramentas utilizadas

Para o desenvolvimento do microserviço foi utilizada a [Spring Tools for Eclipse](https://spring.io/tools) por já possuir o servidor Tomcat integrado.
Para acesso aos endpoints foi utilizada a plataforma [Postman](https://www.postman.com/). 
Para manipulação de dados foi utilizada a dependência H2, um banco de dados em memória. Para criação dos dados foi criada uma classe "TestConfig" para que assim que inicializado o projeto, fosse criado uma massa de dados em memória para realização de testes.

