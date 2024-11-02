package Controladora;

import Dominio.Habitacion;
import Dominio.Hotel;
import Persistencia.PHabitacion;
import Persistencia.PHotel;
import Utils.AppException;
import Utils.Validaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladoraConsultas {
    private static Scanner scanner = new Scanner(System.in);

    public ArrayList<Hotel> buscarHotelXCiudad() {
        String nomCiu;

        do {
            System.out.println("NOMBRE DE LA CIUDAD: ");
            try {
                nomCiu = scanner.nextLine().toLowerCase();
            } catch (Exception e) {
                nomCiu = "";
            }
        } while (nomCiu.isEmpty());

        return PHotel.buscarHotelesXCiudad(nomCiu);
    }

    public void mostrarHotelXCiudad() {
        System.out.println("MOSTRAR HOTELES POR CIUDAD");
        ArrayList<Hotel> h = buscarHotelXCiudad();

        if (h.isEmpty()) {
            System.out.println("No se encontraron hoteles en la ciudad especificada.");
        } else {
            System.out.println("Hoteles encontrados en la ciudad:");
            for (Hotel hotel : h) {
                System.out.println(hotel.toString()); // Imprime cada hotel individualmente
            }
        }
    }

    public ArrayList<Hotel> buscarHotelXNombre() {
        String nomHot;

        do {
            System.out.println("NOMBRE DE DEL HOTEL: ");
            try {
                nomHot = scanner.nextLine().toLowerCase();
            } catch (Exception e) {
                nomHot = "";
            }
        } while (nomHot.isEmpty());

        return PHotel.buscarHotelesXNombre(nomHot);
    }

    public void mostrarHotelXNombre() {
        System.out.println("MOSTRAR HOTELES CON NOMBRE");
        ArrayList<Hotel> h = buscarHotelXNombre();

        if (h.isEmpty()) {
            System.out.println("No se encontraron hoteles con ese nombre.");
        } else {
            System.out.println("Hoteles encontrados con el nombre ingresado:");
            for (Hotel hotel : h) {
                System.out.println(hotel.toString());
            }
        }
    }

    public ArrayList<Hotel> buscarHotelXEstrellas() {
        int cantEstrellas = 0;

        do {
            System.out.println("INGRESE CANTIDAD DE ESTRELLAS(MAX:5, MIN:1): ");
            try {
                cantEstrellas = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
            cantEstrellas = 0;
            }
        } while (cantEstrellas == 0);

        return PHotel.buscarHotelesXEstrellas(cantEstrellas);
    }

    public void mostrarHotelXEstrellas() {
        System.out.println("MOSTRAR HOTELES POR LA CANTIDAD DE ESTRELLAS INGRESADAS");
        ArrayList<Hotel> h = buscarHotelXEstrellas();

        if (h.isEmpty()) {
            System.out.println("No se encontraron hoteles con esas estrellas.");
        } else {
            System.out.println("Hoteles encontrados con esas estrellas:");
            for (Hotel hotel : h) {
                System.out.println(hotel.toString());
            }

        }
    }

    public ArrayList<Habitacion> buscarReservaEntreFechas() {
        String Fecha1 = "";
        LocalDate primeraFechaDeBusqueda = null;

        do {
            System.out.println("Ingrese La Primera Fecha (YYYY/MM/DD) Con '/' Incluido");
            Fecha1 = scanner.nextLine();

            try {
                primeraFechaDeBusqueda = Validaciones.validarFecha(Fecha1);
            } catch (AppException e) {
                primeraFechaDeBusqueda = null;
                System.out.println(e.getMessage());
            } catch (Exception e) {
                primeraFechaDeBusqueda = null;
                System.out.println("Ocurrió un error interno");
            }
        } while (primeraFechaDeBusqueda == null);

        String Fecha2 = "";
        LocalDate SegundaFechaDeBusqueda = null;

        do {
            System.out.println("Ingrese La Segunda Fecha (YYYY/MM/DD) Con '/' Incluido");
            Fecha2 = scanner.nextLine();

            try {
                SegundaFechaDeBusqueda = Validaciones.validarFecha(Fecha2);
            } catch (AppException e) {
                SegundaFechaDeBusqueda = null;
                System.out.println(e.getMessage());
            } catch (Exception e) {
                SegundaFechaDeBusqueda = null;
                System.out.println("Ocurrió un error interno");
            }
        } while (SegundaFechaDeBusqueda == null);



        return PHabitacion.listarHabitacionesPorPeriodoDeReserva(primeraFechaDeBusqueda,SegundaFechaDeBusqueda);
    }

    public void mostrarHabitacionEntreFechasDeReserva() {
        System.out.println("MOSTRAR HABITACIONES RESERVADA ENTRE DOS FECHAS");
        ArrayList<Habitacion> h = buscarReservaEntreFechas();

        if (h.isEmpty()) {
            System.out.println("No se encontraron habitaciones reservada entre esas fechas.");
        } else {
            System.out.println("Habitaciones reservadas entre ese rango de fechas:");
            for (Habitacion habitacion : h) {
                System.out.println(habitacion.toString());
            }

        }
    }

    public void listarHabitacionesConReserva(){
        System.out.println("");
        System.out.println("LISTADO DE HABITACIONES CON RESERVA:");
        for(Habitacion h : PHabitacion.listarHabitacionConReserva()){
            System.out.println(h.toString());
        }
    }

    public void listarHabitacionesSinReserva(){
        System.out.println("");
        System.out.println("LISTADO DE HABITACIONES SIN RESERVA:");
        for(Habitacion h : PHabitacion.listarHabitacionSinReserva()){
            System.out.println(h.toString());
        }
    }

    public ArrayList<Habitacion> buscarHabitacionesXHotel() {
        int idHotel;

        do {
            System.out.println("ID DEL HOTEL: ");
            try {
                idHotel = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                idHotel = 0;
            }
        } while (idHotel==0);

        return PHabitacion.listarHabitacionesPorHotel(idHotel);
    }

    public void mostrarHabitacionesXHotel() {
        System.out.println("MOSTRAR HABITACIONES POR HOTEL");
        ArrayList<Habitacion> h = buscarHabitacionesXHotel();

        if (h.isEmpty()) {
            System.out.println("No se habitaciones en este hotel.");
        } else {
            System.out.println("Todas las habitaciones encontradas en este hotel:");
            for (Habitacion habitacion : h) {
                System.out.println(habitacion.toString());
            }
        }
    }
}
