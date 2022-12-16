package TP2.ASD.Instruction;

import TP2.ASD.Type.Int;
import TP2.ASD.Type.Type;
import TP2.ASD.Type.Void;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;

import java.util.ArrayList;

public class InstructionProto extends Instruction{
    String nom;
    Type type;
    ArrayList<String> args;

    public InstructionProto(String nom, Type type, ArrayList<String> args) {
        this.nom = nom;
        this.type = type;
        this.args = args;
    }

    /**
     * @param profondeur
     * @return
     */
    @Override
    public String pp(int profondeur) {
        String res = "PROTO "+this.type +" "+this.nom +"(";
        res += String.join(",",this.args);
        return res;
    }

    /**
     * @param tab
     * @return
     * @throws TypeException
     */
    @Override
    public RetExpression toIR(SymbolTable tab) throws TypeException {
        ArrayList<SymbolTable.VariableSymbol> vars = new ArrayList<>();
        this.args.forEach(e -> vars.add(new SymbolTable.VariableSymbol(new Int(),e)));
        SymbolTable.FunctionSymbol p = new SymbolTable.FunctionSymbol(this.type,this.nom,vars,false);
        tab.add(p);
        return new RetExpression(new Llvm.IR(Llvm.empty(),Llvm.empty()),new Void(),"");
    }
}
