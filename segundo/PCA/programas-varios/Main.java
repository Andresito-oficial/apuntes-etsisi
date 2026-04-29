import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	private static final Random rnd = new Random();
	public static void main (String[] args) throws InterruptedException {
		System.err.println("Cantidad de memoria disponible: " + Runtime.getRuntime().totalMemory() + " bytes");
		final long begining = System.nanoTime();
		final int amount = Integer.parseInt( args[0]);
		List<Integer> lista = new ArrayList<Integer>(amount);
		//int[] lista = new int[amount];
		for (int i = 0; i < amount; i++) {
			int b = rnd.nextInt(Integer.MAX_VALUE);
			//lista[i] = b;
			 lista.add(b);
		}
		/*System.out.println ("Lista a ordenar:");
		for ( Integer l: lista) {
			System.out.print(l + " , ");
		}
		System.out.println();
		/*lista = new MergeSort(lista).sorted();
		System.out.println("Lista después de ordenar");
		for ( Integer l : lista) {
			System.out.print(l + " , ");
		}
		System.out.println(); */
		//MezclaConcurrente mezcla = new MezclaConcurrente(lista);
		/*MezclaConcurrente mezcla = new MezclaConcurrente(lista, Integer.parseInt(args[1]));
		mezcla.mezclar();*/
		/*System.out.println("Lista después de ordenar");
		System.err.println("Resultado: " + mezcla.resultado().toString());*/
		MezclaConcurrenteExecutor mezcla = new MezclaConcurrenteExecutor(lista, Integer.parseInt(args[1]));
		mezcla.mezclar();
		//System.out.println("Lista después de ordenar");
		//System.err.println("Resultado: " + mezcla.resultado().toString());
		final long end = System.nanoTime();
		System.err.println( "Ha tradado " + (end - begining) + " nanosegundos");
	}
}
