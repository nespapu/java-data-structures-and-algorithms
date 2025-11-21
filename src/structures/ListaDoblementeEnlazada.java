public class ListaDoblementeEnlazada<T extends Comparable<T>> {
    // Clase interna para modelar un nodo de la lista
    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;

        public Nodo (T valor) {
            this.valor = valor;
        }
    }

    // Propiedades
    Nodo primero;
    int contador;

    // Constructores
    public ListaDoblementeEnlazada () {
        contador = 0;
    }

    // Métodos
    public void insertarPrimeraPosicion (T valor) {
        Nodo aux = new Nodo(valor);
        if (primero == null) {
            primero = aux;
        } else {
            aux.siguiente = primero;
            primero.anterior = aux;
            primero = aux;
        }
        contador++;
    }

    public void insertarUltimaPosicion (T valor) {
        if (primero == null) {
            insertarPrimeraPosicion(valor);
        } else {
            Nodo ultimo = getUltimaPosicion();
            Nodo nuevo = new Nodo(valor);
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        contador++;
    }

    public void insertarSegundaPosicion (T valor) {
        if (estaVacia()) {
            return;
        }
        Nodo segundo = primero.siguiente;
        Nodo nuevo = new Nodo(valor);
        nuevo.anterior = primero;
        nuevo.siguiente = segundo;
        primero.siguiente = nuevo;
        if (segundo != null) { // si la lista solo tiene un elemento
            segundo.anterior = nuevo; 
        }
        contador++;       
    }

    public void insertarPenultimaPosicion (T valor) {
        if (estaVacia()) {
            insertarPrimeraPosicion(valor);
        } else {
            Nodo ultimo = getUltimaPosicion();
            Nodo penultimo = ultimo.anterior;
            if (penultimo == null) { // Solo había un nodo en la lista, entonces el nuevo nodo pasa a ser el 1ero de la lista
               insertarPrimeraPosicion(valor);
            } else {
                Nodo nuevo = new Nodo(valor);
                nuevo.anterior = penultimo;
                nuevo.siguiente = ultimo;
                penultimo.siguiente = nuevo;
                ultimo.anterior = nuevo;
            }
        }
        contador++;
    }

    public void borrarPrimeraPosicion () {
        if (primero != null) {
            primero = primero.siguiente;
            if (primero != null) {
                primero.anterior = null;
            }
            contador--;
        }
    }

    public void borrarSegundaPosicion () {
        if (tamanyo() >= 2) {
            Nodo segundo = primero.siguiente;
            Nodo tercero = segundo.siguiente;
            primero.siguiente = tercero;
            if (tercero != null) {
                tercero.anterior = primero;
            }
            contador--;
        }
    }

    public void borrarUltimaPosicion () {
        if (!estaVacia()) {
            Nodo ultimo = getUltimaPosicion();
            if (ultimo.anterior == null) { // La lista tenía un único elemento
                borrarPrimeraPosicion();
            } else {
                Nodo penultimo = ultimo.anterior;
                ultimo.anterior = null;
                penultimo.siguiente = null;
            }
            contador--;
        }
    }

    public void borrarPosicionMayorValor () {
        if (estaVacia()) {
            return;
        }
        if (tamanyo() == 1) {
            borrarPrimeraPosicion();
            return;
        }
        Nodo aux = primero;
        Nodo mayor = primero;
        while (aux != null) {
            if (aux.valor.compareTo(mayor.valor) > 0) {
                mayor = aux;
            }
            aux = aux.siguiente;
        }

        if (mayor == primero) {
            borrarPrimeraPosicion();
        } else if (mayor.siguiente == null) {
            borrarUltimaPosicion();
        } else {
            Nodo anterior = mayor.anterior;
            Nodo siguiente = mayor.siguiente;
            anterior.siguiente = siguiente;
            siguiente.anterior = anterior;
            contador--;
        }
    }

    public boolean estaVacia () {
        return contador == 0;
    }

    public int tamanyo () {
        return contador;
    }

    private Nodo getUltimaPosicion () {
        Nodo ultimo = primero;
        while (ultimo.siguiente != null) {
            ultimo = ultimo.siguiente;
        }
        return ultimo;
    }
}
