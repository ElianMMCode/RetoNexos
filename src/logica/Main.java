package logica;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //lista de collections de departamentos
    private static final List<Departamento> departamentos = new ArrayList<>();
    //lista de collections de empleados
    private static final List<Empleado> empleados = new ArrayList<>();
    //Instancia para traer los metodos de la persistencia
    private static final ControladoraLogica control = new ControladoraLogica();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        //si no consigue ninguna opcion salta al default
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Crear departamento");
            System.out.println("2. Listar departamentos");
            System.out.println("3. Buscar departamento");
            System.out.println("4. Editar departamento");
            System.out.println("5. Eliminar departamento");
            System.out.println("6. Agregar empleado");
            System.out.println("7. Listar empleados");
            System.out.println("8. Buscar empleado");
            System.out.println("9. Editar empleado");
            System.out.println("10. Eliminar empleado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            //Metodo para leer la opcion y pasarla a un numero
            opcion = seleccionOpcion(kb);

            switch (opcion) {
                //CRUD Deparamentos
                case 1:
                    crearDepartamento(kb);
                    break;
                case 2:
                    listaDepartamentos();
                    break;

                case 3:
                    buscarDepartamento(kb);
                    break;

                case 4:
                    editarDepartamento(kb);
                    break;
                case 5:
                    eliminarDepartamento(kb);
                    break;
                case 6:
                    agregarEmpleado(kb);
                    break;

                //CRUD Empleados
                case 7:
                    listaEmpleados();break;
                case 8:
                    buscarEmpleado(kb);break;
                case 9:
                    editarEmpleado(kb);break;
                case 10:
                    eliminarEmpleado(kb);break;
                case 0:
                    System.out.println("==== FIN DEL PROGRAMA ====");break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
        //Cierre del scanner
        kb.close();
    }

    //Lectura de Scanner para devolver una opcion y controlar las exepciones
    private static int seleccionOpcion(Scanner kb){
        int opcion;
        try {
            opcion = Integer.parseInt(kb.nextLine());
        } catch (NumberFormatException e){
            opcion = -1;
        }
        return opcion;
    }

    private static void crearDepartamento(Scanner kb){
        System.out.print("Código: ");
        String codigo = kb.nextLine();
        System.out.print("Nombre: ");
        String nombre = kb.nextLine();
        Departamento d1 = new Departamento(codigo, nombre, empleados);//se agrega la lista de empleados vacia para mantener la relacion
        //Se crea departamento
        departamentos.add(d1);
        control.crearDepartamento(d1);//registro de departamento en BD
        System.out.println("Departamento creado: " + d1);
    }

    private static void listaDepartamentos (){
        //se accede al crea una instancia con el metodo para mostrar todos los departamentos
        //y se recorre con un For Each Loop
        ArrayList<Departamento> listaDepartamentos = control.mostrarListaDepartamentos();
        for (Departamento d2 : listaDepartamentos) {
            //El loop reccorre todos los elementos existentes en el array al vez que instancia un objeto con las propiedades de cada uno de los que esta en el array
            System.out.println(d2);
        }
    }

    private static void buscarDepartamento (Scanner kb){
        System.out.print("Codigo departemnto a buscar: ");
        Long idDpt = strToLong(kb);
        //Con el id del departamento se realiza la busqueda del departamento
        Departamento encontrado = control.buscarDepartamento(idDpt);
        //Si el id corresponde a un departamento "encontrado" se cargara con las variables de este de lo contrario quedara null
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("No existe departamento con código " + idDpt);
        }
    }

    private static Long strToLong (Scanner kb){
        //lee un string y lo pasa a un log para la busqueda de ids
        String cod = kb.nextLine();
        Long codDpt;
        try {
            codDpt = Long.valueOf(cod);
        } catch (NumberFormatException e) {
            System.out.println("Dato ingresado no corresponde a un ID");
            //Con el control de excepciones si lo que se ingresa no se puede volver un Long este devuelve un null
            codDpt = null;
        }
        return codDpt;
    }

    private static void editarDepartamento(Scanner kb){
        System.out.print("Id del departamento a editar: ");
        Long idDpt = strToLong(kb);
        //Primero se busca el departamento para verificar que exista
        Departamento editar = control.buscarDepartamento(idDpt);
        if (editar == null){
            System.out.println("No existe departamento con id " + idDpt);
        } else {
            System.out.print("Código: ");
            String codigo = kb.nextLine();
            System.out.print("Nombre: ");
            String nombre = kb.nextLine();
            //Se instancia denuevo sus atributos y se edita en BD
            editar.setCodigoDepartamento(codigo);
            editar.setNombreDepartamento(nombre);
            control.editarDepartamento(editar);
        }
    }

    private static void eliminarDepartamento(Scanner kb) {
        boolean eliminado = false;
        System.out.println("Ingres Id del departamento a eliminar");
        Long codDpt = strToLong(kb);
        //si la busqueda no encuentra nada devuelve un null
        if (control.buscarDepartamento(codDpt) != null) {
            control.eliminarDepartamento(codDpt);
            //Con este booleano se controla el mensaje de salida
            eliminado=true;
        }
        //Se usa un operador terniario para con ayuda del boolean arrojar un mensaje acorde
        System.out.println(eliminado ? "Departamento eliminado." : "No se encontro el departamento del id "+codDpt);
    }

    private static void agregarEmpleado(Scanner kb){
        System.out.print("Tipo doc: ");
        String tipoDoc = kb.nextLine();
        System.out.print("Número doc: ");
        String numDoc = kb.nextLine();
        System.out.print("Nombres: ");
        String nombres = kb.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = kb.nextLine();
        System.out.print("Código depto: ");
        Long idDpt = strToLong(kb);
        Departamento dept;

        Departamento d5 = control.buscarDepartamento(idDpt);
        if (d5 == null) {
            System.out.println("Departamento no existe.");
        } else {
            dept = d5;
            Empleado e = new Empleado(tipoDoc, numDoc, nombres, apellidos, dept);
            control.crearEmpleado(e);
            empleados.add(e);
            dept.setEmpleados(empleados);
            control.editarDepartamento(dept);
            System.out.println("Empleado creado con ID " + e.getIdEmpleado() + " en depto " + dept.getCodigoDepartamento());

        }
    }

    private static void listaEmpleados (){
        ArrayList<Empleado> listaEmpleados = control.mostrarListaEmpleados();
        for(Empleado e2 : listaEmpleados){
            System.out.println(e2);
        }
    }

    private static void buscarEmpleado (Scanner kb){
        System.out.print("Codigo empleado a buscar: ");
        Long idEmpl = strToLong(kb);
        //Busqueda de la existencia de un empleado acorde al id
        Empleado encontrado = control.buscarEmpleado(idEmpl);
        if(encontrado != null){
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("No existe departamento con codigo "+ idEmpl);
        }
    }


    public static void editarEmpleado (Scanner kb){
        System.out.print("Id del empleado a editar: ");
        //String cod = kb.nextLine();
        Long idEmp = strToLong(kb);
        Empleado editar = control.buscarEmpleado(idEmp);
        if (editar == null){
            System.out.println("No existe empleado con id " + idEmp);
        } else {
            System.out.print("Tipo doc: ");
            String tipoDoc = kb.nextLine();
            System.out.print("Número doc: ");
            String numDoc = kb.nextLine();
            System.out.print("Nombres: ");
            String nombres = kb.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = kb.nextLine();
            System.out.print("Código depto: ");
            Long idDpt = strToLong(kb);

            Departamento dept;
            editar.setDocumentoTipo(tipoDoc);
            editar.setDocumentoNumero(numDoc);
            editar.setNombres(nombres);
            editar.setApellidos(apellidos);

            Departamento d5 = control.buscarDepartamento(idDpt);
            if (d5 == null) {
                System.out.println("Departamento no existe.");
            } else {
                dept = d5;
                editar.setDepartamento(dept);
                control.editarEmpleado(editar);
                System.out.println("Empleado editado.");
            }
        }
    }

    public static void eliminarEmpleado (Scanner kb){
        boolean eliminado = false;
        System.out.print("Ingres Id del empleado a eliminar: ");
        Long idEmp = strToLong(kb);
        if(control.buscarEmpleado(idEmp)!=null) {
            control.eliminarEmpleado(idEmp);
            eliminado=true;
        }
        System.out.println(eliminado ? "Empleado eliminado." : "No se encontro al empleado asociado al id " + idEmp);
    }




}
