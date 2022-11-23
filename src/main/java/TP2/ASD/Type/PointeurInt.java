package TP2.ASD.Type;

import TP2.ASD.Type.Type;
import TP2.Llvm;

public class PointeurInt extends Type {

	@Override
	public String pp() {
		// TODO Auto-generated method stub
		return "INT*";
	}

	@Override
	public TP2.Llvm.Type toLlvmType() {
		
		return new Llvm.Int();
	}

}
