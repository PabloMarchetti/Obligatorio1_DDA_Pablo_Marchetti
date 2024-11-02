package Dominio;

import java.time.LocalDate;

public class Tarifa {
    private int idTarifa;
    private int idHabitacion;
    private LocalDate fechaVigencia;
    private int precio;

    public int getIdTarifa() {
        return idTarifa;
    }
    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }
    public int getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }
    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Tarifa(int idTarifa, int idHabitacion, LocalDate fechaVigencia, int precio) {
        this.idTarifa = idTarifa;
        this.idHabitacion = idHabitacion;
        this.fechaVigencia = fechaVigencia;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "Id Tarifa=" + idTarifa +
                ", Id Habitacion=" + idHabitacion +
                ", Fecha De Vigencia=" + fechaVigencia +
                ", Precio=" + precio +
                '}';
    }
}
