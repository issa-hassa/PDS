package TP2.ASD.Instruction;

import TP2.ASD.Expression.Expression;
import TP2.ASD.Expression.TextExpression;
import TP2.ASD.Type.Void;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;
import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;

public class InstructionPrint extends Instruction{
    ArrayList<Expression> args;

    public InstructionPrint(ArrayList<Expression> args) {
        this.args = args;
    }


    /**
     * @param profondeur
     * @return
     */
    @Override
    public String pp(int profondeur) {
        ArrayList<String> res = new ArrayList<>();
        this.args.forEach(e -> res.add(e.pp(0)));
        return Utils.indent(profondeur)+ "PRINT " +String.join(",",res) + "\n";
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
        for (Expression e : this.args) {
            if(e instanceof TextExpression){
                global.append(((TextExpression) e).getText());
            }
            else{
                global.append("%d");
                Expression.RetExpression irExpression = e.toIR(tab);
                ir.append(irExpression.ir);
                resultExpr.add(irExpression.result);

            }
        }
        ir.appendHeader(new Llvm.StringConst(Utils.stringTransform(global.toString()),globalVar));
        ir.appendCode(new Llvm.Print((Utils.stringTransform(global.toString())).length,resultExpr,globalVar));
        return new RetExpression(ir,new Void(),"print");
    }
}
