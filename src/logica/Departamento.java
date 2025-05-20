package logica;

import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDepartamento;
    @Basic
    private String codigoDepartamento;
    private String nombreDepartamento;
    @Temporal(TemporalType.TIMESTAMP)
    //@Column(name="fecha_creacion")
    private final Date fechaCreacion;      // nueva fecha de creación
    private final Map<Long, Empleado> empleados = new LinkedHashMap<>();  // Lista de empleados guardados por departamento

    // Constructores
    public Departamento() {
        this.fechaCreacion = new Date();
    }

    public Departamento(String codigoDepartamento, String nombreDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.fechaCreacion = new Date();
    }

    // Getters y setters
    public Long getIdDepartamento() {
        return idDepartamento;
    }
    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    //Agregar a
    public void agregarEmpleado(Empleado e) {
        empleados.put(e.getIdEmpleado(), e);
    }

    // 2. Acceso a la lista de empleados
    public Map<Long, Empleado> getEmpleados() {
        return empleados;
    }

    //Clase especial para mostrar los atributos de un objeto de la clase
    public String toString() {
        return "Departamento{" +
                "id=" + idDepartamento +
                ", codigo= " + codigoDepartamento +
                ", nombre= " + nombreDepartamento +
                ", fechaCreacion= "+ fechaCreacion +
                ", empleados= " + empleados.size() +
                " }";
    }




}
