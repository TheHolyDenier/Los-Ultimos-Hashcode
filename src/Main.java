import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String rutaLectura = "Los-Ultimos-Hashcode/a_example.txt";
    private static String rutaEscritura = "output.txt";
    private static List<Foto> lista;
    private static String divisor = " ";
    private static int numeroElementos;
    private static boolean sobrescritura = false;

    public static void main(String[] args) throws IOException {
        leerArchivo();
        escribirArchivo();
        imprimirResultadoPantalla();
    }

    public static void leerArchivo() throws FileNotFoundException {
        lista = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(rutaLectura))) {
            for (int i = 0; scanner.hasNextLine(); i++) {
                String linea = scanner.nextLine();
                if (i == 0) {
                    numeroElementos = Integer.parseInt(linea);
                } else {
                    lista.add(new Foto(i-1, linea.split(divisor)));
                }
            }
        }
        System.out.println("Archivo leído");
    }

    public static void escribirArchivo() throws IOException {
        FileWriter fileWriter = new FileWriter(rutaEscritura, sobrescritura);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("The collection has %s photos\n", numeroElementos);
        for (Foto linea : lista) {
            printWriter.printf("%s\n", linea.toString());
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
