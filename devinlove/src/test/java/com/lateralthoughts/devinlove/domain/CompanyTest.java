package com.lateralthoughts.devinlove.domain;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.lateralthoughts.devinlove.domain.Company;


public class CompanyTest {

	@Test
	public void when_instanciating_with_name_then_name_retrieved() {
		Company company = new Company("Lateral Thoughts");
		assertThat(company.getName()).isEqualTo("Lateral Thoughts");
	}
}
