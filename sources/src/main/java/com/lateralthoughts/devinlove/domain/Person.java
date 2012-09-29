package com.lateralthoughts.devinlove.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Collections.unmodifiableSet;
import static org.neo4j.graphdb.Direction.BOTH;
import static org.neo4j.graphdb.Direction.OUTGOING;
import static org.springframework.data.neo4j.support.index.IndexType.FULLTEXT;


/**
 * We are all human (almost).
 */
@NodeEntity
@TypeAlias("person")
public class Person {
	@GraphId
	private Long id;
    @Indexed(indexType= FULLTEXT, indexName = "people")
	private String firstName;
	private String lastName;
	private String favoriteColor;
	@Fetch
	private Mascot mascot;
	@RelatedTo(elementClass = Person.class, type = "IS_FRIEND_WITH", direction = BOTH)
	private Set<Person> friends = new LinkedHashSet<Person>();

	@RelatedToVia(elementClass = ToolUsage.class, type = "WORKS_WITH", direction = OUTGOING)
	private Set<ToolUsage> tools = new LinkedHashSet<ToolUsage>();
	/**
	 * Simplistic European-formatted shoe size
	 */
	private int shoeSize;

	@RelatedToVia(elementClass = StatusRedaction.class, type = "WRITES", direction = OUTGOING)
    @Fetch
	private Set<StatusRedaction> statuses = new LinkedHashSet<StatusRedaction>();

	private String profoundIdentity;


    public void setId(long island) {
        this.id = island;
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

	public Set<Person> getFriends() {
		return unmodifiableSet(friends);
	}

	public void addFriend(final Person friend) {
		checkNotNull(friend);
		friends.add(friend);
	}

	public void addTool(final Tool tool, final ToolAffinity affinity) {
		final ToolUsage toolUsage = new ToolUsage(this, tool, affinity);
		tools.add(toolUsage);
	}

	public Iterable<ToolUsage> getTools() {
		return tools;
	}

	public void setShoeSize(final int shoeSize) {
		this.shoeSize = shoeSize;
	}

	public int getShoeSize() {
		return shoeSize;
	}

	public Iterable<StatusRedaction> getStatuses() {
		return statuses;
	}

	public void addStatus(final Status message, final Date creationDate) {
		final StatusRedaction statusRedaction = new StatusRedaction(this, message, creationDate);
		statuses.add(statusRedaction);
    }

	public void setProfoundIdentity(final ProfoundIdentity profoundIdentity) {
		this.profoundIdentity = profoundIdentity.toString();
	}

	public String getProfoundIdentity() {
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
