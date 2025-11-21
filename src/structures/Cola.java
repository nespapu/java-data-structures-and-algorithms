public class Cola<T> {

    private class Nodo {
        T valor;
        Nodo siguiente;

        public Nodo ( T valor ) {
            this.valor = valor;
        }
    }

    private Nodo cabeza = null;
    private Nodo fin = null;
    private int contador = 0;

    // Añadir elemento al final de la cola
    public void encolar ( T valor ) {
        Nodo aux = new Nodo (valor);
        if( cabeza == null ) {
            cabeza = aux;
            fin = aux;
        } else {
            fin.siguiente = aux;
            fin = aux;
        }
        contador++;
    }

    // Eliminar el elemento a la cabeza de la cola
    public T desencolar ( ) {
        T aux = null;
        if ( cabeza != null ) {
            aux = cabeza.valor;
            cabeza = cabeza.siguiente;
            if (cabeza == null) {
                fin = null;
            }
            contador--;
        }
        return aux;
    }

    // Devolver el valor del elemento a la cabeza de la cola
    public T peek ( ) {
        T aux = null;
        if ( cabeza != null ) {
            aux = cabeza.valor;
        }
        return aux;
    }

    // Comprobar si la cola esta vacia
    public boolean estaVacia () {
        return contador == 0;
    }

    // Devolver el número de elementos de la cola
    public int tamanyo () {
        return contador;
    }

    public void mostrarCola ( ) {
        if (cabeza == null) {
            System.out.println("La cola está vacía");
            return;
        }
        Nodo aux = cabeza;
        while ( aux.siguiente != null ) {
            System.out.print ( aux.valor + "->" );
            aux = aux.siguiente;
        }
        System.out.println ( fin.valor );
    }

    public static void main ( String[] args ) {
        Cola<Integer> cola = new Cola<> ( );
        assert cola.estaVacia() == true;
        
        cola.encolar ( 1 );
        cola.encolar ( 2);
        cola.encolar ( 3 );
        cola.encolar ( 4 );
        cola.mostrarCola ( );
        assert cola.tamanyo() == 4;

        assert cola.desencolar().equals(1);
        assert cola.tamanyo() == 3;
        cola.mostrarCola ( );

        assert cola.peek().equals(2);
        assert cola.tamanyo() == 3;
    }
}