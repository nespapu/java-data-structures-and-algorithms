package AlgoritmosDeBusqueda;
/**
 * El método QuickSort utiliza la estrategia de divide y vencerás.
 * El algoritmo contiene los siguientes pasos:
 * 1. Divide: partir el conjunto en dos: 1er elemento a pivote - 1 y pivote + 1 a último elemento.
 * 2. Resolver: ordenar los elementos conforme al pivote.
 * 3. Combinar: este método no tiene necesidad de combinar las soluciones porque las divisiones ya están ordenadas.
 * 
 * El pivote es la posición elegida cuyo elemento se utiliza para ordenar elementos a izquierda y derecha.
 * 
 * El algoritmo es recursivo: su caso base es cuando la dimensión del array a ordenar es 1.
 */
public class QuickSort {
    public static void main (String[] args) {
        int[] conjunto = {7, 2, 9, 1, 6, 3, 10, 4, 8, 5};

        // Imprimir conjunto desordenado
        for  (int i=0; i<conjunto.length - 1; i++) {
            System.out.print(conjunto[i] + ", ");
        }
        System.out.println(conjunto[conjunto.length-1]);

        ordenarMayorMenor(conjunto, 0, conjunto.length -1);
        //ordenarMenorMayor(conjunto, 0, conjunto.length - 1);

        // Imprimir conjunto ordenado
        for  (int i=0; i<conjunto.length - 1; i++) {
            System.out.print(conjunto[i] + ", ");
        }
        System.out.println(conjunto[conjunto.length-1]);
    }

    public static void ordenarMenorMayor (int[] conjunto, int inicio, int fin) {
        if ( inicio >= fin) {// Si la dimensión del conjunto es uno
            return;
        }
        int pivote = resolverMenorMayor(conjunto, inicio, fin);
        ordenarMenorMayor(conjunto, inicio, pivote - 1);
        ordenarMenorMayor(conjunto, pivote + 1, fin);
    }

    /*
     * Devuelve la posición del pivote y ordena los elementos del conjunto respecto al pivote
     */
    private static int resolverMenorMayor(int[] conjunto, int inicio, int fin) {
        // La elección del pivote afecta al tiempo de ejecución del problema y
        // no existe una solución perfecta, depende de los valores del conjunto.
        int pivote = conjunto[fin];
        int ultima = inicio - 1;
        int temp;
        for (int k=inicio; k<fin; k++){
            if (conjunto[k] < pivote) {
                ultima++;
                temp = conjunto[k];
                conjunto[k] = conjunto[ultima];
                conjunto[ultima] = temp;
            }
        }
        //Colocamos el pivote en su posición
        ultima++;
        temp = conjunto[ultima];
        conjunto[ultima] = pivote;
        conjunto[fin] = temp;
        return ultima; 
    }

    public static void ordenarMayorMenor (int[] conjunto, int inicio, int fin) {
        // Si la dimensión del conjunto es uno
        if ( inicio >= fin) {
            return;
        }
        int pivote = resolverMayorMenor(conjunto, inicio, fin);
        ordenarMayorMenor(conjunto, inicio, pivote - 1);
        ordenarMayorMenor(conjunto, pivote + 1, fin);
    }

    /*
     * Devuelve la posición del pivote y ordena los elementos del conjunto respecto al pivote
     */
    private static int resolverMayorMenor(int[] conjunto, int inicio, int fin) {
        // La elección del pivote afecta al tiempo de ejecución del problema y
        // no existe una solución perfecta, depende de los valores del conjunto.
        int pivote = conjunto[fin];
        int ultima = inicio - 1;
        int temp;
        for (int k=inicio; k<fin; k++){
            if (conjunto[k] > pivote) {
                ultima++;
                temp = conjunto[k];
                conjunto[k] = conjunto[ultima];
                conjunto[ultima] = temp;
            }
        }
        //Colocamos el pivote en su posición
        ultima++;
        temp = conjunto[ultima];
        conjunto[ultima] = pivote;
        conjunto[fin] = temp;
        return ultima; 
    }
    
}