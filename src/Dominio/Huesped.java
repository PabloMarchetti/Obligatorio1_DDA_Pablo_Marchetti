package Dominio;

import java.time.LocalDate;

public class Huesped {
   private int huesId;
   private String huesNombre;
   private String huesAPaterno;
   private String huesAMaterno;
   private String huesTipoDocumento;
   private int huesNumDocumento;
   private LocalDate huesFechaNacimiento;
   private String huesTelefono;
   private String huesPais;

    public int getHuesId() {
        return huesId;
    }
    public void setHuesId(int huesId) {
        this.huesId = huesId;
    }
    public String getHuesNombre() {
        return huesNombre;
    }
    public void setHuesNombre(String huesNombre) {
        this.huesNombre = huesNombre;
    }
    public String getHuesAPaterno() {
        return huesAPaterno;
    }
    public void setHuesAPaterno(String huesAPaterno) {
        this.huesAPaterno = huesAPaterno;
    }
    public String getHuesAMaterno() {
        return huesAMaterno;
    }
    public void setHuesAMaterno(String huesAMaterno) {
        this.huesAMaterno = huesAMaterno;
    }
    public String getHuesTipoDocumento() {
        return huesTipoDocumento;
    }
    public void setHuesTipoDocumento(String huesTipoDocumento) {
        this.huesTipoDocumento = huesTipoDocumento;
    }
    public int getHuesNumDocumento() {
        return huesNumDocumento;
    }
    public void setHuesNumDocumento(int huesNumDocumento) {
        this.huesNumDocumento = huesNumDocumento;
    }
    public LocalDate getHuesFechaNacimiento() {
        return huesFechaNacimiento;
    }
    public void setHuesFechaNacimiento(LocalDate huesFechaNacimiento) {
        this.huesFechaNacimiento = huesFechaNacimiento;
    }
    public String getHuesTelefono() {
        return huesTelefono;
    }
    public void setHuesTelefono(String huesTelefono) {
        this.huesTelefono = huesTelefono;
    }
    public String getHuesPais() {
        return huesPais;
    }
    public void setHuesPais(String huesPais) {
        this.huesPais = huesPais;
    }

    public Huesped(int huesId,String huesNombre, String huesAPaterno, String huesAMaterno, String huesTipoDocumento, int huesNumDocumento, LocalDate huesFechaNacimiento, String huesTelefono, String huesPais) {
        this.huesId = huesId;
        this.huesNombre = huesNombre;
        this.huesAPaterno = huesAPaterno;
        this.huesAMaterno = huesAMaterno;
        this.huesTipoDocumento = huesTipoDocumento;
        this.huesNumDocumento = huesNumDocumento;
        this.huesFechaNacimiento = huesFechaNacimiento;
        this.huesTelefono = huesTelefono;
        this.huesPais = huesPais;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "Id: " + huesId +
                ", Nombre:'" + huesNombre + '\'' +
                ", Apellido Paterno:'" + huesAPaterno + '\'' +
                ", Apellido Materno:" + huesAMaterno + '\'' +
                ", Tipo Documento:" + huesTipoDocumento + '\'' +
                ", Numero Documento:" + huesNumDocumento +
                ", Fecha Nacimiento:" + huesFechaNacimiento + '\'' +
                ", Telefono:" + huesTelefono + '\'' +
                ", Pais:" + huesPais + '\'' +
                '}';
    }
}
