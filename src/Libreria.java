import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private int numero;
    private List<Integer> libros;
    private int tiempoRegistro;
    private int enviasDia;

    public Libreria() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Integer> getLibros() {
        return libros;
    }

    public void setLibros(List<Integer> libros) {
        this.libros = libros;
    }


    public int getTiempoRegistro() {
        return tiempoRegistro;
    }

    public void setTiempoRegistro(int tiempoRegistro) {
        this.tiempoRegistro = tiempoRegistro;
    }

    public int getEnviasDia() {
        return enviasDia;
    }

    public void setEnviasDia(int enviasDia) {
        this.enviasDia = enviasDia;
    }

    public void iniciarLibros(int longitud) {
        this.libros = new ArrayList<>();
    }

    public void addLibro(String[] librosString) {
        for (String libro : librosString) {
            libros.add(Integer.parseInt(libro));
        }
    }
}
