import java.util.Random;
/**
 *    @author - 
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;

    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int resultado = 2;

        while(resultado * 2 <= numero)
        {
            resultado = resultado * 2;

        }

        return resultado;

    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        int comprobante = 0;
        int contador = 1;
        System.out.printf("\n%6d =", numero);

        while(contador <= 6 && numero != comprobante){
            System.out.printf("%6d",mayorPotencia2(numero - comprobante));
            comprobante += mayorPotencia2(numero - comprobante);
            contador ++;
        }
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {

        int contador = 0;
        int aleatorio = 1;
        
        System.out.printf("%s", "Nºs aleatorios como suma de potencias de " + n);
        while(aleatorio != 0 && contador < n){
            aleatorio = generador.nextInt(256);
            escribirSumaPotencias(aleatorio);
            contador++;
        }

        if(aleatorio == 0){
            System.out.println("\nBucle terminado porque salió el " + aleatorio);
        }

        else{
            System.out.println("\nBucle terminado porque se han generado " 
                + contador + " aleatorios");
        }

    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {

        for(int i = 1; i <= n; i ++){
            if(caracter == ASTERISCO){
                System.out.printf("%c",ASTERISCO);
            }else if(caracter == ESPACIO){
                System.out.printf("%c",ESPACIO);
            }else{
                System.out.printf("%s","Los carácteres permitidos son '*' y ' '");
            }
        }

    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        System.out.println();
        for(int i = 1; i <= escalones; i++)
        {
            for(int j = 1; j <= alto; j++)
            {
                for(int k = 1; k <= alto; k++)
                {
                    escribirCaracter(ancho,ASTERISCO);
                }

                System.out.println();
            }
        }

    }
}
