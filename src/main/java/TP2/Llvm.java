package TP2;

import java.util.List;
import java.util.ArrayList;

/**
 * This file contains a simple LLVM IR representation
 * and methods to generate its string representation
 */
public class Llvm {
  static public class IR {
    /**
     *  IR instructions to be placed before the code (global definitions)
     */ 
    List<Instruction> header; 
    /**
     *  IR composing the main code
     */ 
    List<Instruction> code; 

    /**
     * Creates an IR based on two lists of instructions
     * @param header the instructions to be placed before the code
     * @param code the main code
     */
    public IR(List<Instruction> header, List<Instruction> code) {
      this.header = header;
      this.code = code;
    }

    /**
     * Append two IR.
     * 
     * Append the header of the second to the first, and idem for the code
     * @param other the other IR
     * @return
     */
    public IR append(IR other) {
      header.addAll(other.header);
      code.addAll(other.code);
      return this;
    }

    /**
     * Append an instruction to the IR's code
     * @param inst the instruction to append
     * @return
     */
    public IR appendCode(Instruction inst) {
      code.add(inst);
      return this;
    }

    /**
     * Append an instruction to the IR's header
     * @param inst the instruction to append
     * @return
     */
    public IR appendHeader(Instruction inst) {
      header.add(inst);
      return this;
    }

    public String toString() {
      // This header describe to LLVM the target
      // and declare the external function printf
      StringBuilder r = new StringBuilder("; Target\n" +
        "target triple = \"x86_64-unknown-linux-gnu\"\n" +
        "; External declaration of the printf function\n" +
        "declare i32 @printf(i8* noalias nocapture, ...)\n" +
        "\n; Actual code begins\n\n");

      for(Instruction inst: header)
        r.append(inst);

      r.append("\n\n");

      // We create the function main
      // TODO : remove this when you extend the language
      r.append("define i32 @main() {\n");


      for(Instruction inst: code)
        r.append(inst);

      // TODO : remove this when you extend the language
      r.append("}\n");

      return r.toString();
    }
  }

  /**
   * Returns a new empty list of instruction, handy
   */
  static public List<Instruction> empty() {
    return new ArrayList<Instruction>();
  }


  // LLVM Types

  /**
   * The abstract type representing the LLVM types
   */
  static public abstract class Type {
    public abstract String toString();
  }

  static public class Int extends Type {
    public String toString() {
      return "i32";
    }
  }
  
  static public class IntPointeur extends Type {
	    public String toString() {
	      return "i32*";
	    }
	  }

  // TODO : other types


  // LLVM IR Instructions

  /**
   * The abstract type representing the LLVM instructions
   */
  static public abstract class Instruction {
    public abstract String toString();
  }

  /**
   * Class representing the add instruction
   */
  static public class Add extends Instruction {
    Type type;
    String left;
    String right;
    String lvalue;

    /**
     * The add instruction.
     * lvalue = left + right
     * @param type The type of lvalue, left and right
     * @param left the left side of the addition
     * @param right the right side of the addition
     * @param lvalue the variable containing the result of the addition
     */
    public Add(Type type, String left, String right, String lvalue) {
      this.type = type;
      this.left = left;
      this.right = right;
      this.lvalue = lvalue;
    }

    public String toString() {
      return lvalue + " = add " + type + " " + left + ", " + right +  "\n";
    }
  }
  
  /**
   * Class representing the add instruction
   */
  
  static public class Sous extends Instruction {
	    Type type;
	    String left;
	    String right;
	    String lvalue;

	    /**
	     * The add instruction.
	     * lvalue = left + right
	     * @param type The type of lvalue, left and right
	     * @param left the left side of the addition
	     * @param right the right side of the addition
	     * @param lvalue the variable containing the result of the addition
	     */
	    public Sous(Type type, String left, String right, String lvalue) {
	      this.type = type;
	      this.left = left;
	      this.right = right;
	      this.lvalue = lvalue;
	    }

	    public String toString() {
	      return lvalue + " = sub " + type + " " + left + ", " + right +  "\n";
	    }
	  }
  /**
   * Class representing the add instruction
   */
  
  static public class Mult extends Instruction {
	    Type type;
	    String left;
	    String right;
	    String lvalue;

	    /**
	     * The add instruction.
	     * lvalue = left + right
	     * @param type The type of lvalue, left and right
	     * @param left the left side of the addition
	     * @param right the right side of the addition
	     * @param lvalue the variable containing the result of the addition
	     */
	    public Mult(Type type, String left, String right, String lvalue) {
	      this.type = type;
	      this.left = left;
	      this.right = right;
	      this.lvalue = lvalue;
	    }

	    public String toString() {
	      return lvalue + " = mul " + type + " " + left + ", " + right +  "\n";
	    }
	  }
  
  /**
   * Class representing the add instruction
   */
  
  static public class Div extends Instruction {
	    Type type;
	    String left;
	    String right;
	    String lvalue;

	    /**
	     * The add instruction.
	     * lvalue = left + right
	     * @param type The type of lvalue, left and right
	     * @param left the left side of the addition
	     * @param right the right side of the addition
	     * @param lvalue the variable containing the result of the addition
	     */
	    public Div(Type type, String left, String right, String lvalue) {
	      this.type = type;
	      this.left = left;
	      this.right = right;
	      this.lvalue = lvalue;
	    }

	    public String toString() {
	      return lvalue + " = udiv " + type + " " + left + ", " + right +  "\n";
	    }
	  }
  static public class AffectInt extends Instruction {
	  String  varname ;
  	  String value;
	   
	  
	    public AffectInt(String varname, String value){
	    	        this.varname = varname;
	    	        this.value = value ;
	    	    }

	    	  

	    public String toString() {
	        return "store i32 "+varname+", i32* %"+value+"\n";
	    }	  }
  
  static public class VarIntExpression extends Instruction {
	    String varname;
	    String res;

	    public VarIntExpression(String name, String res){
	      this.varname = name;
	      this.res = res;
	    }

	    public String toString() {
	      return res+" = load i32, i32* %"+varname+"\n";
	    }
	  }
  static public class DeclarationInt extends Instruction{
	   String name;
	  
	   
	   public DeclarationInt(String name){
		   this.name  = name;
		   
	   }
	   
	   @Override
	   public String toString() {
		   return "%"+name+" = alloca i32";
		
	   	}
	   
   	}
  
  static public class DeclarationTab extends Instruction{
	   String name;
	   int size ;
	  
	   
	   public DeclarationTab(String name,int size){
		   this.name  = name;
		   this.size = size;
	   }
	   
	   @Override
	   public String toString() {
		      return "%"+name+ " = alloca ["+size+" x i32] \n";
		    }
		
	   	
	   
  	}

  /**
   * Class representing the return instruction
   */
  static public class Return extends Instruction {
    Type type;
    String value;

    /**
     * The return instruction
     * @param type type of the return value
     * @param value value to be returned
     */
    public Return(Type type, String value) {
      this.type = type;
      this.value = value;
    }

    public String toString() {
      return "ret " + type + " " + value + "\n";
    }
  }

 

	
  // TODO : other instructions
}
