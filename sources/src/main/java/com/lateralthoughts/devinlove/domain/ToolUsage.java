package com.lateralthoughts.devinlove.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.*;

import static com.lateralthoughts.devinlove.domain.Relationships.WORKS_WITH;

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

}
