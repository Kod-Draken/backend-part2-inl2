# Backend del 2 - inl 2

Kör skriptet **run.sh**

Se filen **brunoimport.json**, den kan importeras i Postman, Bruno, mfl. för att smidigt testa restanrop.

Bas-URL: http://localhost:8080


## Endpoints

### POST /customer?name={...}&phone={...}
Skapar en ny kund.
- **name**: String
- **phone**: String

### POST /vehicle?licenceNumber={...}&brand={...}&model={...}&productionYear={...}
Skapar ett nytt fordon.
- **licenceNumber**: String
- **brand**: String
- **model**: String
- **productionYear**: String


### POST /add-vehicle-to-customer?customerId={...}&vehicleId={...}
Kopplar ett fordon till en kund.  
- **vehicleId**: int
- **customerId**: int

### GET /customer-id?name={...}
Hämtar kund-id och namn baserat på sökning.  
- **name**: String

### GET /customers
Hämtar alla kunder inklusive deras fordon.  

### GET /vehicles
Hämtar alla fordon.

### GET /vehicles-by-brand?brand={...}
Hämtar alla fordon av ett visst märke.
- **brand**: String

**Alla POST-anrop kräver att alla parametrar skickas, annars returneras 400 Bad Request.**