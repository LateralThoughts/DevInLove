package com.lateralthoughts.devinlove.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

/**
 * Tool that people can love or hate use during their company time or free time.
 * Can be a programming language, a framework, a piece of software...
 */
public class Tool {

	private String name;
	private String version;
	private DateTime creationDate;
	private final ArrayList<Company> backingCompanies = new ArrayList<Company>();
	private Category category;
	private boolean revolutionary;

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
		this.creationDate = new DateTime(creationDate);
	}

	public Date getCreationDate() {
		return creationDate.toDate();
	}

	public void addBackingCompany(final Company... backingCompanies) {
		checkArgument(backingCompanies != null);
		List<Company> list = asList(backingCompanies);
		checkArgument(!list.contains(null));
		this.backingCompanies.addAll(list);
	}

	public List<Company> getBackingCompanies() {
		return unmodifiableList(backingCompanies);
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

}
