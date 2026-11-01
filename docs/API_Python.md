# Servicio Python FastAPI

La aplicación de servicios `microservicio_python/app/app.py` expone dos endpoints que permiten calcular o validar la letra de un DNI español. Usa `dni_utils.calcula_letra_dni` para realizar la operación de módulo 23.

## Estructura

- `POST /dni/{dni}` recibe un número de 8 dígitos como parte del endpoint y devuelve una letra.
- `GET /dni/validar?dni=...` recibe un DNI completo y devuelve un booleano.

## Arrancar la aplicación

Desde el directorio `microservicio_python`, instala las dependencias y arranca el servidor de desarrollo:

```bash
pip install -r requirements.txt
cd app
fastapi run
```

El servicio está accesible en la dirección `http://127.0.0.1:8000`. La documentación de FastAPI está disponible en `http://127.0.0.1:8000/docs`.

## Uso

Cálculo de la letra:

```python
response = requests.post("http://127.0.0.1:8000/dni/00000000")
```

Respuesta:
```json
{"letra":"T"}
```

El endpoint POST de cálculo requiere exactamente 8 caracteres numéricos, en el caso contrario, devuelve un 400 Bad Request.

Validar un DNI:

```python
response = requests.get("http://127.0.0.1:8000/dni/validar?dni=00000000T")
```

Respuesta:
```json
{"valido":true}
```

El endpoint GET de validación requiere exactamente 9 caracteres, de los cuales los 8 primeros deben ser numéricos. Una longitud diferente o caracteres no numéricos causa un 400 Bad Request.
