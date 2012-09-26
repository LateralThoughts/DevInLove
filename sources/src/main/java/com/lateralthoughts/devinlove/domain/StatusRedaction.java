package com.lateralthoughts.devinlove.domain;

import static com.lateralthoughts.devinlove.domain.Relationships.WRITES;

import java.util.Date;
import java.util.Locale;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.RelationshipType;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ocpsoft.pretty.time.PrettyTime;

@RelationshipEntity(type = "WRITES")
@TypeAlias("status_redaction")
public class StatusRedaction {
	@GraphId
	private Long id;
	@StartNode
	@Fetch
	private Person author;
	@EndNode
	@Fetch
	private Status status;
	@RelationshipType
	private final Relationships type = WRITES;
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

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

	// shouldnt be here, I know...
	public String getFormattedDate() {
		PrettyTime prettyTime = new PrettyTime(new Locale("en"));
		return prettyTime.format(creationDate);
	}

	public Relationships getType() {
		return type;
	}
}
