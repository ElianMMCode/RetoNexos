package logica;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDepartamento;
    @Basic
    private String codigoDepartamento;
    private String nombreDepartamento;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL,fetch = FetchType.LAZY    )
    private List<Empleado> empleados = new ArrayList<>();
    // Constructores
    public Departamento() {
        this.fechaCreacion = new Date();
    }

    public Departamento(String codigoDepartamento, String nombreDepartamento, List<Empleado> empleados) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.empleados = empleados;
        this.fechaCreacion = new Date();
    }




    // Getters y setters
    public Long getIdDepartamento() {
        return idDepartamento;
    }
    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public String getCodigoDepartamento() {return codigoDepartamento;}
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.fechaModificacion = new Date();
        this.codigoDepartamento = codigoDepartamento;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.fechaModificacion = new Date();
        this.nombreDepartamento = nombreDepartamento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }



    //Clase especial para mostrar los atributos de un objeto de la clase
    public String toString() {
        return "\nDepartamento " +
                "id= " + idDepartamento +
                "\n Codigo= " + codigoDepartamento +
                "\n Nombre= " + nombreDepartamento +
                "\n FechaCreacion= "+ fechaCreacion +
                "\n FechaActualizacion= "+fechaModificacion+
                "\n Empleados= " + empleados.size() +"\n";
    }




}
