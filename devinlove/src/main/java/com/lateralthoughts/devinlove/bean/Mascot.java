package com.lateralthoughts.devinlove.bean;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Mascot ! Because everything has a Mascot !
 */
@NodeEntity
public class Mascot {
    
    @GraphId Long id;
    
    //@Indexed(type="FULLTEXT", indexName = "search")
    String name;

}
