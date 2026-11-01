# Librería C++

## Descripción

Esta librería reúne las funciones necesarias para trabajar con la validación del DNI. La idea es que otros programas puedan utilizar estas funciones directamente, sin tener que escribir de nuevo el código que realiza los cálculos.

## Estructura

El proyecto está dividido en los siguientes archivos:
- `include/dni_utils.h`: contiene las declaraciones de las funciones que ofrece la librería.
- `src/dni_utils.cpp`: contiene el código de esas funciones.
- `client/prueba.cpp`: es un pequeño programa que sirve para probar cómo funciona la librería.

## Uso de la librería

Si queremos utilizar la librería en otro programa, primero tenemos que incluir el archivo de cabecera:

```cpp
#include "dni_utils.h"
```

Una vez hecho esto, ya podemos llamar a las funciones que estén declaradas en él desde nuestro programa.

## Compilación

Para compilar el proyecto, abrimos una terminal en la carpeta principal y ejecutamos el siguiente comando:

```bash
g++ -Iinclude src/dni_utils.cpp client/prueba.cpp -o prueba.exe
```

Con este comando se compilan los archivos de la librería junto con el programa de prueba. El resultado es el ejecutable `prueba.exe`.

## Ejecución

Cuando termine la compilación, podemos ejecutar el programa desde PowerShell con:

```powershell
.\prueba.exe
```