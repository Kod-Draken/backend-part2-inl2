# Backend del 2 - inl 2

Kör skriptet **run.sh**

Bas-URL: http://localhost:8080

POST /customer – Skapar en kund. Parametrar: name (kundens namn), phone (telefonnummer).

POST /vehicle – Skapar ett fordon. Parametrar: licenceNumber (registreringsnummer), brand (märke), model (modell), productionYear (årsmodell).

GET /customer-id – Hämtar kundens id med namn. Parametrar: name (kundens namn).

GET /customers – Hämtar alla kunder med deras fordon. Inga parametrar.

GET /vehicles – Hämtar alla fordon. Inga parametrar.

GET /vehicles-by-brand – Hämtar fordon med ett specifikt märke. Parametrar: brand (märke på fordon).

**Alla POST-anrop kräver att alla parametrar skickas, annars returneras 400 Bad Request.**