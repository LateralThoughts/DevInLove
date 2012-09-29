package com.lateralthoughts.devinlove.framework.conversion;

import com.lateralthoughts.devinlove.domain.Status;

import java.beans.PropertyEditorSupport;

public class StatusPropertyEditor extends PropertyEditorSupport {


	@Override
	public String getAsText() {
		Status status = (Status) getValue();
		return status.getMessage();
	}

	@Override
	public void setAsText(final String text) throws IllegalArgumentException {
		setValue(new Status(text));
	}
}