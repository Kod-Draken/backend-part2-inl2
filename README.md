# Backend del 2 - inl 2

Kör skriptet **run.sh**

Se filen **brunoimport.json**, den kan importeras i Postman, Bruno, mfl. för att smidigt testa restanrop.

Bas-URL: http://localhost:8080



## Endpoints

### POST /customer
Skapar en ny kund.  
Parametrar (query params):
- **name**: String
- **phone**: String

### POST /vehicle
Skapar ett nytt fordon.  
Parametrar:
- **licenceNumber**: String
- **brand**: String
- **model**: String
- **productionYear**: String

### POST /add-vehicle-to-customer
Kopplar ett fordon till en kund.  
Parametrar:
- **vehicleId**: int
- **customerId**: int

### GET /customer-id
Hämtar kund-id och namn baserat på sökning.  
Parametrar:
- **name**: String

### GET /customers
Hämtar alla kunder inklusive deras fordon.  
Parametrar: inga.

### GET /vehicles
Hämtar alla fordon.  
Parametrar: inga.

### GET /vehicles-by-brand
Hämtar alla fordon av ett visst märke.  
Parametrar:
- **brand**: String

**Alla POST-anrop kräver att alla parametrar skickas, annars returneras 400 Bad Request.**