package com.lateralthoughts.devinlove.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static org.neo4j.graphdb.Direction.INCOMING;
import static org.springframework.data.neo4j.support.index.IndexType.FULLTEXT;

/**
 * Tool that people can love or hate use during their company time or free time.
 * Can be a programming language, a framework, a piece of software...
 */
@NodeEntity
@TypeAlias("tool")
public class Tool {
	@GraphId
	private Long id;
	@Fetch
	@Indexed(indexType= FULLTEXT, indexName = "tool")
	private String name;
	private String version;
	private Date creationDate;
	private Category category;
	private boolean revolutionary;
	@RelatedTo(type = "CREATED", direction = INCOMING)
	private final Set<Person> authors = new LinkedHashSet<Person>();
	@RelatedTo(type = "WORKS_WITH", direction = INCOMING)
	Set<Person> users = new LinkedHashSet<Person>();
	@RelatedToVia(type = "WORKS_WITH", direction = INCOMING)
	@Fetch
	private Iterable<ToolUsage> usage;



	public Iterable<ToolUsage> getUsage() {
		return usage;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setCreationDate(final Date creationDate) {
		this.creationDate = new Date(creationDate.getTime());
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setRevolutionary(final boolean revolutionary) {
		this.revolutionary = revolutionary;
	}

	public boolean isRevolutionary() {
		return revolutionary;
	}

	public void addAuthors(final Person... authors) {
		checkNotNull(authors);
		List<Person> list = asList(authors);
		this.authors.addAll(list);
	}

	public Set<Person> getAuthors() {
		return unmodifiableSet(authors);
	}

	public Long getId() {
		return id;
	}

}
