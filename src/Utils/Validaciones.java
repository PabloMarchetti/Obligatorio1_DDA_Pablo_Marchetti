package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validaciones {

    //recorre cada carácter de parametro y verifica si es un dígito o un carácter que no sea una letra. Si encuentra algún número o carácter especial, lanza una excepción
    public static void validarNoNumerosYEspeciales(String parametro) throws AppException {
        for (char c : parametro.toCharArray()) {
            if (Character.isDigit(c) || !Character.isLetter(c)) {
                throw new AppException("El parámetro contiene números y/o algun caracter especial o esta vacio.");
            }
        }
    }

    public static void validarNoNumeros(String parametro) throws AppException {
        for (char c : parametro.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new AppException("El parámetro contiene números.");
            }
        }
    }

    public static void validarNoVacio(String parametro) throws AppException {
            if (parametro.isEmpty()) {
                throw new AppException("El parámetro esta vacio.");
            }
        }

    public static void validarNoVacioYNoNumero(String parametro) throws AppException {
        for (char c : parametro.toCharArray()) {
            if (parametro.isEmpty() || Character.isDigit(c)) {
                throw new AppException("El parámetro esta vacio y/o contienen numero.");
            }
        }
    }

    // Si el parámetro no es un número válido lanza una excepción como el parámetro es de tipo int, no necesita verificación adicional.
    public static void validarSoloNumerosPos(int parametro) throws AppException {
        if(parametro < 0){
            throw new AppException("El Parametro Solo Puede Ser Positivo");
        }
    }

    public static void validarSoloNumerosPosYMax5(int parametro) throws AppException {
        if(parametro < 0 && parametro > 5){
            throw new AppException("El Parametro Solo Puede Ser Positivo y/o menor de 6");
        }
    }

    public static LocalDate validarFecha(String pFecha) throws AppException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(pFecha, formatter);
            LocalDate hoy = LocalDate.now();

            // Validar que la fecha no sea futura
            if (fecha.isAfter(hoy)) {
                throw new AppException("La fecha debe ser anterior al día de hoy");
            }
        }

        catch (DateTimeParseException e) {
            // La fecha no está en el formato correcto o es inválida
            throw new AppException("El formato de la fecha no es válido");
        }

        return fecha;
    }

    public static LocalDate validarFechaDespuesHoy(String pFecha) throws AppException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(pFecha, formatter);
        }
        catch (DateTimeParseException e) {
            // La fecha no está en el formato correcto o es inválida
            throw new AppException("El formato de la fecha no es válido");
        }

        return fecha;
    }

    public static void validarNumeroCelular(String parametro) throws AppException {
        if (parametro.length() > 15) {
            throw new AppException("Tiene que tener menos de 15 caracteres");
        } else {
            //Este método intenta convertir el String a un int. Si ocurre un NumberFormatException, lanza una AppException
            try {
                Integer.parseInt(parametro);
                //NumberFormatException es una excepción en Java que se lanza cuando un intento de conversión de una cadena de caracteres (String) en un número falla.
                //Esto sucede cuando intentas convertir un texto que no representa un número válido
            } catch (NumberFormatException e) {
                throw new AppException("No se ingresó un carácter numérico.");
            }
        }
    }
}

