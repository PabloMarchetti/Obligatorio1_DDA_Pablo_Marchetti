package Dominio;

public class Habitacion {
    private int haId;
    private int hotelId;
    private String tipoHabitacion;
    private int haCapacidadCamas;
    private String haCamaMatrimonial;
    private String haAireAcon;
    private String haBalcon;
    private String haVista;
    private int cantHaAmbientes;
    private String reservada;
    private Integer idReserva;
    private Integer idHuesped;
    private String conTarifa;
    private Integer idTarifa;

    public int getHaId() {
        return haId;
    }
    public void setHaId(int haId) {
        this.haId = haId;
    }
    public int getHotelId() {
        return hotelId;
    }
    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public int getHaCapacidadCamas() {
        return haCapacidadCamas;
    }
    public void setHaCapacidadCamas(int haCapacidadCamas) {
        this.haCapacidadCamas = haCapacidadCamas;
    }
    public String getHaCamaMatrimonial() {
        return haCamaMatrimonial;
    }
    public void setHaCamaMatrimonial(String haCamaMatrimonial) {
        this.haCamaMatrimonial = haCamaMatrimonial;
    }
    public String getHaAireAcon() {
        return haAireAcon;
    }
    public void setHaAireAcon(String haAireAcon) {
        this.haAireAcon = haAireAcon;
    }
    public String getHaBalcon() {
        return haBalcon;
    }
    public void setHaBalcon(String haBalcon) {
        this.haBalcon = haBalcon;
    }
    public String getHaVista() {
        return haVista;
    }
    public void setHaVista(String haVista) {
        this.haVista = haVista;
    }
    public int getCantHaAmbientes() {
        return cantHaAmbientes;
    }
    public void setCantHaAmbientes(int cantHaAmbientes) {
        this.cantHaAmbientes = cantHaAmbientes;
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }
    public String getReservada() {
        return reservada;
    }
    public void setReservada(String reservada) {
        this.reservada = reservada;
    }
    public int getIdHuesped() {
        return idHuesped;
    }
    public void setIdHuesped(Integer idHuesped) {
        this.idHuesped = idHuesped;
    }
    public String getConTarifa() {
        return conTarifa;
    }
    public void setConTarifa(String conTarifa) {
        this.conTarifa = conTarifa;
    }
    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }
    public Habitacion(int haId, int hotelId, String tipoHabitacion, int haCapacidadCamas, String haCamaMatrimonial, String haAireAcon, String haBalcon, String haVista, int cantHaAmbientes) {
        this.haId = haId;
        this.hotelId = hotelId;
        this.tipoHabitacion = tipoHabitacion;
        this.haCapacidadCamas = haCapacidadCamas;
        this.haCamaMatrimonial = haCamaMatrimonial;
        this.haAireAcon = haAireAcon;
        this.haBalcon = haBalcon;
        this.haVista = haVista;
        this.cantHaAmbientes = cantHaAmbientes;
    }
    @Override
    public String toString() {
        return "Habitacion{" +
                "ID=" + haId +
                ", Hotel Id=" + hotelId +
                ", Tipo='" + tipoHabitacion + '\'' +
                ", Capacidad Camas=" + haCapacidadCamas +
                ", Cama Matrimonial='" + haCamaMatrimonial + '\'' +
                ", Aire Acondicionado='" + haAireAcon + '\'' +
                ", Balcon='" + haBalcon + '\'' +
                ", Vista='" + haVista + '\'' +
                ", Cantidad De Ambientes=" + cantHaAmbientes +
                ", Reservada='" + reservada + '\'' +
                ", Id De La Reserva=" + idReserva +
                ", Huesped Que La Reservo=" + idHuesped +
                ", Tarifa='" + conTarifa + '\'' +
                ", Id De La Tarifa=" + idTarifa +
                '}';
    }
}
