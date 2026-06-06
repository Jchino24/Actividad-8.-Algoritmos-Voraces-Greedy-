import java.util.Arrays;
import java.util.Comparator;

class Objeto {
    String nombre;
    double valor;
    double peso;
    double ratio;

    public Objeto(String nombre, double valor, double peso) {
        this.nombre = nombre;
        this.valor = valor;
        this.peso = peso;
        this.ratio = valor / peso;
    }
}

public class MochilaFraccional {

    public static void resolverMochila(double capacidad, Objeto[] objetos) {
        Arrays.sort(objetos, new Comparator<Objeto>() {
            @Override
            public int compare(Objeto o1, Objeto o2) {
                return Double.compare(o2.ratio, o1.ratio);
            }
        });

        double valorTotal = 0.0;
        double capacidadRestante = capacidad;

        System.out.println("Objetos seleccionados:");

        for (Objeto obj : objetos) {
            if (capacidadRestante == 0) break; 
            if (obj.peso <= capacidadRestante) {
                System.out.println("- " + obj.nombre + " completo");
                valorTotal += obj.valor;
                capacidadRestante -= obj.peso;
            } else {
                double fraccion = capacidadRestante / obj.peso;
                System.out.println("- " + capacidadRestante + "/" + obj.peso + " Parte del objeto " + obj.nombre);
                valorTotal += obj.valor * fraccion;
                capacidadRestante = 0;
            }
        }

        System.out.println("Valor total aproximado: " + Math.round(valorTotal));
    }

    public static void main(String[] args) {
        System.out.println("Ejemplo 1");
        Objeto[] objetos1 = {
            new Objeto("A", 60, 10),
            new Objeto("B", 100, 20),
            new Objeto("C", 120, 30)
        };
        resolverMochila(50, objetos1);

        System.out.println("\nEjemplo 2");
        Objeto[] objetos2 = {
            new Objeto("A", 80, 20),
            new Objeto("B", 100, 10),
            new Objeto("C", 120, 30)
        };
        resolverMochila(25, objetos2);
    }
}