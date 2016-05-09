package baggers;

import model.PeopleBag;
import model.Person;
import tags.BagTag;
import tags.IMethodKey;
import tags.SainTag;

public class PeopsBag implements IBag {

	Unlocker unlocker = new Unlocker();

	private static class Unlocker implements IMethodKey {
		private Unlocker() {}
	}

	@Override
	public <E extends BagTag, S extends SainTag> boolean add(E bt, S st) {
		Person p = (Person) st;
		PeopleBag bag = (PeopleBag) bt;

		if (!bag.contains(p.getID())) {
			return (bag.getPeopleMap(unlocker).put(p.getID(), p)) == null;
		}
		return false;
	}

	@Override
	public <E extends BagTag, K extends Comparable<K>> boolean delete(E bt, K key) {
		return ((PeopleBag) bt).getPeopleMap(unlocker).remove(key) == null;
	}

	@Override
	public <E extends BagTag, K extends Comparable<K>, S extends SainTag> S find(E bt, K key) {
		return (S) ((PeopleBag) bt).getPeopleMap(unlocker).get(key);
	}

	@Override
	public <E extends BagTag, S extends SainTag> boolean contains(E bt, S st) {
		return ((PeopleBag) bt).getPeopleMap(unlocker).contains(st);
	}
}
