package Controladora;

import Dominio.Habitacion;
import Persistencia.PHabitacion;
import Utils.AppException;
import Utils.Validaciones;

import java.util.Scanner;

public class  ControladoraHabitacion {

        private static Scanner scanner = new Scanner(System.in);


        public void agregarHabitacion() {
                System.out.println("--AGREGAR HABITACION--");
            int haId = 0;
            int hotelId=0;
            String tipoHabitacion = "";
            int haCapacidadCamas = 0;
            String haCamaMatrimonial = "";
            String haAireAcon = "";
            String haBalcon = "";
            String haVista = "";
            int cantHaAmbientes = 0;


            try {
                System.out.println("Ingrese El ID Del Hotel:");
                hotelId = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(hotelId);

                System.out.println("Ingrese El Tipo De La Habitacion:");
                tipoHabitacion = scanner.nextLine().toLowerCase();
                Validaciones.validarNoNumeros(tipoHabitacion);

                System.out.println("Ingrese Cuantas Camas Tiene La Habitacion:");
                haCapacidadCamas = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(haCapacidadCamas);

                System.out.println("Cuenta con Cama Matrimonial? (SI/NO):");
                haCamaMatrimonial = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(haCamaMatrimonial);

                System.out.println("Cuenta con Aire Acondicionado? (SI/NO):");
                haAireAcon = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(haAireAcon);


                System.out.println("Cuenta con Balcon? (SI/NO):");
                haBalcon = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(haBalcon);

                System.out.println("Ingrese La Vistas De La Habitacion:");
                haVista = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacioYNoNumero(haVista);

                System.out.println("Ingrese La Cantidad De Ambientes Que Tiene La Habitacion:");
                cantHaAmbientes = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(cantHaAmbientes);

                System.out.println("Datos Ingresados Correctamente.");

                Habitacion h = new Habitacion(haId,hotelId,tipoHabitacion,haCapacidadCamas,haCamaMatrimonial,haAireAcon,haBalcon,haVista,cantHaAmbientes);

                if (PHabitacion.agregarHabitacion(h)) {
                    System.out.println(" ");
                    System.out.println("---------HABITACION AGREGADO EXITOSAMENTE---------");
                } else {
                    System.out.println("---------NO SE PUDO AGREGAR LA HABITACION---------");
                }
            }
            catch (AppException e) {
                throw new RuntimeException(e);
            }
        }

        public void eliminarHabitacion(){
            System.out.println("--ELIMINAR HABITACION--");
            Habitacion h = buscarHabitacion();
            if(h==null){
                System.out.println("Habitacion No Existe");
            }
            if(PHabitacion.eliminarHabitacion(h.getHaId())){
                System.out.println("Se Elimino La Habitacion Con Exito");
            }
            else{
                System.out.println("No Se Pudo Eliminar La Habitacion");
            }

        }

        public void listarHabitacion(){
            System.out.println("");
            System.out.println("LISTADO DE HABITACIONES:");
            for(Habitacion h : PHabitacion.listarHabitacion()){
                System.out.println(h.toString());
            }
        }

        public Habitacion buscarHabitacion() {

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
            return  PHabitacion.buscarHabitacion(id);


        }

        public void modificarHabitacion() {
            System.out.println("MODIFICAR HABITACION ");

            Habitacion h = buscarHabitacion();

            if(h == null){
                System.out.println("NO SE ENCONTRO LA HABITACION");
            } try {
                System.out.println("Ingrese El Tipo De La Habitacion: ");
                String tipoHabitacion = scanner.nextLine().toLowerCase();
                Validaciones.validarNoVacio(tipoHabitacion);
                h.setTipoHabitacion(tipoHabitacion);

                System.out.println("Ingrese La Capacidad De Camas: ");
                int haCapacidadCamas = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(haCapacidadCamas);
                h.setHaCapacidadCamas(haCapacidadCamas);

                System.out.println("Cuenta con Cama Matrimonial? (SI/NO):");
                String haCamaMatrimonial = scanner.nextLine().toLowerCase();
                Validaciones.validarNoNumerosYEspeciales(haCamaMatrimonial);
                Validaciones.validarNoVacio(haCamaMatrimonial);
                h.setHaCamaMatrimonial(haCamaMatrimonial);

                System.out.println("Cuenta con Aire Acondicionado? (SI/NO): ");
                String aireAcon = scanner.nextLine().toLowerCase();
                Validaciones.validarNoNumerosYEspeciales(aireAcon);
                Validaciones.validarNoVacio(aireAcon);
                h.setHaAireAcon(aireAcon);

               System.out.println("Cuenta con Balcon? (SI/NO):");
               String balHabitacion = scanner.nextLine().toLowerCase();
               Validaciones.validarNoNumerosYEspeciales(balHabitacion);
                Validaciones.validarNoVacio(balHabitacion);
               h.setHaBalcon(balHabitacion);

               System.out.println("Ingrese La Vistas De La Habitacion:");
               String vistaHabitacion = scanner.nextLine().toLowerCase();
               Validaciones.validarNoVacio(vistaHabitacion);
               h.setHaVista(vistaHabitacion);

               System.out.println("Ingrese La Cantidad De Ambientes Que Tiene La Habitacion:");
               int cantAmbiHabitacion = Integer.parseInt(scanner.nextLine().trim());
               Validaciones.validarSoloNumerosPos(cantAmbiHabitacion);
               h.setCantHaAmbientes(cantAmbiHabitacion);

                if(PHabitacion.modificarHabitacion(h)){
                    System.out.println("HABITACION MODIFICADA EXITOSAMENTE");
                }
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        }

        public void mostrarUnaHabitacion(){

            System.out.println("MOSTRAR HABITACION");
            Habitacion h = buscarHabitacion();

            if(h == null){
                System.out.println("No Se Encontro La Habitacion");
            }
            else{
                System.out.println(h.toString());
            }

        }
    }

