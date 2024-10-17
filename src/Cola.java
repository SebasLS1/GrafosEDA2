import java.util.ArrayList;
public class Cola {
    private ArrayList<Integer> elementos;

    public Cola() {
        elementos = new ArrayList<>();
    }

    public void encolar(int valor) {
        elementos.add(valor);
    }

    public int desencolar() {
        if (!estaVacia()) {
            return elementos.remove(0);
        }
        return -1; // Retorna -1 si la cola está vacía
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }
}
