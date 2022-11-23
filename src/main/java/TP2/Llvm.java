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
    //  r.append("define i32 @main() {\n");


      for(Instruction inst: code)
        r.append(inst);

      // TODO : remove this when you extend the language
    //  r.append("}\n");

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
  static public class Void extends Type {
	    public String toString() {
	      return "void";
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
	        return "store i32 "+value+", i32* %"+varname+"\n";
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
		   return "%"+name+" = alloca i32" + "\n";
		
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
  static public class instructionIf extends Instruction{
	    String eRes = "";
	    String tmp = "";
	    String branchIF = "";
	    String branchFI = "";
	    String branchELSE ="";
	    boolean Else = false;
	    /**
	     * 
	     * @param eRes resultat de l'expression
	     * @param tmp resultat de icmp
	     * @param branchIF
	     * @param branchELSE
	     * @param branchFI
	     * @param Else
	     */
	    public instructionIf(String eRes, String tmp, String branchIF,String branchELSE, String branchFI,boolean Else){
	      this.eRes = eRes;
	      this.tmp = tmp;
	      this.branchIF = branchIF;
	      this.branchFI = branchFI;
	      this.branchELSE = branchELSE;
	      this.Else = Else;
	    }

	    
	    @Override
	    public String toString(){
	      String s1 = tmp+" = icmp ne i32 "+eRes+" , 0\n";
	      s1 += "br i1 "+tmp+", label %"+branchIF+", label %";
	    
	      if(this.Else) {
	    	  s1 +=  branchELSE+"\n";
	      }
	      else {
	    	  s1 +=  branchFI+"\n";
	      }
	      
	      return s1;
	    }
	  }
  	static public class instructionWhile extends Instruction {
  		String branchCondition;
  		String branchFin;
  		String resE;
  		
  		public instructionWhile(String branchCondition, String branchFin, String resE){
  			this.branchCondition = branchCondition;
  			this.branchFin = branchFin;
  			this.resE = resE;
  		}
		@Override
		public String toString() {
			String s2 =  Utils.newtmp();
			String s1 = s2 + " = icmp ne i32 "+ resE + " ,0\n";
			s1 += "br i1 "+s2+", label %"+branchCondition + ", label %"+branchFin +"\n";
			return s1;
		}
  		
  	}
  	static public class instructionFunc extends Instruction {
  		String nom;
  		String type;
  		ArrayList<String> args;
  		
  		public instructionFunc(String nom, String type, ArrayList<String> args) {
  			System.out.println("type= " + type + "nom = " + nom  + "args" + args.toString());
  			this.nom = nom;
  			this.args = args;
  			this.type = type;
  		}
		@Override
		public String toString() {
			String res = "define " + type + " @" +nom+"( " ;
			for(int i = 0; i<args.size();i++) {
				String s = args.get(i);
				if(i == args.size() - 1) { res += "i32 %" +s ; }
				else {
					res += "i32 %" +s +", ";
				}
			}
			res +=" ) {  \n";
			
			return res;
		}
  		
  	}
  	
  	static public class Ret extends Instruction {
        String eRes;

        public Ret(String label) {
          this.eRes = label;
        }

        public String toString(){
          return "ret i32  " +eRes;
        }
    }	
  static public class Br extends Instruction {
      String label;

      public Br(String label) {
        this.label = label;
      }

      public String toString(){
        return "br label %"+label + "\n";
      }
  }
 
  static public class Label extends Instruction {
      String label;

      public Label(String label){
        this.label = label;
      }

      public String toString(){
        return label+": \n";
      }
  }
  
  static public class LC extends Instruction {
     

     

      public String toString(){
        return "}";
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
