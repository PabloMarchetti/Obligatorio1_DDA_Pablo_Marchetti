package Dominio;

public class Hotel {
    private int hoId;
    private String hoNombre;
    private String hoCiudad;
    private String hoPais;
    private int hoCantidadEstrellas;
    private String hoDireccion;
    private String hoZonaBarrio;
    private int cantidadDeHabitaciones;

    public int getHoId() {
        return hoId;
    }
    public void setHoId(int hoId) {
        this.hoId = hoId;
    }
    public String getHoNombre() {
        return hoNombre;
    }
    public void setHoNombre(String hoNombre) {
        this.hoNombre = hoNombre;
    }
    public String getHoCiudad() {
        return hoCiudad;
    }
    public void setHoCiudad(String hoCiudad) {
        this.hoCiudad = hoCiudad;
    }
    public String getHoPais() {
        return hoPais;
    }
    public void setHoPais(String hoPais) {
        this.hoPais = hoPais;
    }
    public int getHoCantidadEstrellas() {
        return hoCantidadEstrellas;
    }
    public void setHoCantidadEstrellas(int hoCantidadEstrellas) {
        this.hoCantidadEstrellas = hoCantidadEstrellas;
    }
    public String getHoDireccion() {
        return hoDireccion;
    }
    public void setHoDireccion(String hoDireccion) {
        this.hoDireccion = hoDireccion;
    }
    public String getHoZonaBarrio() {
        return hoZonaBarrio;
    }
    public void setHoZonaBarrio(String hoZonaBarrio) {
        this.hoZonaBarrio = hoZonaBarrio;
    }
    public int getCantidadDeHabitaciones() {
        return cantidadDeHabitaciones;
    }
    public void setCantidadDeHabitaciones(int cantidadDeHabitaciones) {
        this.cantidadDeHabitaciones = cantidadDeHabitaciones;
    }

    public Hotel(int hoId, String hoNombre, String hoCiudad, String hoPais, int hoCantidadEstrellas, String hoDireccion, String hoZonaBarrio) {
        this.hoId = hoId;
        this.hoNombre = hoNombre;
        this.hoCiudad = hoCiudad;
        this.hoPais = hoPais;
        this.hoCantidadEstrellas = hoCantidadEstrellas;
        this.hoDireccion = hoDireccion;
        this.hoZonaBarrio = hoZonaBarrio;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "Id=" + hoId +
                ", Nombre=' " + hoNombre + '\'' +
                ", Ciudad=' " + hoCiudad + '\'' +
                ", Pais=' " + hoPais + '\'' +
                ", Cantidad De Estrellas= " + hoCantidadEstrellas +
                ", Direccion=' " + hoDireccion + '\'' +
                ", Zona/Barrio=' " + hoZonaBarrio + '\'' +
               "Cantidad De Habitaciones=' "+getCantidadDeHabitaciones()+
                '}';
    }
}
