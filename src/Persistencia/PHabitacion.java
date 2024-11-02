package Persistencia;

import Dominio.Habitacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PHabitacion {

    private static Conexion conexion = new Conexion();

    public static boolean agregarHabitacion(Habitacion h) {
        String sql = "INSERT INTO habitaciones (idHabitacion, idHotel, tipoHabitacion, capCamas, camaMat, aireAcon, balHabitacion, vistaHabitacion, cantAmbiHabitacion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(h.getHaId(), h.getHotelId(), h.getTipoHabitacion(), h.getHaCapacidadCamas(), h.getHaCamaMatrimonial(), h.getHaAireAcon(), h.getHaBalcon(), h.getHaVista(), h.getCantHaAmbientes()));
        return conexion.consulta(sql, parametros);
    }

    public static Habitacion buscarHabitacion(int pIdHabitacion) {
        String sql = "SELECT * FROM habitaciones WHERE idHabitacion = ?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdHabitacion));
        for (List<Object> registro : conexion.seleccion(sql, parametros)) {
            int haId = (int) registro.get(0);
            int hotelId = (int) registro.get(1);
            String tipoHabitacion = String.valueOf(registro.get(2));
            int haCapacidadCamas = (int) registro.get(3);
            String haCamaMatrimonial = String.valueOf(registro.get(4));
            String haAireAcon = String.valueOf(registro.get(5));
            String haBalcon = String.valueOf(registro.get(6));
            String haVista = String.valueOf(registro.get(7));
            int cantHaAmbientes = (int) registro.get(8);

            Habitacion unaHabitacion = new Habitacion(haId, hotelId, tipoHabitacion, haCapacidadCamas, haCamaMatrimonial, haAireAcon, haBalcon, haVista, cantHaAmbientes);
            return unaHabitacion;
        }
        return null;
    }

    public static boolean eliminarHabitacion(int pHaId) {
        String sql = "DELETE FROM habitaciones WHERE idHabitacion=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pHaId));
        return conexion.consulta(sql, parametros);
    }

    public static ArrayList<Habitacion> listarHabitacion() {
        String sql = "SELECT h.idHabitacion, h.idHotel, h.tipoHabitacion, h.capCamas, h.camaMat, h.aireAcon, h.balHabitacion, h.vistaHabitacion, h.cantAmbiHabitacion,  r.idReserva,  CASE WHEN r.idReserva IS NOT NULL THEN 'si' ELSE 'no' END AS reservada, r.idHuesped, t.idTarifa, CASE WHEN t.idTarifa IS NOT NULL THEN 'si' ELSE 'no' END AS conTarifa FROM habitaciones h LEFT JOIN reservas r ON h.idHabitacion = r.idHabitacion LEFT JOIN tarifas t ON h.idHabitacion = t.idHabitacion;";
        List<List<Object>> resultado = conexion.seleccion(sql, null);
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        for (List<Object> registro : resultado) {
            int haId = (int) registro.get(0);
            int hotelId = (int) registro.get(1);
            String tipoHabitacion = String.valueOf(registro.get(2));
            int haCapacidadCamas = (int) registro.get(3);
            String haCamaMatrimonial = String.valueOf(registro.get(4));
            String haAireAcon = String.valueOf(registro.get(5));
            String haBalcon = String.valueOf(registro.get(6));
            String haVista = String.valueOf(registro.get(7));
            int cantHaAmbientes = (int) registro.get(8);
            Integer idReserva = registro.get(9) != null ? (Integer) registro.get(9) : null;
            String reservada = String.valueOf(registro.get(10));
            Integer idHuesped = registro.get(11) != null ? (Integer) registro.get(11) : null;
            Integer idTarifa = registro.get(12) != null ? (Integer) registro.get(12) : null;
            String conTarifa = String.valueOf(registro.get(13));


            Habitacion habitacion = new Habitacion(haId, hotelId, tipoHabitacion, haCapacidadCamas, haCamaMatrimonial, haAireAcon, haBalcon, haVista, cantHaAmbientes);
            habitacion.setIdReserva(idReserva);
            habitacion.setReservada(reservada);
            habitacion.setIdHuesped(idHuesped);
            habitacion.setConTarifa(conTarifa);
            habitacion.setIdTarifa(idTarifa);

            habitaciones.add(habitacion);
        }

        return habitaciones;
    }

    public static boolean modificarHabitacion(Habitacion h) {
        String sql = "UPDATE habitaciones SET tipoHabitacion=?, capCamas=?, camaMat=?, aireAcon=?, balHabitacion=?, vistaHabitacion=?, cantAmbiHabitacion=? WHERE idHabitacion=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                h.getTipoHabitacion(),
                h.getHaCapacidadCamas(),
                h.getHaCamaMatrimonial(),
                h.getHaAireAcon(),
                h.getHaBalcon(),
                h.getHaVista(),
                h.getCantHaAmbientes(),
                h.getHaId()
        ));

        return conexion.consulta(sql, parametros);

    }

    //CONSULTAS
    public static ArrayList<Habitacion> listarHabitacionesPorPeriodoDeReserva(LocalDate fechaInicio, LocalDate fechaFin) {
        String sql = "SELECT h.idHabitacion, h.idHotel, h.tipoHabitacion, h.capCamas, h.camaMat, h.aireAcon, h.balHabitacion, h.vistaHabitacion, h.cantAmbiHabitacion, r.idReserva, r.idHuesped, t.idTarifa, CASE WHEN t.idTarifa IS NOT NULL THEN 'si' ELSE 'no' END AS conTarifa FROM habitaciones h LEFT JOIN reservas r ON h.idHabitacion = r.idHabitacion LEFT JOIN tarifas t ON h.idHabitacion = t.idHabitacion WHERE r.fechaReserva >= ? AND r.fechaReserva <= ?";

        List<Object> parametros = new ArrayList<>();
        parametros.add(fechaInicio);
        parametros.add(fechaFin);

        List<List<Object>> resultado = conexion.seleccion(sql, parametros);
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        for (List<Object> registro : resultado) {
            int haId = (int) registro.get(0);
            int hotelId = (int) registro.get(1);
            String tipoHabitacion = String.valueOf(registro.get(2));
            int haCapacidadCamas = (int) registro.get(3);
            String haCamaMatrimonial = String.valueOf(registro.get(4));
            String haAireAcon = String.valueOf(registro.get(5));
            String haBalcon = String.valueOf(registro.get(6));
            String haVista = String.valueOf(registro.get(7));
            int cantHaAmbientes = (int) registro.get(8);
            int idReserva = (int) registro.get(9);
            Integer idHuesped = registro.get(10) != null ? (Integer) registro.get(10) : null;
            Integer idTarifa = registro.get(11) != null ? (Integer) registro.get(11) : null;
            String conTarifa = String.valueOf(registro.get(12));

            Habitacion habitacion = new Habitacion(haId, hotelId, tipoHabitacion, haCapacidadCamas, haCamaMatrimonial, haAireAcon, haBalcon, haVista, cantHaAmbientes);
            habitacion.setIdReserva(idReserva);
            habitacion.setReservada("si");
            habitacion.setIdHuesped(idHuesped);
            habitacion.setConTarifa(conTarifa);
            habitacion.setIdTarifa(idTarifa);

            habitaciones.add(habitacion);
        }

        return habitaciones;
    }

    public static ArrayList<Habitacion> listarHabitacionConReserva() {
        String sql = "SELECT h.idHabitacion, h.idHotel, h.tipoHabitacion, h.capCamas, h.camaMat, h.aireAcon, h.balHabitacion, h.vistaHabitacion, h.cantAmbiHabitacion, r.idReserva, r.idHuesped, t.idTarifa, CASE WHEN t.idTarifa IS NOT NULL THEN 'si' ELSE 'no' END AS conTarifa FROM habitaciones h INNER JOIN reservas r ON h.idHabitacion = r.idHabitacion LEFT JOIN tarifas t ON h.idHabitacion = t.idHabitacion";
        List<List<Object>> resultado = conexion.seleccion(sql, null);
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        for (List<Object> registro : resultado) {
            int haId = (int) registro.get(0);
            int hotelId = (int) registro.get(1);
            String tipoHabitacion = String.valueOf(registro.get(2));
            int haCapacidadCamas = (int) registro.get(3);
            String haCamaMatrimonial = String.valueOf(registro.get(4));
            String haAireAcon = String.valueOf(registro.get(5));
            String haBalcon = String.valueOf(registro.get(6));
            String haVista = String.valueOf(registro.get(7));
            int cantHaAmbientes = (int) registro.get(8);
            Integer idReserva = registro.get(9) != null ? (Integer) registro.get(9) : null;
            Integer idHuesped = registro.get(10) != null ? (Integer) registro.get(10) : null;
            Integer idTarifa = registro.get(11) != null ? (Integer) registro.get(11) : null;
            String conTarifa = String.valueOf(registro.get(12));

            Habitacion habitacion = new Habitacion(haId, hotelId, tipoHabitacion, haCapacidadCamas, haCamaMatrimonial, haAireAcon, haBalcon, haVista, cantHaAmbientes);
            habitacion.setIdReserva(idReserva);
            habitacion.setReservada("SI");
            habitacion.setIdHuesped(idHuesped);
            habitacion.setConTarifa(conTarifa);
            habitacion.setIdTarifa(idTarifa);

            habitaciones.add(habitacion);
        }

        return habitaciones;
    }

    // Filtra solo las habitaciones que no tienen reservas ya que r.idReserva será NULL para las habitaciones sin reservas
    public static ArrayList<Habitacion> listarHabitacionSinReserva() {
        String sql = "SELECT h.idHabitacion, h.idHotel, h.tipoHabitacion, h.capCamas, h.camaMat, h.aireAcon, h.balHabitacion, h.vistaHabitacion, h.cantAmbiHabitacion, r.idReserva, r.idHuesped, T.idTarifa, CASE WHEN t.idTarifa IS NOT NULL THEN 'si' ELSE 'no' END AS conTarifa FROM habitaciones h LEFT JOIN reservas r ON h.idHabitacion = r.idHabitacion LEFT JOIN tarifas t ON h.idHabitacion = t.idHabitacion WHERE r.idReserva IS NULL";
        List<List<Object>> resultado = conexion.seleccion(sql, null);
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        for (List<Object> registro : resultado) {
            int haId = (int) registro.get(0);
            int hotelId = (int) registro.get(1);
            String tipoHabitacion = String.valueOf(registro.get(2));
            int haCapacidadCamas = (int) registro.get(3);
            String haCamaMatrimonial = String.valueOf(registro.get(4));
            String haAireAcon = String.valueOf(registro.get(5));
            String haBalcon = String.valueOf(registro.get(6));
            String haVista = String.valueOf(registro.get(7));
            int cantHaAmbientes = (int) registro.get(8);
            Integer idReserva = registro.get(9) != null ? (Integer) registro.get(9) : null;
            Integer idHuesped = registro.get(10) != null ? (Integer) registro.get(10) : null;
            Integer idTarifa = registro.get(11) != null ? (Integer) registro.get(11) : null;
            String conTarifa = String.valueOf(registro.get(12));

            Habitacion habitacion = new Habitacion(haId, hotelId, tipoHabitacion, haCapacidadCamas, haCamaMatrimonial, haAireAcon, haBalcon, haVista, cantHaAmbientes);
            habitacion.setIdReserva(idReserva);
            habitacion.setReservada("no");
            habitacion.setIdHuesped(idHuesped);
            habitacion.setConTarifa(conTarifa);
            habitacion.setIdTarifa(idTarifa);

            habitaciones.add(habitacion);
        }

        return habitaciones;
    }

    public static ArrayList<Habitacion> listarHabitacionesPorHotel(int pidHotel) {
        String sql = "SELECT h.idHabitacion, h.idHotel, h.tipoHabitacion, h.capCamas, h.camaMat, h.aireAcon, h.balHabitacion, h.vistaHabitacion, h.cantAmbiHabitacion, r.idReserva,  CASE WHEN r.idReserva IS NOT NULL THEN 'SI' ELSE 'NO' END AS reservada, r.idHuesped, t.idTarifa, CASE WHEN t.idTarifa IS NOT NULL THEN 'SI' ELSE 'NO' END AS conTarifa FROM habitaciones h LEFT JOIN reservas r ON h.idHabitacion = r.idHabitacion LEFT JOIN tarifas t ON h.idHabitacion = t.idHabitacion WHERE h.idHotel = ?";

        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pidHotel));
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        for (List<Object> registro : conexion.seleccion(sql, parametros)) {
            Integer haId = registro.get(0) != null ? (Integer) registro.get(0) : null;
            Integer hotelId = registro.get(1) != null ? (Integer) registro.get(1) : null;
            String tipoHabitacion = registro.get(2) != null ? String.valueOf(registro.get(2)) : "";
            Integer haCapacidadCamas = registro.get(3) != null ? (Integer) registro.get(3) : null;
            String haCamaMatrimonial = registro.get(4) != null ? String.valueOf(registro.get(4)) : "";
            String haAireAcon = registro.get(5) != null ? String.valueOf(registro.get(5)) : "";
            String haBalcon = registro.get(6) != null ? String.valueOf(registro.get(6)) : "";
            String haVista = registro.get(7) != null ? String.valueOf(registro.get(7)) : "";
            Integer cantHaAmbientes = registro.get(8) != null ? (Integer) registro.get(8) : null;

            Integer idReserva = registro.get(9) != null ? (Integer) registro.get(9) : null;
            String reservada = registro.get(10) != null ? String.valueOf(registro.get(10)) : "no";
            Integer idHuesped = registro.get(11) != null ? (Integer) registro.get(11) : null;

            Integer idTarifa = registro.get(12) != null ? (Integer) registro.get(12) : null;
            String conTarifa = registro.get(13) != null ? String.valueOf(registro.get(13)) : "no";


            Habitacion habitacion = new Habitacion(haId, hotelId, tipoHabitacion, haCapacidadCamas, haCamaMatrimonial, haAireAcon, haBalcon, haVista, cantHaAmbientes);
            habitacion.setIdReserva(idReserva);
            habitacion.setReservada(reservada);
            habitacion.setIdHuesped(idHuesped);
            habitacion.setConTarifa(conTarifa);
            habitacion.setIdTarifa(idTarifa);

            habitaciones.add(habitacion);
        }

        return habitaciones;
    }
}

