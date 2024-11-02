package Persistencia;

import Dominio.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PHotel {

        private static Conexion conexion = new Conexion();

        public static boolean agregarHotel(Hotel h){
            String sql = "INSERT INTO hoteles(idHotel, nomHotel, ciuHotel, paisHotel, cantEstHotel, dirHotel, zonaBarrioHotel) VALUES(?, ?, ?, ?, ?, ?, ?)";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(h.getHoId(),h.getHoNombre(),h.getHoCiudad(),h.getHoPais(),h.getHoCantidadEstrellas(),h.getHoDireccion(),h.getHoZonaBarrio()));
            return  conexion.consulta(sql,parametros);
        }

        public static Hotel buscarHotel(int pIdHotel) {
            String sql = "SELECT * FROM hoteles WHERE idHotel = ?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdHotel));
            try {
                for(List<Object> registro : conexion.seleccion(sql, parametros)){
                    int hoId = (int) registro.get(0);
                    String hoNombre = String.valueOf(registro.get(1));
                    String hoCiudad = String.valueOf(registro.get(2));
                    String hoPais = String.valueOf(registro.get(3));
                    int hoCantidadEstrellas = (int) registro.get(4);
                    String hoDireccion = String.valueOf(registro.get(5));
                    String hoZonaBarrio = String.valueOf(registro.get(6));

                    Hotel unHotel = new Hotel(hoId, hoNombre, hoCiudad, hoPais, hoCantidadEstrellas, hoDireccion, hoZonaBarrio);
                    return unHotel;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        }

        public static boolean eliminarHotel(int pHoId){
            String sql = "DELETE FROM hoteles WHERE idHotel=?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pHoId));
            return conexion.consulta(sql,parametros);
        }

        public static ArrayList<Hotel> listarHoteles() {
        String sql = "SELECT h.idHotel, h.nomHotel, h.ciuHotel, h.paisHotel, h.cantEstHotel, h.dirHotel, h.zonaBarrioHotel, COUNT(hab.idHabitacion) AS cantidadHabitaciones FROM hoteles h LEFT JOIN habitaciones hab ON h.idHotel = hab.idHotel GROUP BY h.idHotel, h.nomHotel, h.ciuHotel, h.paisHotel, h.cantEstHotel, h.dirHotel, h.zonaBarrioHotel";
        List<List<Object>> resultado = conexion.seleccion(sql, null);
        ArrayList<Hotel> hoteles = new ArrayList<>();

        for(List<Object> registro : resultado) {
            int hoId = (int) registro.get(0);
            String hoNombre = String.valueOf(registro.get(1));
            String hoCiudad = String.valueOf(registro.get(2));
            String hoPais = String.valueOf(registro.get(3));
            int hoCantidadEstrellas = (int) registro.get(4);
            String hoDireccion = String.valueOf(registro.get(5));
            String hoZonaBarrio = String.valueOf(registro.get(6));
            int cantidadHabitaciones = ((Long)registro.get(7)).intValue();

            Hotel hotel = new Hotel(hoId, hoNombre, hoCiudad, hoPais, hoCantidadEstrellas, hoDireccion, hoZonaBarrio);
            hotel.setCantidadDeHabitaciones(cantidadHabitaciones);
            hoteles.add(hotel);
        }
        return hoteles;
    }

        public static boolean modificarHotel(Hotel h){
            String sql = "UPDATE hoteles SET nomHotel=?, ciuHotel=?, paisHotel=?, cantEstHotel=?, dirHotel=?, zonaBarrioHotel=? WHERE idHotel=?";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                    h.getHoNombre(),
                    h.getHoCiudad(),
                    h.getHoPais(),
                    h.getHoCantidadEstrellas(),
                    h.getHoDireccion(),
                    h.getHoZonaBarrio(),
                    h.getHoId()
            ));

            return conexion.consulta(sql,parametros);

        }

        //CONSULTAS
        public static ArrayList<Hotel> buscarHotelesXCiudad(String pCiuHotel) {
            String sql = "SELECT h.idHotel, h.nomHotel, h.ciuHotel, h.paisHotel, h.cantEstHotel, h.dirHotel, h.zonaBarrioHotel, COUNT(hab.idHabitacion) AS cantidadHabitaciones FROM hoteles h LEFT JOIN habitaciones hab ON h.idHotel = hab.idHotel WHERE ciuHotel = ? GROUP BY h.idHotel, h.nomHotel, h.ciuHotel, h.paisHotel, h.cantEstHotel, h.dirHotel, h.zonaBarrioHotel  ";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pCiuHotel));
            ArrayList<Hotel> hoteles = new ArrayList<>();

            try {
                for (List<Object> registro : conexion.seleccion(sql, parametros)) {
                    int hoId = (int) registro.get(0);
                    String hoNombre = String.valueOf(registro.get(1));
                    String hoCiudad = String.valueOf(registro.get(2));
                    String hoPais = String.valueOf(registro.get(3));
                    int hoCantidadEstrellas = (int) registro.get(4);
                    String hoDireccion = String.valueOf(registro.get(5));
                    String hoZonaBarrio = String.valueOf(registro.get(6));
                    int cantidadHabitaciones = ((Long) registro.get(7)).intValue();

                    Hotel hotel = new Hotel(hoId, hoNombre, hoCiudad, hoPais, hoCantidadEstrellas, hoDireccion, hoZonaBarrio);
                    hotel.setCantidadDeHabitaciones(cantidadHabitaciones);
                    hoteles.add(hotel);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return hoteles;
        }

        public static ArrayList<Hotel> buscarHotelesXNombre(String pNomHotel) {
                String sql = "SELECT h.idHotel, h.nomHotel, h.ciuHotel, h.paisHotel, h.cantEstHotel, h.dirHotel, h.zonaBarrioHotel, COUNT(hab.idHabitacion) AS cantidadHabitaciones FROM hoteles h LEFT JOIN habitaciones hab ON h.idHotel = hab.idHotel WHERE nomHotel = ? GROUP BY h.idHotel, h.nomHotel, h.ciuHotel, h.paisHotel, h.cantEstHotel, h.dirHotel, h.zonaBarrioHotel  ";
                ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pNomHotel));
                ArrayList<Hotel> hoteles = new ArrayList<>();

                try {
                    for (List<Object> registro : conexion.seleccion(sql, parametros)) {
                        int hoId = (int) registro.get(0);
                        String hoNombre = String.valueOf(registro.get(1));
                        String hoCiudad = String.valueOf(registro.get(2));
                        String hoPais = String.valueOf(registro.get(3));
                        int hoCantidadEstrellas = (int) registro.get(4);
                        String hoDireccion = String.valueOf(registro.get(5));
                        String hoZonaBarrio = String.valueOf(registro.get(6));
                        int cantidadHabitaciones = ((Long)registro.get(7)).intValue();

                        Hotel hotel = new Hotel(hoId, hoNombre, hoCiudad, hoPais, hoCantidadEstrellas, hoDireccion, hoZonaBarrio);
                        hotel.setCantidadDeHabitaciones(cantidadHabitaciones);
                        hoteles.add(hotel);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                return hoteles;
        }

        public static ArrayList<Hotel> buscarHotelesXEstrellas(int pCantEstrellas) {
            String sql = "SELECT h.idHotel, h.nomHotel, h.ciuHotel, h.paisHotel, h.cantEstHotel, h.dirHotel, h.zonaBarrioHotel, COUNT(hab.idHabitacion) AS cantidadHabitaciones FROM hoteles h LEFT JOIN habitaciones hab ON h.idHotel = hab.idHotel WHERE h.cantEstHotel = ? GROUP BY h.idHotel, h.nomHotel, h.ciuHotel, h.paisHotel, h.cantEstHotel, h.dirHotel, h.zonaBarrioHotel  ";
            ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pCantEstrellas));
            ArrayList<Hotel> hoteles = new ArrayList<>();

            try {
                for (List<Object> registro : conexion.seleccion(sql, parametros)) {
                    int hoId = (int) registro.get(0);
                    String hoNombre = String.valueOf(registro.get(1));
                    String hoCiudad = String.valueOf(registro.get(2));
                    String hoPais = String.valueOf(registro.get(3));
                    int hoCantidadEstrellas = (int) registro.get(4);
                    String hoDireccion = String.valueOf(registro.get(5));
                    String hoZonaBarrio = String.valueOf(registro.get(6));
                    int cantidadHabitaciones = ((Long) registro.get(7)).intValue();

                    Hotel hotel = new Hotel(hoId, hoNombre, hoCiudad, hoPais, hoCantidadEstrellas, hoDireccion, hoZonaBarrio);
                    hotel.setCantidadDeHabitaciones(cantidadHabitaciones);
                    hoteles.add(hotel);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return hoteles;
        }




}





