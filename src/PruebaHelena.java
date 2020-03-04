import java.io.IOException;
import java.util.*;

public class PruebaHelena {
    private static MainHelena m;
    private static List<Libreria> librerias;
    private static List<Integer> yaUsados;
    static Libreria[] original;

    public static void main(String[] args) throws IOException {
        m = new MainHelena();
        m.leerArchivo();
        original = m.getLista();
        librerias = new ArrayList<>();
        yaUsados = new ArrayList<>();
        HashMap<Integer, Double> ordenado = sortByValue(ordenarMapa());
        Iterator it = ordenado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            librerias.add(original[(int) pair.getKey()]);
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

        m.escribirArchivo(librerias);
        m.imprimirResultadoPantalla();
        System.out.print("FIN");
    }


    public static Map<Integer, Double> ordenarMapa() {
        HashMap<Integer, Double> mapa = new HashMap<>();
        for (Libreria libreria : original) {
            Indice indice = new Indice(libreria.getLibros().size(), obtenerScore(libreria.getLibros()), libreria.getEnviasDia(), libreria.getTiempoRegistro());
            mapa.put(libreria.getNumero(), indice.getValor());
        }
        return mapa;
    }

    public static <Integer, Double extends Comparable<? super Double>> HashMap<Integer, Double> sortByValue(Map<Integer, Double> map) {
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        HashMap<Integer, Double> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Double> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    private static int obtenerScore(List<Integer> libros) {
        int total = 0;
        int[] score = m.getScores();
        for (int i = 0; i < libros.size(); i++) {
            total += score[libros.get(i)] * score[libros.get(i)];
        }
        return total;
    }
}

class Indice {
    private double valor;

    public Indice(int totalLibros, int scorePorSet, int diasPorLibro, int diasRegistro) {
        this.valor = (double) (totalLibros * scorePorSet * diasPorLibro) / diasRegistro;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
