package com.lateralthoughts.devinlove.pureneo4j;

import static org.neo4j.graphdb.Direction.BOTH;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ReturnableEvaluator;
import org.neo4j.graphdb.StopEvaluator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.TraversalPosition;
import org.neo4j.graphdb.Traverser;
import org.neo4j.graphdb.Traverser.Order;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class Example {

	private enum ExampleRelationships implements RelationshipType {
		ROMANTIC;
	}

	private static final String PATH = "/tmp/data";
	private GraphDatabaseService graphDatastore = new EmbeddedGraphDatabase(PATH);
	private Node iAmANode;
    
	public static void main(final String[] args) {
		Example example = new Example();
		example.traversals();
		example.indexes();
	}

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

	public void traversals() {
		if (iAmANode == null) {
			basics();
		}
		Traverser traverser = iAmANode.traverse(Order.BREADTH_FIRST, StopEvaluator.DEPTH_ONE, new ReturnableEvaluator() {
			@Override
			public boolean isReturnableNode(final TraversalPosition position) {
				return position.currentNode().hasRelationship(ExampleRelationships.ROMANTIC, BOTH);
			}
		}, ExampleRelationships.ROMANTIC, BOTH);
		
		for (Node node : traverser.getAllNodes()) {
			System.out.println(node.getProperty("name", "OUCH! No Name ?!"));
		}
	}

	public void indexes() {
		Transaction transaction = graphDatastore.beginTx();
		try {
			IndexManager indexManager = graphDatastore.index();
			Index<Node> index = indexManager.forNodes("someEntity");
			Node node = graphDatastore.createNode();
			index.add(node, "key", "value");
			index.remove(node, "key", "value");
			index.delete();
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
