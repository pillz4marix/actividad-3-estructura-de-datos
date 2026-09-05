public class Desafio2 {

    public static int maximoDivideYVenceras(int[] datos) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }
        return maximoRec(datos, 0, datos.length - 1);
    }

    private static int maximoRec(int[] datos, int inicio, int fin) {
        //caso base: un solo elemento en el rango, es el máximo de sí mismo.
        if (inicio == fin) {
            return datos[inicio];
        }

        //caso base: dos elementos, se comparan directamente
        if (fin - inicio == 1) {
            return Math.max(datos[inicio], datos[fin]);
        }

        //dividir
        int medio = inicio + (fin - inicio) / 2;

        //resolver
        int maxIzquierda = maximoRec(datos, inicio, medio);
        int maxDerecha = maximoRec(datos, medio + 1, fin);

        //combinar
        return Math.max(maxIzquierda, maxDerecha);
    }
}