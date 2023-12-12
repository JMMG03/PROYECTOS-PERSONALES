import java.util.Scanner;

public class Figuras_Geometricas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce nombre de forma");
        String forma = scanner.next();

        System.out.println("La forma elegida es: " + forma);

        if (forma.equals("piramide")) {
            System.out.print("Introduce la base de la piramide: ");
            double base = scanner.nextDouble();
            System.out.print("Introduce la altura: ");
            double altura = scanner.nextDouble();
            System.out.print("El volumen de la piramide es: " + (base * altura) / 3);

        } else if (forma.equals("esfera")) {
            System.out.print("Introduce el radio de la esfera: ");
            double radioEsfera = scanner.nextDouble();
            double volumenEsfera = (4 * Math.PI * Math.pow(radioEsfera, 3)) / 3;
            System.out.println("El volumen de la esfera es: " + volumenEsfera);

        } else if (forma.equals("cubo")) {
            System.out.print("Introduce el lado del cubo: ");
            double ladoCubo = scanner.nextDouble();
            double volumenCubo = Math.pow(ladoCubo, 3);
            System.out.println("El volumen del cubo es: " + volumenCubo);

        } else {
            switch (forma) {

                case "triangulo":
                    System.out.print("Introduce la base del triángulo: ");
                    double baseTriangulo = scanner.nextDouble();
                    System.out.print("Introduce la altura del triángulo: ");
                    double alturaTriangulo = scanner.nextDouble();
                    double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
                    System.out.println("El área del triángulo es: " + areaTriangulo);
                    break;

                case "cuadrado":
                    System.out.print("Introduce lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    System.out.print("El area del cuadrado es: " + Math.pow(lado, 2));
                    break;

                case "rectangulo":
                    System.out.print("Introduce la base del rectangulo: ");
                    double basee = scanner.nextDouble();
                    System.out.print("Introduce la altura del triangulo: ");
                    double alturaa = scanner.nextDouble();
                    System.out.print("El area del rectangulo es: " + basee * alturaa);
                    break;

                case "circulo":
                    System.out.print("Introduce radio del circulo: ");
                    double radio = scanner.nextDouble();
                    System.out.print("El area del circulo es: ");
                    System.out.println((Math.PI * (Math.pow(radio, 2))));
                    break;

                case "rombo":
                    System.out.print("Introduce diagonal mayor del rombo: ");
                    double diagonalmayor = scanner.nextDouble();
                    System.out.print("Introduce diagonal menor del rombo: ");
                    double diagonalmenor = scanner.nextDouble();
                    System.out.print("El area del triangulo es: " + (diagonalmayor * diagonalmenor) / 2);
                    break;

                case "poligono":
                    System.out.println("Introduce perimetro");
                    double perimetro = scanner.nextDouble();
                    System.out.print("Introduce la apotema: ");
                    double apotema = scanner.nextDouble();
                    System.out.print("El area del poligono es: " + (perimetro * apotema) / 2);
                    break;

                case "trapecio":
                    System.out.println("Introduce altura");
                    double alt = scanner.nextDouble();
                    System.out.print("Introduce la base A: ");
                    double Abase = scanner.nextDouble();
                    System.out.print("Introduce la base B: ");
                    double Bbase = scanner.nextDouble();
                    System.out.print("El area del trapecio es: " + (alt * ((Abase + Bbase) / 2)));
                    break;
                case "paralelogramo":
                    System.out.println("Introduce base");
                    double bas = scanner.nextDouble();
                    System.out.print("Introduce la altura: ");
                    double hype = scanner.nextDouble();
                    System.out.print("El area del paralelogramo es: " + (bas * hype));
                    break;
                default:
                    System.out.println("Forma geometrica incorrecta");
                    break;
            }
        }
    }
}