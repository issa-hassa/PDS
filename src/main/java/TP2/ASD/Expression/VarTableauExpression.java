package TP2.ASD.Expression;

import TP2.ASD.Type.Int;
import TP2.ASD.Type.PointeurInt;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;

import java.util.List;

public class VarTableauExpression  extends Expression{
    String name;
    Expression index;

    public VarTableauExpression(String name, Expression index) {
        this.name = name;
        this.index = index;
    }

    /**
     * @param profondeur
     * @return
     */
    @Override
    public String pp(int profondeur) {
        return null;
    }

    /**
     * @param table
     * @return
     * @throws TypeException
     */
    @Override
    public RetExpression toIR(SymbolTable table) throws TypeException {

        Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
        String resultat ="";
        SymbolTable.Symbol var = table.lookup(name);
        RetExpression irExp = this.index.toIR(table);
        if(!(irExp.type instanceof Int)) throw new RuntimeException("The index must be an Integer value" +name);

        if(var == null) throw new RuntimeException("Unknown variable : " +name);
        if(!(var instanceof SymbolTable.TabVariableSymbol)) {
            throw new RuntimeException(
                    name + " is not an array");
        }
        SymbolTable.TabVariableSymbol tab = (SymbolTable.TabVariableSymbol)var;
        resultat = Utils.newtmp();

        if(var instanceof SymbolTable.PoinTeurSymbol) {
            if (((SymbolTable.PoinTeurSymbol) var).getV() instanceof SymbolTable.TabVariableSymbol) {
                ir.append(irExp.ir);
                ir.appendCode(new Llvm.ExpressionTab(((SymbolTable.PoinTeurSymbol) var).getV().getIdent(), irExp.result, tab.getSize(), resultat));
            }
        }
        else {
            ir.append(irExp.ir);
            ir.appendCode(new Llvm.ExpressionTab(name,irExp.result,tab.getSize(),resultat));
        }

        return new RetExpression(ir,new Int(),resultat);

    }
}
