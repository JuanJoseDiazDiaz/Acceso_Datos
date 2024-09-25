package org.example;

import java.io.*;

public class Ejercicios {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Necesitas introducir un parametro de entrada");
            return;
        }
        String nombreFichero = args[0];
        // ejemploEscritura(nombreFichero);
        // ejemploEscritura2(nombreFichero);
       //  ejemploLectura(nombreFichero);
        String ficheroVolcado = (new File(nombreFichero).getName()) + ".dump.txt";
        try {
            volcarEstructura(new PrintStream(ficheroVolcado), nombreFichero);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: "+ nombreFichero);
        }
    }

    public static void ejemploEscritura(String nombre) {
        try (FileWriter fileWriter = new FileWriter(nombre, true)) {
            fileWriter.write("H");
            fileWriter.write("o");
            fileWriter.write("l");
            fileWriter.write("a");
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    public static void ejemploEscritura2(String nombre) {
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nombre, true));
            bufferedWriter.write("esto es un fichero de texto");
            bufferedWriter.newLine();
            bufferedWriter.write("VIVA ESPAÑA!!!!");
            bufferedWriter.close();
            bufferedWriter = new BufferedWriter(new FileWriter(nombre));
            bufferedWriter.write("esto es un fichero de texto2");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    public static void ejemploLectura(String nombre) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nombre));) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    private static void ejemploLectura2(String nombreFichero) {
        try {
            BufferedReader fbr = new BufferedReader(new
                    FileReader(nombreFichero));
            int i = 0;
            String linea = fbr.readLine();
            while (linea != null) {
                System.out.format("[%d] %s", ++i, linea);
                System.out.println();
                linea = fbr.readLine();
            }
            fbr.close();
        } catch (FileNotFoundException fnf) {
            System.out.println(" No existe el fichero: " +
                    nombreFichero);
        } catch (Exception e) {
            System.out.println("Error en la E/S: " + e.getMessage());
        }
    }

    private static void volcarEstructura(PrintStream ps, String nombreFichero) {
        try(FileInputStream fileInputStream = new FileInputStream(nombreFichero)){
            byte[] buffer = new byte[32];
            int byteLeido;
            int offset = 0;
            do {
                byteLeido = fileInputStream.read(buffer); // Va ir leyendo 32 bits en 32 bits
                ps.format("[%5d]", offset);
                for (int i = 0; i < byteLeido; i++) {
                    ps.format("%2x", buffer[i]); // Pasa a hexadecimal el valor dado
                }
                offset += byteLeido;
                ps.println();

            }while (byteLeido == 32 && offset < 2048);
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }


}
