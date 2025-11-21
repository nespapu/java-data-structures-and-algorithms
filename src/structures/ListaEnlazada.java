public class ListaEnlazada <T> {
    
    private class Nodo {
        T valor;
        Nodo siguiente;

        public Nodo ( T valor ){
            this.valor = valor;
        }
    }

    private Nodo primero = null;
    private int contador = 0;

    //Insertar un elemento al principio de la lista
    public void insertarPrimero ( T valor ) {
        Nodo aux = new Nodo(valor);
        aux.siguiente = primero;
        primero = aux;
        contador++;
    }

    //Insertar un elemento al final de la lista
    public void insertarUltimo ( T valor ) {
        if ( primero == null ) {
            primero = new Nodo(valor);
        } else {
            Nodo aux = primero;
            while ( aux.siguiente != null ){
                aux = aux.siguiente;
            }
            aux.siguiente = new Nodo(valor);
        }
        contador++;
    }

    //Eliminar el primer nodo de la lista
    public void eliminarPrimero ( ) {
        if (primero != null) {
            primero = primero.siguiente;
            contador--;
        }
    }

    // Comprobar si está vacía
    public boolean estaVacia () {
        return contador == 0;
    }

    // Devolver número de elementos de la lista
    public int tamanyo () {
        return contador;
    }

    //Mostar los elementos de la lista
    public void mostrarElementos ( ) {
        if (primero == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Nodo aux = primero;
        while ( aux.siguiente != null ) {
            System.out.print ( aux.valor + " -> " );
            aux = aux.siguiente;
        }
        System.out.print ( aux.valor );
    }

    public static void main ( String[] args ) {
        ListaEnlazada<Integer> lista = new ListaEnlazada <> ( );
        lista.insertarPrimero ( 1 );
        lista.insertarUltimo (  2 );
        lista.mostrarElementos ();
    }

}