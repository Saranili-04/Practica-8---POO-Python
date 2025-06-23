import java.util.*;

public class Curso {
    private String nombreCurso;
    private List<Estudiante> estudiantes;
    private Persona profesorAsignado;

    public Curso(String nombreCurso, Persona profesorAsignado) {
        this.nombreCurso = nombreCurso;
        this.profesorAsignado = profesorAsignado;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void mostrarInfoCurso() {
        System.out.println("Curso: " + nombreCurso);
        System.out.print("Profesor: ");
        profesorAsignado.mostrarInfo();
        System.out.println("Estudiantes:");
        for (Estudiante e : estudiantes) {
            e.mostrarInfo();
        }
    }
}
