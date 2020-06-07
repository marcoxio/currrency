## Ejemplo de Criptocurrency
Este proyecto  realiza los metodos de post y get en la creación de criptocurrencies y en los diferentes precios de 3 monedas.
## Currency
``Metodos validos en la implementación``
* POST
    * http://localhost:9081/api/v1/currency

``Ejemplo``
{
  "name": "Tether",
  "symbol": "USDT",
  "rank": "0",
  "quote": [
    {
      "id": 1,
      "name": "Dolares Americanos",
      "symbol": "USD",
      "price": 9500.4,
      "lastUpdate": "2020-06-06"
    },
    {
      "id": 2,
      "name": "Euro",
      "symbol": "EUR",
      "price": 8500.4,
      "lastUpdate": "2020-06-06"
    },
    {
      "id": 3,
      "name": "Libra Esterlina",
      "symbol": "GBP",
      "price": 7500.4,
      "lastUpdate": "2020-06-06"
    }
  ]
}


* GET
    * http://localhost:9081/api/v1/currency
    
* GetByName({name})
    * http://localhost:9081/api/v1/currency/Bitcoin
    
    
## Quote
``Metodos validos en la implementación``
* POST
    * http://localhost:9081/api/v1/quote
    
``Ejemplo``

{
	"name":"Euro",
	"symbol": "EUR",
	"price": 7600.4,
	"lastUpdate": "2020-10-10",
	"currency_id": 1
}


* GET
    * http://localhost:9081/api/v1/quote
