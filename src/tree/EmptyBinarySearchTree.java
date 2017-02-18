package tree;

import list.*;

public class EmptyBinarySearchTree<E extends Comparable<E>> implements
		BinaryTree<E> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#getLeft()
	 */
	public BinaryTree<E> getLeft() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#getRight()
	 */
	public BinaryTree<E> getRight() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#add(java.lang.Object)
	 */
	public BinaryTree<E> add(E value) {
		return new BinarySearchTree<E>(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#containsKey(java.lang.Object)
	 */
	public boolean containsKey(E value) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#get(java.lang.Object)
	 */
	public E get(E value) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#remove(java.lang.Object)
	 */
	public BinaryTree<E> remove(Object obj) {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#iterator()
	 */
	public Iterator<E> iterator() {
		return new EmptyIterator<E>();
	}

	public String toString() {
		return "";
	}

	@Override
	public E getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(E value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLeft(BinaryTree<E> left) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRight(BinaryTree<E> right) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public E getLargest() {
		// TODO Auto-generated method stub
		return null;
	}

}
