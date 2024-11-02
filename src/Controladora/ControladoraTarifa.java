package Controladora;

import Dominio.Tarifa;
import Persistencia.PTarifa;
import Utils.AppException;
import Utils.Validaciones;

import java.time.LocalDate;
import java.util.Scanner;

public class ControladoraTarifa {
        private static Scanner scanner = new Scanner(System.in);

        public void agregarTarifa() {
            System.out.println("--AGREGAR TARIFA--");
            int idTarifa = 0;
            int idHabitacion = 0;
            int precio = 0;


            try {
                System.out.println("Ingrese El ID De La Habitacion");
                idHabitacion = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(idHabitacion);


                String fecha = "";
                LocalDate fechaDeVigencia = null;

                do {
                    System.out.println("Ingrese La Fecha De Vigencia De La Tarifa (YYYY/MM/DD) Con '/' Incluido");
                    fecha = scanner.nextLine();

                    try {
                        fechaDeVigencia = Validaciones.validarFechaDespuesHoy(fecha);
                    } catch (AppException e) {
                        fechaDeVigencia = null;
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        fechaDeVigencia = null;
                        System.out.println("Ocurrió un error interno");
                    }
                } while (fechaDeVigencia == null);

                System.out.println("Ingrese El Precio De La Tarifa");
                precio = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(precio);


                System.out.println("Datos Ingresados Correctamente.");

                Tarifa t = new Tarifa(idTarifa, idHabitacion, fechaDeVigencia, precio);

                if (PTarifa.agregarTarifa(t)) {
                    System.out.println(" ");
                    System.out.println("---------TARIFA AGREGADA EXITOSAMENTE---------");
                } else {
                    System.out.println("---------NO SE PUDO AGREGAR LA TARIFA---------");
                }

            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        }

        public void eliminarTarifa(){
            System.out.println("--ELIMINAR TARIFA--");
            Tarifa t = buscarTarifa();
            if(t==null){
                System.out.println("Tarifa No Existe");
            }
            if(PTarifa.eliminarTarifa(t.getIdTarifa())){
                System.out.println("Se Elimino La Tarifa Con Exito");
            }
            else{
                System.out.println("No Se Pudo Eliminar La Tarifa");
            }

        }

        public void listarTarifas(){
            System.out.println("");
            System.out.println("LISTADO DE TARIFAS:");
            for(Tarifa t : PTarifa.listarTarifas()){
                System.out.println(t.toString());
            }
        }

        public Tarifa buscarTarifa() {

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
            return  PTarifa.buscarTarifa(id);


        }

        public void modificarTarifa() {
            System.out.println("MODIFICAR TARIFA ");

            Tarifa t = buscarTarifa();

            if(t == null){
                System.out.println("NO SE ENCONTRO LA TARIFA");
            } try {
                System.out.println("Ingrese El ID De La Habitacion: ");
                int idHabitacion = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(idHabitacion);


                t.setIdHabitacion(idHabitacion);

                String fecha = "";
                LocalDate fechaDeVigencia = null;

                do {
                    System.out.println("Ingrese La Fecha De Vigencia De La Tarifa (YYYY/MM/DD) Con '/' Incluido");
                    fecha = scanner.nextLine();

                    try {
                        fechaDeVigencia = Validaciones.validarFechaDespuesHoy(fecha);
                    } catch (AppException e) {
                        fechaDeVigencia = null;
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        fechaDeVigencia = null;
                        System.out.println("Ocurrió un error interno");
                    }
                } while (fechaDeVigencia == null);
                t.setFechaVigencia(fechaDeVigencia);

                System.out.println("Ingrese El Precio De La Tarifa: ");
                int precio = Integer.parseInt(scanner.nextLine().trim());
                Validaciones.validarSoloNumerosPos(precio);
                t.setPrecio(precio);




                if(PTarifa.modificarTarifa(t)){
                    System.out.println("TARIFA MODIFICADA EXITOSAMENTE");
                }
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        }

        public void mostrarUnaTarifa(){

            System.out.println("MOSTRAR TARIFA");
            Tarifa t = buscarTarifa();

            if(t == null){
                System.out.println("No Se Encontro La Tarifa");
            }
            else{
                System.out.println(t.toString());
            }

        }
    }




