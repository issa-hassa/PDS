# TP2 PDS, version Java

Issa Hassan Fadoul et Aiman Aouad

## Arborescence
- ASD
  - Declaration 
    - Declaration 
    - DeclarationInt 
    - DeclarationTab 
    
     
  - Expression
    - AddExpression  </br>
    - AppelFun
    - DivExpression
    - Integerexpression
    - MultExpression
    - SousExpression
    - TextExpression
    - VarIntExpression
    - VarTableauExpression
    
        
  - Instruction
    - AffectationInt
    - AffectationTabElement
    - Instruction
    - InstructionBlock
    - InstructionFunc
    - InstructionIF
    - InstructionList
    - InstructionPrint
    - InstructionProto
    - InstructionRead
    - InstructionRet
    - InstructionWhile
    
  - Type
    - Int
    - PointeurInt
    - Void
  



 ## Amélioration à apporter
- Les instrucions print ne prennent pas en enconte le type pointeur pour les tableau</br> 
  au lieu d'avoir i32 pour toutes les valeur il faut passer le type en paramètre

- les instruction read ne fonctionnet qu'avec des entiers
- Utiliser le design pattern Visitor pour la table de symbole au lieu de la passer en paramètre de toIR
 </br> la même chose pour le pretty printer 



## Gestion des blocks
<pre>
Nous avons ajouté une nouvelle classe PoinTeurSymbol dans la table des symbole,
cette classe a deux nouveaux attributs :
Le nom de la variable pointeur et la variable vers laquelle elle pointe.

Lors de la déclaration d'une  variable (v) qui existe dans  un block englobant 
nous déclarons un PoinTeurSymbol avec le nom v et VariableSymbole(v.type, Utils.newglob(name))
Ainsi on s'assure que chaque variable à été déclarée  une seule fois.
</pre>>