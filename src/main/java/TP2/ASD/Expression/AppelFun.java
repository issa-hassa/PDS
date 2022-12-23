package TP2.ASD.Expression;

import TP2.ASD.Type.Int;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;

import java.util.ArrayList;

public class AppelFun extends Expression{

    String name;
    ArrayList<Expression> args;

    public AppelFun(String name, ArrayList<Expression> args) {
        this.name = name;
        this.args = args;
    }

    /**
     * @return
     */
    @Override
    public String pp(int profondeur) {
        String res = name + "( ";
        for (int i = 0; i < args.size(); i++){
            Expression e = args.get(i);
            String s  =e.pp(profondeur);
            if(i< args.size() - 1) s += ",";
            res +=s;
        }
        return res;
    }

    /**
     * @param table
     * @return
     * @throws TypeException
     */
    @Override
    public RetExpression toIR(SymbolTable table) throws TypeException {
        Llvm.IR ir = new Llvm.IR(Llvm.empty(),Llvm.empty());
        SymbolTable.Symbol symbol = table.lookup(this.name);
        if(!(symbol instanceof SymbolTable.FunctionSymbol)){
            throw new TypeException("unkown function " + this.name);
        }
        SymbolTable.FunctionSymbol f = ( SymbolTable.FunctionSymbol) symbol;
        if(f.getArgsSize() != this.args.size())  throw new TypeException(f.getArgsSize() + " :Arguments expected, Found: "+this.args.size());
        ArrayList<String> arguments = new ArrayList<>();
        for (Expression e:this.args){
            RetExpression irExp = e.toIR(table);
            ir.append(irExp.ir);
            arguments.add(irExp.result);
        }
        String result = Utils.newtmp();
        ir.appendCode(new Llvm.AppelFun(this.name,f.getType().toLlvmType(),arguments,result));
        return new RetExpression(ir,f.getType(),result);
    }
}
