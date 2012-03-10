package com.lateralthoughts.devinlove.transaction;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by IntelliJ IDEA.
 * User: ogirardot
 * Date: 10/03/12
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Transactional("neo4jTransactionManager")
public @interface GraphTransactional {

}
