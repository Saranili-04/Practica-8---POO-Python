import interfaces.*;
import excepciones.*;
public class ProfesorTiempoCompleto extends Persona implements Pagable {
    private double salarioMensual;

    public ProfesorTiempoCompleto(String nombre, String id, double salarioMensual) {
        super(nombre, id);
        this.salarioMensual = salarioMensual;
    }
    @Override
    public double calcularPago() throws PagoInvalidoException {
        if (salarioMensual <= 0)
            throw new PagoInvalidoException("Salario mensual no válido para: " + nombre);
        return salarioMensual;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Profesor de tiempo Completo: " + nombre + " con Id: " + id);
    }

}