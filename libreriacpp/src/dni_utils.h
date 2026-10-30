#ifndef HELPERS_H
#define HELPERS_H

#include <string>

/**
 * @brief Calcula la letra correspondiente a un número de DNI
 *
 * @param numero Número del DNI
 * @return Letra correspondiente al DNI
 */
char calcular_letra(int numero);

/**
 * @brief Comprueba si un DNI completo es válido
 *
 * @param dni Cadena de caracteres con el DNI completo
 * @return true si el DNI es válido, false en caso contrario
 */
bool validar_dni(const char* dni);

#endif