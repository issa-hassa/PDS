package TP2.ASD.Instruction;

import TP2.ASD.Expression.Expression;
import TP2.ASD.Type.Type;
import TP2.ASD.Type.Void;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;

import java.util.ArrayList;

public class InstructionBlock extends Instruction {
    InstructionList instructions;
    Type type;
    public InstructionBlock(Instruction i){
        this.instructions =(InstructionList) i;
    }

    public ArrayList<Expression> getInstructions() {
        return instructions.getInstructions();
    }

    @Override
    public String pp(int profondeur) {
        String res = Utils.indent(profondeur)+ "{ \n";
        instructions.pp(profondeur + 1);
       return res + Utils.indent(profondeur)+ " }";
    }


    @Override
    public RetExpression toIR(SymbolTable tab) throws TypeException {
        SymbolTable t = new SymbolTable(tab);
        Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
        ir.append(instructions.toIR(t).ir);

        return new RetExpression(ir,new Void(),"");
    }
}
