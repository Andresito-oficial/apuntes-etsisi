import java.util.ArrayList;
import java.util.List;

public class MergeSortConcurrent {
	private final List<Integer> ToSort;

	public MergeSortConcurrent (List<Integer> input) {
		ToSort = input;
		System.err.println("Creando MergeSort con " + ToSort.size() + " elementos");
	}

	List<Integer> merge ( List<Integer> a, List<Integer> b) {
		final List<Integer> merged = new ArrayList<Integer>(a.size() + b.size());
		//System.err.println("Mezclando : " + a.toString() + " con b: " + b.toString());
		Integer currentA = a.removeLast();
		Integer currentB = b.removeLast();
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
		//System.err.println("Mezclado : " + merged.toString());
		return merged;
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

	List<Integer> sorted () {
		if (ToSort.size() < 2) {
			return ToSort;
		}
		final int divider = ToSort.size() / 2;
		List<Integer> FirstHalf = new MergeSortConcurrent(new ArrayList<>(ToSort.subList(0, (divider)))).sorted();
		List<Integer> SecondHalf = new MergeSortConcurrent(new ArrayList<>(ToSort.subList(divider, ToSort.size()))).sorted();
		return merge(FirstHalf, SecondHalf);
	}
}
