package baggers;

import tags.BagTag;
import tags.SainTag;

public class MBag implements IBag {

	@Override
	public <E extends BagTag, S extends SainTag> boolean add(E bt, S st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <E extends BagTag, K extends Comparable<K>> boolean delete(E bt, K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <E extends BagTag, K extends Comparable<K>, S extends SainTag> S find(E bt, K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E extends BagTag, S extends SainTag> boolean contains(E bt, S st) {
		// TODO Auto-generated method stub
		return false;
	}

}
