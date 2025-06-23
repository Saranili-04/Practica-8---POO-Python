import excepciones.*;
import interfaces.*;

public class ProfesorPorHoras extends Persona implements Pagable {
    private int horasTrabajadas;
    private double pagoPorHora;

    public ProfesorPorHoras(String nombre, String id, int horasTrabajadas, double pagoPorHora) {
        super(nombre, id);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }
    @Override
    public double calcularPago() throws PagoInvalidoException {
        double pago = horasTrabajadas * pagoPorHora;
        if (pago <= 0)
            throw new PagoInvalidoException("Pago por horas no válido hacia: " + nombre);
        return pago;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Profesor oor Horas: " + nombre + " con Id: " + id);
    }

}