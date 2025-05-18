package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Departamento {
    private Long idDepartamento;
    private String codigoDepartamento;
    private String nombreDepartamento;
    private final LocalDateTime fechaCreacion;      // nueva fecha de creación
    private final Map<Long, Empleado> empleados = new LinkedHashMap<>();  // Lista de empleados guardados por departamento

    // Constructores
    public Departamento() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Departamento(String codigoDepartamento, String nombreDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.fechaCreacion = LocalDateTime.now();
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

    public LocalDateTime getFechaCreacion() {
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
                ", fechaCreacion= "+ fechaCreacion.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                ", empleados= " + empleados.size() +
                " }";
    }




}
