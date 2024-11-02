package Persistencia;

import Dominio.Tarifa;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PTarifa {

        private static Conexion conexion = new Conexion();

        public static boolean agregarTarifa(Tarifa t){
            String sql = "INSERT INTO tarifas(idTarifa, idHabitacion, idHotel, fechaVigencia, precio) VALUES(?, ?, ?, ?, ?)";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(t.getIdTarifa(),t.getIdHabitacion(),t.getFechaVigencia(),t.getPrecio()));
            return  conexion.consulta(sql,parametros);
        }

        public static Tarifa buscarTarifa(int pIdTarifa) {
            String sql = "SELECT * FROM tarifas WHERE idTarifa = ?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdTarifa));
            for(List<Object> registro : conexion.seleccion(sql, parametros)){
                int idTarifa = (int) registro.get(0);
                int idHabitacion = (int) registro.get(1);
                Date sqlDate = (Date)registro.get(2);
                // Convertir java.sql.Date a java.time.LocalDate
                LocalDate tarifaFechaVigencia = sqlDate.toLocalDate();
                int precio = (int) registro.get(3);


                Tarifa unaTarifa = new Tarifa(idTarifa,idHabitacion,tarifaFechaVigencia,precio);
                return unaTarifa;
            }
            return null;
        }

        public static boolean eliminarTarifa(int pTarifaId){
            String sql = "DELETE FROM tarifas WHERE idTarifa=?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pTarifaId));
            return conexion.consulta(sql,parametros);
        }

        public static ArrayList<Tarifa> listarTarifas(){
            String sql = "SELECT * FROM tarifas";
            List<List<Object>> resultado = conexion.seleccion(sql, null);
            ArrayList<Tarifa> tarifas = new ArrayList<>();
            for(List<Object> registro : resultado) {
                int idTarifa = (int) registro.get(0);
                int idHabitacion = (int) registro.get(1);;
                Date sqlDate = (Date)registro.get(2);
                // Convertir java.sql.Date a java.time.LocalDate
                LocalDate tarifaFechaVigencia = sqlDate.toLocalDate();
                int precio = (int) registro.get(3);

                tarifas.add(new Tarifa(idTarifa,idHabitacion,tarifaFechaVigencia,precio));

            }
            return tarifas;

        }

        public static boolean modificarTarifa(Tarifa t){
            String sql = "UPDATE tarifas SET IdHabitacion=?, fechaVigencia=?, precio=? WHERE idTarifa=?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                    t.getIdHabitacion(),
                    t.getFechaVigencia(),
                    t.getPrecio(),
                    t.getIdTarifa()
            ));

            return conexion.consulta(sql,parametros);

        }

    }

