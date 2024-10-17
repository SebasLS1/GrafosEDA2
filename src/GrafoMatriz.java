
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
        nodosMax = Math.max(nodosMax, nuevoTamaño);
        boolean[][] nuevaMatriz = new boolean[nuevoTamaño][nuevoTamaño];
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                nuevaMatriz[i][j] = matriz[i][j];
            }
        }
        matriz = nuevaMatriz;
        numNodos = nuevoTamaño;
        System.out.println("Nodos agregados. Total de nodos: " + numNodos);
        mostrar();  // Mostrar la matriz después de agregar nodos
    }
    
    public void eliminarNodo(int nodo) {
        if (nodo < numNodos) {
            for (int i = 0; i < numNodos; i++) {
                matriz[nodo][i] = false;
                matriz[i][nodo] = false;
            }
            boolean[][] nuevaMatriz = new boolean[numNodos - 1][numNodos - 1];
            for (int i = 0, ni = 0; i < numNodos; i++) {
                if (i == nodo) continue;
                for (int j = 0, nj = 0; j < numNodos; j++) {
                    if (j == nodo) continue;
                    nuevaMatriz[ni][nj] = matriz[i][j];
                    nj++;
                }
                ni++;
            }
            matriz = nuevaMatriz;
            numNodos--;
            System.out.println("Nodo " + nodo + " eliminado. Total de nodos: " + numNodos);
            mostrar();  // Mostrar la matriz después de eliminar nodos
        } else {
            System.out.println("Ese nodo no existe.");
        }
    }
    

    public boolean existeArista(int origen, int destino){
        return matriz[origen][destino];
    }

    public void profundidad(){
        boolean[] visitados= new boolean[numNodos];
        for (int i=0; i<numNodos; i++){
            visitados[i]=false;
        }
        for(int i=0; i<numNodos; i++){
            if(!visitados[i]){
                recorrerProfundidad(i, visitados);
            }
        }
    }

    public void recorrerProfundidad(int v, boolean[]visitados){
        visitados[v]=true;
        System.out.println("Visitando nodo: "+v);
        for (int i=0; i<numNodos; i++){
            if (!visitados[i]&&existeArista(v, i)){
                System.out.println("Ir de " + v + " a " + i);
                recorrerProfundidad(i, visitados);
            }
        }
    }
 
    public void amplitud() {
        boolean[] visitados = new boolean[numNodos];
        for (int i = 0; i < numNodos; i++) {
            visitados[i] = false;
        }

        Cola cola = new Cola();

        for (int i = 0; i < numNodos; i++) {
            if (!visitados[i]) {
                cola.encolar(i);
                visitados[i] = true;

                while (!cola.estaVacia()) {
                    int v = cola.desencolar();
                    System.out.println("Visitando nodo: " + v);

                    for (int j = 0; j < numNodos; j++) {
                        if ((v != j) && existeArista(v, j) && !visitados[j]) {
                            cola.encolar(j);
                            visitados[j] = true;
                        }
                    }
                }
            }
        }
    }



}
