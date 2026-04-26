import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MezclaConcurrenteExecutor {
	private final List<Integer> origen;
	private List<Future<List<Integer>>> mezcladora;
	private final int Niveles;
	private int nivel;
	private final int nThreads;
	private final ForkJoinPool ejecutor;

	/*public MezclaConcurrenteExecutor ( List<Integer> a ) {
		origen = a;
		mezcladora = new ArrayList<Future<List<Integer>>>();
		Niveles = (int) Math.ceil(Math.log(a.size()) / Math.log(2)) + 1;
		nivel = 0;
		nThreads = Math.min(a.size(), Runtime.getRuntime().availableProcessors());
		ejecutor = new ForkJoinPool(nThreads);
		System.err.println("Nivel máximo: " + Niveles);
		System.err.println("Número de hilos: " + nThreads);
	}

	public MezclaConcurrenteExecutor ( List<Integer> a, int n) {
		origen = a;
		mezcladora = new ArrayList<Future<List<Integer>>>();
		Niveles = (int) Math.ceil(Math.log(a.size()) / Math.log(2)) + 1;
		nivel = 0;i resultado (
		nThreads = n <= 0 ? Runtime.getRuntime().availableProcessors() : Math.min(a.size(), n);
		ejecutor = new ForkJoinPool(nThreads);
		System.err.println("Nivel máximo: " + Niveles);
		System.err.println("Número de hilos: " + nThreads);
	}*/
	public MezclaConcurrenteExecutor ( List<Integer> a, int n) {
		origen = a;
		mezcladora = new ArrayList<Future<List<Integer>>>();
		Niveles = (int) Math.ceil(Math.log(a.size()) / Math.log(2)) + 1;
		nivel = 0;
		nThreads = n <= 0 ? Runtime.getRuntime().availableProcessors() : Math.min(a.size(), n);
		ejecutor = new ForkJoinPool(nThreads);
		/*System.err.println("Nivel máximo: " + Niveles);
		System.err.println("Número de hilos: " + nThreads);*/
	}

	/*
	 * 1º crear los primeros conjuntos de tamaño 1 y añadirlos a mezcladora
	 * 2º crear mezclas a partir de mezclaconcurrente pasandole una lista destino, origen.get(i), origen.get(i+1) en mezcladora con incremento en i de la fomra i+= 2;
	 * 3º inicializar bucle de tamaños para las mezclas
	 * 4º dentro de ese bucle */
	public void mezclar () throws InterruptedException {
		//List<MergeSortConcurrent> primerasDependencias = new ArrayList<MergeSortConcurrent>(origen.size());
		for (int i = 0; i < origen.size(); i++) {
			final int index = i;
			mezcladora.add(ejecutor.submit(() -> {
				List<Integer> item = new ArrayList<Integer>();
				item.add(origen.get(index));
				return item;
			}));
			/*List<Integer> item = new ArrayList<Integer>();
			item.add(origen.get(i));
			//primerasDependencias.add(null);
			mezcladora.add(item);*/
		}
		//hilos[nivel] = primerasDependencias;
		nivel = 1;
		aux();
	}

	private void aux() throws InterruptedException {
		while ( mezcladora.size() > 1) {
			List<Future<List<Integer>>>temp = new ArrayList<Future<List<Integer>>>();
			/*List<MergeSortConcurrent> dependencias = hilos[nivel - 1];
			List<MergeSortConcurrent> nuevasDependencias = new ArrayList<MergeSortConcurrent>();*/
			for (int j = 0; j < mezcladora.size(); j+=2) {
				/*List<Integer> destino = new ArrayList<Integer>();
				System.out.println("Voy a crear el hilo " + temp.size() + " del nivel " + nivel + " que depende de los hilos " + j + " y " + (j + 1) + " del nivel " + (nivel - 1));
				control.acquire();*/
				MergeSortConcurrentExec merge = new MergeSortConcurrentExec(getDep(mezcladora, j), getDep(mezcladora, j + 1) );
				temp.add(ejecutor.submit(merge));
				/*nuevasDependencias.add(merge);
				temp.add(destino);
				merge.start();*/
			}
			mezcladora = temp;
			//hilos[nivel] = nuevasDependencias;
			nivel += 1;
		}
		/*try {
			hilos[nivel -1].getLast().join();
		} catch (Exception e) {
		}*/
	}

	private List<Integer> get (List<List<Integer>> list, int i) {
		try {
			return list.get(i);
		} catch (Exception e) {
			return null;
		}
	}

	private Future<List<Integer>> getDep (List<Future<List<Integer>>> list, int i) {
		try {
			return list.get(i);
		} catch (Exception e) {
			return null;
		}
	}

	/*private Integer getA (int[] list, int i) {
		try {
			return list[i];
		} catch (Exception e) {
			return null;
		}
	}*/

	public List<Integer> resultado () {
		try {
			return mezcladora.getFirst().get();
		} catch (Exception e) {
			System.err.println("Error al obtener el resultado: " + e.getMessage());
			return null;
		}
		//return mezcladora.get(0);
	}
}
