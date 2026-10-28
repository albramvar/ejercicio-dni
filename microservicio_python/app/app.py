from fastapi import FastAPI, HTTPException
from dni_utils import calcula_letra_dni

app = FastAPI()

@app.post("/dni/{dni}")
def calcula_letra(dni):
    if dni is None or len(dni) != 8:
        raise HTTPException(status_code=400, detail="The DNI provided is not valid")

    try:
        dni_int = int(dni)
    except ValueError:
        raise HTTPException(status_code=400, detail="The DNI provided is not valid")
    letra = calcula_letra_dni(dni_int)
    return {"letra": letra}

@app.get("/dni/validar")
def valida_dni(dni):
    if dni is None or len(dni) != 9:
        raise HTTPException(status_code=400, detail="The DNI provided is not valid")

    dni_numero = dni[0:len(dni)-1]
    try:
        dni_numero_int = int(dni_numero)
    except ValueError:
        raise HTTPException(status_code=400, detail="The DNI provided is not valid")

    dni_letra = dni[-1]
    letra_calculada = calcula_letra_dni(dni_numero_int)

    if letra_calculada == dni_letra:
        return {"valido": True}
    else:
        return {"valido": False}