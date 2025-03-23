public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private String tipoEmpleado; // "Permanente" o "Temporal"
    private double salario;
    private Departamento departamento;

    // Constructor
    public Empleado(int id, String nombre, String apellido, String tipoEmpleado, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoEmpleado = tipoEmpleado;
        this.salario = salario;
        this.departamento = null; // Inicialmente sin departamento
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void asignarDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " + nombre + " " + apellido + " - " + tipoEmpleado + " - Salario: $" + salario;
    }
}