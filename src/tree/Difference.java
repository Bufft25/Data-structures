package tree;

/**
 * @author Travis Buff
 *
 */
public class Difference extends Expr {
	public Difference(Expr left, Expr right) {
		super(left, right);
	}

	public int eval() {
		return left.eval() - right.eval();
	}

	public boolean equals(Expr other) {
		if (!(other instanceof Difference))
			return false;

		return (left.equals(other.left) && right.equals(other.right));
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();

		if (right.toString().compareTo(left.toString()) == 0) {
			return new Constant(0);
		}

		if ((right instanceof Variable) && (left instanceof Variable)) {

			if (((Variable) right).getName() == (((Variable) left).getName())) {
				return new Constant(0);
			}

		}

		if ((right instanceof Constant) && right.eval() == 0) {
			return left;
		}

		if ((left instanceof Constant) && left.eval() == 0) {
			return right;
		}
		if (right instanceof Constant && left instanceof Constant
				&& right.equals(left)) {
			return new Constant(0);
		}

		if (left instanceof Constant && right instanceof Constant)
			return new Constant(this.eval());

		return this;
	}

	public String toString() {
		return "(" + left + "-" + right + ")";
	}
}
