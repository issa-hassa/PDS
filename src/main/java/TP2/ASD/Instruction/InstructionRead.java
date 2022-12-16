package TP2.ASD.Instruction;

import TP2.ASD.Expression.Expression;
import TP2.ASD.Expression.TextExpression;
import TP2.ASD.Expression.VarIntExpression;
import TP2.ASD.Type.Void;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;
import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;

public class InstructionRead extends Instruction{
    ArrayList<String> args;

    public InstructionRead(ArrayList<String> args) {
        this.args = args;
    }


    /**
     * @param profondeur
     * @return
     */
    @Override
    public String pp(int profondeur) {
        ArrayList<String> res = new ArrayList<>();
        this.args.forEach(e -> res.add(e));
        return Utils.indent(profondeur)+ "READ " +String.join(",",res)+ "\n";
    }

    /**
     * @param tab
     * @return
     * @throws TypeException
     */
    @Override
    public RetExpression toIR(SymbolTable tab) throws TypeException {
        Llvm.IR ir = new Llvm.IR(Llvm.empty(),Llvm.empty());
        ArrayList<String> resultExpr = new ArrayList<>();
        StringBuilder global = new StringBuilder();
        String globalVar = Utils.newglob("@.fmt");
        ArrayList<String> argsIr = new ArrayList<>();
        for (String s : this.args) {
            SymbolTable.Symbol var = tab.lookup(s);
            if( !(var instanceof SymbolTable.VariableSymbol)){
                throw new TypeException("type miss match required: INT found: "+ var.getType().pp() );
            }
            if(var == null){
                throw new TypeException("unknown variable"+ s);
            }
            else{
                global.append("%d");
                resultExpr.add(s);
            }
        }
        ir.appendHeader(new Llvm.StringConst(Utils.stringTransform(global.toString()),globalVar));
        ir.appendCode(new Llvm.Read((Utils.stringTransform(global.toString())).length,resultExpr,globalVar));
        return new RetExpression(ir,new Void(),"");
    }
}
