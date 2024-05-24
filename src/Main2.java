import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    private static ArrayList<Guitarra> guitarras = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String INVENTARIO = "inventario.dat";

    public static void main(String[] args) {
        cargarGuitarras();
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("1. Mostrar guitarras");
            System.out.println("2. Comprar guitarra");
            System.out.println("3. Agregar guitarra");
            System.out.println("4. Modificar guitarra");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarGuitarras();
                    break;
                case 2:
                    comprarGuitarra();
                    break;
                case 3:
                    agregarGuitarra();
                    break;
                case 4:
                    modificarGuitarra();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    guardarGuitarras(); // Guardar el inventario  
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void inicializarGuitarras() {
        guitarras.add(new Guitarra("Gibson", "Les Paul", 9100000, 20));
        guitarras.add(new Guitarra("Gibson", "SG", 4300000, 20));
        guitarras.add(new Guitarra("Gibson", "ES", 1800000, 10));
        guitarras.add(new Guitarra("Gibson", "Flying V", 3600000, 5));
        guitarras.add(new Guitarra("Gibson", "Explorer", 3200000, 5));
        guitarras.add(new Guitarra("Fender", "Telecaster", 2900000, 20));
        guitarras.add(new Guitarra("Fender", "Jaguar", 2100000, 20));
        guitarras.add(new Guitarra("Fender", "Jazzmaster", 2400000, 10));
        guitarras.add(new Guitarra("Fender", "Stratocaster", 1500000, 50));
        guitarras.add(new Guitarra("Fender", "Lead", 3600000, 10));
    }

    private static void mostrarGuitarras() {
        for (Guitarra guitarra : guitarras) {
            System.out.println(guitarra);
        }
    }

    private static void comprarGuitarra() {
        scanner.nextLine(); 
        System.out.print("Ingrese el nombre del modelo de la guitarra a comprar: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la cantidad a comprar: ");
        int cantidad = scanner.nextInt();

        for (Guitarra guitarra : guitarras) {
            if (guitarra.getModelo().equalsIgnoreCase(modelo) && guitarra.getCantidad() >= cantidad) {
                guitarra.setCantidad(guitarra.getCantidad() - cantidad);
                System.out.println("Compra realizada exitosamente de " + cantidad + " " + modelo);
                return;
            }
        }
        System.out.println("Modelo no disponible o cantidad insuficiente.");
    }

    private static void agregarGuitarra() {
        scanner.nextLine(); 
        System.out.print("Ingrese la marca de la nueva guitarra: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo de la nueva guitarra: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el precio de la guitarra: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad de la guitarra: ");
        int cantidad = scanner.nextInt();
        guitarras.add(new Guitarra(marca, modelo, precio, cantidad));
        System.out.println("Guitarra agregada correctamente.");
    }

    private static void modificarGuitarra() {
        scanner.nextLine(); 
        System.out.print("Ingrese el modelo de la guitarra a modificar: ");
        String modelo = scanner.nextLine();
        for (Guitarra guitarra : guitarras) {
            if (guitarra.getModelo().equalsIgnoreCase(modelo)) {
                System.out.print("Ingrese el nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();
                System.out.print("Ingrese la nueva cantidad: ");
                int nuevaCantidad = scanner.nextInt();
                guitarra.setPrecio(nuevoPrecio);
                guitarra.setCantidad(nuevaCantidad);
                System.out.println("Guitarra modificada correctamente.");
                return;
            }
        }
        System.out.println("Guitarra no encontrada.");
    }

    private static void cargarGuitarras() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(INVENTARIO))) {
            guitarras = (ArrayList<Guitarra>) entrada.readObject();
            System.out.println("Inventario de guitarras cargado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar el inventario de guitarras. Se inicializará con valores por defecto.");
            inicializarGuitarras();
        }
    }

    private static void guardarGuitarras() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(INVENTARIO))) {
            salida.writeObject(guitarras);
            System.out.println("Inventario de guitarras guardado correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el inventario de guitarras.");
        }
    }
}
