package AlgoritmosDeBusqueda;

public class MergeSort {
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
        if (inicio >= fin) { //Caso base: dimensión del arreglo es 1
            return;
        }
        int mitad = (fin - inicio) / 2;
        ordenarMenorMayor(conjunto, inicio, inicio + mitad);
        ordenarMenorMayor(conjunto, inicio + mitad + 1, fin);
        combinar(conjunto, inicio, mitad, fin);
    }

    private static void combinar (int[] conjunto, int inicio, int mitad, int fin) {
        int dimension = fin - inicio + 1;
        int[] izquierda = (dimension % 2 == 0) ? new int[dimension / 2] : new int[(dimension / 2) + 1];
        int[] derecha = new int[dimension / 2];

        for(int i=0; i<izquierda.length; i++) {
            izquierda[i] = conjunto[inicio + i];
        }

        for(int i=0; i<derecha.length; i++) {
            derecha[i] = conjunto[inicio + mitad + i + 1];
        }

        int i=0;
        int j=0;
        int k=inicio;

        while (i<izquierda.length && j<derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                conjunto[k] = izquierda[i];
                i++;
            }else {
                conjunto[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i<izquierda.length) {
            conjunto[k] = izquierda[i];
            k++;
            i++; 
        }

        while (j<derecha.length) {
            conjunto[k] = derecha[j];
            k++;
            j++;
        }
    }

    public static void ordenarMayorMenor (int[] conjunto, int inicio, int fin) {
        if (inicio >= fin) { //Caso base: dimensión del arreglo es 1
            return;
        }
        int mitad = (fin - inicio) / 2;
        ordenarMayorMenor(conjunto, inicio, inicio + mitad);
        ordenarMayorMenor(conjunto, inicio + mitad + 1, fin);
        combinarMayorMenor(conjunto, inicio, mitad, fin);
    }

    private static void combinarMayorMenor (int[] conjunto, int inicio, int mitad, int fin) {
        int dimension = fin - inicio + 1;
        int[] izquierda = (dimension % 2 == 0) ? new int[dimension / 2] : new int[(dimension / 2) + 1];
        int[] derecha = new int[dimension / 2];

        for(int i=0; i<izquierda.length; i++) {
            izquierda[i] = conjunto[inicio + i];
        }

        for(int i=0; i<derecha.length; i++) {
            derecha[i] = conjunto[inicio + mitad + i + 1];
        }

        int i=0;
        int j=0;
        int k=inicio;

        while (i<izquierda.length && j<derecha.length) {
            if (izquierda[i] >= derecha[j]) {
                conjunto[k] = izquierda[i];
                i++;
            }else {
                conjunto[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i<izquierda.length) {
            conjunto[k] = izquierda[i];
            k++;
            i++; 
        }

        while (j<derecha.length) {
            conjunto[k] = derecha[j];
            k++;
            j++;
        }
    }
}
