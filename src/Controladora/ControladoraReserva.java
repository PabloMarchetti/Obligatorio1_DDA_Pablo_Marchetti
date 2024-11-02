package Controladora;

import Dominio.Reserva;
import Persistencia.PReserva;
import Utils.AppException;
import Utils.Validaciones;

import java.time.LocalDate;
import java.util.Scanner;

public class ControladoraReserva {

        private static Scanner scanner = new Scanner(System.in);

        public void agregarReserva() {
            System.out.println("--AGREGAR RESERVA--");
            int idReserva = 0;
            int idHuesped = 0;
            int idHabitacion = 0;
            int cantPersonas = 0;
            String observaciones = "";
            String pagadoCompletamente = "";
            String periodoDeTiempo = "";

            try {
                System.out.println("Ingrese El ID Del Huesped");
                idHuesped = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(idHuesped);

                System.out.println("Ingrese El ID De La Habitacion");
                idHabitacion = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(idHabitacion);

                System.out.println("Ingrese La Cantidad De Personas");
                cantPersonas = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(cantPersonas);

                System.out.println("Ingrese Las Observaciones De La Reserva");
                observaciones = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(observaciones);

                System.out.println("El huesped Pago completamente La reserva? (SI/NO): ");
                pagadoCompletamente = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(pagadoCompletamente);
                Validaciones.validarNoVacio(pagadoCompletamente);

                System.out.println("Ingrese El Periodo De Tiempo Que Se Va A Quedar El Huesped");
                periodoDeTiempo = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(periodoDeTiempo);

                String Fecha = "";
                LocalDate fechaReserva = null;

                do {
                    System.out.println("Ingrese La Fecha De La Reserva (YYYY/MM/DD) Con '/' Incluido");
                    Fecha = scanner.nextLine();

                    try {
                        fechaReserva = Validaciones.validarFecha(Fecha);
                    } catch (AppException e) {
                        fechaReserva = null;
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        fechaReserva = null;
                        System.out.println("Ocurrió un error interno");
                    }
                } while (fechaReserva == null);

                String Fecha2 = "";
                LocalDate fechaDeOcupacion = null;

                do {
                    System.out.println("Ingrese La Fecha De Ocupacion (YYYY/MM/DD) Con '/' Incluido");
                    Fecha2 = scanner.nextLine();

                    try {
                        fechaDeOcupacion = Validaciones.validarFechaDespuesHoy(Fecha2);
                    } catch (AppException e) {
                        fechaDeOcupacion = null;
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        fechaDeOcupacion = null;
                        System.out.println("Ocurrió un error interno");
                    }
                } while (fechaDeOcupacion == null);



                System.out.println("Datos Ingresados Correctamente.");
                if(fechaReserva.isAfter(fechaDeOcupacion)) {

                    Reserva r = new Reserva(idReserva, idHuesped, idHabitacion, cantPersonas, observaciones, pagadoCompletamente, periodoDeTiempo, fechaReserva, fechaDeOcupacion);

                    if (PReserva.agregarReserva(r)) {
                        System.out.println(" ");
                        System.out.println("---------RESERVA AGREGADA EXITOSAMENTE---------");
                    } else {
                        System.out.println("---------NO SE PUDO AGREGAR LA RESERVA---------");
                    }
                }else{
                    System.out.println("La Fecha De Reserva Tiene Que Ser Menor A La Fecha De Ocupacion");
                }
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        }

        public void eliminarReserva(){
            System.out.println("--ELIMINAR RESERVA--");
            Reserva r = buscarReserva();
            if(r==null){
                System.out.println("Reserva No Existe");
            }
            if(PReserva.eliminarReserva(r.getIdReserva())){
                System.out.println("Se Elimino La Reserva Con Exito");
            }
            else{
                System.out.println("No Se Pudo Eliminar La Reserva");
            }

        }

        public void listarReservas(){
            System.out.println("");
            System.out.println("LISTADO DE RESERVAS:");
            for(Reserva r : PReserva.listarReservas()){
                System.out.println(r.toString());
            }
        }

        public Reserva buscarReserva() {

            int id;

            do {
                System.out.println("ID: ");
                try {
                    id = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    id = 0;
                }
            }
            while (id == 0);
            return  PReserva.buscarReserva(id);


        }

        public void modificarReserva() {
            System.out.println("MODIFICAR RESERVA ");

            Reserva r = buscarReserva();

            if(r == null){
                System.out.println("NO SE ENCONTRO LA RESERVA");
            } try {
                System.out.println("Ingrese El ID De La Habitacion: ");
                int idHabitacion = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(idHabitacion);


                r.setIdHabitacion(idHabitacion);

                System.out.println("Ingrese La Cantidad De Personas: ");
                int cantPersonas = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(cantPersonas);
                r.setCantPersonas(cantPersonas);

                System.out.println("Ingrese Observaciones: ");
                String observaciones = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(observaciones);
                r.setObservaciones(observaciones);

                System.out.println("Ingrese El Periodo De Tiempo: ");
                String periodoDeTiempo = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(periodoDeTiempo);
                r.setPeriodoTiempo(periodoDeTiempo);

                String Fecha2 = "";
                LocalDate fechaDeOcupacion = null;

                do {
                    System.out.println("Ingrese La Fecha De Ocupacion (YYYY/MM/DD) Con '/' Incluido");
                    Fecha2 = scanner.nextLine();

                    try {
                        fechaDeOcupacion = Validaciones.validarFechaDespuesHoy(Fecha2);
                    } catch (AppException e) {
                        fechaDeOcupacion = null;
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        fechaDeOcupacion = null;
                        System.out.println("Ocurrió un error interno");
                    }
                } while (fechaDeOcupacion == null);
                r.setFechaOcup(fechaDeOcupacion);

                if(PReserva.modificarReserva(r)){
                    System.out.println("RESERVA MODIFICADA EXITOSAMENTE");
                }
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        }

        public void mostrarUnaReserva(){

            System.out.println("MOSTRAR RESERVA");
            Reserva r = buscarReserva();

            if(r == null){
                System.out.println("No Se Encontro La Reserva");
            }
            else{
                System.out.println(r.toString());
            }

        }
    }


