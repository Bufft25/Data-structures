package tree;

public class Constant extends Expr {
	int value;

	public Constant(int value) {
		this.value = value;
	}

	public int eval() {
		return value;
	}

	public boolean equals(Expr other) {
		return (other instanceof Constant) && value == other.eval();
	}

	public Expr simplify() {
		return this;
	}

	public String toString() {
		return value + "";
	}

}
