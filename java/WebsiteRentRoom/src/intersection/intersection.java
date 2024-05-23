package intersection;

import java.util.ArrayList;
import java.util.List;

import model.House;

public class intersection {
	public List<House> intersection_lists(List<House> list1, List<House> list2) {
		List<House> intersection = new ArrayList<House>();
		for (House h: list1) {
			if (list2.contains(h)) {
				intersection.add(h);
			}
		}
		return intersection;
	}
}
