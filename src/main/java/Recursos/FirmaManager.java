package Recursos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FirmaManager {

    private static final String DIRECTORIO_FIRMAS = "firmas";
    
    public static String guardarFirma(BufferedImage firma, String identificador) throws IOException {
        File carpeta = new File(DIRECTORIO_FIRMAS);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        File archivo = new File(carpeta, identificador + ".png");
        ImageIO.write(firma, "png", archivo);
        return archivo.getPath();
    }

    public static BufferedImage cargarFirma(String rutaFirma) throws IOException {
        File archivo = new File(rutaFirma);
        if (!archivo.exists()) {
            System.err.println("⚠️ Firma no encontrada: " + rutaFirma);
            return null;
        }
        return ImageIO.read(archivo);
    }

    public static boolean firmaExiste(String rutaFirma) {
        return new File(rutaFirma).exists();
    }

    public static boolean eliminarFirma(String rutaFirma) {
        File archivo = new File(rutaFirma);
        return archivo.exists() && archivo.delete();
    }
}