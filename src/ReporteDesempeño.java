public class ReporteDesempeño {
    private Empleado empleado;
    private double calificacion; // Calificación del 1 al 10

    // Constructor
    public ReporteDesempeño(Empleado empleado, double calificacion) {
        this.empleado = empleado;
        this.calificacion = calificacion;
    }

    // Método para generar el reporte
    public String generarReporte() {
        String desempenio;
        if (calificacion >= 9) {
            desempenio = "Excelente";
        } else if (calificacion >= 6) {
            desempenio = "Bueno";
        } else {
            desempenio = "Malo";
        }

        return "Reporte de Desempeño para " + empleado.getNombre() + " " + empleado.getApellido() + ":\n" +
                "Calificación: " + calificacion + "\n" +
                "Desempeño: " + desempenio;
    }
}