package baggers;

import tags.BagTag;
import tags.SainTag;

public interface IBag {
	
	public <E extends BagTag, S extends SainTag> boolean add(E bt, S st);
	public <E extends BagTag, K extends Comparable<K>> boolean delete(E bt, K key);
	public <E extends BagTag, K extends Comparable<K>, S extends SainTag> S find(E bt, K key);
	public <E extends BagTag, S extends SainTag> boolean contains(E bt, S st);
}
