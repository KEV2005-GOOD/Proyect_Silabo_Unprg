package com.mycompany.proyect_silabo_unprg;

import GUI.JFLogeo;
import com.formdev.flatlaf.FlatLightLaf;
import entidades.Docente;
import entidades.Facultad;
import entidades.Usuario;
import Recursos.VersionesHandler;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.jdesktop.swingx.prompt.PromptSupport;

public class Proyect_Silabo_Unprg {

    public static Facultad FACU;
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Docente> docentes = new ArrayList<>();

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());

        try {
            File archivoXML = new File("src/main/resources/BaseDeDatosSilabo.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            VersionesHandler handler = new VersionesHandler();
            parser.parse(archivoXML, handler);
            Facultad facultad = handler.getFacultad();
            FACU = facultad;

        } catch (Exception e) {
            e.printStackTrace();
        }
        JFLogeo logeo = new JFLogeo();

    }

    public static boolean validarPasswordDoble(JPasswordField pass1, JPasswordField pass2) {
        String texto1 = new String(pass1.getPassword()).trim();
        String texto2 = new String(pass2.getPassword()).trim();

        return !texto1.isEmpty() && texto1.equals(texto2);
    }

    public static void configurarCampoConPlaceholder(JTextField campo, String placeholder) {
        campo.setForeground(Color.BLACK); // color del texto escrito
        PromptSupport.setPrompt(placeholder, campo);
        PromptSupport.setForeground(Color.GRAY, campo); // color del placeholder
    }

    public static void configurarCampoConPlaceholder(JPasswordField campo, String placeholder) {
        campo.setForeground(Color.BLACK); // color del texto escrito
        PromptSupport.setPrompt(placeholder, campo);
        PromptSupport.setForeground(Color.GRAY, campo);
    }

    public static boolean validarCamposTextoYPassword(JTextField[] camposTexto, JPasswordField[] camposPassword) {
        for (JTextField campo : camposTexto) {
            if (campo.getText().trim().isEmpty()) {
                return false;
            }
        }

        for (JPasswordField campo : camposPassword) {
            if (new String(campo.getPassword()).trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public static boolean validarCamposLlenos(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
