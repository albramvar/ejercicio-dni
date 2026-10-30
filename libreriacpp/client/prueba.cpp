#include <iostream>
#include "../src/dni_utils.h"

using namespace std;

int main() {

    int numero;
    char dni[10];

    cout << "Introduce el numero del DNI: ";
    cin >> numero;

    char letra = calcular_letra(numero);

    cout << "La letra correspondiente es: " << letra << endl;

    cout << "\nIntroduce el DNI completo: ";
    cin >> dni;

    if (validar_dni(dni)) {
        cout << "El DNI es correcto." << endl;
    }
    else {
        cout << "El DNI no es correcto." << endl;
    }

    return 0;
}