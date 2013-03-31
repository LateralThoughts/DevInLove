package com.lateralthoughts.devinlove.domain;

import com.google.common.base.Objects;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import static com.lateralthoughts.devinlove.domain.Authorities.USER;
import static java.util.Collections.unmodifiableSet;
import static org.neo4j.graphdb.Direction.BOTH;
import static org.neo4j.graphdb.Direction.OUTGOING;
import static org.springframework.data.neo4j.support.index.IndexType.FULLTEXT;


/**
 * We are all human (almost).
 */
@NodeEntity
@TypeAlias("person")
public class Person implements UserDetails {
	@GraphId
	private Long id;
    @Indexed(indexType = FULLTEXT, indexName = "people")
	private String firstName;
    private String lastName;
    private String login;
    private char[] password;
    private String favoriteColor;
    private int shoeSize;
    private String profoundIdentity;
    @Fetch
	private Mascot mascot;
    @Fetch
	private Set<StatusRedaction> statuses = new LinkedHashSet<StatusRedaction>();
    @RelatedTo(elementClass = Person.class, type = "IS_FRIEND_WITH", direction = BOTH)
	private Set<Person> friends = new LinkedHashSet<Person>();
    @RelatedToVia(elementClass = ToolUsage.class, type = "WORKS_WITH", direction = OUTGOING)
	private Set<ToolUsage> tools = new LinkedHashSet<ToolUsage>();

	public Long getId() {
		return id;
	}

    @RelatedToVia(elementClass = StatusRedaction.class, type = "WRITES", direction = OUTGOING)


    public void setId(long island) {
        this.id = island;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(final String favoriteColor) {
		checkNotNull(favoriteColor);
		this.favoriteColor = favoriteColor.toUpperCase();
	}

	public Mascot getMascot() {
		return mascot;
	}

	public void setMascot(final Mascot mascot) {
		this.mascot = mascot;
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

	public int getShoeSize() {
		return shoeSize;
	}

	public void setShoeSize(final int shoeSize) {
		this.shoeSize = shoeSize;
	}

	public Iterable<StatusRedaction> getStatuses() {
		return statuses;
	}

	public void addStatus(final Status message, final Date creationDate) {
		final StatusRedaction statusRedaction = new StatusRedaction(this, message, creationDate);
		statuses.add(statusRedaction);
    }

	public String getProfoundIdentity() {
		return profoundIdentity;
	}

	public void setProfoundIdentity(final ProfoundIdentity profoundIdentity) {
		this.profoundIdentity = profoundIdentity.toString();
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return newArrayList(USER);
    }

    public void setPassword(String password) {
        this.password = password.toCharArray();
    }

    @Override
    public String getPassword() {
        return new String(password);
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person other = (Person) o;
        return equal(shoeSize, other.shoeSize) &&
            equal(favoriteColor, other.favoriteColor) &&
            equal(firstName, other.firstName) &&
            equal(lastName, other.lastName) &&
            equal(login, other.login) &&
            equal(profoundIdentity, other.profoundIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            login,
            firstName,
            lastName,
            favoriteColor,
            shoeSize,
            profoundIdentity
        );
    }
}
