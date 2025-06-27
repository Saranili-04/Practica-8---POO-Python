from abc import ABC, abstractmethod

class PagoInvalidoException(Exception):
    pass

class PromedioInvalidoException(Exception):
    pass

class Pagable(ABC):
    @abstractmethod
    def calcular_pago(self):
        pass

class Calificable(ABC):
    @abstractmethod
    def calcular_promedio(self):
        pass

class Persona(ABC):
    def __init__(self, nombre, id_):
        self.nombre = nombre
        self.id = id_

    @abstractmethod
    def mostrar_info(self):
        pass

class ProfesorTiempoCompleto(Persona, Pagable):
    def __init__(self, nombre, id_, salario_mensual):
        super().__init__(nombre, id_)
        self.salario_mensual = salario_mensual

    def calcular_pago(self):
        if self.salario_mensual <= 0:
            raise PagoInvalidoException(f"Salario mensual inválido para {self.nombre}")
        return self.salario_mensual

    def mostrar_info(self):
        print(f"Profesor Tiempo Completo: {self.nombre} | ID: {self.id}")


class ProfesorPorHoras(Persona, Pagable):
    def __init__(self, nombre, id_, horas_trabajadas, pago_por_hora):
        super().__init__(nombre, id_)
        self.horas_trabajadas = horas_trabajadas
        self.pago_por_hora = pago_por_hora

    def calcular_pago(self):
        pago = self.horas_trabajadas * self.pago_por_hora
        if pago <= 0:
            raise PagoInvalidoException(f"Pago por horas inválido para {self.nombre}")
        return pago

    def mostrar_info(self):
        print(f"Profesor Por Horas: {self.nombre} | ID: {self.id}")

class Estudiante(Persona, Calificable):
    def __init__(self, nombre, id_):
        super().__init__(nombre, id_)
        self.calificaciones = []

    def agregar_calificacion(self, nota):
        self.calificaciones.append(nota)

    def calcular_promedio(self):
        if not self.calificaciones:
            raise PromedioInvalidoException(f"No hay calificaciones para {self.nombre}")
        return sum(self.calificaciones) / len(self.calificaciones)

    def mostrar_info(self):
        print(f"Estudiante: {self.nombre} | ID: {self.id}")

class Curso:
    def __init__(self, nombre_curso, profesor_asignado):
        self.nombre_curso = nombre_curso
        self.profesor_asignado = profesor_asignado
        self.estudiantes = []

    def agregar_estudiante(self, estudiante):
        self.estudiantes.append(estudiante)

    def mostrar_info_curso(self):
        print(f"Curso: {self.nombre_curso}")
        print("Profesor:")
        self.profesor_asignado.mostrar_info()
        print("Estudiantes:")
        for est in self.estudiantes:
            est.mostrar_info()

def main():
    try:
        ptc = ProfesorTiempoCompleto("Laura García", "P001", 15000)
        pph = ProfesorPorHoras("Carlos Panco", "P002", 40, 200)

        e1 = Estudiante("Ann Tomaroca", "E001")
        e2 = Estudiante("Luz Gómez Torres", "E002")

        e1.agregar_calificacion(9.0)
        e1.agregar_calificacion(8.5)

        e2.agregar_calificacion(7.0)
        e2.agregar_calificacion(6.5)

        curso1 = Curso("Biologia", ptc)
        curso1.agregar_estudiante(e1)
        curso1.agregar_estudiante(e2)

        curso2 = Curso("Base de Datos", pph)
        curso2.agregar_estudiante(e1)

        print("\n--- CURSOS ---")
        curso1.mostrar_info_curso()
        print()
        curso2.mostrar_info_curso()

        print("\n--- PAGOS ---")
        print(f"{ptc.nombre}: ${ptc.calcular_pago()}")
        print(f"{pph.nombre}: ${pph.calcular_pago()}")

        print("\n--- PROMEDIOS ---")
        print(f"{e1.nombre}: {e1.calcular_promedio():.2f}")
        print(f"{e2.nombre}: {e2.calcular_promedio():.2f}")

    except (PagoInvalidoException, PromedioInvalidoException) as ex:
        print(f"ERROR: {ex}")


if __name__ == "__main__":
    main()
