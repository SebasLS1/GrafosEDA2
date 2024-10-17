
public class GrafoMatriz {

    private boolean[][] matriz;
    private int nodosMax;
    private int numNodos;

    public  GrafoMatriz (int nodosMax){
        this.nodosMax= nodosMax;
        matriz= new boolean [nodosMax][nodosMax];
        this.numNodos= nodosMax;
    }
    public void agregarArista(int origen, int destino){
        matriz[origen][destino]=true;
    }

    public void eliminarArista(int origen, int destino){
        matriz[origen][destino]= false;
    }
    public void mostrar(){
        for(boolean[] fila: matriz){
            for(boolean valor : fila){
                System.out.print((valor ? 1:0) + " ");
            }
            System.err.println("");
        }
    }

    public void insertarNodo(int nodosAAgregar) {
        int nuevoTamaño = numNodos + nodosAAgregar;
        // Aquí actualizamos nodosMax para que se ajuste al nuevo tamaño
        nodosMax = Math.max(nodosMax, nuevoTamaño);
        boolean[][] nuevaMatriz = new boolean[nuevoTamaño][nuevoTamaño];
        // Copia la matriz antigua en la nueva
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                nuevaMatriz[i][j] = matriz[i][j];
            }
        }
        matriz = nuevaMatriz;
        numNodos = nuevoTamaño;
        System.out.println("Nodos agregados. Total de nodos: " + numNodos);
    }
    

    public void eliminarNodo(int nodo){
        if (nodo < numNodos) {
            // Elimina las aristas conectadas al nodo
            for (int i = 0; i < numNodos; i++) {
                matriz[nodo][i] = false;
                matriz[i][nodo] = false;
            }
            // Crea una nueva matriz sin el nodo eliminado
            boolean[][] nuevaMatriz = new boolean[numNodos - 1][numNodos - 1];
            for (int i = 0, ni = 0; i < numNodos; i++) {
                if (i == nodo) continue;  // Salta el nodo eliminado
                for (int j = 0, nj = 0; j < numNodos; j++) {
                    if (j == nodo) continue;  // Salta el nodo eliminado
                    nuevaMatriz[ni][nj] = matriz[i][j];
                    nj++;
                }
                ni++;
            }
            matriz = nuevaMatriz;
            numNodos--;
            System.out.println("Nodo " + nodo + " eliminado. Total de nodos: " + numNodos);
        } else {
            System.out.println("Ese nodo no existe");
        }
    }
}
