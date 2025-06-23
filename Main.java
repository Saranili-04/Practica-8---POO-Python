import java.util.Scanner;

import excepciones.*;
import interfaces.*;
public class Main {
    public static void main(String[] args) {
        try {
            
            ProfesorTiempoCompleto ptc = new ProfesorTiempoCompleto("Luz Gomez Torres", "P001", 15000);
            ProfesorPorHoras pph = new ProfesorPorHoras("Carlos Panco", "P002", 40, 200);

            Estudiante e1 = new Estudiante("Ann Tomaroca", "2025009901");
            Estudiante e2 = new Estudiante("Alfedro Gutierrez", "2025009902");

            e1.agregarCalificacion(9.0);
            e1.agregarCalificacion(8.5);

            e2.agregarCalificacion(7.0);
            e2.agregarCalificacion(6.5);

            Curso curso1 = new Curso("Biología", ptc);
            curso1.agregarEstudiante(e1);
            curso1.agregarEstudiante(e2);

            Curso curso2 = new Curso("Base de Datos", pph);
            curso2.agregarEstudiante(e1);
            
            System.out.println("-- Información -- ");
            System.out.println("Estudiantes: ");
            System.out.println(e1.getNombre());
            System.out.println(e2.getNombre());
            System.out.println();
            System.out.println("Profesores: ");
            System.out.println(ptc.getNombre());
            System.out.println(pph.getNombre());

            System.out.println();
            System.out.println("--- CURSOS ---");
            curso1.mostrarInfoCurso();
            System.out.println();
            curso2.mostrarInfoCurso();

            System.out.println("\n--- PAGOS ---");
            System.out.println(ptc.getNombre() + ": $" + ptc.calcularPago());
            System.out.println(pph.getNombre() + ": $" + pph.calcularPago());

            System.out.println("\n--- PROMEDIOS ---");
            System.out.println(e1.getNombre() + ": " + e1.calcularPromedio());
            System.out.println(e2.getNombre() + ": " + e2.calcularPromedio());

        } catch (PagoInvalidoException | PromedioInvalidoException ex) {
            System.out.println("oh hau un error: " + ex.getMessage());
        }
    }
}
