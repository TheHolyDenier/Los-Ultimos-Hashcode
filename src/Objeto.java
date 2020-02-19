public class Objeto {
    private int elemento1;
    private String elemento2;
    private String elemento3;

    public Objeto(String[] texto) {
        this.elemento1 = Integer.parseInt(texto[0]);
        this.elemento2 = texto[1];
        this.elemento3 = texto[2];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
