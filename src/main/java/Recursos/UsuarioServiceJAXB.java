package Recursos;

import entidades.Usuario;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceJAXB {

    private final String rutaXml;
    private final boolean usarClasspath;

    public UsuarioServiceJAXB(String rutaXml) {
        this.rutaXml = rutaXml;
        this.usarClasspath = false;
    }

    public UsuarioServiceJAXB() {
        this.rutaXml = "Usuarios.xml";
        this.usarClasspath = true;
    }

    public List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            JAXBContext context = JAXBContext.newInstance(ListaUsuarios.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ListaUsuarios lista;

            if (usarClasspath) {
                InputStream input = getClass().getClassLoader().getResourceAsStream(rutaXml);
                if (input == null) {
                    System.out.println("[ERROR] No se encontró el archivo en el classpath: " + rutaXml);
                    return usuarios;
                }
                lista = (ListaUsuarios) unmarshaller.unmarshal(input);
            } else {
                File archivo = new File(rutaXml);
                if (!archivo.exists()) {
                    System.out.println("[ERROR] Archivo no encontrado en ruta externa: " + rutaXml);
                    return usuarios;
                }
                lista = (ListaUsuarios) unmarshaller.unmarshal(archivo);
            }

            if (lista != null && lista.getUsuarios() != null) {
                usuarios = lista.getUsuarios();
                System.out.println("[DEBUG] Usuarios cargados: " + usuarios.size());
            } else {
                System.out.println("[WARN] Archivo procesado pero sin usuarios.");
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Excepción al cargar usuarios:");
            e.printStackTrace();
        }
        return usuarios;
    }

    public void guardarUsuarios(List<Usuario> usuarios) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListaUsuarios.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ListaUsuarios lista = new ListaUsuarios();
            lista.setUsuarios(usuarios);

            File archivo = new File(rutaXml);
            marshaller.marshal(lista, archivo);

            System.out.println("[DEBUG] Usuarios guardados correctamente: " + usuarios.size());
        } catch (Exception e) {
            System.out.println("[ERROR] Fallo al guardar usuarios:");
            e.printStackTrace();
        }
    }

    public boolean agregarUsuarioSiNoExiste(Usuario nuevoUsuario) {
        List<Usuario> usuarios = cargarUsuarios();
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nuevoUsuario.getNombreUsuario())) {
                System.out.println("[WARN] Usuario ya registrado: " + nuevoUsuario.getNombreUsuario());
                return false;
            }
        }
        usuarios.add(nuevoUsuario);
        guardarUsuarios(usuarios);
        System.out.println("[DEBUG] Usuario agregado: " + nuevoUsuario.getNombreUsuario());
        return true;
    }
}
