package tree;

/**
 * @author Travis Buff
 *
 */
public class Assign extends Expr {
	Variable var = null;
	Constant num = null;

	public Assign(Expr var, Constant num) {
		if (var instanceof Variable) {
			this.var = (Variable) var;
			this.num = num;
		}
	}

	public int eval() {
		var.setTrue();
		var.value = num.eval();
		return var.eval();
	}

	@Override
	public boolean equals(Expr other) {
		// TODO Auto-generated method stub
		return false;
	}

	public Expr simplify() {
		return this;
	}

	public String toString() {
		return "(" + var + " = " + num + ")";
	}

}
