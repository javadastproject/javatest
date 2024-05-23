package pair;

import java.util.List;

public class pair_operations<T extends Comparable<T>> {
	public void bubblesort(List<pair<T>> list) {
		int i, j;
		pair<T> temp;
		for (i = 1; i < list.size(); i++) {
			for (j = list.size() - 1; j >= i; j--) {
				if (list.get(j - 1).getVar().compareTo(list.get(j).getVar()) > 0) {
					temp = list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
}
