import java.io.*;
import java.util.Scanner;

public class Main {
    private static String rutaLectura = "Los-Ultimos-Hashcode/a_example.txt";
    private static String rutaEscritura = "output.txt";
    private static Libreria[] lista;
    private static String divisor = " ";
    private static boolean sobrescritura = false;
    private static int numeroLibros, numeroLibrerias, totalDias;
    private static int[] scores;

    public static void main(String[] args) throws IOException {
        leerArchivo();
        escribirArchivo();
        imprimirResultadoPantalla();
    }

    public static void leerArchivo() throws FileNotFoundException {
        Libreria libreria = null;
        int libreriaNumero = 0;
        try (Scanner scanner = new Scanner(new File(rutaLectura))) {
            for (int i = 0; scanner.hasNextLine(); i++) {
                String linea = scanner.nextLine();
                if (i == 0) {
                    numeroLibros = Integer.parseInt(linea.split(divisor)[0]);
                    numeroLibrerias = Integer.parseInt(linea.split(divisor)[1]);
                    totalDias = Integer.parseInt(linea.split(divisor)[2]);
                    lista = new Libreria[numeroLibrerias];
                } else if (i == 1) {
                    scores = new int[linea.split(divisor).length];
                    for (int j = 0; j < linea.split(divisor).length; j++) {
                        scores[j] = Integer.parseInt(linea.split(divisor)[j]);
                    }
                } else if (i % 2 == 0) {
                    libreria = new Libreria();
                    libreria.setNumero(libreriaNumero);
                    libreria.iniciarLibros(Integer.parseInt(linea.split(divisor)[0]));
                    libreria.setTiempoRegistro(Integer.parseInt(linea.split(divisor)[1]));
                    libreria.setLibrosPorDia(Integer.parseInt(linea.split(divisor)[2]));
                } else {
                    libreria.addLibro(linea.split(divisor));
                    lista[libreriaNumero] = libreria;
                    libreriaNumero++;
                    libreria = null;
                }
            }
        }
        System.out.println("Archivo leído");
    }

    public static void escribirArchivo() throws IOException {
        FileWriter fileWriter = new FileWriter(rutaEscritura, sobrescritura);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s\n", String.valueOf(numeroLibrerias));
        for (Libreria libreria : lista) {
            String registroLibros = libreria.getLibros().toString().replaceAll("[\\[\\], ]", " ");
            registroLibros = registroLibros.substring(1, registroLibros.length() - 1);
            printWriter.printf("%s %s\n%s\n", libreria.getNumero(), libreria.getLibros().size(), registroLibros);
        }
        printWriter.close();
        if (new File(rutaEscritura).exists()) System.out.println("Archivo escrito");
    }

    public static void imprimirResultadoPantalla() throws FileNotFoundException {
        System.out.print("\n\n==========RESULTADO==========\n\n");
        try (Scanner scanner = new Scanner(new File(rutaEscritura))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }

    }
}
