package TP2.ASD.Instruction;

import java.util.ArrayList;

import TP2.ASD.Declaration.DeclarationInt;
import TP2.ASD.Expression.Expression;
import TP2.ASD.Expression.IntegerExpression;
import TP2.ASD.Expression.TextExpression;
import TP2.ASD.Expression.VarIntExpression;
import TP2.ASD.Type.Int;
import TP2.ASD.Type.PointeurInt;
import TP2.ASD.Type.Type;
import TP2.ASD.Type.Void;
import TP2.Llvm.IR;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.SymbolTable.VariableSymbol;
import TP2.TypeException;
import TP2.Utils;

public class InstructionFunc extends Instruction {
	final String nom;
	final Type type;
	ArrayList<String> args;
	Instruction funcBlock;
	
	public InstructionFunc(String nom, Type type, ArrayList<String> args, Instruction funcBlock){
		this.nom = nom;
		this.args = args;
		this.type = type;
		this.funcBlock = funcBlock;

	}
	
	@Override
	public String pp(int profondeur) {

		StringBuilder res =new StringBuilder( "Func " + this.type.pp() + " " + nom +"(");
		res.append(String.join(",",args));
		res.append(")\n");
		res.append(funcBlock.pp(profondeur + 1) + "\n");

		return res.toString();
	}
	public boolean addToTable(SymbolTable tab,ArrayList<VariableSymbol> argsS) throws RuntimeException  {

		SymbolTable.FunctionSymbol f = new SymbolTable.FunctionSymbol(this.type,this.nom, argsS,true);
		SymbolTable.Symbol exist = tab.lookup(this.nom);
		if((exist != null) && (exist instanceof SymbolTable.FunctionSymbol) ){
			SymbolTable.FunctionSymbol fexist = (SymbolTable.FunctionSymbol) exist;
			if(fexist.equals(f)){ throw new  RuntimeException("Multiple declaration of the fonction + "+this.nom ); }
			if(fexist.incomArg(f)){
				throw new RuntimeException("The fonction "+this.nom + " is incompatible with the prototype");
			}
			if(fexist.equalsNotDefined(f)){
				fexist.setDefined(true);
				return true;
			}



		}
		else {
			tab.add(f);
			return false;
		}
		return false;
	}
	@Override
	public RetExpression toIR(SymbolTable tab) throws TypeException {
		SymbolTable t = new SymbolTable(tab);
		Llvm.IR irInstructions = new Llvm.IR(Llvm.empty(),Llvm.empty());
		Llvm.IR irRes = new Llvm.IR(Llvm.empty(),Llvm.empty());
		
		ArrayList<VariableSymbol> argsS = new ArrayList<>();
		args.forEach(e -> argsS.add( new VariableSymbol(new Int(),e)));
		boolean proto = this.addToTable(tab,argsS);
		for(String s : args){
			String argVar = Utils.newlab(s);
			DeclarationInt d = new DeclarationInt(argVar);
			AffectationInt a = new AffectationInt(argVar, "%"+s);
			t.add(new VariableSymbol(new Int(),s));
			if(proto){
				irInstructions.appendHeader(d.toIR(t).ir);
				irInstructions.appendHeader(a.toIR(t).ir);
			}
			else {
				irInstructions.append(d.toIR(t).ir);
				irInstructions.append(a.toIR(t).ir);
			}

			t.remove(s);
			SymbolTable.Symbol sym = new SymbolTable.PoinTeurSymbol(new SymbolTable.VariableSymbol(new PointeurInt(),argVar),s);
			t.add(sym);

		}
		Llvm.instructionFunc func =new  Llvm.instructionFunc(this.nom,(this.type.toLlvmType()).toString(),this.args);
		if(proto){
			irRes.appendHeader(func);
			irRes.appendHeader(irInstructions);
			irRes.appendHeader(this.funcBlock.toIR(t).ir);
			if(funcBlock instanceof InstructionBlock) {
				InstructionBlock b = (InstructionBlock) funcBlock;
				if (!(b.getInstructions().get(b.getInstructions().size() - 1) instanceof InstructionRet)) {
					if (this.type instanceof Void) {
						irRes.appendHeader(new Llvm.Ret());
					} else {
						Expression zero =new IntegerExpression(0);
						RetExpression zeroIr = zero.toIR(t);
						irRes.appendHeader(new Llvm.Ret(zeroIr.result));
					}
				}
			}
			else {
			     if(!(funcBlock instanceof InstructionRet)){
					if (this.type instanceof Void) {
						irRes.appendHeader(new Llvm.Ret());
					} else {
						Expression zero =new IntegerExpression(0);
						RetExpression zeroIr = zero.toIR(t);
						irRes.appendHeader(new Llvm.Ret(zeroIr.result));					}
				}
			}
			irRes.appendHeader(new Llvm.LC());
		}
		else {
			irRes.appendCode(func);
			irRes.append(irInstructions);
			irRes.append(this.funcBlock.toIR(t).ir);
			if(funcBlock instanceof InstructionBlock) {
				InstructionBlock b = (InstructionBlock) funcBlock;
				if (!(b.getInstructions().get(b.getInstructions().size() - 1) instanceof InstructionRet)) {
					if (this.type instanceof Void) {
						irRes.appendCode(new Llvm.Ret());

					} else {
						Expression zero =new IntegerExpression(0);
						RetExpression zeroIr = zero.toIR(t);
						irRes.appendCode(new Llvm.Ret(zeroIr.result));
					}
				}
			}
			else if(!(funcBlock instanceof InstructionRet)){
				if (this.type instanceof Void) {
					irRes.appendCode(new Llvm.Ret());
				} else {
					Expression zero =new IntegerExpression(0);
					RetExpression zeroIr = zero.toIR(t);
					irRes.appendCode(new Llvm.Ret(zeroIr.result));
				}
			}
			irRes.appendCode(new Llvm.LC());

		}
		return new RetExpression(irRes,this.type,this.nom);
	}

}
