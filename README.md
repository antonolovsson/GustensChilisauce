# GustensChilisauce

Run project in Intellij.

## Update the stock
Use the following json to add some sauces to the stock on the POST endpoint /api/postSauce

Example json
```
[
{
"id": 1,
"name": "Lombardo",
"quantity": 20,
"origin": "Itally",
"scoville": 2000,
"price": 4
},
{
"id": 2,
"name": "Bhut Jolokia",
"quantity": 550,
"origin": "India",
"scoville": 800000,
"price": 20
},
{
"id": 3,
"name": "Ají Charapita",
"quantity": 100,
"origin": "Peru",
"scoville": 40000,
"price": 50
}
]
```

## Place an order
You can place an order by using the following example json on the POST endpoint /api/placeOrder
```
{
    "clientId": 1,
    "clientName": "Anton",
    "sauceList": [
        {
            "id": 1,
            "quantity": 10
        },
        {
            "id": 2,
            "quantity": 20
        }
    ]
}
```
## Get the stock view
You can see whats in stock on the GET endpoint /api/getStock
You can filter these results with query params:

```
name
origin
scoville
```
