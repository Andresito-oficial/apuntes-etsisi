import java.io.*;
import java.util.Scanner;

public class MasterMind
{
    private final Tablero tablero;
    private final Jugada jugadaOculta;
    private final int numFichas;

    public MasterMind ( int numFichas )
    {
        this.numFichas = numFichas;
        this.jugadaOculta = new Jugada ( numFichas );
        this.tablero = new Tablero ();
    }

    public Tablero getTablero ()
    {
        return tablero;
    }

    public MasterMind ( String nombreArchivo ) throws FileNotFoundException
    {
        final Scanner sc = new Scanner ( new FileReader ( nombreArchivo ) );
        final String firstLine = sc.next ();
        this.jugadaOculta = new Jugada ( firstLine );
        this.numFichas = firstLine.length ();
        this.tablero = new Tablero ();
        while ( sc.hasNext () )
        {
            final Jugada jugada = new Jugada ( sc.next () );
            final int aciertos = sc.nextInt ();
            final int descolocados = sc.nextInt ();
            final Pistas pistas = new Pistas ( aciertos, descolocados );
            tablero.insertar ( jugada, pistas );
        }
        sc.close ();
    }

    private void guardarPartida ( String nombreArchivo ) throws IOException
    {
        final FileWriter guardado = new FileWriter ( nombreArchivo );
        final PrintWriter salida = new PrintWriter ( guardado );
        salida.println ( jugadaOculta.toString () );
        salida.print ( tablero.toString () );
        salida.close ();
    }

    public void jugar ()
    {
        boolean salir = false;
        do
        {
            final String entrada = Teclado.leerJugadaGuardar ( numFichas, "Introduce jugada o G (guardar la partida).\nR (Rojo), V(Verde), A (Amarillo), P (púrpura): " );
            if ( entrada.equals ( "G" ) )
            {
                try
                {
                    final String nombrearchivo = Teclado.leerString ( "Nombre del archivo: " );
                    guardarPartida ( nombrearchivo );
                }
                catch (IOException e)
                {
                    System.err.println ( "ERROR AL GUARDAR LA PARTIDA" );
                }
                finally
                {
                    salir = true;
                }
            }
            else
            {
                final Jugada jugada = new Jugada ( entrada );
                final Pistas pistas = jugada.comprobar ( jugadaOculta );
                tablero.insertar ( jugada, pistas );
                tablero.visualizar ();
                if ( tablero.completo () )
                {
                    salir = true;
                    System.out.println ( "FIN DE LOS INTENTOS, NO CONSEGUISTE ACERTAR" );
                    jugadaOculta.visualizar ();
                }
                else if ( pistas.getAciertos () == numFichas )
                {
                    salir = true;
                    System.out.println ( "ACERTASTE LA JUGADA" );
                }
            }
        } while ( ! salir );
    }

    public static void main ( String[] args )
    {
        try
        {
            MasterMind masterMind;
            if ( Teclado.leerSiNo ( "¿Quieres recuperar una partida? (S/N): " ) == 'S' )
            {
                final String nombreArchivo = Teclado.leerString ( "Nombre del archivo: " );
                masterMind = new MasterMind ( nombreArchivo );
                masterMind.getTablero ().visualizar ();
            }
            else
            {
                final int fichas = Teclado.leerEntero ( 4, 6, "Número de fichas de las jugadas (4 - 6): " );
                masterMind = new MasterMind ( fichas );
            }
            masterMind.jugar ();
        }
        catch (FileNotFoundException e)
        {
            System.err.println ( "ERROR AL RECUPERAR LA PARTIDA" );
        }
    }
}
