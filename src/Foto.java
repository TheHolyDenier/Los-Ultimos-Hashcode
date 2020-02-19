import java.util.ArrayList;
import java.util.List;

class Foto {
    private char orientacion;
    private String orientacionString;
    private int longitud;
    private List<String> etiquetas;
    private int posicion;

    public Foto(int pos, String[] informacion) {
        posicion = pos;
        orientacion = informacion[0].charAt(0);
        longitud = Integer.parseInt(informacion[1]);
        etiquetas = new ArrayList<>();
        for (int i = 2; i < informacion.length; i++) {
            etiquetas.add(informacion[i]);
        }
    }

    @Override
    public String toString() {
        if (orientacion == 'V') orientacionString = "vertical";
        else orientacionString = "horizontal";
        return String.format("Photo %s is %s and has tags [%s]", posicion, orientacionString, String.join(", ", etiquetas));
    }

}