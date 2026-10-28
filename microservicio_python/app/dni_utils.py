def calcula_letra_dni(numero):
    letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE"
    modulo = numero % 23
    return letrasDNI[modulo]