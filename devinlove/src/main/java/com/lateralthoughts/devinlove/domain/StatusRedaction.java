package com.lateralthoughts.devinlove.domain;

import java.util.Date;
import java.util.Locale;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ocpsoft.pretty.time.PrettyTime;

@RelationshipEntity(type = "WRITES")
public class StatusRedaction {
	@GraphId
	private Long id;
	@StartNode private Person author;
	@EndNode private Status status;
	private Date creationDate = new Date();

	public StatusRedaction() {}

	public StatusRedaction(final Person author, final Status status, final Date creationDate) {
		this.author = author;
		this.status = status;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(final Person author) {
		this.author = author;
	}

	public Status getStatus() {
		return status;
	}

	public String getStatusMessage() {
		return status.getMessage();
	}

	public void setStatus(final Status status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

	// shouldnt be here, I know...
	public String getFormattedDate() {
		PrettyTime prettyTime = new PrettyTime(new Locale("en"));
		return prettyTime.format(creationDate);
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
		StatusRedaction other = (StatusRedaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

}
