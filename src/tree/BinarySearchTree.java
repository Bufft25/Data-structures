package tree;

import list.*;

public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {
	E value;
	BinaryTree<E> left;// always < value
	BinaryTree<E> right;// always > value

	public BinarySearchTree(E value) {
		this.value = value;
		left = new EmptyBinarySearchTree<E>();
		right = new EmptyBinarySearchTree<E>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#getLeft()
	 */
	public BinaryTree<E> getLeft() {
		return left;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#getRight()
	 */
	public BinaryTree<E> getRight() {
		return right;
	}

	/** Set the (root) value of this Binary tree to the given value */
	public void setValue(E value) {
		this.value = value;
	}

	/** Set the left child of this Binary tree to the given Binary Tree */
	public void setLeft(BinaryTree<E> left) {
		this.left = left;
	}

	/** Set the right child of this Binary tree to the given BinaryTree */
	public void setRight(BinaryTree<E> right) {
		this.right = right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#add(java.lang.Object)
	 */
	public BinaryTree<E> add(E value) {
		int cmp = value.compareTo(this.value);
		if (cmp < 0) {
			left = left.add(value);
		}
		if (cmp > 0) {
			right = right.add(value);
		}
		return this;
	}

	public boolean containsKey(E value) {
		int cmp = value.compareTo(this.value);
		if (cmp == 0) {
			return true;
		}
		if (cmp < 0) {
			return left.containsKey(value);
		}
		if (cmp > 0) {
			return right.containsKey(value);
		}
		return false;
	}

	public E get(E value) {
		int cmp = value.compareTo(this.value);
		if (cmp == 0) {
			return this.value;
		}
		if (cmp < 0) {
			return left.get(value);
		}
		if (cmp > 0) {
			return right.get(value);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#getValue()
	 */
	public E getValue() {
		return value;
	}

	/*FIXXXXXX
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#remove(java.lang.Object)
	 */
	public BinaryTree<E> remove(Object obj) {
		try {
			E value = (E) obj;
			int cmp = value.compareTo(this.value);
			if (cmp == 0) {
				List<BinaryTree<E>> kids = children();
				if (kids.size() == 0) {
					return new EmptyBinarySearchTree<E>();
				}
				if (kids.size() == 1) {
					return kids.get(0);
				}
				if (kids.size() == 2) {
					BinaryTree<E> successor = ((BinarySearchTree<E>) right).smallest();
					BinaryTree<E> result = remove(successor.getValue());
					result.setValue(successor.getValue());
					return result;
				}
			}
			if (cmp < 0) {
				left = left.remove(obj); // left =??
			}
			if (cmp > 0) {
				right = right.remove(obj); // right =??
			}
		} catch (ClassCastException cce) {
		}
		return this;
	}

	/**
	 * @return List of children for this BinaryTree.
	 */
	private List<BinaryTree<E>> children() {
		List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
		if (left instanceof BinarySearchTree) {
			result.add(left);
		}
		if (right instanceof BinarySearchTree) {
			result.add(right);
		}
		return result;
	}

	/**
	 * @return smallest BinaryTree of this.
	 */
	private BinaryTree<E> smallest() {
		if (left instanceof BinarySearchTree) {
			return ((BinarySearchTree<E>) left).smallest();
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.BinaryTree#iterator()
	 */
	public Iterator<E> iterator() {
		return new TreeIterator<E>(this);
	}

	@Override
	public boolean isEmpty() {
		if (value == null) {
			return true;
		}
		return false;
	}

	public String toString() {
		Iterator<E> itty = this.iterator();
		String treeString = "[";
		E valueCurrent;
		while (itty.hasNext()) {
			valueCurrent = itty.next();
			treeString = treeString + valueCurrent + ",";
		}
		treeString = treeString.substring(0, treeString.length() - 1) + "]";

		return treeString;
	}

	@Override
	public E getLargest() {
		if (right instanceof BinarySearchTree) {
			return ((BinarySearchTree<E>) right).getLargest();
		}
		return this.value;
	}

}
