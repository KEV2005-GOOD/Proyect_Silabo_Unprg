package entidades;

import Recursos.FirmaManager;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.awt.image.BufferedImage;
import java.io.IOException;

@XmlRootElement(name = "docente")
public class Docente {

    private String nombres;
    private String Apellidos;
    private String gradoAcademico;
    private String DNI;
    private String correo;

    // Aquí guardamos solo la ruta, no la imagen
    private String firmaPath;

    public Docente() {
    }

    public Docente(String nombres, String Apellidos, String gradoAcademico, String DNI, String correo, String firmaPath) {
        this.nombres = nombres;
        this.Apellidos = Apellidos;
        this.gradoAcademico = gradoAcademico;
        this.DNI = DNI;
        this.correo = correo;
        this.firmaPath = firmaPath;
    }

    // Getters y setters
    @XmlElement(name = "nombres")
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @XmlElement(name = "apellidos")
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }

    @XmlElement(name = "grado")
    public String getGrado() {
        return gradoAcademico;
    }

    public void setGrado(String grado) {
        this.gradoAcademico = grado;
    }

    @XmlElement(name = "dni")
    public String getDni() {
        return DNI;
    }

    public void setDni(String dni) {
        this.DNI = dni;
    }

    @XmlElement(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlElement(name = "firmaPath")
    public String getFirmaPath() {
        return firmaPath;
    }

    public void setFirmaPath(String firmaPath) {
        this.firmaPath = firmaPath;
    }

    // Cargar firma como imagen cuando se necesite
    public BufferedImage getFirma() throws IOException {
        return FirmaManager.cargarFirma(firmaPath);
    }

    public String getFullName() {
        return   nombres +" "+  Apellidos;
    }
}
