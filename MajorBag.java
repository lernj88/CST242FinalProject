package model;

import java.util.concurrent.ConcurrentHashMap;

import baggers.IBag;
import baggers.MBag;
import tags.BagTag;

public class MajorBag implements BagTag {
	/**
	 * HashMap of the <s>stars</s> majors<br><br>
	 * 
	 * key used is the major code
	 */
	private ConcurrentHashMap<String, Major> majorMalfunction;
	private IBag bag = new MBag();
	
	public MajorBag() {
		majorMalfunction = new ConcurrentHashMap<String, Major>();
	}
	
	/**
	 * @return the {@link #majorMalfunction}
	 */
	public ConcurrentHashMap<String, Major> getMajorMalfunction() {
		return majorMalfunction;
	}
	
	public boolean add(Major m) {
		return bag.add(this, m);
	}
	
	public boolean delete(String id) {
		return bag.delete(this, id);
	}
	
	public Major find(String id) {
		return bag.find(this, id);
	}
	
	public boolean contains(Major m) {
		return bag.contains(this, m);
	}
	
	
}
