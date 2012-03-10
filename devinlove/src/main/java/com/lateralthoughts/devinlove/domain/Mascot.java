package com.lateralthoughts.devinlove.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Mascot ! Because everything has a Mascot !
 */
@NodeEntity
public class Mascot {
    
    @GraphId Long id;
    public String name;

    public Mascot() {}
}
