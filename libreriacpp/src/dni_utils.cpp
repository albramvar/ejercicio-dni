#include <iostream>
#include <string>
#include "dni_utils.h"

using namespace std;

char calcular_letra(int numero)
{
    const string letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    return letras[numero % 23];
}

bool validar_dni(const char *dni)
{
    // Comprobamos que el DNI tenga 9 caracteres
    if (strlen(dni) != 9)
    {
        return false;
    }

    // Extraemos el número del DNI para dejar solo la letra
    int numero = stoi(string(dni, 8));

    // Calculamos la letra que debería tener
    char letra_correcta = calcular_letra(numero);

    // Comparamos la letra calculada con la del DNI
    return dni[8] == letra_correcta;
}