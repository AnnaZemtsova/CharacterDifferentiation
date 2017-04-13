package SymbolDiff;

/**
 * Created by anna on 22.02.16.
 */
public class StandartFormul extends StandartTable{

    public String multi(String x,String y,String x1,String y1){
      //  System.out.println(x+" "+y+" "+x1+" "+y1);
        String result="";
        if(x.length()>1){
            x = "("+x+")";
        }
        if(y.length()>1){
            y="("+y+")";
        }
        result+="("+x1+"*"+y+"+"+y1+"*"+x+")";
     return result;
    }

    public String division(String x,String y,String x1,String y1){
        String result="";
        if(x.length()>1){
            x = "("+x+")";
        }
        if(y.length()>1){
            y="("+y+")";
        }
        result+="("+x1+"*"+y+"-"+y1+"*"+x+")/("+y+")^2";
        return result;
    }
    public String sum(String x1,String y1){
        String result="";
        result+="("+x1+"+"+y1+")";
        return result;
    }
    public String minus(String x1,String y1) {
        String result = "";
        result += "("+x1 + "-" + y1+")";
        return result;
    }
}
