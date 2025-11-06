public class Jugada
{
    enum Color
    {
        ROJO, VERDE, AMARILLO, PURPURA
    }

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final char CUADRADO = '■';
    private static final String ANSI_RESET = "\u001B[0m";

    private final Color[] fichas;

    public Jugada ( String cadena )
    {
        fichas = new Color[ cadena.length () ];
        for ( int i = 0; i < cadena.length (); i++ )
        {
            switch ( cadena.charAt ( i ) )
            {
                case 'R':
                    fichas[ i ] = Color.ROJO;
                    break;
                case 'V':
                    fichas[ i ] = Color.VERDE;
                    break;
                case 'A':
                    fichas[ i ] = Color.AMARILLO;
                    break;
                case 'P':
                    fichas[ i ] = Color.PURPURA;
                    break;
            }
        }
    }

    public Jugada ( int numFichas )
    {
        fichas = new Color[ numFichas ];
        for ( int i = 0; i < numFichas; i++ )
        {
            switch ( ( int ) ( Math.random () * 4 ) )
            {
                case 0:
                    fichas[ i ] = Color.ROJO;
                    break;
                case 1:
                    fichas[ i ] = Color.VERDE;
                    break;
                case 2:
                    fichas[ i ] = Color.AMARILLO;
                    break;
                case 3:
                    fichas[ i ] = Color.PURPURA;
                    break;
            }
        }
    }

    public Pistas comprobar ( Jugada oculta )
    {
        int colocados, descolocados;
        int tam = Color.values ().length;
        int[] cont1 = new int[ tam ];
        int[] cont2 = new int[ tam ];
        int cont = 0;
        colocados = 0;
        for ( int k = 0; k < cont2.length; k++ )
        {
            cont1[ k ] = cont2[ k ] = 0;
        }
        for ( int i = 0; i < this.fichas.length; i++ )
        {
            if ( this.fichas[ i ] == oculta.fichas[ i ] )
            {
                colocados += 1;
            }
        }
        for ( int j = 0; j < this.fichas.length; j++ )
        {
            cont1[ this.fichas[ j ].ordinal () ] += 1;
            cont2[ oculta.fichas[ j ].ordinal () ] += 1;
        }
        for ( int h = 0; h < cont2.length; h++ )
        {
            cont += Math.min ( cont1[ h ], cont2[ h ] );
        }
        descolocados = cont - colocados;
        return new Pistas ( colocados, descolocados );
    }

    public void visualizar ()
    {
        for ( Color ficha : fichas )
        {
            switch ( ficha )
            {
                case ROJO:
                    System.out.print ( ANSI_RED + CUADRADO + " " );
                    break;
                case VERDE:
                    System.out.print ( ANSI_GREEN + CUADRADO + " " );
                    break;
                case AMARILLO:
                    System.out.print ( ANSI_YELLOW + CUADRADO + " " );
                    break;
                case PURPURA:
                    System.out.print ( ANSI_PURPLE + CUADRADO + " " );
                    break;
            }
        }
        //System.out.print ( ANSI_BLACK );
        System.out.print ( ANSI_RESET );
    }

    @Override
    public String toString ()
    {
        String resultado = "";
        for ( Color ficha : fichas )
        {
            switch ( ficha )
            {
                case ROJO:
                    resultado += "R";
                    break;
                case VERDE:
                    resultado += "V";
                    break;
                case AMARILLO:
                    resultado += "A";
                    break;
                case PURPURA:
                    resultado += "P";
                    break;
            }
        }
        return resultado;
    }
}
