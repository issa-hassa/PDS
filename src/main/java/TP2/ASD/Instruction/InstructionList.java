package TP2.ASD.Instruction;

import TP2.ASD.Expression.Expression;
import TP2.ASD.Type.Type;
import TP2.ASD.Type.Void;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;

import java.util.ArrayList;

public class InstructionList extends Instruction{
    ArrayList<Expression> instructions;
    Type type;


    public InstructionList(ArrayList<Expression> instructions) {
        this.instructions = instructions;
    }

    public ArrayList<Expression> getInstructions() {
        return instructions;
    }

    /**
     * @param profondeur
     * @return
     */
    @Override
    public String pp(int profondeur) {
        StringBuilder res = new StringBuilder();
        for(Expression i :this.instructions) res.append(i.pp(profondeur));
        return res.toString();
    }
    public void verifType(Type type) {
        this.type = type;
    }
    /**
     * @param tab
     * @return
     * @throws TypeException
     */
    @Override
    public RetExpression toIR(SymbolTable tab) throws TypeException {
        Llvm.IR res = new Llvm.IR(Llvm.empty(),Llvm.empty());
        for(Expression i : this.instructions){
            if(i instanceof InstructionRet){
                ((InstructionRet)i).verifType(this.type);
            }
            if(i instanceof InstructionIf){
                ((InstructionIf)i).verifType(this.type);
            }
            res.append(i.toIR(tab).ir);
        }
        return new RetExpression(res,new Void(),"instrucionList");
    }
}
