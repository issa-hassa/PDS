package TP2.ASD.Declaration;

import TP2.*;
import TP2.ASD.Type.PointeurInt;


public class DeclarationTab extends Declaration{
    private String value;
    private int size;

    public DeclarationTab(String value, int size){
        this.value = value;
        this.size = size;
    }

    //Pretty-printer
    public String pp(int profondeur){
        return "INT "+value+"["+size+"] \n";
    }

    public Llvm.IR toIR(SymbolTable tab) throws TypeException {
        Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
        SymbolTable.TabVariableSymbol vSymbol = new SymbolTable.TabVariableSymbol(new PointeurInt(), value, size);
         if(!tab.add(vSymbol)){
                throw new RuntimeException(value+" already is the Symbol Tab.");
            }
            ir.appendCode(new Llvm.DeclarationTab(value, size));
        
        return ir;
    }    
}
