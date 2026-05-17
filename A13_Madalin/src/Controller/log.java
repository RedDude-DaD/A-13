package Controller;

import static Controller.A13_Madalin.rutaIFitxerLogActual;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author radum
 */
public class log {

    public static void createFile(String nom) {
        try {
            File fitxer = new File(nom);
            if (fitxer.createNewFile()) {
                //  System.out.println("S'ha creat el fitxer : " + fitxer.getName());
            } else {
                // System.out.println("El fitxer ja existeix.");
            }
        } catch (IOException e) {
            System.out.println("An error has ocurred.");
            e.printStackTrace();
        }

    }

    public static void creacioLog() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyyMMdd");
        String diaActual = LocalDateTime.now().format(formater);
        String directori = "src/Logs/";
        String rutaCompleta = directori + diaActual + ".log";
        rutaIFitxerLogActual = rutaCompleta;
        createFile(rutaCompleta);
    }

    public static void addLogLine(String where, String what) { // addLogLine("","");
        try {
            FileWriter fitxer = new FileWriter(rutaIFitxerLogActual, true);
            fitxer.write(LocalTime.now() + "     " + where + "     " + what + "\n");
            fitxer.close();
        } catch (IOException e) {
            System.out.println("An error has ocurred.");
            e.printStackTrace();
        }
    }
}
