import java.time.LocalTime;

public class RelojDigital {

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

    public static void pintaPuntos(int fila) {
        System.out.print((fila == 2 || fila == 4) ? "*" : " ");
    }
    
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {

        final int ALTO = 7;

        do { 
            System.out.println("         **********************************************");
            System.out.println("         ********** R E L O J  D I G I T A L **********");
            System.out.println("         **********************************************");

            LocalTime ahora = LocalTime.now(); 
            int hora = ahora.getHour();
            int minuto = ahora.getMinute();
            int segundo = ahora.getSecond();

            int hora1 = hora / 10;
            int hora2 = hora % 10;
            int minuto1 = minuto / 10;
            int minuto2 = minuto % 10;
            int segundo1 = segundo / 10;
            int segundo2 = segundo % 10;

            for (int i = 0; i < ALTO; i++) {

                for (int j = 0; j < 7; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 8; j++) {
                    switch (j) {
                        case 0 -> pintaNumero(i, hora1);
                        case 1 -> pintaNumero(i, hora2);
                        case 2 -> pintaPuntos(i);
                        case 3 -> pintaNumero(i, minuto1);
                        case 4 -> pintaNumero(i, minuto2);
                        case 5 -> pintaPuntos(i);
                        case 6 -> pintaNumero(i, segundo1);
                        case 7 -> pintaNumero(i, segundo2);
                        default -> System.out.print("");
                        }
                        System.out.print("  ");
                    }
                    System.out.println();

                }
                System.out.println("         **********************************************");
                Thread.sleep(1000); 
                limpiarPantalla();
            } while (true);


    }
}
