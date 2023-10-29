# SGV
Sistema de Gerenciamento de Vacinas


curl para import no postman

#Vacinas


Cria Vacina

curl --location 'http://localhost:8080/vacinas' \
--header 'Content-Type: application/json' \
--data '{
    "nomeVacina": "Pfizer",
    "doseVacina": "Segunda Dose",
    "numeroLote": 1652,
    "quantidade": 55980
}'


Busca vacina

curl --location --request GET 'http://localhost:8080/vacinas/dcb1199d-fe34-4e11-9ab5-aab2f9c8633d' \
--header 'Content-Type: application/json' \
--data '{
    "nomeVacina": "CoronaVac",
    "doseVacina": "Primeira Dose",
    "numeroLote": 123,
    "quantidade": 5980
}'

Busca Todas Vacinas

curl --location --request GET 'http://localhost:8080/vacinas' \
--header 'Content-Type: application/json' \
--data '{
    "nomeVacina": "CoronaVac",
    "doseVacina": "Primeira Dose",
    "numeroLote": 123,
    "quantidade": 5980
}'


Atualiza Vacina

curl --location --request PUT 'http://localhost:8080/vacinas/dcb1199d-fe34-4e11-9ab5-aab2f9c8633d' \
--header 'Content-Type: application/json' \
--data '{
    "nomeVacina": "CoronaVac",
    "doseVacina": "Primeira Dose",
    "numeroLote": 123,
    "quantidade": 8980
}'

Deleta Vacina

curl --location --request DELETE 'http://localhost:8080/vacinas/dcb1199d-fe34-4e11-9ab5-aab2f9c8633d' \
--data ''



