package logica;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Empleado {
    //Mapeo de atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // permite que al generarse un nuevo registro desde esta clase su id se cargue automaticamente y de manera secuencial
    private Long idEmpleado; //se declara tipo long al permitir guardar NULL
    @Basic //atributos normales de la entidad
    private String documentoTipo; //Se puede convertir en un enum para normalizar las tablas
    private String documentoNumero;
    private String nombres;
    private String apellidos;
    @ManyToOne //Cardinalidad de tablas
    @JoinColumn(name="IDDEPARTAMENTO", referencedColumnName="IDDEPARTAMENTO")// Fk de la tabla departamento
    private Departamento departamento;
    @Temporal(TemporalType.TIMESTAMP)//Estable el registro de tipo fecha
    private final Date fechaCreacion;    // nueva fecha de creación
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion; //Cada modificacion se actualiza
    // Constructores
    public Empleado() {
        this.fechaCreacion = new Date();
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
        this.fechaCreacion   = new Date(); //sé instancia la fecha de creacion
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
        return "\nEmpleado "+ idEmpleado +
                "\nDocumentoTipo= " + documentoTipo  +
                "\nDocumentoNumero= " + documentoNumero +
                "\nNombres= " + nombres +
                "\nApellidos= " + apellidos +
                "\n" + departamento +
                "\nFechaCreacion= " + fechaCreacion +
                "\nFechaActualizacion= " + fechaModificacion +"\n";
    }
}

