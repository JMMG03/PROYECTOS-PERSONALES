import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        // Borrar los archivos .txt escritos/generados por el usuario.
        Scanner opcion = new Scanner(System.in);
        System.out.println("=========================== Bienvenido al juego de Mecanografía ========================");
        System.out.println("\tInstrucciones: \n\tCopia el texto nivel de la mejor manera posible para completar el nivel");
        System.out.println("========================================================================================");
        boolean nivelFacilCompletado = false;
        boolean nivelMedioCompletado = false;
        boolean nivelDificilCompletado = false;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            if (!nivelFacilCompletado) {
                System.out.println("Opciones: \n1.Iniciar Nivel Fácil \n2.Salir");
                int numeroOpc = opcion.nextInt();

                switch (numeroOpc) {
                    case 1:
                        opcion.nextLine(); // Consumir la línea en blanco

                        System.out.println("Escribe la ruta del editor de texto:");
                        String editorPath = opcion.nextLine();

                        nivelFacilCompletado = jugarNivel(editorPath, "Nivel-Facil.txt", "textoCopiaFacil.txt", 25000);
                        if (nivelFacilCompletado) {
                            System.out.println("¡Nivel Fácil completado!");
                            System.out.println("¿Deseas continuar al Nivel Medio? (1 para Sí / 2 para No)");
                            int continuar = opcion.nextInt();
                            if (continuar == 1) {
                                nivelMedioCompletado = jugarNivel(editorPath, "Nivel-Medio.txt", "textoCopiaMedio.txt", 15000);
                                if (nivelMedioCompletado) {
                                    System.out.println("¡Nivel Medio completado!");
                                    System.out.println("¿Deseas continuar al Nivel Difícil? (1 para Sí / 2 para No)");
                                    continuar = opcion.nextInt();
                                    if (continuar == 1) {
                                        nivelDificilCompletado = jugarNivel(editorPath, "Nivel-Dificil.txt", "textoCopiaDificil.txt", 10000);
                                        if (nivelDificilCompletado) {
                                            System.out.println("=========================================");
                                            System.out.println("============== FELICIDADES ==============");
                                            System.out.println("=========================================");
                                            juegoTerminado = true;
                                        } else {
                                            System.out.println("Que pena, casi lo consigues :(");
                                            eliminarArchivoCopia("textoCopiaFacil.txt");
                                            eliminarArchivoCopia("textoCopiaMedio.txt");
                                            eliminarArchivoCopia("textoCopiaDificil.txt");

                                            break;
                                        }
                                    } else {
                                        System.out.println("Gracias por jugar");
                                        eliminarArchivoCopia("textoCopiaMedio.txt");
                                        eliminarArchivoCopia("textoCopiaFacil.txt");
                                        juegoTerminado = true;
                                        break;
                                    }
                                } else {
                                    System.out.println("Has fallado en el Nivel Medio.");
                                    juegoTerminado = true;
                                    eliminarArchivoCopia("textoCopiaMedio.txt");
                                    eliminarArchivoCopia("textoCopiaFacil.txt");
                                    break;
                                }
                            } else {
                                System.out.println("Gracias por jugar");
                                eliminarArchivoCopia("textoCopiaMedio.txt");
                                eliminarArchivoCopia("textoCopiaFacil.txt");
                                juegoTerminado = true;
                                break;
                            }
                        } else {
                            System.out.println("Has fallado en el Nivel Fácil.");
                            eliminarArchivoCopia("textoCopiaMedio.txt");
                            eliminarArchivoCopia("textoCopiaFacil.txt");
                            juegoTerminado = true;
                            break;
                        }
                        break;
                    case 2:
                        System.out.println("Gracias por usar el programa");
                        eliminarArchivoCopia("textoCopiaMedio.txt");
                        eliminarArchivoCopia("textoCopiaFacil.txt");
                        juegoTerminado = true;
                        break;
                    default:
                        System.out.println("Opción no válida, selecciona una de las opciones");
                }
            }
        }
    }

    // Metodo para jugar un nivel
    private static boolean jugarNivel(String editorPath, String textoOriginal, String textoCopia, int tiempo) {
        try {
            Path textoOriginalPath = Paths.get("./src/textosNivelDificultad/" + textoOriginal);
            Path nuevoTextoCopiaPath = Paths.get("./src/" + textoCopia);

            // Crear un nuevo archivo en blanco
            Files.createFile(nuevoTextoCopiaPath);

            // Leer el contenido original
            String contenidoOriginal = Files.readString(textoOriginalPath);

            // Abrir la aplicación seleccionada y esperar
            abrirAplicacion(editorPath, nuevoTextoCopiaPath.toString());

            System.out.println("Contenido a copiar:");
            System.out.println(contenidoOriginal);
            System.out.println("Por favor, copia este texto en la aplicación y cierra la aplicación cuando hayas terminado.");

            Timer timer = new Timer();
            final boolean nivelCompletado[] = {false};

            // Esperar el tiempo programado antes de finalizar
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!nivelCompletado[0]) {
                        System.out.println("Tiempo agotado. Has fallado.");
                        cerrarAplicacion();
                    }
                }
            }, tiempo);

            // Esperar a que la aplicación se cierre manualmente o hasta que el tiempo se agote
            while (!nivelCompletado[0]) {
                try {
                    // Leer el contenido del archivo copiado
                    String contenidoCopia = Files.readString(nuevoTextoCopiaPath);

                    if (contenidoOriginal.equals(contenidoCopia)) {
                        nivelCompletado[0] = true;
                        System.out.println("¡Nivel completado!");
                        cerrarAplicacion();
                    }

                    // Esperar un momento antes de volver a verificar
                    Thread.sleep(1000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return nivelCompletado[0];
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo para abrir una aplicacion con un archivo específico
    private static void abrirAplicacion(String aplicacion, String filePath) {
        try {
            ProcessBuilder builder = new ProcessBuilder(aplicacion, filePath);
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cerrar una aplicación
    private static void cerrarAplicacion() {
        try {
            /* Robot se utiliza para generar eventos de entrada en el sistema,
             * en este caso se utiliza para que se cierre el programa activo con alt+f4 */
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_F4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Método para eliminar un archivo de copia
    private static void eliminarArchivoCopia(String archivoCopia) {
        try {
            Path archivoCopiaPath = Paths.get("./src/" + archivoCopia);
            Files.deleteIfExists(archivoCopiaPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
