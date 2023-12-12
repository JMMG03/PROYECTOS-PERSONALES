import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Estos son los datos
        Scanner sc = new Scanner(System.in);
        String[] palabras = {"abeja", "bacon", "cacao", "dados,", "ebano", "fagot", "gafas", "habla", "idolo",
                "jabon", "lacon", "madre", "nadie", "oasis", "pagar", "queso", "rabia", "sobre", "tacto", "umbra", "vacio", "yacer", "zagal"};
        int maxIntentos = 5;// numero maximo de intentos
        String palabra = "";//variable que se utilizará para leer palabras por teclado
        int intentos = 0;// contador de intentos que llevamos en el programa
        int contador = 0;
        int contador2 = 0;
        int nMalditos = 0;
        char[] malditos = new char[27];// letras/caracteres que se tiene máximo
        //palabra aleatoria desde el array palabras
        Random randomNumberGenerator = new Random();
        int randomPosition = randomNumberGenerator.nextInt(palabras.length);
        String palabraAleatoria = palabras[randomPosition];
        //Introducción del programa
        System.out.println("Se ha generado una palabra aleatoria. Las letras en mayusculas estan en la palabra y posicionadas correctamente,");
        System.out.println("las letras en minusculas estan en la palabra pero mal posicionadas y las letras que no esten se introduciran");
        System.out.println("en la lista de caracteres malditos.");
        System.out.println("_ _ _ _ _ _");
        System.out.println("Caracteres malditos: []");
        //Empieza el funcionamiento
        do {
            do {
                //EL primer do se ejecutará primero
                System.out.println(" ");
                System.out.print("Inserta palabra: ");
                palabra = sc.next().toLowerCase();//valor que se lee por teclado
                if (palabra.length() != 5) { //establecemos la condición de expresión para que cuando se introduzca una distinto de
                    System.out.println("La palabra contiene 5 letras");//5 caracteres te lo diga
                }
                //Empezamos el desarrollo del programa
            } while (palabra.length() != 5);
            //Se comprueba si la palabra está bien o no y se commienzan a dar pistas
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) != palabraAleatoria.charAt(i)) {
                    for (int j = 0; j < 5; j++) {
                        //comparamos caracteres de palabras
                        if (contador == 0 && palabra.charAt(i) == palabraAleatoria.charAt(j)) {
                            System.out.print(palabra.charAt(i));
                            contador = 1;
                        }
                    }//si son iguales se reemplazara la letra por el _
                    if (contador == 0) {
                        System.out.print("_");
                    }
                }//Volverá el caracter de la letra en mayúscula
                if (palabra.charAt(i) == palabraAleatoria.charAt(i)) {
                    System.out.print(palabra.toUpperCase().charAt(i));

                }
                contador = 0;
            }//Introduccióon y comparación para el conjunto de letras malditas
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (palabra.charAt(i) == palabraAleatoria.charAt(j)) {
                        contador2++;
                    }
                    for (int k = 0; k < malditos.length; k++) {
                        if (palabra.charAt(i) == malditos[k]) {
                            contador2++;
                        }
                    }
                }
                if (contador2 == 0) {
                    malditos[nMalditos] = palabra.charAt(i);
                    nMalditos++;
                }
                contador2 = 0;
            }
            System.out.println();
            intentos++;
            //Inserción de las letras no correspondientes al conjunto de caracteres malditos
            System.out.print("Caracteres malditos: [");
            for (int k = 0; k < nMalditos - 1; k++) {
                System.out.print(malditos[k] + ",");
            }
            System.out.println(malditos[nMalditos - 1] + "]");

        }//haz bucle mientras intentos sea menor que el maxIntentos y palabra igual a la palabrAleatoria
        while (intentos < maxIntentos && !palabra.equals(palabraAleatoria));
        //Condición de que si palabra es igual a palabraAleatoria exprese: has acertado...
        if (palabra.equalsIgnoreCase(palabraAleatoria))
            System.out.println("Has acertado la palabra " + palabraAleatoria.toUpperCase() + " al intento " + intentos + ". Enhorabuena.");
            //Condición que expresa lo que pasa si no se cumple la condición expresando los intentos realizados y la palabraAleatoria
        else {
            System.out.println("Se han consumido los " + intentos + " intentos." + " La palabra era " + palabraAleatoria.toUpperCase() + ".");
        }
    }
}