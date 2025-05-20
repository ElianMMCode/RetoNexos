package logica;


import persistencia.ControladoraPersistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //lista de collections de departamentos
    private static final List<Departamento> departamentos = new ArrayList<>();
    //Ids para los empleados
    //private static long asignarDepId = 1L;
    //private static long asignarEmpId = 1L;

    public static void main(String[] args) {
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        Scanner kb = new Scanner(System.in);
        //si no consigue ninguna opcion salta al default
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Crear departamento");
            System.out.println("2. Listar departamentos");
            System.out.println("3. Buscar departamento");
            System.out.println("4. Eliminar departamento");
            System.out.println("5. Agregar empleado");
            System.out.println("6. Listar empleados");
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
                    Departamento d1 = new Departamento(codigo, nombre);
                    departamentos.add(d1);
                    //d1.setIdDepartamento(asignarDepId++);
                    System.out.println("Departamento creado: " + d1);
                    break;

                case 2:
                    // Mostrar departamentos registrados
                    if (departamentos.isEmpty()) {
                        System.out.println("No hay departamentos registrados.");
                    } else {
                        for (Departamento d2 : departamentos) {
                            System.out.println(d2);
                        }
                    }
                    break;

                case 3:
                    // Buscar departamento
                    System.out.print("Código a buscar: ");
                    String codBus = kb.nextLine();
                    Departamento encontrado = null;
                    for (Departamento d3 : departamentos) {
                        if (d3.getCodigoDepartamento().equalsIgnoreCase(codBus)) {
                            encontrado = d3;
                            break;
                        }
                    }
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No existe departamento con código " + codBus);
                    }
                    break;

                case 4:
                    // Eliminar departamento
                    System.out.print("Código a eliminar: ");
                    String codElim = kb.nextLine();
                    boolean eliminado = false;
                    for (int i = 0; i < departamentos.size(); i++) {
                        if (departamentos.get(i).getCodigoDepartamento().equalsIgnoreCase(codElim)) {
                            departamentos.remove(i);
                            eliminado = true;
                            break;
                        }
                    }
                    System.out.println(eliminado ? "Departamento eliminado." : "No se encontró departamento con código " + codElim);
                    break;

                case 5:
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
                    for (Departamento d4 : departamentos) {
                        if (d4.getCodigoDepartamento().equalsIgnoreCase(deptCode)) {
                            dept = d4;
                            break;
                        }
                    }
                    if (dept == null) {
                        System.out.println("Departamento no existe.");
                    } else {
                        Empleado e = new Empleado(tipoDoc, numDoc, nombres, apellidos);
                        //e.setIdEmpleado(asignarEmpId++);
                        e.setDepartamento(dept);
                        dept.agregarEmpleado(e);
                        System.out.println("Empleado creado con ID " + e.getIdEmpleado() + " en depto " + dept.getCodigoDepartamento());
                    }
                    break;

                case 6:
                    // Ver lista de empleados
                    for (Departamento d5 : departamentos) {
                        System.out.println("\n-- Empleados de " + d5.getCodigoDepartamento() + " --");
                        Map<Long, Empleado> emps = d5.getEmpleados();
                        if (emps.isEmpty()) {
                            System.out.println("(sin empleados)");
                        } else {
                            for (Long id : emps.keySet()) {
                                System.out.println(emps.get(id));
                            }
                        }
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

