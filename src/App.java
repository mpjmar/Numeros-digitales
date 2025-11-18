
public class App {

    public static void horizontal(boolean linea, int ancho) {
        for (int j = 0; j < ancho; j++) {
            if (linea)
                System.out.print((j > 0 && j < ancho - 1) && linea ? "*" : " ");
            else
                System.out.print(" ");
        }
        System.out.println();
    }

    public static void vertical(boolean linea, int ancho, int pos) {
        for (int j = 0; j < ancho; j++) {
            if (linea)
                System.out.print(j == pos  ? "*" : " ");
            else
                System.out.print(" ");
        }
    }

    public static void main(String[] args) throws Exception {
        boolean superior = true;
        boolean superiorDerecha = true;
        boolean superiorIzquierda = true;
        boolean central = true;
        boolean inferiorIzquierda = true;
        boolean inferiorDerecha = true;
        boolean inferior = true;
        final int ALTO = 7;
        final int ANCHO = 5;
        // Pinta el número 5
        superiorDerecha = false;
        inferiorIzquierda = false;
        for (int i = 0; i < ALTO; i++) {
            switch (i) {
                case 0: 
                    horizontal(superior, ANCHO);
                    break;
                case 1:
                    vertical(superiorIzquierda, ANCHO - 2, 0);
                    vertical(superiorDerecha, 1, 1);
                    System.out.println();
                    break;
                case 2:
                    vertical(superiorIzquierda, ANCHO - 2, 0);
                    vertical(superiorDerecha, 1, 0);
                    System.out.println();
                    break;
                case 3:
                    horizontal(central, ANCHO);
                    break;
                case 4:
                    vertical(inferiorIzquierda, ANCHO - 2 , 0);
                    vertical(inferiorDerecha, 2, 1);
                    System.out.println();
                    break;
                case 5:
                    vertical(inferiorIzquierda, ANCHO - 2, 0);
                    vertical(inferiorDerecha, 2, 1);
                    System.out.println();
                    break;
                case 6:
                    horizontal(inferior, ANCHO); 
                    break;
                default:

            }
        }
    }
}
