package baggers;

import model.Course;
import model.CourseBag;
import tags.BagTag;
import tags.IMethodKey;
import tags.SainTag;

public class CBag implements IBag {
	private Unlocker unlocker = new Unlocker();

	private class Unlocker implements IMethodKey {
		private Unlocker() {}
	}

	@Override
	public <E extends BagTag, S extends SainTag> boolean add(E bt, S st) {
		CourseBag bag = (CourseBag) bt;
		Course c = (Course) st;

		return bag.getCourseMap(unlocker).putIfAbsent(c.getCrn(), c) == null;
	}

	@Override
	public <E extends BagTag, K extends Comparable<K>> boolean delete(E bt, K key) {
		CourseBag bag = (CourseBag) bt;
		int crn = (Integer) key;

		return bag.getCourseMap(unlocker).remove(crn) != null;
	}

	@Override
	public <E extends BagTag, K extends Comparable<K>, S extends SainTag> S find(E bt, K key) {
		CourseBag bag = (CourseBag) bt;
		int crn = (Integer) key;

		return (S) bag.find(crn);
	}

	@Override
	public <E extends BagTag, S extends SainTag> boolean contains(E bt, S st) {
		CourseBag bag = (CourseBag) bt;
		Course c = (Course) st;

		return bag.find(c.getCrn()) != null;
	}

}
