# com-bootcamp-proyectos-simulador1e
# Para probar con curl
curl -v -d @request-body.json -X POST --header "Content-Type:application/json" localhost:8086/simulador1e/


Contenido del @request-body.json

Valores validos
{
    "dni": "12345678",
    "tarjeta": "BLACK",
    "moneda": "USD",
    "monto": 500,
    "cuota": 5,
    "tea": "99.90%",
    "diaPago": 19
}


Valores invalidos: DNI incorrecto
{
    "dni": "12345670",
    "tarjeta": "BLACK",
    "moneda": "USD",
    "monto": 500,
    "cuota": 5,
    "tea": "99.90%",
    "diaPago": 19
}

Valores invalidos: Tarjeta incorrecta
{
    "dni": "12345678",
    "tarjeta": "VISA",
    "moneda": "USD",
    "monto": 500,
    "cuota": 5,
    "tea": "99.90%",
    "diaPago": 19
}

Valores invalidos: TEA incorrecta
{
    "dni": "12345678",
    "tarjeta": "BLACK",
    "moneda": "USD",
    "monto": 500,
    "cuota": 5,
    "tea": "99.70%",
    "diaPago": 19
}