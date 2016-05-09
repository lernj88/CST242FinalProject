package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import baggers.IBag;
import baggers.PeopsBag;
import exceptions.InvalidUsernameException;
import tags.BagTag;
import tags.IMethodKey;

public class PeopleBag implements BagTag {
	/**
	 * HashMap containing members of the Person class. Key = ID, value = Person.
	 */
	private ConcurrentHashMap<String, Person> peopleMap;
	/**
	 * HashSet containing all usernames
	 */
	private HashSet<String> userMap;
	
	private IBag bag = new PeopsBag();

	/**
	 * returns a copy of the peopleMap. This copy doesn't allow for manipulation
	 * of actual model.
	 * 
	 * @return
	 */
	public HashMap<String, Person> getPeopleMap() {
		return new HashMap<String, Person>(peopleMap);
	}

	/**
	 * returns a copy of the userMap. This copy doesn't allow for manipulation
	 * of actual model.
	 * 
	 * @return
	 */
	public HashSet<String> getUserMap() {
		return new HashSet<String>(userMap);
	}

	/**
	 * @return the peopleMap
	 */
	public ConcurrentHashMap<String, Person> getPeopleMap(IMethodKey justBecause) {
		return peopleMap;
	}

	/**
	 * @return the userMap
	 */
	public HashSet<String> getUserMap(IMethodKey justBecause) {
		return userMap;
	}

	/**
	 * creates storage for Person data.
	 */
	public PeopleBag() {
		peopleMap = new ConcurrentHashMap<String, Person>();
		userMap = new HashSet<>();
	}

	/**
	 * Searches peopleMap for person with matching username. Useful for login
	 * purposes. </br>
	 * <b>NB:</b> This method does not, in and of itself, guarantee that only
	 * one Person exists in map with the given username. If there is no
	 * implementation in place to prevent duplicate usernames, this method may
	 * behave non-deterministically. Currently, {@link #addUser(String)} serves this purpose, so if removal of that method is desired, suggest something is done to compensate for lost functionality.
	 * 
	 * @param username
	 * @return <b>null</b> if object does not exist in map, or the Person corresponding to
	 *         given username if found.
	 * @see HashMap#forEach(java.util.function.BiConsumer)
	 * @see #addUser(String)
	 */
	public Person findByUsername(String username) {
		Person p[] = new Person[1];
		peopleMap.forEach((k, v) -> {
			if (v.getUsername() != null && v.getUsername().equals(username)) {
				p[0] = v;
			}
		});
		return p[0];
	}

	// Look up HashSet

	/**
	 * Searches peopleMap for person with matching ID. Useful for non-login
	 * purposes. For login, {@link PeopleBag#findByUsername(String)} is preferable.
	 * 
	 * @param id
	 * @return null if object does not exist in map, or Person corresponding to
	 *         given id, if found
	 * @see HashMap#get(Object)
	 */
	public Person findById(String id) {
		return bag.find(this, id);
	}
	
	public boolean contains(String id) {
		return findById(id) != null;
	}
	
	/**
	 * 
	 * @param p
	 * @return <b>true</b> if person added successfully. False, if the person is already in database.
	 * @throws InvalidUsernameException thrown if a username assigned to the given entrant already exists.
	 */
	public boolean add(Person p) throws InvalidUsernameException {
		if(addUser(p.getUsername()) && bag.add(this, p)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param username username to add
	 * @return <b>true</b>, if username successfully added.
	 * @throws InvalidUsernameException
	 * @see {@link #findByUsername(String)}
	 */
	private synchronized boolean addUser(String username) throws InvalidUsernameException {
		if (!userMap.add(username)) {
			throw new InvalidUsernameException("Identical username already exists");
		}
		return true;
	}
	
	public boolean delete(String id) {
		return bag.delete(this, id);
	}
	
	public Person login(String username, String password) {
		Person p = findByUsername(username);
		if (p != null && p.checkPassword(password)) {
			return p;
		}
		return null;
	}

}
