public class Pila<T> {

    private class Nodo {
        T valor;
        Nodo siguiente;

        public Nodo ( T valor ) {
            this.valor = valor;
        }
    }

    private Nodo cima = null;
    private int contador = 0;

    // Añadir un nuevo elemento a la cima
    public void push ( T valor ) {
        Nodo aux = new Nodo(valor);
        aux.siguiente = cima;
        cima = aux;
        contador++;
    }

    // Eliminar el elemento actual de la cima devolviendo su valor
    public T pop ( ) {
        T aux = null;
        if ( cima != null ) {
            aux = cima.valor;
            cima = cima.siguiente;
            this.contador--;
        }
        return aux;
    }

    // Devolver el valor del elemento actual de la cima
    public T peek ( ) {
        T aux = null;
        if ( cima != null ) {
            aux = cima.valor;
        }
        return aux;
    }

    public boolean estaVacia () {
        return cima == null;
    }

    public int tamanyo () {
        return this.contador;
    }

    public void mostrarPila ( ) {
        Nodo aux = cima;

        if (aux == null) {
            System.out.println("Pila vacía");
            return;
        }

        while ( aux.siguiente != null ) {
            System.out.println ( "| " + aux.valor + " |" );
            aux = aux.siguiente;
        }
        System.out.println ( "| " + aux.valor + " |" );
    }

    public static void main ( String[] args ) {
        Pila<Integer> pila = new Pila<>( );
        assert pila.estaVacia() == true;
        
        pila.push ( 1 );
        pila.push ( 2 );
        pila.push ( 3 );
        assert pila.tamanyo() == 3;

        pila.mostrarPila ( );

        pila.pop ( );
        pila.mostrarPila ( );
        assert pila.tamanyo () == 2;

        assert pila.peek().equals(2);
        assert pila.tamanyo() == 2;
    }
}