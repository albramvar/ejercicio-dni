package src.main.java.com.example;

/**
 * Auxiliary library class to validate DNIs
 * Default constructor
 */
public class DniUtils {
    /**
     * List of letters used in DNI validation, ordered by its modulo 23 correspondence
     */
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    /**
     * Default constructor
     */
    public DniUtils() {
        super();
    }

    /**
     * Given a DNI number the method returns the corresponding letter
     * @param numero a maximum 8 digit number
     * @return the validation character
     * @throws IllegalArgumentException if the number exceeds the 8 digit limit
     * @since 1.0
     */
    public static char calcularLetra(int numero) throws IllegalArgumentException {
        if (String.valueOf(numero).length() > 8)
            throw new IllegalArgumentException();

        int modulo = numero % 23;
        return LETRAS_DNI.charAt(modulo);
    }

    /**
     * Given a complete DNI the method returns a boolean that corresponds to the validity of its letter
     * @param dni A 9-char string that must follow the format 00000000A
     * @return the validity of its letter
     * @throws IllegalArgumentException if either the length is not 9 or the first 8 characters cannot be converted to a number
     * @since 1.0
     */
    public static boolean validarDni(String dni) {
        if (dni.length() != 9)
            throw new IllegalArgumentException();

        int dni_numero;
        try {
            dni_numero = Integer.parseInt(dni.substring(0,8));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        char dni_letra = dni.charAt(8);

        return dni_letra == calcularLetra(dni_numero);
    }
}