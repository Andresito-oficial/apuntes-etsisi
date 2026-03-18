import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	private static final Random rnd = new Random();
	public static void main (String[] args) {
		final int amount = Integer.parseInt( args[0]);
		List<Integer> lista = new ArrayList<Integer>(amount);
		for (int i = 0; i < amount; i++) {
			int b = rnd.nextInt(Integer.MAX_VALUE);
			lista.add(b);
		}
		/*System.out.println ("Lista a ordenar:");
		for ( Integer l: lista) {
			System.out.print(l + " , ");
		}
		System.out.println();*/
		lista = new MergeSort(lista).sorted();
		System.out.println("Lista después de ordenar");
		for ( Integer l : lista) {
			System.out.print(l + " , ");
		}
		System.out.println();
	}
}
