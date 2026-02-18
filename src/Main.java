import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FICHERO = "pilotos_f1.dat";
    private static List<Piloto> pilotos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        cargarPilotos();
        int opcion;

        do {
            System.out.println("Sistema de Gestion:");
            System.out.println("1. Mostrar piloto");
            System.out.println("2. Añadir piloto");
            System.out.println("3. Buscar piloto");
            System.out.println("4. Guardar datos");
            System.out.println("0. Salir");
            System.out.println("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> mostrarPilotos();
                case 2 -> añadirPiloto();
                case 3 -> buscarPiloto();
                case 4 -> guardarPiloto();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no válida");
            }
        } while (opcion != 0);
    }

    // Cargar Pilotos
    private static void cargarPilotos() {
        pilotos.clear();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))){
            while (true) {
                Piloto p = (Piloto) ois.readObject();
                pilotos.add(p);
            }
        } catch (EOFException e) {
            System.out.println("Pilotos Cargados.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se puede cargar el fichero.");
        }
    }

    //Mostrar Pilotos
    private static void mostrarPilotos() {
        if (pilotos.isEmpty()) {
            System.out.println("No hay pilotos.");
        } else {
            pilotos.forEach(System.out::println);
        }
    }

    //Añadir Piloto
    private static void añadirPiloto() {
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();

        for (Piloto p : pilotos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("El piloto ya existe.");
                return;
            }
        }

        System.out.println("Escuderia: ");
        String escuderia = scanner.nextLine();
        System.out.println("Puntos: ");
        int puntos = scanner.nextInt();
        scanner.nextLine();

        pilotos.add(new Piloto(nombre, escuderia, puntos));
        System.out.println("Piloto añadido.");
    }

    //Buscar piloto
    private static void buscarPiloto() {
        System.out.println("Nombre del piloto: ");
        String nombre = scanner.nextLine();

        for (Piloto p : pilotos) {
            if (p.getNombre().equalsIgnoreCase(nombre)){
                System.out.println(p);
                return;
            }
        }
        System.out.println("Piloto no encontrado.");
    }
    //Guardar datos
    private static void guardarPiloto() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            for (Piloto p : pilotos) {
                oos.writeObject(p);
            }
            System.out.println("Datos guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos.");
        }
    }
}