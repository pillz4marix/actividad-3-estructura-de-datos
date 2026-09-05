public class Desafio1 {

    public static int sumarDigitos(int n) {
        n = Math.abs(n);
        if (n == 0) {
            return 0; //caso base
        }
        return (n % 10) + sumarDigitos(n / 10); //caso recursivo
    }

    public static int reducirAUnDigito(int n) {
        n = Math.abs(n);
        if (n < 10) {
            return n; //caso base
        }
        return reducirAUnDigito(sumarDigitos(n)); //caso recursivo
    }
}