public class MetodosOrdenacion {

    public static int[] Burbuja(int array[]) {
        int limite = array.length;
        int i, j, temp;
        for (i = 0; i < limite; i++) {
            for (j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }

            }
        }
        return array;
    }

    public static int[] Insercion(int array[]) {
        int i, j, tmp;
        int limite = array.length;
        for (i = 1; i < limite; i++) {

            tmp = array[i];
            j = i - 1;
            while ((array[j] > tmp) && (j >= 0)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }

        return array;
    }

    public static int[] Seleccion(int array[]) {
        int i, j, tmp, k, p;
        int limite = array.length - 1;
        for (k = 0; k < limite; k++) {
            p = k;
            for (i = k + 1; i <= limite; i++) {
                if (array[i] < array[p]) {
                    p = i;
                }
            }
            if (p != k) {
                tmp = array[p];
                array[p] = array[k];
                array[k] = tmp;
            }
        }
        return array;

    }
}