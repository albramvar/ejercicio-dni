import src.main.java.com.example.DniUtils;

public class Main {
    private static final String DNI_NUMERO = "00000000";
    private static final String DNI_LETRA = "T";

    static void main(String[] args) {
        System.out.println("Prueba positiva:\nValor esperado: T\tValor obtenido: " + DniUtils.calcularLetra(Integer.parseInt(DNI_NUMERO)));
        try {
            DniUtils.calcularLetra(100000000);
        } catch (IllegalArgumentException e) {
            System.out.println("Prueba negativa:\nValor esperado: IllegalArgumentException");
        } catch (Exception e) {
            System.out.println("Prueba negativa:\nValor esperado: IllegalArgumentException\tValor obtenido: " + e.getStackTrace());
        }

        System.out.println("Prueba positiva:\nValor esperado: true\tValor obtenido: " + DniUtils.validarDni(DNI_NUMERO + DNI_LETRA));
        System.out.println("Prueba negativa:\nValor esperado: false\tValor obtenido: " + DniUtils.validarDni(DNI_NUMERO + "A"));
        try {
            DniUtils.validarDni("A");
        } catch (IllegalArgumentException e) {
            System.out.println("Prueba negativa:\nValor esperado: IllegalArgumentException");
        } catch (Exception e) {
            System.out.println("Prueba negativa:\nValor esperado: IllegalArgumentException\tValor obtenido: " + e.getStackTrace());
        }
        try {
            DniUtils.validarDni("AAAAAAAAA");
        } catch (IllegalArgumentException e) {
            System.out.println("Prueba negativa:\nValor esperado: IllegalArgumentException");
        } catch (Exception e) {
            System.out.println("Prueba negativa:\nValor esperado: IllegalArgumentException\tValor obtenido: " + e.getStackTrace());
        }
    }
}