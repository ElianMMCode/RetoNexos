package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Empleado {
    private Long idEmpleado; //se declara tipo long al permitir guardar NULL
    private String documentoTipo;
    private String documentoNumero;
    private String nombres;
    private String apellidos;
    private final LocalDateTime fechaCreacion;    // nueva fecha de creación
    private Departamento departamento;

    // Constructores
    public Empleado() {
        this.fechaCreacion = LocalDateTime.now(); //sé instancia la fecha de creacion
    }

    public Empleado(String documentoTipo,
                    String documentoNumero,
                    String nombres,
                    String apellidos) {
        this.documentoTipo = documentoTipo;
        this.documentoNumero = documentoNumero;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaCreacion   = LocalDateTime.now();
    }



    // Getters y setters Empleado
    public Long getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getDocumentoTipo() {
        return documentoTipo;
    }
    public void setDocumentoTipo(String documentoTipo) {
        this.documentoTipo = documentoTipo;
    }
    public String getDocumentoNumero() {
        return documentoNumero;
    }
    public void setDocumentoNumero(String documentoNumero) {
        this.documentoNumero = documentoNumero;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    //Getters y setters Departamento
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


    //Clase especial para mostrar los atributos de un objeto de la clase
    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + idEmpleado +
                ", documentoTipo= " + documentoTipo  +
                ", documentoNumero= " + documentoNumero +
                ", nombres= " + nombres +
                ", apellidos= " + apellidos +
                ", fechaCreacion= " + fechaCreacion.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))+
                " }";
    }
}

