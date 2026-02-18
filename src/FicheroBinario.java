import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FicheroBinario {
    public static void main(String[] args) {
        List<Piloto> pilotos = new ArrayList<>();
        pilotos.add(new Piloto("Lando Norris", "Mclaren", 423 ));
        pilotos.add(new Piloto("Max Verstappen", "Red Bull", 421));
        pilotos.add(new Piloto("Oscar Piastri", "Mclaren", 410));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pilotos_f1.dat"))) {
            for (Piloto p : pilotos) {
                oos.writeObject(p);
            }

            System.out.println("Fichero creado.");
        } catch (Exception e) {
            System.out.println("Error al crear el fichero");
        }
    }
}
