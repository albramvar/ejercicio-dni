# Java DNI Librería

`DniUtils` es una pequeña clase auxiliar que sirve para calcular y comprobar la validez de la letra de un DNI español. Está definida en el paquete `src.main.java.com.example`.

## Estructura

- `LETRAS_DNI` es una constante que contiene las letras usadas tras el cálculo del módulo 23.
- `calcularLetra(int numero)` calcula la letra de un número dado.
- `validarDni(String dni)` comprueba si la letra del DNI dado es válida o no.

Ambas operaciones son estáticas por lo que se pueden llamar directamente, sin necesidad de crear una instancia específica.

## Uso

```java
import src.main.java.com.example.DniUtils;

char letra = DniUtils.calcularLetra(12345678);
System.out.println(letra);
```

`calcularLetra` acepta un número de máximo 8 dígitos. Un número más largo ocasiona un `IllegalArgumentException`.


```java
boolean valido = DniUtils.validarDni("00000000T");
System.out.println(valido);
```

`validarDni` espera una cadena de exactamente 9 caracteres, de los cuales 8 deben ser numnéricos. Devuelve `true` cuando la letra concuerda con la calculada a partir del número y `false` cuando no lo hace. Una longitud de la cadena distinta a 9 o unos primeros 8 caracteres que no sean numéricos causan un `IllegalArgumentException`.
