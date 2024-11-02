package Controladora;

import Dominio.Hotel;
import Persistencia.PHotel;
import Utils.AppException;
import Utils.Validaciones;

import java.util.Scanner;

public class ControladoraHotel {
        private static Scanner scanner = new Scanner(System.in);



        public void agregarHotel() {
            System.out.println("--AGREGAR HOTEL--");
            int idHotel = 0;
            String nomHotel = "";
            String ciuHotel = "";
            String paisHotel = "";
            int cantEstHotel = 0;
            String dirHotel = "";
            String zonaBarrioHotel = "";


            try {
                System.out.println("Ingrese El Nombre Del Hotel");
                nomHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(nomHotel);

                System.out.println("Ingrese La Ciudad Del Hotel");
                ciuHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(ciuHotel);

                System.out.println("Ingrese El Pais Del Hotel");
                paisHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(paisHotel);

                System.out.println("Ingrese La Cantidad De Estrellas Del Hotel");
                cantEstHotel = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPosYMax5(cantEstHotel);

                System.out.println("Ingrese La Direccion Del Hotel");
                dirHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(dirHotel);

                System.out.println("Ingrese La Zona/Barrio Del Hotel");
                zonaBarrioHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(zonaBarrioHotel);


                System.out.println("Datos Ingresados Correctamente.");

                Hotel h = new Hotel(idHotel, nomHotel, ciuHotel, paisHotel, cantEstHotel, dirHotel, zonaBarrioHotel);

                if (PHotel.agregarHotel(h)) {
                    System.out.println(" ");
                    System.out.println("---------HOTEL AGREGADO EXITOSAMENTE---------");
                } else {
                    System.out.println("---------NO SE PUDO AGREGAR EL HOTEL---------");
                }
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        }

        public void eliminarHotel(){
            System.out.println("--ELIMINAR HOTEL--");
            Hotel h = buscarHotel();
            if(h==null){
                System.out.println("Hotel No Existe");
            }
            if(PHotel.eliminarHotel(h.getHoId())){
                System.out.println("Se Elimino El Hotel Con Exito");
            }
            else{
                System.out.println("No Se Pudo Eliminar El Hotel");
            }

        }

        public void listarHoteles(){
            System.out.println("");
            System.out.println("LISTADO DE HOTELES:");
            for(Hotel h : PHotel.listarHoteles()){
                System.out.println(h.toString());
            }
        }

        public Hotel buscarHotel() {

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
            return  PHotel.buscarHotel(id);


        }

        public void modificarHotel() {
            System.out.println("MODIFICAR HOTEL ");

            Hotel h = buscarHotel();

            if(h == null){
                System.out.println("NO SE ENCONTRO EL HOTEL");
            } try {
                System.out.println("Ingrese El Nombre: ");
                String nombreHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(nombreHotel);
                h.setHoNombre(nombreHotel);

                System.out.println("Ingrese La Ciudad: ");
                String CiudadHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(CiudadHotel);
                h.setHoCiudad(CiudadHotel);

                System.out.println("Ingrese El Pais: ");
                String paisHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(paisHotel);
                h.setHoPais(paisHotel);

                System.out.println("Ingrese La Cantidad De Estrellas: ");
                int cantEstHotel = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPosYMax5(cantEstHotel);
                h.setHoCantidadEstrellas(cantEstHotel);

                System.out.println("Ingrese La Direccion: ");
                String direccionHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(direccionHotel);
                h.setHoDireccion(direccionHotel);

                System.out.println("Ingrese El Barrio/Zona: ");
                String barrioZonaHotel = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(barrioZonaHotel);
                h.setHoPais(barrioZonaHotel);


                if(PHotel.modificarHotel(h)){
                    System.out.println("HOTEL MODIFICADO EXITOSAMENTE");
                }
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        }

        public void mostrarUnHotel(){

            System.out.println("MOSTRAR HOTEL");
            Hotel h = buscarHotel();

            if(h == null){
                System.out.println("No Se Encontro El Hotel");
            }
            else{
                System.out.println(h.toString());
            }

        }
    }


