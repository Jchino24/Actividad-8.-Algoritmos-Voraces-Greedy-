import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class CoberturaAntenas {

    public static void resolverCobertura(int[] casas, int rangoR) {
        Arrays.sort(casas);
        
        List<Integer> posicionesAntenas = new ArrayList<>();
        int i = 0;
        int n = casas.length;

        while (i < n) {
            int casaIzquierda = casas[i];
            int posicionAntena = casaIzquierda + rangoR;
            posicionesAntenas.add(posicionAntena);
            int limiteCobertura = posicionAntena + rangoR;
            while (i < n && casas[i] <= limiteCobertura) {
                i++;
            }
        }

        System.out.println("Antenas colocadas aproximadamente en:");
        for (int pos : posicionesAntenas) {
            System.out.println(pos);
        }
        System.out.println("Cantidad total: " + posicionesAntenas.size());
    }

    public static void main(String[] args) {
        System.out.println("Ejemplo 1 ");
        int[] casas1 = {1, 2, 7, 11, 20, 21, 30};
        int cobertura1 = 5;
        resolverCobertura(casas1, cobertura1);

        System.out.println("\nEjemplo 2 ");
        int[] casas2 = {2, 4, 8, 15, 18, 22};
        int cobertura2 = 3;
        resolverCobertura(casas2, cobertura2);
    }
}