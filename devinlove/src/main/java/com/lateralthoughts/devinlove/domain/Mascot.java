package com.lateralthoughts.devinlove.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Mascot ! Because everything has a Mascot !
 */
@NodeEntity
public class Mascot {
	@GraphId
	private Long id;
	private String name;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Mascot mascot = (Mascot) o;

		if (id != null ? !id.equals(mascot.id) : mascot.id != null)
			return false;
		if (name != null ? !name.equals(mascot.name) : mascot.name != null)
			return false;

		return true;
	}

	@Override
    public String toString() {
        return "Mascot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
