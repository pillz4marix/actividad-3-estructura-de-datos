import java.util.ArrayList;
import java.util.List;

public class Laberinto {

    private static final int[][] DIRECCIONES = {
            {-1, 0}, //arriba
            {1, 0},  //abajo
            {0, -1}, //izquierda
            {0, 1}   //derecha
    };

    private final char[][] grid;
    private final int filas;
    private final int columnas;

    private boolean[][] visitado;
    private List<int[]> rutaActual;
    private List<int[]> mejorRuta;
    private int mejorLongitud;

    private List<int[]> posicionesExploradas; //orden cronologico de exploracion
    private int retrocesos;
    private int estados;

    public Laberinto(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("El laberinto no puede estar vacío");
        }
        this.grid = grid;
        this.filas = grid.length;
        this.columnas = grid[0].length;
    }

    private int[] encontrar(char simbolo) {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (grid[f][c] == simbolo) {
                    return new int[]{f, c};
                }
            }
        }
        return null;
    }

    public ResultadoLaberinto resolver() {
        int[] inicio = encontrar('S');
        int[] salida = encontrar('E');

        visitado = new boolean[filas][columnas];
        rutaActual = new ArrayList<>();
        mejorRuta = null;
        mejorLongitud = Integer.MAX_VALUE;
        posicionesExploradas = new ArrayList<>();
        retrocesos = 0;
        estados = 0;

        if (inicio == null || salida == null) {
            //no hay inicio o salida definidos
            return new ResultadoLaberinto(posicionesExploradas, null, retrocesos, estados);
        }

        backtrack(inicio[0], inicio[1], salida[0], salida[1]);

        return new ResultadoLaberinto(posicionesExploradas, mejorRuta, retrocesos, estados);
    }

    private void backtrack(int fila, int col, int filaSalida, int colSalida) {
        estados++;

        visitado[fila][col] = true;
        rutaActual.add(new int[]{fila, col});
        posicionesExploradas.add(new int[]{fila, col});
        boolean podada = (rutaActual.size() - 1) >= mejorLongitud;

        if (!podada) {
            if (fila == filaSalida && col == colSalida) {
                //llego a la salida y se registra si es mejor que la actual
                int longitudActual = rutaActual.size() - 1; //numero de movimientos
                if (longitudActual < mejorLongitud) {
                    mejorLongitud = longitudActual;
                    mejorRuta = new ArrayList<>();
                    for (int[] paso : rutaActual) {
                        mejorRuta.add(paso.clone());
                    }
                }
            } else {
                // Probar todas las direcciones posibles desde esta posición.
                for (int[] dir : DIRECCIONES) {
                    int nuevaFila = fila + dir[0];
                    int nuevaCol = col + dir[1];
                    if (esValido(nuevaFila, nuevaCol)) {
                        backtrack(nuevaFila, nuevaCol, filaSalida, colSalida);
                    }
                }
            }
        }

        rutaActual.remove(rutaActual.size() - 1);
        visitado[fila][col] = false;
        retrocesos++;
    }

    private boolean esValido(int fila, int col) {
        if (fila < 0 || fila >= filas || col < 0 || col >= columnas) {
            return false; //fuera del laberinto
        }
        if (grid[fila][col] == '#') {
            return false; //obstaculo
        }
        return !visitado[fila][col]; // evita ciclos
    }

    public static class ResultadoLaberinto {
        public final List<int[]> posicionesExploradas;
        public final List<int[]> rutaMasCorta; //null si no existe solucion
        public final int retrocesos;
        public final int estados;

        public ResultadoLaberinto(List<int[]> posicionesExploradas, List<int[]> rutaMasCorta,
                                   int retrocesos, int estados) {
            this.posicionesExploradas = posicionesExploradas;
            this.rutaMasCorta = rutaMasCorta;
            this.retrocesos = retrocesos;
            this.estados = estados;
        }

        public void imprimir() {
            for (int[] p : posicionesExploradas) {
                System.out.println(p[0] + "," + p[1]);
            }
            System.out.println();

            if (rutaMasCorta == null) {
                System.out.println("RUTA: NO EXISTE SOLUCION");
            } else {
                StringBuilder sb = new StringBuilder("RUTA:");
                for (int i = 0; i < rutaMasCorta.size(); i++) {
                    int[] p = rutaMasCorta.get(i);
                    sb.append(p[0]).append(",").append(p[1]);
                    if (i < rutaMasCorta.size() - 1) {
                        sb.append(";");
                    }
                }
                System.out.println(sb.toString());
            }

            System.out.println();
            System.out.println("METRICAS:retrocesos=" + retrocesos + ";estados=" + estados);
        }
    }
}