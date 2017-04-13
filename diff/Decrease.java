package SymbolDiff;

/**
 * Created by anna on 29.02.16.
 */
public class Decrease {
    private String result;

    public void setResult(String formula){
        result = formula;
    }
    public String decrease(String formula) {
        char[] nulFormul = formula.toCharArray();
        String result = "";
        boolean flag1=false;
        boolean flagSearch=false;
        for (int i = 0; i < nulFormul.length; i++) {
            if(nulFormul[i]=='0'){
                flagSearch=true;
                break;
            }
        }
        if(!flagSearch){
            setResult(formula);
            return formula;
        }
        else {
            for (int i = 0; i < nulFormul.length; i++) {
                if (nulFormul[i] == '0') {
                    int start = i;
                    int j = start;
                    int end = 0;
                    if (start != (nulFormul.length - 1)) {
                        if (nulFormul[start + 1] == '/' || nulFormul[start + 1] == '*') {
                            if (nulFormul[start + 2] == '(' || nulFormul[start + 2] == 'a' || nulFormul[start + 2] == 's' || nulFormul[start + 2] == 'l' || nulFormul[start + 2] == 'c' || nulFormul[start + 2] == 'e' || nulFormul[start + 2] == 't') {
                                flag1 = true;
                                int amount = 1;
                                int numberBreak = 0;
                                for (int a = start + 2; a < nulFormul.length; a++) {
                                    if (nulFormul[a] == '(') {
                                        numberBreak = a;
                                        break;
                                    }
                                }
                                for (int a = start + 3; a < nulFormul.length; a++) {
                                    if (a != numberBreak) {
                                        if (nulFormul[a] == '(') amount++;
                                    }
                                    if (nulFormul[a] == ')') amount--;
                                    if (amount == 0) {
                                        end = a + 1;
                                        break;
                                    }
                                }
                                for (int a = 0; a < nulFormul.length; a++) {
                                    if ((a >= i && a < end + 1)) {
                                    } else {
                                        result += nulFormul[a];
                                    }
                                }
                            }
                            if (!flag1) {
                                for (int k = i; k < nulFormul.length; k++) {
                                    if (nulFormul[k] == '+' || nulFormul[k] == '-') {
                                        flag1 = true;
                                        end = k;
                                        break;
                                    }
                                }
                                for (int a = 0; a < nulFormul.length; a++) {
                                    if ((a >=i && a < end )) {
                                    } else {
                                        result += nulFormul[a];
                                    }
                                }
                            }

                            if (flag1) break;
                        }
                    }
                    if (start != 0) {
                        if (nulFormul[start - 1] == '*') {
                            if (nulFormul[start - 2] == ')') {
                                flag1 = true;
                                int amount = 1;
                                for (int a = start - 3; a > 0; a--) {
                                    if (nulFormul[a] == ')') amount++;
                                    if (nulFormul[a] == '(') amount--;
                                    if (amount == 0) {
                                        end = a - 1;
                                        break;
                                    }
                                }
                                for (int a = end; a > 0; a--) {
                                    if (nulFormul[a] == '+' || nulFormul[a] == '-') {
                                        end = a;
                                        break;
                                    }
                                }
                                for (int a = 0; a < nulFormul.length; a++) {
                                    if ((a > end && a < i + 2)) {
                                    } else {
                                        result += nulFormul[a];
                                    }
                                }
                            }
                            int begin=i+1;
                            if (!flag1) {
                                for (int k = i; k > 0; k--) {
                                    if (nulFormul[k] == '+' || nulFormul[k] == '-'||nulFormul[k]=='(') {
                                        if(nulFormul[k]=='('){
                                            end=k+1;
                                            begin=i+2;
                                        }else {
                                            end = k;
                                            begin=i+1;
                                        }
                                        flag1 = true;
                                        break;
                                    }
                                }
                                for (int a = 0; a < nulFormul.length; a++) {
                                    if ((a >= end && a < begin)) {
                                    } else {
                                        result += nulFormul[a];
                                    }
                                }
                            }
                            if (flag1) break;
                        }
                    }
                    if (start != 0) {
                        if (nulFormul[start - 1] == '+' || nulFormul[start - 1] == '-') {
                            flag1 = true;
                            for (int a = 0; a < nulFormul.length; a++) {
                                if ((a >= start - 1 && a < start + 1)) {
                                } else {
                                    result += nulFormul[a];
                                }
                            }
                        }

                        if (flag1) break;
                    }
                }
            }
            decrease(result);
        }
            return null;
    }

    public String getResult(){
        return result;
    }

    public static void main(String[] args) {
        Decrease decrease = new Decrease();
        decrease.decrease("(0*x-1*1)/(x)^2");
        System.out.println(decrease.getResult());

    }
}
