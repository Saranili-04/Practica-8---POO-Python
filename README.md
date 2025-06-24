# Práctica 8: Sistema de Gestión de Cursos Académicos Multilenguaje
## Objetivo del Proyecto
El objetivo de este sistema es crear una plataforma simple que permita:

	•Registrar profesores (de tiempo completo y por horas)
 
	•Registrar estudiantes con sus calificaciones
 
	•Asociar estudiantes y profesores a cursos
 
	•Calcular promedios de estudiantes y pagos de profesores
 
	•Mostrar información estructurada del curso, profesores y estudiantes

El objetivo principal del proyecto es desarrollar un sistema académico modular y escalable que a través de una arquitectura orientada a objetos. Este sistema se ha implementado en dos lenguajes de programación: Java y Python, con el propósito de mostrar cómo se puede mantener la lógica y diseño en múltiples plataformas de desarrollo.

## Características Comunes del Sistema

## Versión en Java
Este proyecto pone en práctica conceptos clave de Programación Orientada a Objetos en Java: abstracción, herencia, interfaces, polimorfismo, excepciones personalizadas y colecciones (List, ArrayList).

**Estructura de Archivos**
/SistemaCursosJava

│
├── Main.java

├── MainConScannerDatos.java

├── Curso.java

├── Persona.java

├── Estudiante.java

├── ProfesorPorHoras.java

├── ProfesorTiempoCompleto.java

│

├── interfaces/

│   ├── Pagable.java

│   └── Calificable.java

│

└── excepciones/

    ├── PagoInvalidoException.java
    
    └── PromedioInvalidoException.java
   
**Elementos Clave** 

	•Interfaces: Pagable, Calificable
 
	•Excepciones: PagoInvalidoException, PromedioInvalidoException
 
	•POO: Uso fuerte de encapsulamiento, herencia, abstracción y polimorfismo
 
	•Listas: ArrayList

**Instrucciones de Compilación**
javac */*.java *.java
java MainConScannerDatos

## Versión en Python
