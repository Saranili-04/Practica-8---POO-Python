import java.util.Scanner;

import excepciones.*;
import interfaces.*;
import java.util.*;

public class MainConScannerDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();

        System.out.println("--- Sistema de Gestión de Cursos ---");

        System.out.print("Ingresa la cantidad de profesores a registrar: ");
        int nProfesores = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nProfesores; i++) {
            System.out.println("\nProfesor número " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Número de empleado: ");
            String id = scanner.nextLine();

            System.out.print("Ingresa si es de: tiempo completo (1) o por horas (2): ");
            int tipo = scanner.nextInt();

            if (tipo == 1) {
                System.out.print("Salario mensual: ");
                double salario = scanner.nextDouble();
                scanner.nextLine();
                personas.add(new ProfesorTiempoCompleto(nombre, id, salario));
            } else {
                System.out.print("Horas trabajadas: ");
                int horas = scanner.nextInt();
                System.out.print("Pago por hora: ");
                double pago = scanner.nextDouble();
                scanner.nextLine();
                personas.add(new ProfesorPorHoras(nombre, id, horas, pago));
            }
        }

        System.out.print("\nIngresa la cantidad de estudiantes a registrar ");
        int nEstudiantes = scanner.nextInt();
        scanner.nextLine();

        List<Estudiante> estudiantes = new ArrayList<>();

        for (int i = 0; i < nEstudiantes; i++) {
            System.out.println("\nEstudiante número:" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Boleta: ");
            String id = scanner.nextLine();

            Estudiante est = new Estudiante(nombre, id);
            System.out.print("Ingresa la cantidad de calificaciones a registrar: ");
            int nCalif = scanner.nextInt();

            for (int j = 0; j < nCalif; j++) {
                System.out.print("Calificación " + (j + 1) + ": ");
                double cal = scanner.nextDouble();
                est.agregarCalificacion(cal);
            }
            scanner.nextLine();
            estudiantes.add(est);
            personas.add(est);
        }

        System.out.print("\nIngresa la cantidad de cuross a registrar ");
        int nCursos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nCursos; i++) {
            System.out.println("\nCurso número " + (i + 1));
            System.out.print("Nombre del curso: ");
            String nombreCurso = scanner.nextLine();

            System.out.println("Elige al profesor para este curso (por índice): ");
            for (int j = 0; j < personas.size(); j++) {
                if (personas.get(j) instanceof Pagable) {
                    System.out.println(j + " - " + personas.get(j).getNombre());
                }
            }
            int idxProfesor = scanner.nextInt();
            scanner.nextLine();

            Curso curso = new Curso(nombreCurso, personas.get(idxProfesor));

            System.out.print("Ingresa la cantidad de estudiantes a ingresar al curso ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            for (int k = 0; k < cantidad; k++) {
                System.out.println("Elige estudiante por índice:");
                for (int j = 0; j < estudiantes.size(); j++) {
                    System.out.println(j + " - " + estudiantes.get(j).getNombre());
                }
                int idxEst = scanner.nextInt();
                scanner.nextLine();
                curso.agregarEstudiante(estudiantes.get(idxEst));
            }

            cursos.add(curso);
        }

        System.out.println("\n--- Cursos Registrados ---");
        for (Curso curso : cursos) {
            curso.mostrarInfoCurso();
            System.out.println();
        }

        System.out.println("--- Pagos a Profesores ---");
        for (Persona p : personas) {
            if (p instanceof Pagable pagable) {
                try {
                    System.out.println(p.getNombre() + " = $" + pagable.calcularPago());
                } catch (PagoInvalidoException e) {
                    System.out.println("Error de pago: " + e.getMessage());
                }
            }
        }

        System.out.println("\n--- Promedio de Estudiantes ---");
        for (Estudiante e : estudiantes) {
            try {
                System.out.println(e.getNombre() + " = Promedio: " + e.calcularPromedio());
            } catch (PromedioInvalidoException e1) {
                System.out.println("Error de promedio: " + e1.getMessage());
            }
        }

        scanner.close();
    }
}

