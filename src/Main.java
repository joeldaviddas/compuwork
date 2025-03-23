import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Departamento> departamentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    editarEmpleado();
                    break;
                case 3:
                    eliminarEmpleado();
                    break;
                case 4:
                    crearDepartamento();
                    break;
                case 5:
                    asignarEmpleadoADepartamento();
                    break;
                case 6:
                    generarReporteDesempeño();
                    break;
                case 7:
                    imprimirReportes();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de CompuWork ---");
        System.out.println("1. Crear Empleado");
        System.out.println("2. Editar Empleado");
        System.out.println("3. Eliminar Empleado");
        System.out.println("4. Crear Departamento");
        System.out.println("5. Asignar Empleado a Departamento");
        System.out.println("6. Generar Reporte de Desempeño");
        System.out.println("7. Imprimir Reportes");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearEmpleado() {
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del empleado: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el tipo de empleado (Permanente/Temporal): ");
        String tipoEmpleado = scanner.nextLine();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        Empleado empleado = new Empleado(id, nombre, apellido, tipoEmpleado, salario);
        empleados.add(empleado);
        System.out.println("Empleado creado exitosamente.");
    }

    private static void editarEmpleado() {
        System.out.print("Ingrese el ID del empleado a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Empleado empleado = buscarEmpleadoPorId(id);
        if (empleado != null) {
            System.out.print("Ingrese el nuevo nombre del empleado: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo apellido del empleado: ");
            String apellido = scanner.nextLine();
            System.out.print("Ingrese el nuevo tipo de empleado (Permanente/Temporal): ");
            String tipoEmpleado = scanner.nextLine();
            System.out.print("Ingrese el nuevo salario del empleado: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setTipoEmpleado(tipoEmpleado);
            empleado.setSalario(salario);
            System.out.println("Empleado editado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void eliminarEmpleado() {
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Empleado empleado = buscarEmpleadoPorId(id);
        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("Empleado eliminado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void crearDepartamento() {
        System.out.print("Ingrese el ID del departamento: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nombre del departamento: ");
        String nombre = scanner.nextLine();

        Departamento departamento = new Departamento(id, nombre);
        departamentos.add(departamento);
        System.out.println("Departamento creado exitosamente.");
    }

    private static void asignarEmpleadoADepartamento() {
        System.out.print("Ingrese el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el ID del departamento: ");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Empleado empleado = buscarEmpleadoPorId(idEmpleado);
        Departamento departamento = buscarDepartamentoPorId(idDepartamento);

        if (empleado != null && departamento != null) {
            departamento.agregarEmpleado(empleado);
            System.out.println("Empleado asignado al departamento exitosamente.");
        } else {
            System.out.println("Empleado o departamento no encontrado.");
        }
    }

    private static void generarReporteDesempeño() {
        System.out.print("Ingrese el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Empleado empleado = buscarEmpleadoPorId(idEmpleado);
        if (empleado != null) {
            System.out.print("Ingrese la calificación del empleado (1-10): ");
            double calificacion = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            ReporteDesempeño reporte = new ReporteDesempeño(empleado, calificacion);
            System.out.println(reporte.generarReporte());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void imprimirReportes() {
        System.out.println("\n--- Reportes de Empleados ---");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        System.out.println("\n--- Reportes de Departamentos ---");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
    }

    private static Empleado buscarEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;
    }

    private static Departamento buscarDepartamentoPorId(int id) {
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == id) {
                return departamento;
            }
        }
        return null;
    }
}