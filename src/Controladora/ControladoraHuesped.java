package Controladora;

import Dominio.Huesped;
import Persistencia.PHuesped;
import Utils.AppException;
import Utils.Validaciones;

import java.time.LocalDate;
import java.util.Scanner;

public class ControladoraHuesped {
    private static Scanner scanner = new Scanner(System.in);

    public void agregarHuesped() {
        System.out.println("--AGREGAR HUESPED--");
        int huesId = 0;
        String huesNombre = "";
        String huesAPaterno = "";
        String huesAMaterno = "";
        String huesTipoDocumento = "";
        int huesNumDocumento = 0;
        String huesTelefono = "";
        String huesPais = "";


        try {
            System.out.println("Ingrese El Nombre Del Huesped");
            huesNombre = scanner.nextLine().toLowerCase();
            Validaciones.validarNoNumerosYEspeciales(huesNombre);

            System.out.println("Ingrese El Apellido Paterno Del Huesped");
            huesAPaterno = scanner.nextLine().toLowerCase();
            Validaciones.validarNoNumerosYEspeciales(huesAPaterno);

            System.out.println("Ingrese El Apellido Materno Del Huesped");
            huesAMaterno = scanner.nextLine().toLowerCase();
            Validaciones.validarNoNumerosYEspeciales(huesAMaterno);

            System.out.println("Ingrese El Tipo De Documento Del Huesped");
            huesTipoDocumento = scanner.nextLine().toLowerCase();
            Validaciones.validarNoNumerosYEspeciales(huesTipoDocumento);

            System.out.println("Ingrese El Numero De Documento Del Huesped");
            huesNumDocumento = Integer.parseInt(scanner.nextLine().trim());
            Validaciones.validarSoloNumerosPos(huesNumDocumento);

            String Fecha = "";
            LocalDate huesFechaNacimiento = null;

            do {
                System.out.println("Ingrese Una Fecha (YYYY/MM/DD) Con / Incluido");
                Fecha = scanner.nextLine();

                try {
                    huesFechaNacimiento = Validaciones.validarFecha(Fecha);
                } catch (AppException e) {
                    huesFechaNacimiento = null;
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    huesFechaNacimiento = null;
                    System.out.println("Ocurrió un error interno");
                }
            } while (huesFechaNacimiento == null);

            System.out.println("Ingrese El Numero De Telefono Del Huesped");
            huesTelefono = scanner.nextLine();
            Validaciones.validarNumeroCelular(huesTelefono);

            System.out.println("Ingrese El Pais Del Huesped");
            huesPais = scanner.nextLine().toLowerCase();
            Validaciones.validarNoNumerosYEspeciales(huesPais);


            System.out.println("Datos Ingresados Correctamente.");

            Huesped h = new Huesped(huesId, huesNombre, huesAPaterno, huesAMaterno, huesTipoDocumento, huesNumDocumento, huesFechaNacimiento, huesTelefono, huesPais);

            if (PHuesped.agregarHuesped(h)) {
                System.out.println(" ");
                System.out.println("---------HUESPED AGREGADO EXITOSAMENTE---------");
            } else {
                System.out.println("---------NO SE PUDO AGREGAR EL HUESPED---------");
            }
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarHuesped(){
        System.out.println("--ELIMINAR HUESPED--");
        Huesped h = buscarHuesped();
        if(h==null){
            System.out.println("Huesped No Existe");
        }
        if(PHuesped.eliminarHuesped(h.getHuesId())){
            System.out.println("Se Elimino El Huesped Con Exito");
        }
        else{
            System.out.println("No Se Pudo Eliminar El Huesped");
        }

    }

   public void listarHuespedes(){
       System.out.println("");
       System.out.println("LISTADO DE HUESPEDES:");
        for(Huesped h : PHuesped.listarHuespedes()){
            System.out.println(h.toString());
        }
    }

    public Huesped buscarHuesped() {

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
        return  PHuesped.buscarHuesped(id);


    }

    public void modificarHuesped() {
        System.out.println("MODIFICAR HUESPED ");

        Huesped h = buscarHuesped();

        if(h == null){
            System.out.println("NO SE ENCONTRO EL HUESPED");
        } try {
            System.out.println("Ingrese El Nombre: ");
            String huesNombre = scanner.nextLine().toLowerCase();
            Validaciones.validarNoNumerosYEspeciales(huesNombre);
            h.setHuesNombre(huesNombre);

            System.out.println("Ingrese El Apellido Paterno: ");
            String huesApellidoPat = scanner.nextLine().toLowerCase();
            Validaciones.validarNoNumerosYEspeciales(huesApellidoPat);
                h.setHuesAPaterno(huesApellidoPat);

            System.out.println("Ingrese El Apellido Materno: ");
            String huesApellidoMat = scanner.nextLine().toLowerCase();
            Validaciones.validarNoNumerosYEspeciales(huesApellidoMat);
                h.setHuesAMaterno(huesApellidoMat);

            System.out.println("Ingrese El Celular: ");
            String huesTelefono = scanner.nextLine().toLowerCase();
            Validaciones.validarNumeroCelular(huesTelefono);
                h.setHuesTelefono(huesTelefono);

           if(PHuesped.modificarHuesped(h)){
               System.out.println("HUESPED MODIFICADO EXITOSAMENTE");
           }
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarUnHuesped(){

        System.out.println("MOSTRAR HUESPED");
        Huesped h = buscarHuesped();

        if(h == null){
            System.out.println("No Se Encontro El Huesped");
        }
        else{
            System.out.println(h.toString());
        }

    }
}
