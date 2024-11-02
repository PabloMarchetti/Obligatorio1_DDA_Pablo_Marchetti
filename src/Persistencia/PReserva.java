package Persistencia;

import Dominio.Reserva;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PReserva {

        private static Conexion conexion = new Conexion();

        public static boolean agregarReserva(Reserva r){
            String sql = "INSERT INTO reservas(idReserva, idHuesped, idHabitacion, cantPersonas, observaciones, pagadoCompletamente, periodoTiempo, fechaReserva, fechaOcup) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(r.getIdReserva(),r.getIdHuesped(),r.getIdHabitacion(),r.getCantPersonas(),r.getObservaciones(),r.getPagadoCompletamente(),r.getPeriodoTiempo(),r.getFechaReserva(),r.getFechaOcup()));
            return  conexion.consulta(sql,parametros);
        }

        public static Reserva buscarReserva(int pIdReserva) {
            String sql = "SELECT * FROM reservas WHERE idReserva = ?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdReserva));
            for(List<Object> registro : conexion.seleccion(sql, parametros)){
                int idReserva = (int) registro.get(0);
                int idHuesped = (int) registro.get(1);
                int idHabitacion = (int) registro.get(2);
                int cantPersonas = (int) registro.get(3);
                String observaciones = String.valueOf(registro.get(4));
                String pagadoCompletamente = String.valueOf(registro.get(5));
                String periodoTiempo = String.valueOf(registro.get(6));
                Date fecha1 = (Date)registro.get(7);
                LocalDate fechaReserva = fecha1.toLocalDate();
                Date fecha2 = (Date)registro.get(8);
                LocalDate fechaOcup = fecha2.toLocalDate();

                Reserva unaReserva = new Reserva(idReserva, idHuesped, idHabitacion, cantPersonas, observaciones, pagadoCompletamente, periodoTiempo, fechaReserva, fechaOcup);
                return unaReserva;
            }
            return null;
        }

        public static boolean eliminarReserva(int pReservaId){
            String sql = "DELETE FROM reservas WHERE idReserva=?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pReservaId));
            return conexion.consulta(sql,parametros);
        }

        public static ArrayList<Reserva> listarReservas(){
            String sql = "SELECT * FROM reservas";
            List<List<Object>> resultado = conexion.seleccion(sql, null);
            ArrayList<Reserva> reservas = new ArrayList<>();
            for(List<Object> registro : resultado) {
                int idReserva = (int) registro.get(0);
                int idHuesped = (int) registro.get(1);
                int idHabitacion = (int) registro.get(2);
                int cantPersonas = (int) registro.get(3);
                String observaciones = String.valueOf(registro.get(4));
                String pagadoCompletamente = String.valueOf(registro.get(5));
                String periodoTiempo = String.valueOf(registro.get(6));
                Date fecha1 = (Date)registro.get(7);
                LocalDate fechaReserva = fecha1.toLocalDate();
                Date fecha2 = (Date)registro.get(8);
                LocalDate fechaOcup = fecha2.toLocalDate();

                reservas.add(new Reserva(idReserva, idHuesped, idHabitacion, cantPersonas, observaciones, pagadoCompletamente, periodoTiempo, fechaReserva, fechaOcup));


            }
            return reservas;

        }

        public static boolean modificarReserva(Reserva r){
            String sql = "UPDATE reservas SET IdHabitacion=?, cantPersonas=?, observaciones=?, periodoTiempo=?, fechaOcup=? WHERE idReserva=?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                    r.getIdHabitacion(),
                    r.getCantPersonas(),
                    r.getObservaciones(),
                    r.getPeriodoTiempo(),
                    r.getFechaOcup(),
                    r.getIdReserva()
            ));

            return conexion.consulta(sql,parametros);

        }

}
