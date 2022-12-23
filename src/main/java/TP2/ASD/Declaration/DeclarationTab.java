package TP2.ASD.Declaration;

import TP2.*;
import TP2.ASD.Type.Int;
import TP2.ASD.Type.PointeurInt;


public class DeclarationTab extends Declaration{
    private String name;
    private int size;

    public DeclarationTab(String value, int size){
        this.name = value;
        this.size = size;
    }

    //Pretty-printer
    public String pp(int profondeur){
        return "INT "+name+"["+size+"] \n";
    }

    public RetExpression toIR(SymbolTable tab) throws TypeException {
        Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
        SymbolTable.TabVariableSymbol vSymbol = new SymbolTable.TabVariableSymbol(new PointeurInt(), name, size);
         if(tab.lookInTable(vSymbol)){
                throw new RuntimeException(name+" already in the Symbol Tab.");
         }
        SymbolTable.Symbol s = tab.lookup(name);
        if((s != null)) {
            if (s instanceof SymbolTable.TabVariableSymbol) {
                String newName = Utils.newglob(name);
                SymbolTable.Symbol pointer = new SymbolTable.PoinTeurSymbol(
                        new SymbolTable.TabVariableSymbol(new PointeurInt(),this.name,this.size), newName);
                tab.add(pointer);
                ir.appendCode(new Llvm.DeclarationTab(newName, size));
            }
            else if (s instanceof SymbolTable.PoinTeurSymbol) {
                String newName = Utils.newglob(((SymbolTable.PoinTeurSymbol)s).getV().getIdent());
                SymbolTable.Symbol pointer = new SymbolTable.PoinTeurSymbol(
                        new SymbolTable.TabVariableSymbol(new PointeurInt(),this.name,this.size), newName);
                tab.add(pointer);
                ir.appendCode(new Llvm.DeclarationTab(newName, size));

            }


        }
        else {
            tab.add(vSymbol);
            ir.appendCode(new Llvm.DeclarationTab(name,size));
        }



        return new RetExpression(ir,new PointeurInt(),"");
    }    
}
