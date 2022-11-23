package TP2.ASD.Instruction;

import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;

import java.util.ArrayList;

public class InstructionBlock extends Instruction {
    ArrayList<Instruction> instructions ;
    public InstructionBlock(ArrayList<Instruction> i){
        this.instructions = i;
    }
    @Override
    public String pp(int profondeur) {
        String res = Utils.indent(profondeur)+ "{ ";
        for (Instruction ins : instructions) {
            res += ins.pp(profondeur+1);
        }
       return res + Utils.indent(profondeur)+ " }";
    }

    @Override
    public Llvm.IR toIR(SymbolTable tab) throws TypeException {
        SymbolTable t = new SymbolTable(tab);
        Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
        for (Instruction ins : instructions) {
            ir.append(ins.toIR(t));
        }
        return ir;
    }
}
