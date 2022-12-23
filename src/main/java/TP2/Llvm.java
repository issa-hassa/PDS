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
	public List<Instruction> header;
    /**
     *  IR composing the main code
     */ 
    List<Instruction> code;

	  public List<Instruction> globals;

	  /**
     * Creates an IR based on two lists of instructions
     * @param header the instructions to be placed before the code
     * @param code the main code
     */
    public IR(List<Instruction> header, List<Instruction> code) {
      this.header = header;
      this.code = code;
	  this.globals = empty();
    }

    /**
     * Append two IR.
     * 
     * Append the header of the second to the first, and idem for the code
     * @param other the other IR
     * @return
     */
    public IR append(IR other) {
		globals.addAll(other.globals);
      header.addAll(other.header);
      code.addAll(other.code);
      return this;
    }
	public IR appendGlobals(Instruction i){
		this.globals.add(i);
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
	  public IR appendHeader(IR other) {
		  globals.addAll(other.globals);
		  header.addAll(other.header);
		  header.addAll(other.code);
		  return this;
	  }

    public String toString() {
      // This header describe to LLVM the target
      // and declare the external function printf
      StringBuilder r = new StringBuilder("; Target\n" +
        "target triple = \"x86_64-unknown-linux-gnu\"\n" +
        "; External declaration of the printf function\n" +
        "declare i32 @printf(i8* noalias nocapture, ...)\n" +
		"declare i32 @scanf(i8* noalias nocapture, ... )\n"+
        "\n; Actual code begins\n\n");

    for(Instruction inst  : globals){
		r.append(inst);
	}
		r.append("\n\n");
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
		Type type;

	    public VarIntExpression(Llvm.Type type,String name, String res){
	      this.varname = name;
	      this.res = res;
		  this.type = type;
	    }

	    public String toString() {
	      return res+" = load i32, i32* %" +varname+"\n";
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
	static public class ExpressionTab extends Instruction{
		String name;
		String index;
		int size;

		String result;


		public ExpressionTab(String name,String index,int size, String result){
			this.name  = name;
			this.index = index;
			this.size = size;
			this.result = result;

		}

		@Override
		public String toString() {
			return result+" = getelementptr ["+this.size+" x i32], "+"["+this.size+" x i32]* "
					+"%"+this.name+", i64 0, i32 " + index
					+ "\n";

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

  			this.nom = nom;
  			this.args = args;
  			this.type = type;

  		}
		@Override
		public String toString() {
			for(int i = 0; i < args.size(); i++){ args.set(i,"i32 %"+args.get(i)); }
			String res = "define " + type + " @" +nom+"( " ;
			res +=String.join(",",this.args) ;
			res +=" ) {  \n" ;
			return res;
		}
  		
  	}
  	
  	static public class Ret extends Instruction {
        String eRes;

        public Ret(String label) {
          this.eRes = label;
        }
		public Ret() {
			this.eRes = null;
		}

        public String toString(){
			if(eRes == null){
				return "ret void \n";
			}
          return "ret i32  " +eRes + "\n";
        }
    }
	static public class AppelFun extends Instruction{
	  String name;
	  ArrayList<String> args;
	  String result;
	  Type type;
		public AppelFun(String name,Type type, ArrayList<String> args, String result) {
			this.name = name;
			this.args = args;
			this.result = result;
			this.type = type;
		}



		/**
		 * @return
		 */
		@Override
		public String toString() {
			String res ="call "+this.type+" @"+this.name+"(";
			for (int i = 0; i < args.size(); i++){
				String s = "i32 " + args.get(i);
				if(i<args.size() - 1) s+=",";
				res+=s;
			}
			res+=")";
			if(!(this.type instanceof Void))res = this.result +" = " + res+ "\n";
			else{
				res +="\n";
			}
			return res;
		}
	}
	static public class Print extends Instruction{

		int length;
		ArrayList<String> result ;
		String globalVar;

		public Print(int lengtht, ArrayList<String> result, String globalVar) {
			this.length = lengtht;
			this.result = result;
			this.globalVar = globalVar;
		}

		/**
		 * @return
		 */
		@Override
		public String toString() {
			StringBuilder res =new StringBuilder("call i32 (i8*, ...) @printf (i8* getelementptr inbounds" +
					"(["+length+ " x i8] , ["+length+" x i8]* "+this.globalVar + ", i64 0, i64 0)");

			for (String s: this.result) {
				res.append(", i32 "+s);
			}
			res.append(")\n");



			return res.toString();
		}
	}
	static public class Read extends Instruction{

		int length;
		ArrayList<String> result ;
		String globalVar;

		public Read(int length, ArrayList<String> result, String globalVar) {
			this.length = length;
			this.result = result;
			this.globalVar = globalVar;
		}

		/**
		 * @return
		 */
		@Override
		public String toString() {
			StringBuilder res =new StringBuilder("call i32 (i8*, ...) @scanf (i8* getelementptr inbounds" +
					"(["+length+ " x i8] , ["+length+" x i8]* "+this.globalVar + ", i64 0, i64 0)");

			for (String s: this.result) {
				res.append(", i32 * %"+s);
			}
			res.append(")\n");



			return res.toString();
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
	static public class Text extends Instruction {
		String text;

		public Text(String text){
			this.text = text;
		}

		public String toString(){
			return this.text;
		}
	}
	static public class StringConst extends Instruction {
		Utils.LLVMStringConstant text;
		String res ;

		public StringConst(Utils.LLVMStringConstant text, String res) {
			this.text = text;
			this.res = res;
		}


		public String toString(){
			return res +" = global [" +this.text.length + " x i8 ] c\"" + this.text.str + "\" \n";
		}
	}
  
  static public class LC extends Instruction {
     

     

      public String toString(){
        return "}\n";
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
