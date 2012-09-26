package com.lateralthoughts.devinlove.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Collections.unmodifiableSet;
import static javax.persistence.GenerationType.AUTO;
import static org.neo4j.graphdb.Direction.BOTH;
import static org.neo4j.graphdb.Direction.OUTGOING;


/**
 * We are all human (almost).
 */
@Entity
@Table(name = "accounts")
@NodeEntity(partial = true)
@TypeAlias("person")
public class Person {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;
    @Column
    private String email;
    @Column(name = "password")
    private String pass;
    @GraphProperty
	private String firstName;
    @GraphProperty
	private String lastName;
    @GraphProperty
	private String favoriteColor;
    @GraphProperty
    private int shoeSize;
    @GraphProperty
	@Fetch
	private Mascot mascot;
    @GraphProperty
    private String profoundIdentity;
	@RelatedTo(elementClass = Person.class, type = "IS_FRIEND_WITH", direction = BOTH)
	private Set<Person> friends = new LinkedHashSet<Person>();
	@RelatedToVia(elementClass = ToolUsage.class, type = "WORKS_WITH", direction = OUTGOING)
	private Set<ToolUsage> tools = new LinkedHashSet<ToolUsage>();
	@RelatedToVia(elementClass = StatusRedaction.class, type = "WRITES", direction = OUTGOING)
    @Fetch
	private Set<StatusRedaction> statuses = new LinkedHashSet<StatusRedaction>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
