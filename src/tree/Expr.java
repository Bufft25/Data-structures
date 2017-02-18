package tree;

/**
 * @author Travis Buff
 *
 */
public abstract class Expr {
	Expr left;
	Expr right;

	public Expr() {
	}

	public Expr(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

	public abstract int eval();

	public abstract boolean equals(Expr other);

	public abstract Expr simplify();

	public abstract String toString();
}
