package com.lateralthoughts.devinlove.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.ImmutableList.copyOf;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;


/**
 * We are all human (almost).
 */
@NodeEntity
public class Person {

	public enum ProfoundIdentity {
		DEVELOPER, ARCHITECT, SYSADMIN, MANAGER, BOSS;
	}

	@GraphId
	private Long id;
	private final String firstName;
	private final String lastName;
	private String favoriteColor;
	private Mascot mascot;
	private final List<Person> friends = new LinkedList<Person>();
	private final List<Tool> tools = new LinkedList<Tool>();
	/**
	 * Simplistic European-formatted shoe size
	 */
	private int shoeSize;
	private final LinkedList<String> statuses = new LinkedList<String>();
	private ProfoundIdentity profoundIdentity;


	public Person(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFavoriteColor(final String favoriteColor) {
		checkNotNull(favoriteColor);
		this.favoriteColor = favoriteColor.toUpperCase();
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public void setMascot(final Mascot mascot) {
		this.mascot = mascot;
	}

	public Mascot getMascot() {
		return mascot;
	}

	public List<Person> getFriends() {
		return copyOf(friends);
	}

	public void addFriend(final Person friend) {
		checkNotNull(friend);
		friends.add(friend);
	}

	public void addTool(final Tool tool) {
		checkNotNull(tool);
		tools.add(tool);
	}

	public List<Tool> getTools() {
		return copyOf(tools);
	}

	public void setShoeSize(final int shoeSize) {
		checkArgument(shoeSize > 0 && shoeSize < 80);
		this.shoeSize = shoeSize;
	}

	public int getShoeSize() {
		return shoeSize;
	}

	public void addStatus(final String status) {
		checkArgument(!isNullOrEmpty(status));
		statuses.add(status);
	}

	public List<String> getStatuses() {
		return copyOf(statuses);
	}

	public void setProfoundIdentity(final ProfoundIdentity profoundIdentity) {
		checkNotNull(profoundIdentity);
		this.profoundIdentity = profoundIdentity;
	}

	public ProfoundIdentity getProfoundIdentity() {
		return profoundIdentity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		}
		else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		}
		else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
