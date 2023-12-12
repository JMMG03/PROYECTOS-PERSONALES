import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner opcion = new Scanner(System.in);
        boolean opcionValida=false;
        while (!opcionValida) {
            // Menú principal
            System.out.println("=============================================");
            System.out.println("Opción 1: Cifrado y descifrado de información");
            System.out.println("Opcion 2: Cálculo de frecuencias");
            System.out.println("=============================================");
            System.out.println("Selecciona una opción: ");
            int numero = opcion.nextInt();
            switch (numero) {
                case 1:
                    //Listado de archivos .txt de la carpeta actual del proyecto
                    File carpeta = new File("./");
                    File[] archivos = carpeta.listFiles(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".txt");
                        }
                    });
                    if (archivos != null) {
                        for (File arch : archivos) {
                            System.out.println(arch.getName());
                        }
                    }
                    cifrarDescifrarArchivos(opcion);
                    System.out.println("Gracias por usar el programa");
                    opcionValida=true;
                    break;
                case 2:
                    calcularFrecuenciaCaracteres(opcion);
                    System.out.println("Gracias por usar el programa");
                    opcionValida=true;
                    break;
                default:
                    System.out.println("Ingresa una opción válida: ");

            }
        }
    }

    private static void cifrarDescifrarArchivos(Scanner opcion) {
        // Menú para cifrar o descifrar
        System.out.println("¿Quieres cifrar o descifrar (E/D)?");
        String respuesta = opcion.next();
        boolean cifrar = respuesta.equalsIgnoreCase("E");

        String accion = cifrar ? "cifrar" : "descifrar";
        String archivoAccion = cifrar ? "Codificado-" : "Descodificado-";

        //Ingresa el nombre del archivo
        System.out.println("Ingresa el nombre de tu archivo " + (cifrar ? "codificable" : "descodificable") + ": ");
        String nombreArchivo = opcion.next();
        File archivoEntrada = new File(nombreArchivo + ".txt");

        // Nombre del archivo de entrada
        if (!archivoEntrada.exists()) {
            System.err.println("El archivo no existe en la carpeta");
            return;
        }

        // Nombre del archivo de salida
        String nombreArchivoSalida = archivoAccion + archivoEntrada.getName();
        File archivoSalida = new File(nombreArchivoSalida);

        if (archivoSalida.exists()) {
            System.err.println("El archivo " + nombreArchivoSalida + " ya existe. No se creará un nuevo archivo.");
            return;
        }
        // Número de desplazamiento
        System.out.println("¿Cuánto de desplazamiento quieres aplicar para  " + accion + "? ");
        int numeroDesplazamiento = opcion.nextInt();

        try {
            // Lectura y escritura de archivos
            FileReader lector = new FileReader(archivoEntrada);
            BufferedReader br = new BufferedReader(lector);
            FileWriter escritor = new FileWriter(archivoAccion + archivoEntrada.getName());
            BufferedWriter bw = new BufferedWriter(escritor);

            String linea;
            /* Bucle para leer linea por el archivo ya sea para cifrar o descifrar
             * antes de escribirla en un archivo de salida*/
            while ((linea = br.readLine()) != null) {
                // El StringBuilder se utliza para evitar la creación de String intermedios mejorando el rendimiento
                StringBuilder resultado = new StringBuilder();
                /* Como caracter tiene un valor numérico lo que se hace es obtener los valores de
                 * los caracteres a los cuales: en la version original se sumará el pasemos como variable
                 * para codificar o  se restará al valor del archivo codificado para volver al valor base*/
                for (char caracter : linea.toCharArray()) {
                    int valorASCII = (int) caracter;
                    int valorModificado = cifrar ? (valorASCII + numeroDesplazamiento) : (valorASCII - numeroDesplazamiento);
                    resultado.append((char) valorModificado);
                }
                /* Convierto el StringBuilder a una cadena de texto resultadoTexto
                 * el se escribira en el archivo de salida ya sea el que se codifica o descodifica*/

                String resultadoTexto = resultado.toString();
                bw.write(resultadoTexto);
                bw.newLine();
            }
            // Cierro la escritura del archivo de salida para asegurar que se ha escrito correctamente.
            bw.close();
            System.out.println("Archivo " + accion + " exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void calcularFrecuenciaCaracteres(Scanner opcion) {
        System.out.println("Ingrese el nombre del archivo de texto: ");
        String nombreArchivo = opcion.next();

        File archivo = new File(nombreArchivo + ".txt");
        //Comprueba si el archivo existe
        if (!archivo.exists()) {
            System.err.println("El archivo no existe en la carpeta");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "UTF-8"))) {
            Map<Character, Integer> frecuenciaCaracteres = new HashMap<>();
            int caracter;

            while ((caracter = br.read()) != -1) {
                char charCaracter = (char) caracter;
                // Ignora los espacios
                if (charCaracter != ' ') {
                    // Actualiza la frecuencia del caracter
                    frecuenciaCaracteres.put(charCaracter, frecuenciaCaracteres.getOrDefault(charCaracter, 0) + 1);
                }
            }
            // Muestra la frecuencia de caracteres
            for (Map.Entry<Character, Integer> entry : frecuenciaCaracteres.entrySet()) {
                System.out.println("Caracter: " + entry.getKey() + ", Frecuencia: " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}