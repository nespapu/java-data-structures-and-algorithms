package AlgoritmosDeBusqueda;

public class Burbuja {
    public static void main (String[] main) {
        int[] conjunto = {7, 2, 9, 1, 6, 3, 10, 4, 8, 5};

        // Imprimir conjunto desordenado
        for  (int i=0; i<conjunto.length - 1; i++) {
            System.out.print(conjunto[i] + ", ");
        }
        System.out.println(conjunto[conjunto.length-1]);

        //ordenarMayorMenor(conjunto);
        ordenarMenorMayor(conjunto);

        // Imprimir conjunto ordenado
        for  (int i=0; i<conjunto.length - 1; i++) {
            System.out.print(conjunto[i] + ", ");
        }
        System.out.println(conjunto[conjunto.length-1]);
    }

    public static void ordenarMayorMenor (int[] conjunto) {
        int temp;
        boolean noHuboModificacion;
        for(int i=0; i<conjunto.length - 1; i++) {
            noHuboModificacion = true;
            for(int j=0; j<conjunto.length - i - 1; j++) {
                if ( conjunto[j] < conjunto[j+1]) {
                    temp = conjunto[j];
                    conjunto[j] = conjunto[j+1];
                    conjunto[j+1] = temp;
                    noHuboModificacion = false;
                }
            }
            if (noHuboModificacion) { // El array ya está ordenado
                break;
            }
        }
    }

    public static void ordenarMenorMayor (int[] conjunto) {
        int temp;
        boolean noHuboModificacion;
        for(int i=0; i<conjunto.length - 1; i++) {
            noHuboModificacion = true;
            for(int j=0; j<conjunto.length - i - 1; j++) {
                if ( conjunto[j] > conjunto[j+1]) {
                    temp = conjunto[j];
                    conjunto[j] = conjunto[j+1];
                    conjunto[j+1] = temp;
                    noHuboModificacion = false;
                }
            }
            if (noHuboModificacion) { // El array ya está ordenado
                break;
            }
        }
    }
}