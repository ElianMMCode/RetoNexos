package logica;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //lista de collections de departamentos
    private static List<Departamento> departamentos = new ArrayList<>();
    private static List<Empleado> empleados = new ArrayList<>();
    //Ids para los empleados
    //private static long asignarDepId = 1L;
    //private static long asignarEmpId = 1L;

    public static void main(String[] args) {
        ControladoraLogica control = new ControladoraLogica();
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
            try {
                //se convierte la opcion leida en un int para no cambiar el tipo de scanner constantemente
                opcion = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                //al detectar una opcion distinta a un int saltara al default
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    // Crear departamento

                    System.out.print("Código: ");
                    String codigo = kb.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = kb.nextLine();
                    Departamento d1 = new Departamento(codigo, nombre, empleados);
                    departamentos.add(d1);
                    //d1.setIdDepartamento(asignarDepId++);
                    control.crearDepartamento(d1);
                    System.out.println("Departamento creado: " + d1);
                    break;

                case 2:
                    // Mostrar departamentos registrados
                    /*if (departamentos.isEmpty()) {
                        System.out.println("No hay departamentos registrados.");
                    } else {
                        for (Departamento d2 : departamentos) {
                            System.out.println(d2);
                        }
                    }*/
                    ArrayList<Departamento> listaDepartamentos = control.mostrarListaDepartamentos();
                    for (Departamento d2 : listaDepartamentos) {
                        System.out.println(d2);
                    }

                    break;

                case 3:
                    // Buscar departamento
                    System.out.print("ID departemnto a buscar: ");
                    String codId = kb.nextLine();
                    Long idDpt = null;
                    try {
                        //se convierte la opcion leida en un long para no cambiar el tipo de scanner constantemente
                        idDpt = Long.valueOf(codId);
                    } catch (NumberFormatException e) {
                        System.out.println("Dato ingresado no corresponde a un ID");
                    }
                    Departamento encontrado = control.buscarDepartamento(idDpt);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No existe departamento con código " + codId);
                    }
                    /*for (Departamento d3 : departamentos) {
                        if (d3.getCodigoDepartamento().equalsIgnoreCase(codBus)) {
                            encontrado = d3;
                            break;
                        }
                    }
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No existe departamento con código " + codBus);
                    }*/


                    break;

                case 4:
                    //Editar departamento
                    System.out.print("Codigo departamento a editar");
                    String codEdt = kb.nextLine();
                    Departamento editar = null;
                    for (Departamento d4 : departamentos) {
                        if (d4.getCodigoDepartamento().equalsIgnoreCase(codEdt)) {
                            editar = d4;
                            break;
                        }
                    }
                    if (editar != null) {
                        System.out.print("Código: ");
                        codigo = kb.nextLine();
                        System.out.print("Nombre: ");
                        nombre = kb.nextLine();
                        editar.setCodigoDepartamento(codigo);
                        editar.setNombreDepartamento(nombre);
                        control.editarDepartamento(editar);
                    } else {
                        System.out.println("No existe departamento con código " + codEdt);
                    }
                    break;
                case 5:
                    // Eliminar departamento
                    System.out.print("Código a eliminar: ");
                    String codElim = kb.nextLine();
                    boolean eliminado = false;
                    for (int i = 0; i < departamentos.size(); i++) {
                        if (departamentos.get(i).getCodigoDepartamento().equalsIgnoreCase(codElim)) {
                            control.eliminarDepartamento(codElim); //eliminar registro del departamento
                            departamentos.remove(i);
                            eliminado = true;
                            break;
                        }
                    }
                    System.out.println(eliminado ? "Departamento eliminado." : "No se encontró departamento con código " + codElim);
                    break;

                case 6:
                    // Agregar empleado
                    System.out.print("Tipo doc: ");
                    String tipoDoc = kb.nextLine();
                    System.out.print("Número doc: ");
                    String numDoc = kb.nextLine();
                    System.out.print("Nombres: ");
                    String nombres = kb.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = kb.nextLine();
                    System.out.print("Código depto: ");
                    String deptCode = kb.nextLine();
                    Departamento dept = null;
                    idDpt = null;
                    try {
                        //se convierte la opcion leida en un long para no cambiar el tipo de scanner constantemente
                        idDpt = Long.valueOf(deptCode);
                    } catch (NumberFormatException e) {
                        System.out.println("Dato ingresado no corresponde a un ID");
                    }
                    Departamento d5 = control.buscarDepartamento(idDpt);
                    if (d5 == null) {
                        System.out.println("Departamento no existe.");
                    } else {
                        dept = d5;
                        Empleado e = new Empleado(tipoDoc, numDoc, nombres, apellidos, dept);
                        control.crearEmpleado(e);
                        empleados.add(e);
                        //e.setIdEmpleado(asignarEmpId++);
                        //edicion departamento
                        for (Departamento d4 : departamentos) {
                            if (d4.getIdDepartamento().equals(idDpt)) {
                                editar = d5;
                                editar.setEmpleados(empleados);
                                control.editarDepartamento(editar);
                                break;
                            }
                        }

                        //edicion departamento

                        System.out.println("Empleado creado con ID " + e.getIdEmpleado() + " en depto " + dept.getCodigoDepartamento());

                    }
                    break;

                case 7:
                    // Ver lista de empleados
                    /*for (Departamento d6 : departamentos) {
                        System.out.println("\n-- Empleados de " + d6.getCodigoDepartamento() + " --");
                        Map<Long, Empleado> emps = d6.getEmpleados();
                        if (emps.isEmpty()) {
                            System.out.println("(sin empleados)");
                        } else {
                            for (Long id : emps.keySet()) {
                                System.out.println(emps.get(id));
                            }
                        }
                    }*/
                    ArrayList<Empleado> listaEmpleados = control.mostrarListaEmpleados();
                    for(Empleado e2 : listaEmpleados){
                        System.out.println(e2);
                    }
                    break;

                case 0:
                    System.out.println("==== FIN DEL PROGRAMA ====");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
        kb.close();
    }
}

