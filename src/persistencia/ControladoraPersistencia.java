package persistencia;

import logica.Departamento;
import logica.Empleado;

import java.util.*;

public class ControladoraPersistencia {

    DepartamentoJpaController depJpa = new DepartamentoJpaController();

    EmpleadoJpaController empJpa = new EmpleadoJpaController();

    //CRUD Departamento
    //Recibe al objeto Departamento y lo pasa a la controladora de persistencia para crear un registro
    public void crearDepartamento(Departamento departamento) {
        depJpa.create(departamento);
    }


    public void editarDepartamento(Departamento departamento) {
        try {
            depJpa.edit(departamento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Departamento buscarDepartento(Long id) {
        return depJpa.findDepartamento(id);
    }
    


    public ArrayList<Departamento> mostrarListaDepartamentos() {
        List<Departamento> list = depJpa.findDepartamentoEntities();
        ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>(list);
        return listaDepartamentos;
    }

    public void eliminarDepartamento(String id) {
        try {
            depJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //CRUD Empleado
    public void crearEmpleado(Empleado empleado) {
        empJpa.create(empleado);
    }

    public void editarEmpleado(Empleado empleado) {
        try {
            empJpa.edit(empleado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarEmpleado(String documentoNumero) {
        try {
            empJpa.destroy(documentoNumero);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Empleado buscarEmpleado(String documentoNumero) {
        return empJpa.findEmpleado(documentoNumero);
    }


    public ArrayList<Empleado> mostrarListaEmpleados() {
        List<Empleado> lista = empJpa.findEmpleadoEntities();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>(lista);
        return listaEmpleados;
    }
}
