package Dominio;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private int idHuesped;
    private int idHabitacion;
    private int cantPersonas;
    private String observaciones;
    private String pagadoCompletamente;
    private String periodoTiempo;
    private LocalDate fechaReserva;
    private LocalDate fechaOcup;

    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public int getIdHuesped() {
        return idHuesped;
    }
    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }
    public int getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public int getCantPersonas() {
        return cantPersonas;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getPagadoCompletamente() {
        return pagadoCompletamente;
    }
    public void setPagadoCompletamente(String pagadoCompletamente) {
        this.pagadoCompletamente = pagadoCompletamente;
    }
    public String getPeriodoTiempo() {
        return periodoTiempo;
    }
    public void setPeriodoTiempo(String periodoTiempo) {
        this.periodoTiempo = periodoTiempo;
    }
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public LocalDate getFechaOcup() {
        return fechaOcup;
    }
    public void setFechaOcup(LocalDate fechaOcup) {
        this.fechaOcup = fechaOcup;
    }

    public Reserva(int idReserva, int idHuesped, int idHabitacion, int cantPersonas, String observaciones, String pagadoCompletamente, String periodoTiempo, LocalDate fechaReserva, LocalDate fechaOcup) {
        this.idReserva = idReserva;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.cantPersonas = cantPersonas;
        this.observaciones = observaciones;
        this.pagadoCompletamente = pagadoCompletamente;
        this.periodoTiempo = periodoTiempo;
        this.fechaReserva = fechaReserva;
        this.fechaOcup = fechaOcup;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "Id=" + idReserva +
                ", Id Huesped=" + idHuesped +
                ", Id Habitacion=" + idHabitacion +
                ", Cantidad de Personas=" + cantPersonas +
                ", Observaciones='" + observaciones + '\'' +
                ", Pago Completo='" + pagadoCompletamente + '\'' +
                ", Periodo De Tiempo='" + periodoTiempo + '\'' +
                ", Fecha De La Reserva=" + fechaReserva +
                ", Fecha De Ocupacion=" + fechaOcup +
                '}';
    }
}
