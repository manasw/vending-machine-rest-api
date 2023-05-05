## Prereqs to build/run the project
    Java 17 or later
    Gradle 7.5+
    IDE of your choice

## Running the project
In the project directory you can run: 

`./gradlew bootRun`

This will start the service at [http://localhost:8080](http://localhost:8080)

## Available RESTful endpoints

### To get the inventory
http://localhost:8080/inventory \
Sample response
```json
[
    {
        "name": "Chips",
        "quantity": 25,
        "price": 0.99
    },
    {
        "name": "Candy Bar",
        "quantity": 25,
        "price": 0.60
    },
    {
        "name": "Soda",
        "quantity": 25,
        "price": 0.95
    }
]
```

### To get all the sale transactions
http://localhost:8080/transactions \
Sample response
```json
{
    "sales": [
        {
            "id": 1,
            "items": [
                {
                    "name": "Chips",
                    "quantity": 1,
                    "price": 0.99
                },
                {
                    "name": "Candy Bar",
                    "quantity": 1,
                    "price": 0.6
                },
                {
                    "name": "Soda",
                    "quantity": 1,
                    "price": 0.95
                }
            ],
            "amount": 2.54
        }
    ]
}
```

### To get a sale transaction by id
http://localhost:8080/transactions/1 \ 
Sample Response
```json
{
    "id": 1,
    "items": [
        {
            "name": "Chips",
            "quantity": 1,
            "price": 0.99
        }
    ],
    "amount": 0.99
}
```

### To add a new sale transaction
http://localhost:8080/transactions \
Sample Request
```json
{
    "amount": 0.95,
    "items": [
        {
            "name": "Soda",
            "quantity": 1,
            "price": 0.95
        }
    ]
}
```

Sample Response
```json
{
    "id": 1,
    "items": [
        {
            "name": "Soda",
            "quantity": 1,
            "price": 0.95
        }
    ],
    "amount": 0.95
}
```

