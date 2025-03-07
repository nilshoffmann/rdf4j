/*******************************************************************************
 * Copyright (c) 2015 Eclipse RDF4J contributors, Aduna, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.eclipse.rdf4j.query.parser.serql.ast;

/*
 * All AST nodes must implement this interface. It provides basic machinery for
 * constructing the parent and child relationships between nodes.
 */

public interface Node {

	/**
	 * This method is called after the node has been made the current node. It indicates that child nodes can now be
	 * added to it.
	 */
	void jjtOpen();

	/**
	 * This method is called after all the child nodes have been added.
	 */
	void jjtClose();

	/**
	 * This pair of methods are used to inform the node of its parent.
	 */
	void jjtSetParent(Node n);

	Node jjtGetParent();

	/**
	 * This method tells the node to add its argument to the node's list of children.
	 */
	void jjtAddChild(Node n, int i);

	/**
	 * Adds the supplied node as the last child node to this node.
	 */
	void jjtAppendChild(Node n);

	/**
	 * Adds the supplied node as the <tt>i</tt>'th child node to this node.
	 */
	void jjtInsertChild(Node n, int i);

	/**
	 * Replaces a child node with a new node.
	 */
	void jjtReplaceChild(Node oldNode, Node newNode);

	/**
	 * This method returns a child node. The children are numbered from zero, left to right.
	 */
	Node jjtGetChild(int i);

	/** Return the number of children the node has. */
	int jjtGetNumChildren();

	/**
	 * Accept the visitor.
	 */
	Object jjtAccept(SyntaxTreeBuilderVisitor visitor, Object data) throws VisitorException;
}
