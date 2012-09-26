package com.lateralthoughts.devinlove.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

import static org.springframework.data.neo4j.support.index.IndexType.FULLTEXT;

/**
 * Mascot ! Because everything has a Mascot !
 */
@NodeEntity
@TypeAlias("mascot")
public class Mascot {
	@GraphId
	private Long id;

	@Indexed(indexType= FULLTEXT, indexName = "mascotSearch")
	String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

	@Override
    public String toString() {
        return "Mascot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
