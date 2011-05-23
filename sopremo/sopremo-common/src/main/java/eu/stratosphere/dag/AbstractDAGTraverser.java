package eu.stratosphere.dag;

import java.util.Arrays;

/**
 * Implementing classes traverse a directed acyclic graph (DAG) with a specific strategy. Unless explicitly stated, no
 * implementing class should visit a node more than once.
 * 
 * @author Arvid Heise
 */
public abstract class AbstractDAGTraverser implements DAGTraverser {

	/**
	 * Traverses the DAG consisting of the given start nodes and all notes reachable with the navigator and calls the
	 * specified {@link DAGTraverseListener} for each found node.
	 * 
	 * @param startNodes
	 *        the initial nodes of the graph
	 * @param navigator
	 *        successively returns all connected nodes from the initial nodes
	 * @param listener
	 *        the callback called for all nodes in the DAG
	 * @param <Node>
	 *        the class of the nodes
	 */
	public <Node> void traverse(Iterable<Node> startNodes, Navigator<Node> navigator, DAGTraverseListener<Node> listener) {
		traverse(startNodes.iterator(), navigator, listener);
	}

	/**
	 * Traverses the DAG consisting of the given start nodes and all notes reachable with the navigator and calls the
	 * specified {@link DAGTraverseListener} for each found node.
	 * 
	 * @param startNodes
	 *        the initial nodes of the graph
	 * @param navigator
	 *        successively returns all connected nodes from the initial nodes
	 * @param listener
	 *        the callback called for all nodes in the DAG
	 * @param <Node>
	 *        the class of the nodes
	 */
	public <Node> void traverse(Node[] startNodes, Navigator<Node> navigator, DAGTraverseListener<Node> listener) {
		traverse(Arrays.asList(startNodes).iterator(), navigator, listener);
	}

}