
public class App {

    public static void horizontal(boolean linea, int ancho) {
        for (int j = 0; j < ancho; j++) {
            if (linea)
                System.out.print((j > 0 && j < ancho - 1) && linea ? "*" : " ");
            else
                System.out.print(" ");
        }
    }

    public static void vertical(boolean linea, int ancho, int pos) {
        for (int j = 0; j < ancho; j++) {
            if (linea)
                System.out.print(j == pos  ? "*" : " ");
            else
                System.out.print(" ");
        }
    }

    public static void pintaNumero(int fila, int num) {

        boolean superior = true;
        boolean superiorDerecha = true;
        boolean superiorIzquierda = true;
        boolean central = true;
        boolean inferiorIzquierda = true;
        boolean inferiorDerecha = true;
        boolean inferior = true;

        final int ALTO = 7;
        final int ANCHO = 5;

        switch (num) {
            case 0:
                central = false;
                break;
            case 1:
                superior = false;
                superiorIzquierda = false;
                central = false;
                inferiorIzquierda = false;
                inferior = false;
                break;
            case 2:
                superiorIzquierda = false;
                inferiorDerecha = false;
                break;
            case 3:
                superiorIzquierda = false;
                inferiorIzquierda = false;
                break;
            case 4:
                superior = false;
                inferiorIzquierda = false;
                inferior = false;
                break;
            case 5:
                superiorDerecha = false;
                inferiorIzquierda = false;
                break;
            case 6:
                superiorDerecha = false;
                break;
            case 7:
                superiorIzquierda = false;
                central = false;
                inferiorIzquierda = false;
                inferior = false;
                break;
            case 9:
                inferiorIzquierda = false;
                break;
            default:
                break;
        }

        switch (fila) {
            case 0: 
                horizontal(superior, ANCHO);
                break;
            case 1:
                vertical(superiorIzquierda, ANCHO - 2, 0);
                vertical(superiorDerecha, 2, 1);
                break;
            case 2:
                vertical(superiorIzquierda, ANCHO - 2, 0);
                vertical(superiorDerecha, 2, 1);
                break;
            case 3:
                horizontal(central, ANCHO);
                break;
            case 4:
                vertical(inferiorIzquierda, ANCHO - 2 , 0);
                vertical(inferiorDerecha, 2, 1);
                break;
            case 5:
                vertical(inferiorIzquierda, ANCHO - 2, 0);
                vertical(inferiorDerecha, 2, 1);
                break;
            case 6:
                horizontal(inferior, ANCHO); 
                break;
            default:

        }
    }

    public static void main(String[] args) throws Exception {

        boolean correcto = false, salir = false;
        final int ALTO = 7;
        int opcion = 0, num = 0;
        
        do {
        
            System.out.println("""
            *****************************************
            *                                       *
            *       NÚMEROS DIGITALES v1.0          *
            *                                       *
            *****************************************
            *                                       *
            *   [1] Mostrar secuencia (0 a N)       *
            *   [2] Número específico               *
            *   [0] Salir                           *
            *                                       *
            *****************************************
            """);

            try {
                do {
                    opcion = Integer.parseInt(System.console().readLine());
                    correcto = opcion >= 0 && opcion <= 2;
                    if (!correcto) System.out.println("La opción introducida no es correcta.");
                } while (!correcto);
            } catch (NumberFormatException e) {
                System.out.println("El número debe ser un entero.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
            
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1: 
                    System.out.print("Introduce un número del 0 al 9: ");
                    num = Integer.parseInt(System.console().readLine());
                    for (int i = 0; i < ALTO; i++) {
                        for (int j = 0; j <= num; j++) {
                            pintaNumero(i, j);
                            System.out.print("  ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Introduce un número del 0 al 9: ");
                    num = Integer.parseInt(System.console().readLine());
                    for (int i = 0; i < ALTO; i++) {
                        pintaNumero(i, num);
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }            
        } while (!salir);
    } 
}
