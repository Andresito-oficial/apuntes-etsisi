import java.util.List;
import java.util.concurrent.Semaphore;

public class MergeSortConcurrent extends Thread {
	private final List<Integer> ToMergeA;
	private final List<Integer> ToMergeB;
	private final List<Integer> ToOutput;
	private MergeSortConcurrent dependencyA;
	private MergeSortConcurrent dependencyB;
	private Semaphore control;

	public MergeSortConcurrent (List<Integer> inputA, List<Integer> inputB, List<Integer> Output, MergeSortConcurrent depA, MergeSortConcurrent depB) {
		ToMergeA = inputA;
		ToMergeB = inputB;
		ToOutput = Output;
		dependencyA = depA;
		dependencyB = depB;
	}

	public MergeSortConcurrent (List<Integer> inputA, List<Integer> inputB, List<Integer> Output, MergeSortConcurrent depA, MergeSortConcurrent depB, Semaphore control) {
		ToMergeA = inputA;
		ToMergeB = inputB;
		ToOutput = Output;
		dependencyA = depA;
		dependencyB = depB;
		this.control = control;
	}

	void merge ( List<Integer> a, List<Integer> b, List<Integer> merged) {
		//final List<Integer> merged = new ArrayList<Integer>(a.size() + b.size());
		//System.out.println( this.getName() + " mezclando : " + (a == null ? "null" : a.toString()) + " con b: " + (b == null ? "null" : b.toString()));
		Integer currentA = getLast(a);
		Integer currentB = getLast(b);
		while (!(currentA == null && currentB == null)) {
			final Integer max = max(currentA, currentB);
			merged.addFirst(max);
			if (max == currentA) {
				currentA = getLast(a);
			}
			else if (max == currentB) {
				currentB = getLast(b);
			}
		}
		//System.out.println( this.getName() + " ha Mezclado : " + merged.toString());
		//return merged;
	}

	Integer getLast (List<Integer> list) {
		Integer var;
		try {
			var = list.removeLast();
		} catch (Exception e) {
			var = null;
		}
		return var;
	}

	Integer max (Integer a, Integer b) {
		if (a == null) { return b; }
		else if (b == null || a > b) { return a; }
		else { return b; }
	}

	@Override
	public void run() {
		try {
			if (dependencyA != null) {
				//System.err.println( this.getName() + " Esperando a " + dependencyA.getName());
				dependencyA.join();
			}
			if (dependencyB != null) {
				//System.err.println( this.getName() + " Esperando a " + dependencyB.getName());
				dependencyB.join();
			}
			merge(ToMergeA, ToMergeB, ToOutput);
			control.release();
			//System.err.println( this.getName() + " ha terminado de mezclar y ha liberado un permiso");
		} catch (Exception e) {
				System.err.println( this.getName() + " ha sido interrumpido");
				System.err.println("Error: " + e.getMessage());
		}
	}
}
