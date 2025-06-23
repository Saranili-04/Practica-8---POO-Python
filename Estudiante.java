import java.util.*;
import excepciones.*;
import interfaces.*;

public class Estudiante extends Persona implements Calificable {
    private List<Double> calificaciones;

    public Estudiante(String nombre, String id) {
        super(nombre, id);
        this.calificaciones = new ArrayList<>();
    }
    public void agregarCalificacion(double nota) {
        calificaciones.add(nota);
    }

    @Override
    public double calcularPromedio() throws PromedioInvalidoException {
        if (calificaciones.isEmpty())
            throw new PromedioInvalidoException("No hay calificaciones para: " + nombre);
        double suma = 0;
        for (double nota : calificaciones)
            suma += nota;
        return suma / calificaciones.size();
    }
    @Override
    public void mostrarInfo() {
        System.out.println("Estudiante con boleta " + id + ": " + nombre);
    }
}
