package TP2.ASD;

import TP2.Llvm;

public class Void extends Type {

	public String pp() {
	      return "VOID";
	    }

	    @Override public boolean equals(Object obj) {
	      return obj instanceof Int;
	    }

	    public Llvm.Type toLlvmType() {
	      return new Llvm.Void();
	    }
	  

}
