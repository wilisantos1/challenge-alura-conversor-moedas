# Conversor de Moeda

Este é um projeto de conversor de moedas que utiliza a API ExchangeRate para obter taxas de câmbio em tempo real e converter valores entre diferentes moedas. O programa é escrito em Java e faz uso de várias bibliotecas para gerenciar requisições HTTP e manipular respostas JSON.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.
- **Gson**: Biblioteca para manipulação de JSON.
- **Apache HttpClient**: Biblioteca para fazer requisições HTTP.

## Estrutura do Projeto
### Classes

#### `CurrencyConverter`

A classe `CurrencyConverter` é o ponto de entrada do programa. Ela solicita ao usuário que escolha uma opção de conversão e insira um valor. Com base na escolha do usuário, a classe define as moedas de origem e destino e chama o método `getExchangeRate` da classe `ExchangeRateClient` para obter a taxa de câmbio e converter o valor.

#### `ExchangeRateClient`

A classe `ExchangeRateClient` é responsável por fazer requisições à API ExchangeRate. Ela utiliza a classe `HttpRequest` para configurar a solicitação e a classe `HttpResponseHandler` para manipular a resposta da API. O método `getExchangeRate` constrói a URL da API, faz a requisição e retorna a resposta tratada.

#### `HttpRequest`

A classe `HttpRequest` encapsula a URL da API e fornece um método para obter a URI formatada corretamente. Esta classe ajuda a modularizar a configuração das requisições HTTP.

#### `HttpResponseHandler`

A classe `HttpResponseHandler` encapsula a resposta da API, incluindo o código de status e o corpo da resposta. Esta classe é usada para analisar a resposta HTTP e extrair informações importantes, como a taxa de câmbio.

## Como Executar


1. **Adicionar a chave da API**:
   Substitua `"YOUR_API_KEY"` na classe `ExchangeRateClient` pela sua chave de API real da ExchangeRate.

2. **Usar o programa**:
   Siga as instruções no terminal para escolher uma opção de conversão e inserir o valor a ser convertido. O programa retornará o valor convertido com base na taxa de câmbio atual.

## Dependências

O projeto utiliza as seguintes dependências, especificadas no arquivo `pom.xml`:

- `gson`: Para manipulação de JSON.
- `httpclient`: Para fazer requisições HTTP.
