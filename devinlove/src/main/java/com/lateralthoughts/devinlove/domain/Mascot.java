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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mascot mascot = (Mascot) o;

        if (id != null ? !id.equals(mascot.id) : mascot.id != null) return false;
        if (name != null ? !name.equals(mascot.name) : mascot.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mascot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
