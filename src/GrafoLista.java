import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrafoLista {
    private List<List<Integer>> listaAdyacencia;
    private int numNodos;

    public GrafoLista(int numNodos) {
        this.numNodos = numNodos;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            listaAdyacencia.add(new LinkedList<>());
        }
    }

    public void agregarArista(int origen, int destino) {
        if (origen < numNodos && destino < numNodos) {
            listaAdyacencia.get(origen).add(destino);
            // Para grafos no dirigidos, también agregamos la arista inversa
            listaAdyacencia.get(destino).add(origen);
        } else {
            System.out.println("Nodos fuera de los límites.");
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen < numNodos && destino < numNodos) {
            listaAdyacencia.get(origen).remove((Integer) destino);
            listaAdyacencia.get(destino).remove((Integer) origen);  // Si es no dirigido
        } else {
            System.out.println("Nodos fuera de los límites.");
        }
    }

    public void mostrar() {
        for (int i = 0; i < numNodos; i++) {
            System.out.print(i + ": ");
            for (int destino : listaAdyacencia.get(i)) {
                System.out.print(destino + " ");
            }
            System.out.println();
        }
    }

    public void insertarNodo(int nodosAAgregar) {
        for (int i = 0; i < nodosAAgregar; i++) {
            listaAdyacencia.add(new LinkedList<>());
        }
        numNodos += nodosAAgregar;
        System.out.println("Nodos agregados. Total de nodos: " + numNodos);
        mostrar();  // Mostrar la lista después de agregar nodos
    }
    
    public void eliminarNodo(int nodo) {
        if (nodo < numNodos) {
            listaAdyacencia.remove(nodo);
            for (List<Integer> adyacencias : listaAdyacencia) {
                adyacencias.remove((Integer) nodo);
            }
            numNodos--;
            System.out.println("Nodo " + nodo + " eliminado. Total de nodos: " + numNodos);
            mostrar();  // Mostrar la lista después de eliminar nodos
        } else {
            System.out.println("Ese nodo no existe.");
        }
    }
    

    public void profundidad() {
        long inicioNano = System.nanoTime();
        long inicioMillis = System.currentTimeMillis();
        boolean[] visitados = new boolean[numNodos];
        for (int i = 0; i < numNodos; i++) {
            if (!visitados[i]) {
                recorrerProfundidad(i, visitados);
            }
        }
        long finNano = System.nanoTime();
        long finMillis = System.currentTimeMillis();
        System.out.println("Tiempo en nanoTime: " + (finNano-inicioNano) + " ns");
        System.out.println("Tiempo en currentMillis: " + (finMillis-inicioMillis) + " ms");
    }
    private void recorrerProfundidad(int v, boolean[] visitados) {
        visitados[v] = true;
        System.out.println("Visitando nodo: " + v);
        for (int adyacente : listaAdyacencia.get(v)) {
            if (!visitados[adyacente]) {
                recorrerProfundidad(adyacente, visitados);
            }
        }
    }
    public void amplitud() {
        long inicioNano = System.nanoTime();
        long inicioMillis = System.currentTimeMillis();
        boolean[] visitados = new boolean[numNodos];
        Cola cola = new Cola();
        for (int i = 0; i < numNodos; i++) {
            if (!visitados[i]) {
                cola.encolar(i);
                visitados[i] = true;
                while (!cola.estaVacia()) {
                    int v = cola.desencolar();
                    System.out.println("Visitando nodo: " + v);
                    for (int adyacente : listaAdyacencia.get(v)) {
                        if (!visitados[adyacente]) {
                            cola.encolar(adyacente);
                            visitados[adyacente] = true;
                        }
                    }
                }
            }
        }
        long finNano = System.nanoTime();
        long finMillis = System.currentTimeMillis();
        System.out.println("Tiempo en nanoTime: " + (finNano-inicioNano) + " ns");
        System.out.println("Tiempo en currentMillis: " + (finMillis-inicioMillis) + " ms");
    }

}
