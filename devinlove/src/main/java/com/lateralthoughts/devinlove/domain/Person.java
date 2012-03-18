package com.lateralthoughts.devinlove.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Collections.unmodifiableSet;
import static org.neo4j.graphdb.Direction.BOTH;
import static org.neo4j.graphdb.Direction.OUTGOING;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.transaction.annotation.Transactional;


/**
 * We are all human (almost).
 */
@NodeEntity
public class Person {


	@GraphId
	private Long id;
	private String firstName;
	private String lastName;
	private String favoriteColor;
	private Mascot mascot;
	@RelatedTo(elementClass = Person.class, type = "IS_FRIEND_WITH", direction = BOTH)
	private final Set<Person> friends = new LinkedHashSet<Person>();
	@RelatedTo(elementClass = Tool.class, type = "WORKS_WITH", direction = OUTGOING)
	private final Set<Tool> tools = new LinkedHashSet<Tool>();
	/**
	 * Simplistic European-formatted shoe size
	 */
	private int shoeSize;

	@RelatedToVia(elementClass = StatusRedaction.class, type = "WRITES", direction = OUTGOING)
    @Fetch
	private Iterable<StatusRedaction> statuses;

	private ProfoundIdentity profoundIdentity;

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

	public Set<Person> getFriends() {
		return unmodifiableSet(friends);
	}

	public void addFriend(final Person friend) {
		checkNotNull(friend);
		friends.add(friend);
	}

	public void addTool(final Tool tool) {
		checkNotNull(tool);
		tools.add(tool);
	}

	public Set<Tool> getTools() {
		return unmodifiableSet(tools);
	}

	public void setShoeSize(final int shoeSize) {
		checkArgument(shoeSize > 0 && shoeSize < 80);
		this.shoeSize = shoeSize;
	}

	public int getShoeSize() {
		return shoeSize;
	}


	public Iterable<StatusRedaction> getStatuses() {
		return statuses;
	}

    public StatusRedaction addStatus(Neo4jOperations template, Status message, final Date creationDate) {
        final StatusRedaction statusRedaction = template.createRelationshipBetween(this,
                message, StatusRedaction.class, "WRITES", false);
        statusRedaction.setCreationDate(creationDate);
        return template.save(statusRedaction);
    }

	public void setProfoundIdentity(final ProfoundIdentity profoundIdentity) {
		//checkNotNull(profoundIdentity);
		this.profoundIdentity = profoundIdentity;
	}

	public ProfoundIdentity getProfoundIdentity() {
		return profoundIdentity;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
		result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
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
		if (getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		}
		else if (!getFirstName().equals(other.getFirstName()))
			return false;
		if (getLastName() == null) {
			if (other.getLastName() != null)
				return false;
		}
		else if (!getLastName().equals(other.getLastName()))
			return false;
		return true;
	}
}
