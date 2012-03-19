package com.lateralthoughts.devinlove.domain;

import static com.lateralthoughts.devinlove.domain.Relationships.WORKS_WITH;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.RelationshipType;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "WORKS_WITH")
@TypeAlias("tool_usage")
public class ToolUsage {
	@GraphId
	private Long id;
	@StartNode
	private Person user;
	@EndNode
	private Tool tool;
	@RelationshipType
	private Relationships type = WORKS_WITH;
	private String affinity;

	public ToolUsage() {}

	public ToolUsage(final Person user, final Tool tool, final ToolAffinity affinity) {
		this.user = user;
		this.tool = tool;
		this.affinity = affinity.toString();
	}

	public Long getId() {
		return id;
	}

	public Person getUser() {
		return user;
	}

	public Tool getTool() {
		return tool;
	}

	public String getAffinity() {
		return affinity;
	}

	@Override
	public String toString() {
		return "User " + user.getFirstName() + " " + user.getLastName() + " REALLY " + affinity + " " + tool;
	}

	public Relationships getType() {
		return type;
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
		ToolUsage other = (ToolUsage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

}
