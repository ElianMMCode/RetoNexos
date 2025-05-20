package logica;

import persistencia.ControladoraPersistencia;

import java.util.ArrayList;

public class ControladoraLogica {

   ControladoraPersistencia controlPersis = new ControladoraPersistencia();

   //CRUD Departamentos
   public void crearDepartamento(Departamento departamento){
       controlPersis.crearDepartamento(departamento);
   }

    public void editarDepartamento(Departamento departamento){
        controlPersis.editarDepartamento(departamento);
    }

    public void eliminarDepartamento(Long codigo){
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

    public void eliminarEmpleado(Long documentoNumero){
        controlPersis.eliminarEmpleado(documentoNumero);
    }

    public Empleado buscarEmpleado(Long id){
        return controlPersis.buscarEmpleado(id);
    }

    public ArrayList<Empleado> mostrarListaEmpleados(){
        return controlPersis.mostrarListaEmpleados();
    }

}
