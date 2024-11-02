package Persistencia;

import Dominio.Huesped;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PHuesped {

        private static Conexion conexion = new Conexion();

        public static boolean agregarHuesped(Huesped h){
            String sql = "INSERT INTO huespedes(nomHuesped, aPatHuesped, aMatHuesped, tipoDocHuesped, numDocHuesped, fechaNacHuesped, telHuesped, PaisHuesped) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                    h.getHuesNombre(),
                    h.getHuesAPaterno(),
                    h.getHuesAMaterno(),
                    h.getHuesTipoDocumento(),
                    h.getHuesNumDocumento(),
                    h.getHuesFechaNacimiento(),
                    h.getHuesTelefono(),
                    h.getHuesPais()));
            return  conexion.consulta(sql,parametros);
        }

        public static Huesped buscarHuesped(int pIdHuesped) {
        String sql = "SELECT * FROM huespedes WHERE idHuesped = ?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdHuesped));

        for (List<Object> registro : conexion.seleccion(sql, parametros)) {
            int huesId = (int) registro.get(0);
            String huesNombre = String.valueOf(registro.get(1));
            String huesAPaterno = String.valueOf(registro.get(2));
            String huesAMaterno = String.valueOf(registro.get(3));
            String huesTipoDocumento = String.valueOf(registro.get(4));
            int huesNumDocumento = (int) registro.get(5);
            // Obtener el java.sql.Date de la base de datos
            Date fecha = (Date)registro.get(6);
            // Convertir java.sql.Date a java.time.LocalDate
            LocalDate huesFechaNacimiento = fecha.toLocalDate();
            String huesTelefono = String.valueOf(registro.get(7));
            String huesPais = String.valueOf(registro.get(8));

            Huesped unHuesped = new Huesped(huesId, huesNombre, huesAPaterno, huesAMaterno, huesTipoDocumento, huesNumDocumento, huesFechaNacimiento, huesTelefono, huesPais);
            return unHuesped;
        }
        return null;
    }

        public static boolean eliminarHuesped(int pHuId){
            String sql = "DELETE FROM huespedes WHERE idHuesped=?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pHuId));
            return conexion.consulta(sql,parametros);
        }

        public static ArrayList<Huesped> listarHuespedes(){
            String sql = "SELECT * FROM huespedes";
            List<List<Object>> resultado = conexion.seleccion(sql, null);
            ArrayList<Huesped> huespedes = new ArrayList<>();
            for(List<Object> registro : resultado) {
                int huesId = (int) registro.get(0);
                String huesNombre = String.valueOf(registro.get(1));
                String huesAPaterno = String.valueOf(registro.get(2));
                String huesAMaterno = String.valueOf(registro.get(3));
                String huesTipoDocumento = String.valueOf(registro.get(4));
                int huesNumDocumento = (int) registro.get(5);
                // Obtener el java.sql.Date de la base de datos
                Date fecha = (Date)registro.get(6);
                // Convertir java.sql.Date a java.time.LocalDate
                LocalDate huesFechaNacimiento = fecha.toLocalDate();
                String huesTelefono = String.valueOf(registro.get(7));
                String huesPais = String.valueOf(registro.get(8));

                huespedes.add(new Huesped(huesId, huesNombre, huesAPaterno, huesAMaterno, huesTipoDocumento, huesNumDocumento, huesFechaNacimiento, huesTelefono, huesPais));


            }
            return huespedes;

        }

        public static boolean modificarHuesped(Huesped h){
            String sql = "UPDATE huespedes SET nomHuesped=?, aPatHuesped=?, aMatHuesped=?, telHuesped=? WHERE idHuesped=?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                    h.getHuesNombre(),
                    h.getHuesAPaterno(),
                    h.getHuesAMaterno(),
                    h.getHuesTelefono(),
                    h.getHuesId()
            ));

            return conexion.consulta(sql,parametros);

        }
    }


