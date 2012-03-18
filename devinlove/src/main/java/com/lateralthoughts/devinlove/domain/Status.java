package com.lateralthoughts.devinlove.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class Status {
	@GraphId
	private Long id;
	private String message = "";
    
    @RelatedToVia(type = "WRITES", direction = Direction.INCOMING)
    @Fetch private Iterable<StatusRedaction> statuses;


	public Status() {}

	public Status(final String message) {
		this.message = message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

}
