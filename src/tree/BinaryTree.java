package tree;

import list.*;

/**
 * @author Travis buff
 * @version 3/10/2015
 * @param <E>
 */
public interface BinaryTree<E> {

	/**
	 * @return left child of this binary tree.
	 */
	BinaryTree<E> getLeft();

	/**
	 * @return right child of this binary tree.
	 */
	BinaryTree<E> getRight();

	/** Set the (root) value of this Binary tree to the given value */
	void setValue(E value);

	/** Set the left child of this Binary tree to the given Binary Tree */
	void setLeft(BinaryTree<E> left);

	/** Set the right child of this Binary tree to the given BinaryTree */
	void setRight(BinaryTree<E> right);

	/**
	 * @param value
	 *            being added to this family of binary tree.
	 * @return resulting family.
	 */
	BinaryTree<E> add(E value);

	/**
	 * @param value
	 *            being searched for in this family.
	 * @return true only if family of this binary tree contains given value.
	 */
	boolean containsKey(E value);

	/**
	 * @param value
	 *            to look for in this tree.
	 * @return the given value if found in this tree, or null.
	 */
	E get(E value);

	/**
	 * @return value of this tree.
	 */
	E getValue();

	/**
	 * @param obj
	 *            that is to be removed from this tree.
	 * @return the updated Binary tree.
	 */
	BinaryTree<E> remove(Object obj);

	/**
	 * @return an Iterator for this tree.
	 */
	Iterator<E> iterator();

	/**
	 * @return String of this tree.
	 */
	String toString();

	/**
	 * @return true if tree is empty, false otherwise.
	 */
	boolean isEmpty();

	/**
	 * @return the largest value in the family of this BinaryTree Pre: This
	 *         BinaryTree is not empty
	 */
	E getLargest();
}
