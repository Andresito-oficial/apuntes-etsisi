import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class MergeSortConcurrentExec implements Callable<List<Integer>> {
	private Future<List<Integer>> dependencyA;
	private Future<List<Integer>> dependencyB;
	
	public MergeSortConcurrentExec (Future<List<Integer>> depA, Future<List<Integer>> depB) {

		dependencyA = depA;
		dependencyB = depB;
	}

	void merge ( List<Integer> a, List<Integer> b, List<Integer> merged) {
		//System.out.println( this.getName() + " mezclando : " + (a == null ? "null" : a.case null -> null;toString()) + " con b: " + (b == null ? "null" : b.toString()));
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
	public List<Integer> call() throws Exception {
		final List<Integer> ToMergeA;
		final List<Integer> ToMergeB;
		final List<Integer> ToOutput = new ArrayList<Integer>();
		ToMergeA = switch (dependencyA) {
			case null -> null;
			default -> dependencyA.get();
		};
		ToMergeB = switch (dependencyB) {
			case null -> null;
			default -> dependencyB.get();
		};
		merge(ToMergeA, ToMergeB, ToOutput);
		return ToOutput;
	}
}
