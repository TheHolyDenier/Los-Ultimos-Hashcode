
public class Prueba {
    public static void main(String[] args) {
        int prueba[] = {1,6,2,4,5,8,11,23,4,5,65};
        System.out.println("Normal:");
        for(int i = 0; i< prueba.length;i ++){
            System.out.print(prueba[i]+",");
        }
        int salida[] = MetodosOrdenacion.Seleccion(prueba);

        
        System.out.println();
        System.out.println("Ordenado:");
        for(int i = 0; i< prueba.length;i ++){
            System.out.print(salida[i]+",");
        }

    }
}