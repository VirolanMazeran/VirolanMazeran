package incendie;

import java.util.List;

public interface Propagation {

	public abstract int getPropagation();
	
	public abstract List<List<Integer>> getPropagationIncendie(int x, List<Case> liste);
}
