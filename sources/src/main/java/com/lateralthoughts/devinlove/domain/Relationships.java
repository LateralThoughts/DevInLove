package com.lateralthoughts.devinlove.domain;

import org.neo4j.graphdb.RelationshipType;

public enum Relationships implements RelationshipType {
	IS_FRIEND_WITH, WORKS_WITH, WRITES;
}
