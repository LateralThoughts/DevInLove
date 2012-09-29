package com.lateralthoughts.devinlove;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class Example {

	private enum ExampleRelationships implements RelationshipType {
		ROMANTIC;
	}

	private static final String PATH = "/tmp/data";
	private GraphDatabaseService graphDatastore = new EmbeddedGraphDatabase(PATH);
	private Node iAmANode;


	public void basics() {
		Transaction transaction = graphDatastore.beginTx();
		try {
			iAmANode = graphDatastore.createNode();
			iAmANode.setProperty("name", "original");
			Node anotherNode = graphDatastore.createNode();
			anotherNode.setProperty("name", "neighbour");
			iAmANode.createRelationshipTo(anotherNode, ExampleRelationships.ROMANTIC);
			transaction.success();
		}
		catch (Exception e) {
			transaction.failure();
		}
		finally {
			transaction.finish();
		}
	}
}
