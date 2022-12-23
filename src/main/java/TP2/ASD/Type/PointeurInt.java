package TP2.ASD.Type;

import TP2.ASD.Type.Type;
import TP2.Llvm;

public class PointeurInt extends Type {
	String id;

	@Override
	public String pp() {

		return "INT*";
	}
	@Override
	public boolean equals(Object o) {
	    return o instanceof PointeurInt;
	}
	@Override
	public TP2.Llvm.Type toLlvmType() {
		
		return new Llvm.IntPointeur();
	}

}
