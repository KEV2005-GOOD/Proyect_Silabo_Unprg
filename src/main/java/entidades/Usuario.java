
package entidades;

import com.chm.converter.xml.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlRootElement(name = "usuario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private Docente docente;

    
    
    //justto
    
    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseña, Docente docente) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.docente = docente;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }



    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario + ", Contraseña: " + contraseña + "\n" + docente.toString();
    }
    
}
