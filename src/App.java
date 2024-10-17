import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        int opcion = 0;
        int numNodos = 0;
        int aristas = 0;
        int origen = 0;
        int destino = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese ¿Qué tipo de grafo quiere?");
        System.out.println("0. Matriz");
        System.out.println("1. Lista");
        opcion = scanner.nextInt();
        System.out.println("Ingrese el número de nodos que desea");
        numNodos = scanner.nextInt();

        switch (opcion) {
            case 0:
                GrafoMatriz grafo = new GrafoMatriz(numNodos);
                System.out.println("Ingrese el número de aristas");
                aristas = scanner.nextInt();
                for (int i = 0; i < aristas; i++) {
                    System.out.println("Ingrese el origen y el destino de la arista (origen y luego destino)");
                    origen = scanner.nextInt();
                    destino = scanner.nextInt();
                    grafo.agregarArista(origen, destino);
                }
                System.out.println("Matriz:");
                grafo.mostrar();


                boolean continuar = true;
                while (continuar) {
                    System.out.println("Ingrese:");
                    System.out.println("1. Si quiere agregar nodos");
                    System.err.println("2. Si quiere eliminar nodos");
                    System.out.println("3. Desea hacer el recorrido en profundidad");
                    System.out.println("4. Desea hacer el recorrido en anchura");
                    System.out.println("5. Salir");
                    int opcionMatriz = scanner.nextInt();
                    switch (opcionMatriz) {
                        case 1:
                            System.out.println("Ingrese el número de nodos a agregar:");
                            int nodosAAgregar = scanner.nextInt();
                            grafo.insertarNodo(nodosAAgregar);
                            manejarAristas(scanner, grafo);
                            break;
                        case 2:
                            System.out.println("Ingrese el nodo a eliminar:");
                            int nodoEliminar = scanner.nextInt();
                            grafo.eliminarNodo(nodoEliminar);
                            manejarAristas(scanner, grafo);
                            break;
                        case 3:
                        System.out.println("Recorrido en profundidad (DFS): ");
                        grafo.profundidad();
                        break;
                        case 4:
                        System.out.println("Recorrido en amplitud (BFS):");
                        grafo.amplitud();
                        break;
                        case 5:
                            continuar = false;
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                }
                break;

            case 1:
               
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
    }
// Función para manejar la inserción o eliminación de aristas
public static void manejarAristas(Scanner scanner, GrafoMatriz grafo) {
    System.out.println("¿Desea agregar o eliminar aristas?");
    System.out.println("1. Agregar arista");
    System.out.println("2. Eliminar arista");
    System.out.println("3. No hacer nada");

    int opcion = scanner.nextInt();

    while (opcion == 1 || opcion == 2) {
        if (opcion == 1) {
            System.out.println("Ingrese el origen y el destino de la arista:");
            int origen = scanner.nextInt();
            int destino = scanner.nextInt();
            grafo.agregarArista(origen, destino);
        } else if (opcion == 2) {
            System.out.println("Ingrese el origen y el destino de la arista a eliminar:");
            int origen = scanner.nextInt();
            int destino = scanner.nextInt();
            grafo.eliminarArista(origen, destino);
        }

        System.out.println("Matriz actualizada:");
        grafo.mostrar();  // Mostrar la matriz después de cada operación

        System.out.println("¿Desea seguir agregando o eliminando aristas?");
        System.out.println("1. Agregar arista");
        System.out.println("2. Eliminar arista");
        System.out.println("3. No hacer nada");
        opcion = scanner.nextInt();
    }

    System.out.println("Operación de aristas finalizada.");
    System.out.println("Matriz final:");
    grafo.mostrar();  // Mostrar la matriz una vez que termina la operación con aristas
}
}

