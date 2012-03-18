package com.lateralthoughts.devinlove.transaction;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.transaction.annotation.Transactional;

@Retention(RetentionPolicy.RUNTIME)
@Transactional("neo4jTransactionManager")
public @interface GraphTransactional {

}
