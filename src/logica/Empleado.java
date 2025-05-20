package logica;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEmpleado; //se declara tipo long al permitir guardar NULL
    @Basic
    private String documentoTipo;
    private String documentoNumero;
    private String nombres;
    private String apellidos;
    @ManyToOne
    @JoinColumn(name="IDDEPARTAMENTO", referencedColumnName="IDDEPARTAMENTO")
    private Departamento departamento;
    @Temporal(TemporalType.TIMESTAMP)
    private final Date fechaCreacion;    // nueva fecha de creación
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    // Constructores
    public Empleado() {
        this.fechaCreacion = new Date(); //sé instancia la fecha de creacion
    }

    public Empleado(String documentoTipo,
                    String documentoNumero,
                    String nombres,
                    String apellidos,
                    Departamento departamento) {
        this.documentoTipo = documentoTipo;
        this.documentoNumero = documentoNumero;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaCreacion   = new Date();
        this.departamento = departamento;
    }



    // Getters y setters Empleado
    public Long getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Long idEmpleado) {
        this.fechaModificacion = new Date();
        this.idEmpleado = idEmpleado;
    }
    public String getDocumentoTipo() {
        return documentoTipo;
    }
    public void setDocumentoTipo(String documentoTipo) {
        this.fechaModificacion = new Date();
        this.documentoTipo = documentoTipo;
    }
    public String getDocumentoNumero() {
        return documentoNumero;
    }
    public void setDocumentoNumero(String documentoNumero) {
        this.fechaModificacion = new Date();
        this.documentoNumero = documentoNumero;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.fechaModificacion = new Date();
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.fechaModificacion = new Date();
        this.apellidos = apellidos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    //Getters y setters Departamento
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.fechaModificacion = new Date();
        this.departamento = departamento;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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
                ", fechaCreacion= " + fechaCreacion+
                " }";
    }
}

