public class Tablero
{
    private final static int MAX_JUGADAS = 10;

    private Jugada[] jugadas;
    private Pistas[] pistas;
    private int numJugadas;

    public Tablero ()
    {
        this.jugadas = new Jugada[ MAX_JUGADAS ];
        this.pistas = new Pistas[ MAX_JUGADAS ];
        numJugadas = 0;
    }

    public int getNumJugadas ()
    {
        return numJugadas;
    }

    public Jugada[] getJugadas ()
    {
        return jugadas;
    }

    public Pistas[] getResultados ()
    {
        return pistas;
    }

    public void insertar ( Jugada jugada, Pistas pistas )
    {
        this.jugadas[ numJugadas ] = jugada;
        this.pistas[ numJugadas ] = pistas;
        numJugadas += 1;
    }

    public boolean completo ()
    {
        return numJugadas == MAX_JUGADAS;
    }

    public void visualizar ()
    {
        for ( int i = 0; i < numJugadas; i++ )
        {
            System.out.print ( " Jugada " + ( i + 1 ) + ".\t\t" );
            jugadas[ i ].visualizar ();
            System.out.print ( " " );
            pistas[ i ].visualizar ();
            System.out.println ( "" );
        }
    }

    @Override
    public String toString ()
    {
        final StringBuilder resultado = new StringBuilder (150 );
        for ( int i = 0; i < numJugadas; i++ )
        {
            resultado.append ( jugadas[ i ].toString () );
            resultado.append ( " " );
            resultado.append ( pistas[ i ].toString () );
            resultado.append ( "\n" );
        }
        return resultado.toString ();
    }
}
