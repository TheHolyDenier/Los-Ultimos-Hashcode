import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private String rutaLectura = "";
    private String rutaEscritura = "";
    private List<Objeto> lista;
    private String divisor = "";
    private int numeroElementos;
    private boolean sobrescritura = false;

    public void main(String[] args) {

    }

    public void leerArchivo() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(rutaLectura))) {
            for (int i = 0; scanner.hasNextLine(); i++) {
                String linea = scanner.nextLine();
                if (i == 0) {
                    i++;
                    numeroElementos = Integer.parseInt(linea);
                } else {
                    lista.add(new Objeto(linea.split(divisor)));
                }
            }
        }

    }

    public void escribirArchivo() throws IOException {
        FileWriter fileWriter = new FileWriter(rutaEscritura, sobrescritura);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("TEXTO %s TEXTO", numeroElementos);
        for (Objeto linea : lista) {
            printWriter.print(linea.toString());
        }
        printWriter.close();

    }
}
