# MapStruct Demo

MapStruct is a widely-used tool in Java development for automating the mapping process between complex objects. It is particularly beneficial in Spring Boot applications where data transformations are frequently required between entities and DTOs.

This demo showcases a basic example of mapping between an entity class (`Product`) and a DTO class (`ProductDto`). The mapping logic is defined in the `ProductMapper` interface. 

## Examples

### Example 1

Given request body
```
{
    "name": "tv", 
    "price": 2650.30
}
```

When `POST /api/v1/products`

Then output
```
{
    "id": 1,
    "productName": "tv",
    "productPrice": 2650.3
}
```

### Example 2

Given `pageNumber` = 0 and `pageSize` = 3

When `GET /api/v1/products`

Then output
```
[
    {
        "id": 7,
        "productName": "tv",
        "productPrice": 2650.3
    },
    {
        "id": 6,
        "productName": "tv",
        "productPrice": 2650.3
    },
    {
        "id": 5,
        "productName": "tv",
        "productPrice": 2650.3
    }
]
```
