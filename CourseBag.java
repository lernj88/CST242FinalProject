package model;

import java.util.concurrent.ConcurrentHashMap;

import baggers.CBag;
import baggers.IBag;
import tags.BagTag;
import tags.IMethodKey;

public class CourseBag implements BagTag {
	private ConcurrentHashMap<Integer, Course> courseMap;
	private IBag bag = new CBag();

	public CourseBag() {
		courseMap = new ConcurrentHashMap<>();
	}

	public boolean add(Course c) {
		return bag.add(this, c);
	}

	public boolean delete(int crn) {
		return bag.delete(this, crn);
	}

	public Course find(int crn) {
		return bag.find(this, crn);
	}

	public boolean contains(Course c) {
		return bag.contains(this, c);
	}

	/**
	 * @return the courseMap
	 */
	public ConcurrentHashMap<Integer, Course> getCourseMap(IMethodKey unlocker) {
		return courseMap;
	}

	public ConcurrentHashMap<Integer, Course> getMapCopy() {
		ConcurrentHashMap<Integer, Course> mapCopy = new ConcurrentHashMap<>();
		courseMap.forEach((k, v) -> {
			mapCopy.put(k, new Course(v));
		});
		return mapCopy;
	}

}
