package SymbolDiff;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by anna on 22.02.16.
 */
public class Hash {
    HashMap<String,String> differencial = new HashMap();
    HashMap<String,String> innerExpression = new HashMap<String, String>();
    private String formula;

    public void add(String formula, String findDif){
        this.formula = formula;
        differencial.put(formula,findDif);
    }
    public void addInner(String formula,String inner){
        innerExpression.put(formula,inner);
    }

    public String getDiff(String formula){
       return differencial.get(formula);
    }
    public String getInner(String formula){
    return innerExpression.get(formula);
}
    public String getFormula(){
        return formula;
    }
}
