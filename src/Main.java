import Controladora.*;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static ControladoraHuesped controladoraHuesped = new ControladoraHuesped();
    private static ControladoraHotel controladoraHotel = new ControladoraHotel();
    private static ControladoraHabitacion controladoraHabitacion = new ControladoraHabitacion();
    private static ControladoraReserva controladoraReserva = new ControladoraReserva();
    private static ControladoraTarifa controladoraTarifa = new ControladoraTarifa();
    private static ControladoraConsultas controladoraConsultas = new ControladoraConsultas();


    public static void main(String[] args) {
        int opcion;


        do {
            menuInicial();
            System.out.println("INGRESE UNA OPCION(-1 PARA CERRAR LA APLICACION): ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1: {
                    int opcionHuesped;
                    do {
                        menuHuespedes();
                        System.out.println("INGRESE UNA OPCION (-1 PARA SALIR AL MENU PRINCIPAL): ");
                        opcionHuesped = Integer.parseInt(scanner.nextLine());
                        switch (opcionHuesped) {
                            case 1: {
                                controladoraHuesped.agregarHuesped();
                                break;
                            }
                            case 2: {
                                controladoraHuesped.eliminarHuesped();
                                break;
                            }
                            case 3: {
                                controladoraHuesped.modificarHuesped();
                                break;
                            }
                            case 4: {
                                controladoraHuesped.listarHuespedes();
                                break;
                            }
                            case 5: {
                                controladoraHuesped.mostrarUnHuesped();
                                break;
                            }
                        }
                    }
                    while (opcionHuesped != -1);
                }
                break;

                case 2: {
                    int opcionHotel;
                    do {
                        menuHoteles();
                        System.out.println("INGRESE UNA OPCION (-1 PARA SALIR AL MENU PRINCIPAL): ");
                        opcionHotel = Integer.parseInt(scanner.nextLine());
                        switch (opcionHotel) {
                            case 1: {
                                controladoraHotel.agregarHotel();
                                break;
                            }
                            case 2: {
                                controladoraHotel.eliminarHotel();
                                break;
                            }
                            case 3: {
                                controladoraHotel.modificarHotel();
                                break;
                            }
                            case 4: {
                                controladoraHotel.listarHoteles();
                                break;
                            }
                            case 5: {
                                controladoraHotel.mostrarUnHotel();
                                break;
                            }
                        }
                    }
                    while (opcionHotel != -1);
                }
                break;

                case 3: {
                    int opcionHabitacion;
                    do {
                        menuHabitaciones();
                        System.out.println("INGRESE UNA OPCION (-1 PARA SALIR AL MENU PRINCIPAL): ");
                        opcionHabitacion = Integer.parseInt(scanner.nextLine());
                        switch (opcionHabitacion) {
                            case 1: {
                                controladoraHabitacion.agregarHabitacion();
                                break;
                            }
                            case 2: {
                                controladoraHabitacion.eliminarHabitacion();
                                break;
                            }
                            case 3: {
                                controladoraHabitacion.modificarHabitacion();
                                break;
                            }
                            case 4: {
                                controladoraHabitacion.listarHabitacion();

                                break;
                            }
                            case 5: {
                                controladoraHabitacion.mostrarUnaHabitacion();
                                break;
                            }
                        }
                    }
                    while (opcionHabitacion != -1);
                }
                break;

                case 4: {
                    int opcionReserva;
                    do {
                        menuReservaciones();
                        System.out.println("INGRESE UNA OPCION (-1 PARA SALIR AL MENU PRINCIPAL): ");
                        opcionReserva = Integer.parseInt(scanner.nextLine());
                        switch (opcionReserva) {
                            case 1: {
                                controladoraReserva.agregarReserva();
                                break;
                            }
                            case 2: {
                                controladoraReserva.eliminarReserva();
                                break;
                            }
                            case 3: {
                                controladoraReserva.modificarReserva();
                                break;
                            }
                            case 4: {
                                controladoraReserva.listarReservas();

                                break;
                            }
                            case 5: {
                                controladoraReserva.mostrarUnaReserva();
                                break;
                            }
                        }
                    }
                    while (opcionReserva != -1);
                }
                break;

                case 5: {
                    int opcionTarifa;
                    do {
                        menuTarifa();
                        System.out.println("INGRESE UNA OPCION (-1 PARA SALIR AL MENU PRINCIPAL): ");
                        opcionTarifa = Integer.parseInt(scanner.nextLine());
                        switch (opcionTarifa) {
                            case 1: {
                                controladoraTarifa.agregarTarifa();
                                break;
                            }
                            case 2: {
                                controladoraTarifa.eliminarTarifa();
                                break;
                            }
                            case 3: {
                                controladoraTarifa.modificarTarifa();
                                break;
                            }
                            case 4: {
                                controladoraTarifa.listarTarifas();

                                break;
                            }
                            case 5: {
                                controladoraTarifa.mostrarUnaTarifa();
                                break;
                            }
                        }
                    }
                    while (opcionTarifa != -1);
                }
                break;

                case 6: {
                    int opcionConsulta;
                    do {
                        menuConsultas();
                        System.out.println("INGRESE UNA OPCION (-1 PARA SALIR AL MENU PRINCIPAL): ");
                        opcionConsulta = Integer.parseInt(scanner.nextLine());
                        switch (opcionConsulta) {
                            case 1: {
                                int opcionConsultaBuscar;
                                do {
                                    menuBuscarHotelX();
                                    System.out.println("INGRESE UNA OPCION (-1 PARA SALIR AL MENU PRINCIPAL): ");
                                    opcionConsultaBuscar = Integer.parseInt(scanner.nextLine());
                                    switch (opcionConsultaBuscar) {
                                        case 1: {
                                            controladoraConsultas.mostrarHotelXCiudad();
                                            break;
                                        }
                                        case 2: {
                                            controladoraConsultas.mostrarHotelXNombre();
                                            break;
                                        }
                                        case 3: {
                                            controladoraConsultas.mostrarHotelXEstrellas();
                                            break;
                                        }
                                    }
                                }
                                while (opcionConsultaBuscar != -1);
                            }

                            break;

                            case 2: {
                                controladoraConsultas.mostrarHabitacionEntreFechasDeReserva();
                                break;
                            }
                            case 3: {
                                int opcionConsultaHabitaciones;
                                do {
                                    menuFiltroHabitaciones();
                                    System.out.println("INGRESE UNA OPCION (-1 PARA SALIR AL MENU PRINCIPAL): ");
                                    opcionConsultaHabitaciones = Integer.parseInt(scanner.nextLine());
                                    switch (opcionConsultaHabitaciones) {
                                        case 1: {
                                            controladoraConsultas.listarHabitacionesSinReserva();
                                            break;
                                        }
                                        case 2: {
                                            controladoraConsultas.listarHabitacionesConReserva();
                                            break;
                                        }

                                        }

                                }
                                while (opcionConsultaHabitaciones != -1);
                            }

                            break;

                            case 4: {
                                controladoraConsultas.mostrarHabitacionesXHotel();
                                break;
                            }

                        }
                    }
                    while (opcionConsulta != -1);
                }

                break;
                }

        }
        while(opcion != -1);
    }

    private static void menuInicial(){
        System.out.println(" ");
        System.out.println("--MENU PRINCIPAL--");
        System.out.println("1 - MENU HUESPED");
        System.out.println("2 - MENU HOTEL");
        System.out.println("3 - MENU HABITACION");
        System.out.println("4 - MENU RESERVA");
        System.out.println("5 - MENU TARIFA");
        System.out.println("6 - MENU CONSULTAS");
    }
    private static void menuHuespedes(){
        System.out.println(" ");
        System.out.println("--MENU HUESPED--");
        System.out.println("1 - AGREGAR HUESPED");
        System.out.println("2 - ELIMINAR HUESPED");
        System.out.println("3 - MODIFICAR HUESPED");
        System.out.println("4 - LISTA DE HUESPEDES");
        System.out.println("5 - BUSCAR HUESPED");

    }
    private static void menuHoteles(){
        System.out.println(" ");
        System.out.println("--MENU HOTEL--");
        System.out.println("1 - AGREGAR HOTEL");
        System.out.println("2 - ELIMINAR HOTEL");
        System.out.println("3 - MODIFICAR HOTEL");
        System.out.println("4 - LISTA DE HOTELES");
        System.out.println("5 - BUSCAR HOTEL");
    }
    private static void menuHabitaciones(){
        System.out.println(" ");
        System.out.println("--MENU HABITACION--");
        System.out.println("1 - AGREGAR HABITACION");
        System.out.println("2 - ELIMINAR HABITACION");
        System.out.println("3 - MODIFICAR HABITACION");
        System.out.println("4 - LISTA DE HABITACIONES");
        System.out.println("5 - BUSCAR HABITACION");
    }
    private static void menuReservaciones(){
        System.out.println(" ");
        System.out.println("--MENU RESERVA--");
        System.out.println("1 - AGREGAR RESERVA");
        System.out.println("2 - ELIMINAR RESERVA");
        System.out.println("3 - MODIFICAR RESERVA");
        System.out.println("4 - LISTA DE RESERVACIONES");
        System.out.println("5 - BUSCAR RESERVA");
    }

    private static void menuTarifa(){
        System.out.println(" ");
        System.out.println("--MENU TARIFA--");
        System.out.println("1 - AGREGAR TARIFA");
        System.out.println("2 - ELIMINAR TARIFA");
        System.out.println("3 - MODIFICAR TARIFA");
        System.out.println("4 - LISTA DE TARIFAS");
        System.out.println("5 - BUSCAR TARIFA");
    }

    private static void menuConsultas(){
        System.out.println(" ");
        System.out.println("--MENU CONSULTA--");
        System.out.println("1 - BUSCAR HOTEL POR");
        System.out.println("2 - RESERVA DE HABITACIONES POR UN PERIODO DE TIEMPO");
        System.out.println("3 - FILTRO HABITACIONES");
        System.out.println("4 - MOSTRAR TODAS LAS HABITACIONES POR HOTEL(CONSULTA EXTRA)");
    }

    private static void menuBuscarHotelX(){
        System.out.println(" ");
        System.out.println("--MENU BUSCAR HOTEL POR--");
        System.out.println("1 - BUSCAR HOTEL POR CIUDAD");
        System.out.println("2 - BUSCAR HOTEL POR NOMBRE");
        System.out.println("3 - BUSCAR HOTEL POR CATEGORIA");
    }

    private static void menuFiltroHabitaciones(){
        System.out.println(" ");
        System.out.println("--MENU FILTRO HABITACIONES--");
        System.out.println("1 - MOSTRAR HABITACIONES NO RESERVADAS");
        System.out.println("2 - MOSTRAR HABITACIONES RESERVADAS");

    }
}