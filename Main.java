public class Main {

    public static void main(String[] args) {
        ejecutarDesafio1y2();
        ejecutarDesafio3();
    }

    private static void ejecutarDesafio1y2() {
        System.out.println("DESAFIO 1 El codigo fragmentado");
        int[] bloques = {84729, 56318, 92746};
        StringBuilder clave1 = new StringBuilder();
        for (int bloque : bloques) {
            int resultado = Desafio1.reducirAUnDigito(bloque);
            System.out.println(bloque + " -> " + resultado);
            clave1.append(resultado);
        }
        System.out.println("CLAVE 1: " + clave1);

        System.out.println();
        System.out.println(" DESAFIO 2 El radar de emergencia");
        int[] lecturas = {
                418, 732, 156, 894, 327, 641, 285, 519,
                763, 204, 947, 386, 675, 128, 856, 493
        };
        int clave2 = Desafio2.maximoDivideYVenceras(lecturas);
        System.out.println("Valor maximo encontrado: " + clave2);
        System.out.println("CLAVE 2: " + clave2);

        System.out.println();
        System.out.println("=== ACCESO AL SISTEMA ===");
        String contrasena = clave1 + "-" + clave2;
        System.out.println("Contrasena generada: " + contrasena);
    }

    private static void ejecutarDesafio3() {
        System.out.println();
        System.out.println(" DESAFIO 3 La ruta de escape ");

        char[][] caso1 = {
                {'S', '.', '.', 'E'}
        };
        ejecutarCaso("CASO 1 - Ruta directa", caso1);

        char[][] caso2 = {
                {'S', '.', '.'},
                {'.', '#', '.'},
                {'.', '#', 'E'}
        };
        ejecutarCaso("CASO 2 - Callejon sin salida", caso2);

        char[][] caso3 = {
                {'S', '.', '.', '.', '.'},
                {'.', '#', '#', '#', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '#', '#', '#', '.'},
                {'.', '.', '.', '.', 'E'}
        };
        ejecutarCaso("CASO 3 - Varias rutas", caso3);

        char[][] caso4 = {
                {'S', '.', '.', '.', 'E'},
                {'.', '#', '#', '#', '.'},
                {'.', '.', '.', '.', '.'}
        };
        ejecutarCaso("CASO 4 - Primera ruta no es la mas corta", caso4);

        char[][] caso5 = {
                {'S', '.', '.'},
                {'#', '#', '#'},
                {'.', '.', 'E'}
        };
        ejecutarCaso("CASO 5 - Sin solucion", caso5);
    }

    private static void ejecutarCaso(String titulo, char[][] maze) {
        System.out.println();
        System.out.println("--- " + titulo + " ---");
        Laberinto laberinto = new Laberinto(maze);
        Laberinto.ResultadoLaberinto resultado = laberinto.resolver();
        resultado.imprimir();
    }
}