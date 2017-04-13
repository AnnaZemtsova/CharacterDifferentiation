package SymbolDiff;

/**
 * Created by anna on 29.02.16.
 */
public class Decrease1 {
    private String result;

    public void setResult(String formula){
        result = formula;
    }
    public String getResult(){
        return result;
    }

    public boolean checkNeedDecrease(String formula,int i){
        char[] nulFormul = formula.toCharArray();
        boolean need = false;
        int begin;
        int end;
               begin=i;
               end=i;
               if(i==formula.length()-1){
                   if(nulFormul[i-1]=='/'||nulFormul[i-1]=='*'){
                       return true;
                   }else return false;
               }
               if(i==0){
                   if(nulFormul[i+1]=='*'){
                       return true;
                   }else return false;
               }
                   if (nulFormul[i + 1] == ')' && nulFormul[i - 1] == '(') {
                       begin = i + 1;
                       end = i - 1;
                   }
               if(begin==nulFormul.length-1){
                   if(nulFormul[begin-3]=='/'||nulFormul[begin-3]=='*'){
                       return true;
                   }else return false;
               }
               if(end==0){
                   if(nulFormul[3]=='*'){
                       return true;
                   }else return false;
               }
               if((nulFormul[begin+1]=='*'&&(nulFormul[end-1]=='+'||nulFormul[end-1]=='-'))){
                   need=true;
               }
               if((nulFormul[end-1]=='*'&&(nulFormul[begin+1]=='+'||nulFormul[begin+1]=='-'))){
                   need=true;
               }
               if(nulFormul[end-1]=='/'&&(nulFormul[begin+1]=='+'||nulFormul[begin+1]=='-')){
                   need=true;
               }
        return need;
    }

    public String decrease(String formula){
        //System.out.println(formula);
        char[] nulFormul = formula.toCharArray();
        boolean exit=false;
        for(int i=0;i<formula.length();i++) {
            if (nulFormul[i] == '1') {
                if (checkNeedDecrease(formula, i)) {
                    exit=true;
                    break;
                }
            }
        }
        if(!exit) {
            setResult(formula);
            return null;
        }
        if(exit) {
            String result = "";
            boolean flag = false;
            for (int i = 0; i < nulFormul.length; i++) {
                if (nulFormul[i] == '1') {
                    if (checkNeedDecrease(formula, i)) {
                        flag = true;
                        if (i == nulFormul.length - 1) {
                            for (int a = 0; a < nulFormul.length - 2; a++) {
                                result += nulFormul[a];
                            }
                            break;
                        }
                        if (i == 0) {
                            for (int a = 2; a < nulFormul.length; a++) {
                                result += nulFormul[a];
                            }
                            break;
                        }
                        if (nulFormul[i + 1] == ')' && nulFormul[i - 1] == '(') {
                            if ((i + 1) == nulFormul.length - 1) {
                                for (int a = 0; a < nulFormul.length - 4; a++) {
                                    result += nulFormul[a];
                                }
                                break;
                            }
                            if ((i - 1) == 0) {
                                for (int a = 4; a < nulFormul.length; a++) {
                                    result += nulFormul[a];
                                }
                                break;
                            }
                            if (nulFormul[i + 2] == '*') {
                                for (int a = 0; a < nulFormul.length; a++) {
                                    if (a >= i - 1 && a < i + 3) {
                                    } else result += nulFormul[a];
                                }
                                break;
                            }

                            if (nulFormul[i - 2] == '*' || nulFormul[i - 2] == '/') {
                                for (int a = 0; a < nulFormul.length; a++) {
                                    if (a >= i - 2 && a < i + 2) {
                                    } else result += nulFormul[a];
                                }
                                break;
                            }
                        } else {
                            if ((i) == nulFormul.length - 1) {
                                for (int a = 0; a < nulFormul.length - 2; a++) {
                                    result += nulFormul[a];
                                }
                                break;
                            }
                            if ((i) == 0) {
                                for (int a = 2; a < nulFormul.length; a++) {
                                    result += nulFormul[a];
                                }
                                break;
                            }
                            if (nulFormul[i + 1] == '*') {
                                for (int a = 0; a < nulFormul.length; a++) {
                                    if (a > i - 1 && a < i + 2) {
                                    } else result += nulFormul[a];
                                }
                                break;
                            }
                            if (nulFormul[i - 1] == '*' || nulFormul[i - 1] == '/') {
                                for (int a = 0; a < nulFormul.length; a++) {
                                    if (a > i - 2 && a < i + 1) {
                                    } else result += nulFormul[a];
                                }
                                break;
                            }
                        }
                        if(flag) break;
                    }
                }
            }
           // System.out.println(result);
            decrease(result);
        }
        return formula;
    }
    public static void main(String[]args){
        Decrease1 decrease1 = new Decrease1();
        decrease1.decrease("(1)*4+x/(1)-x+1-2*1+(1)/4-1+3*(1+3)-1*x");
        System.out.println(decrease1.getResult());
    }
}
