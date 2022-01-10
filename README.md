# Instruções

A porta escolhida foi a 9999. Portanto, a URL base utilizada deve ser: _http://localhost:9999_. A ferramenta utilizada para testes foi o **Postman**.

## Consultas  

* Para buscar todos os produtos, utilizar o endpoint `/products` com o método **GET**. Exemplo de **url**: `http://localhost:9999/products`

* Para buscar um produto específico, utilizar o endpoint `/products/{id}` com o método **GET**, onde _id_ é o ID do produto a ser buscado. Exemplo de **url**: `http://localhost:9999/products/1`

* Para buscar os produtos filtrados pelo nome, descrição, preço mínimo e máximo, utilizar o endpoint `/products/search`, e colocar como QueryParams: _q, min_price e max_price_. Informando o **q**, serão retornados os produtos que o _name_ ou a _description_ forem iguais ao **q**. Informando o **min_price**, serão retornados os produtos que o _price_ for maior ou igual ao **min_price**. Informando o **max_price**, serão retornados os produtos que o _price_ for menor ou igual ao **max_price**.  _**Observação:**_ Nenhum parâmetro desse endpoint é obrigatório, e os filtros serão feitos simultaneamente pelos parâmetros informados. Se nenhum parâmetro for informado, todos os produtos serão retornados. Exemplo de **url**: `http://localhost:9999/products/search?q=product&min_price=50&max_price=150`

## Cadastro  

* Para cadastro de um produto, utilizar o endpoint `/products` com o método **POST**, disponibilizando via body as informações do produto a ser cadastrado. O **id** é gerado automaticamente. Validações feitas: _name e description_ não podem ser nulos e _price_ deve ser positivo. Exemplo de **url e body:**  
`http://localhost:9999/products`
```json
{
    "name": "product",
    "description": "description of the product",
    "price": 49.90
}
```

## Atualização  

* Para atualização de um produto, utilizar o endpoint `/products/{id}` com o método **PUT**, onde _id_ é o ID do produto a ser atualizado e as informações atualizadas do produto devem ser enviadas via body. Validações feitas: _name e description_ não podem ser nulos e _price_ deve ser positivo. Exemplo de **url e body:**  
`http://localhost:9999/products/1`
```json
{
    "name": "updated product",
    "description": "new description of the product",
    "price": 100
}
```  

## Deleção  

* Para a deleção de um produto, utilizar o endpoint `/products/{id}`, onde _id_ é o ID do produto a ser deletado. Exemplo de **url**: `http://localhost:9999/products/1`