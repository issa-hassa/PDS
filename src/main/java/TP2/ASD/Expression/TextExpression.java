package TP2.ASD.Expression;

import TP2.ASD.Type.Void;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.ASD.Type.*;

public class TextExpression extends Expression{
    String text;

    public TextExpression(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


    /**
     * @return
     */
    @Override
    public String pp(int profondeur) {
        return this.text;
    }

    /**
     * @param table
     * @return
     * @throws TypeException
     */
    @Override
    public RetExpression toIR(SymbolTable table) throws TypeException {
        RetExpression ir = new RetExpression(new Llvm.IR(Llvm.empty(),Llvm.empty()),new Int(),"");
        ir.ir.appendCode(new Llvm.Text(this.text));
        return ir;
    }
}
