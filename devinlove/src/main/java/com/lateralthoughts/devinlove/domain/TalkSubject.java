package com.lateralthoughts.devinlove.domain;

public class TalkSubject {
	private final String subject;

	public TalkSubject(final String subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		TalkSubject other = (TalkSubject) obj;
		if (subject == null) {
			if (other.subject != null)
				return false;
		}
		else if (!subject.equals(other.subject))
			return false;
		return true;
	}

}
