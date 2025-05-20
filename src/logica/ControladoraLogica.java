package logica;

import persistencia.ControladoraPersistencia;

import java.util.ArrayList;
import java.util.Map;

public class ControladoraLogica {

   ControladoraPersistencia controlPersis = new ControladoraPersistencia();

   //CRUD Departamentos
   public void crearDepartamento(Departamento departamento){
       controlPersis.crearDepartamento(departamento);
   }

    public void editarDepartamento(Departamento departamento){
        controlPersis.editarDepartamento(departamento);
    }

    public void eliminarDepartamento(String codigo){
        controlPersis.eliminarDepartamento(codigo);
    }

    public Departamento buscarDepartamento(Long id){
        return controlPersis.buscarDepartento(id);
    }


    public ArrayList<Departamento> mostrarListaDepartamentos(){
        return controlPersis.mostrarListaDepartamentos();
    }

    //CRUD Empleados

    public void crearEmpleado(Empleado empleado){
        controlPersis.crearEmpleado(empleado);
    }

    public void editarEmpleado(Empleado empleado){
        controlPersis.editarEmpleado(empleado);
    }

    public void eliminarEmpleado(String documentoNumero){
        controlPersis.eliminarEmpleado(documentoNumero);
    }

    public Empleado buscarEmpleado(String documentoNumero){
        return controlPersis.buscarEmpleado(documentoNumero);
    }

    public ArrayList<Empleado> mostrarListaEmpleados(){
        return controlPersis.mostrarListaEmpleados();
    }

}
