import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private int id;
    private String nombre;
    private List<Empleado> empleados;

    // Constructor
    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    // Método para obtener el ID del departamento
    public int getId() {
        return id;
    }

    // Método para agregar un empleado al departamento
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.asignarDepartamento(this);
    }

    // Método para remover un empleado del departamento
    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
        empleado.asignarDepartamento(null);
    }

    // Método para obtener la lista de empleados
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Departamento: " + nombre + " - Empleados: " + empleados.size();
    }
}