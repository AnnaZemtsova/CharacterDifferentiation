package SymbolDiff;

import com.sun.xml.internal.fastinfoset.util.StringIntMap;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by anna on 22.02.16.
 */
public class Tree {
    private String formula = "";
    private Tree left;
    private Tree right;
    private Hash hash = new Hash();
    private int aX;
    private int trigonom;
    private int xN;
    private String aX_Trigonom_Difficult;
    int i = 0;

    public Tree(String formula) {
        aX_Trigonom_Difficult = "";
        aX = 0;
        trigonom = 0;
        this.formula = formula;
    }

    public void setLeft(String formula) {
        left = new Tree(formula);
    }

    public void setRight(String formula) {
        right = new Tree(formula);
    }

    public Tree getRight() {
        return left;
    }

    public Tree getLeft() {
        return right;
    }

    public String getFormula() {
        return formula;
    }

    public Hash getHash() {
        return hash;
    }

    public String findingElementary(String formula, int i) {
        StandartTable table = new StandartTable();
        String result = "";
        boolean trigFlag = false;
        //System.out.println(formula+"   p");
        char[] genElementary = formula.toCharArray();
        if (genElementary[0] == 'x') {
            result = table.kXn(formula);
            trigFlag = true;
        }
        if (genElementary.length > 3) {
            if (genElementary[0] == 's' && genElementary[1] == 'q') {
                if (genElementary[5] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.sqrt();
                trigFlag = true;
            }
            if (genElementary[0] == 'a' && genElementary[3] == 's') {
                if (genElementary[7] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.arcsin();
                trigFlag = true;
            }
            if (genElementary[0] == 'a' && genElementary[4] == 'o') {
                if (genElementary[7] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.arccos();
                trigFlag = true;
            }
            if (genElementary[0] == 'a' && genElementary[3] == 't') {
                if (genElementary[6] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.arctg();
                trigFlag = true;
            }
            if (genElementary[0] == 'a' && genElementary[4] == 't') {
                if (genElementary[7] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.arcctg();
                trigFlag = true;
            }
            if (genElementary[0] == 'l' && genElementary[1] == 'n') {
                if (genElementary[3] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.ln();
                trigFlag = true;
            }
            if (genElementary[0] == 'l' && genElementary[1] == 'o') {
           /*    if(genElementary[genElementary.length]!='x'){

               }*/
                result = table.log(formula);
                trigFlag = true;
            }
            if (genElementary[0] == 'e') {
                if (genElementary[3] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.exp();
                trigFlag = true;
            }
            if (genElementary[0] == 'c' && genElementary[1] == 'o') {
                if (genElementary[4] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.cos();
                trigFlag = true;
            }
            if (genElementary[0] == 's' && genElementary[1] == 'i') {
                if (genElementary[4] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.sin();
                trigFlag = true;
            }
            if (genElementary[0] == 's' && genElementary[1] == 'h') {
                if (genElementary[3] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.sh();
                trigFlag = true;
            }
            if (genElementary[0] == 'c' && genElementary[1] == 'h') {
                if (genElementary[3] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.ch();
                trigFlag = true;
            }
            if (genElementary[0] == 't' && genElementary[1] == 'h') {
                if (genElementary[3] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.th();
                trigFlag = true;
            }
            if (genElementary[0] == 'c' && genElementary[2] == 'h') {
                if (genElementary[4] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.cth();
                trigFlag = true;
            }
            if (genElementary[0] == 't' && genElementary[1] == 'g') {
                if (genElementary[3] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.tg();
                trigFlag = true;
            }
            if (genElementary[0] == 'c' && genElementary[2] == 'g') {
                if (genElementary[4] != 'x') {
                    if (i == 1) {
                        findingTrigonomDiff(formula);
                    }
                    result = "difficult";
                } else result = table.ctg();
                trigFlag = true;
            }
        }
        if (trigFlag == false) {
            if (genElementary[0] != 'x' && (genElementary[genElementary.length - 1] == 'x')) {
                result = table.aX(formula);
                trigFlag = true;
            }
        }
        if (trigFlag == false) {
            findingAX(formula);
            result = "difficult";
        }

        //hash.add(formula,result);
        return result;
    }

    public void findingTrigonomDiff(String formula) {
        String innerExpression = "";
        String standartResult = "";
        String function = "";
        char[] genElementary = formula.toCharArray();
        if (genElementary.length > 3) {
            if (genElementary[0] == 's' && genElementary[1] == 'q') {
                function = "sqrt(x)";
                standartResult = findingElementary("sqrt(x)", 0);
                for (int i = 5; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'a' && genElementary[3] == 's') {
                function = "arcsin(x)";
                standartResult = findingElementary("arcsin(x)", 0);
                for (int i = 7; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'a' && genElementary[4] == 'o') {
                standartResult = findingElementary("arccos(x)", 0);
                function = "arccos(x)";
                for (int i = 7; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'a' && genElementary[3] == 't') {
                standartResult = findingElementary("arctg(x)", 0);
                function = "arctg(x)";
                for (int i = 6; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'a' && genElementary[4] == 't') {
                standartResult = findingElementary("arcctg(x)", 0);
                function = "arcctg(x)";
                for (int i = 7; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'l' && genElementary[1] == 'n') {
                standartResult = findingElementary("ln(x)", 0);
                function = "ln(x)";
                for (int i = 3; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'l' && genElementary[1] == 'o') {
                //дописать!
            }
            if (genElementary[0] == 'e') {
                function = "e^(x)";
                standartResult = findingElementary("e^(x)", 0);
                for (int i = 3; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'c' && genElementary[1] == 'o') {
                function = "cos(x)";
                standartResult = findingElementary("cos(x)", 0);
                for (int i = 4; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 's' && genElementary[1] == 'i') {
                function = "sin(x)";
                standartResult = findingElementary("sin(x)", 0);
                for (int i = 4; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 's' && genElementary[1] == 'h') {
                function = "sh(x)";
                standartResult = findingElementary("sh(x)", 0);
                for (int i = 3; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'c' && genElementary[1] == 'h') {
                function = "ch(x)";
                standartResult = findingElementary("ch(x)", 0);
                for (int i = 3; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 't' && genElementary[1] == 'h') {
                function = "th(x)";
                standartResult = findingElementary("th(x)", 0);
                for (int i = 3; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'c' && genElementary[2] == 'h') {
                function = "cth(x)";
                standartResult = findingElementary("cth(x)", 0);
                for (int i = 4; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 't' && genElementary[1] == 'g') {
                function = "tg(x)";
                standartResult = findingElementary("tg(x)", 0);
                for (int i = 3; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (genElementary[0] == 'c' && genElementary[2] == 'g') {
                function = "ctg(x)";
                standartResult = findingElementary("ctg(x)", 0);
                for (int i = 4; i < genElementary.length - 1; i++) {
                    innerExpression += genElementary[i];
                }
            }
            if (!standartResult.equals("")) {
                right = new Tree(function);
                left = new Tree(innerExpression);
                left.createTree(innerExpression);
                hash.addInner(formula, innerExpression);
            } else {
                System.out.println("что-то пошло не так");
            }
        }
    }

    public void findingAX(String formula) {
        char[] genAX = formula.toCharArray();
        String innerExpression = "";
        String koef = "";
        int ind = 0;
        for (int i = 0; i < genAX.length - 1; i++) {
            if (genAX[i] == '(') {
                ind = i;
                break;
            } else {
                koef += genAX[i];
            }
        }
        for (int i = ind + 1; i < genAX.length - 1; i++) {
            innerExpression += genAX[i];
        }
        right = new Tree(koef + "x");
        left = new Tree(innerExpression);
        left.createTree(innerExpression);
        // hash.addInner(formula,innerExpression);
    }

    private void findingXn(String formula) {/////дописать!!!
        char[] genAX = formula.toCharArray();
        String innerExpression = "";
        String power = "";
        int amount = 1;
        int ind = 0;
        for (int i = 1; i < formula.length(); i++) {
            if (genAX[i] == '(') amount++;
            if (genAX[i] == ')') amount--;
            if (amount == 0) {
                ind = i + 1;
                break;
            }
            innerExpression += genAX[i];
        }
        for (int i = ind; i < genAX.length; i++) {
            power += genAX[i];
        }
        // System.out.println("x"+power+" power");
        right = new Tree("x" + power);
        left = new Tree(innerExpression);
        left.createTree(innerExpression);
    }

    private String defineKindFunction(String formula) {
        String kind = "";
        trigonom = 0;
        aX = 0;
        boolean flag = false;
        boolean noCoef = false;
        aX_Trigonom_Difficult = "";
        char[] GENERAL = formula.toCharArray();
        ///////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < GENERAL.length; i++) {
            if ((GENERAL[i]) == 'x') {
                noCoef = true;
            }
        }
        if (!noCoef) {
            kind = "koef";
            hash.add(formula, "0");
        } else {
            if (kind.equals("")) {
                flag = false;
                for (int i = 0; i < GENERAL.length; i++) {
                    if (GENERAL[i] == '-' || GENERAL[i] == '+' || GENERAL[i] == '/' || GENERAL[i] == '*') {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    kind = "elementary";
                } else {
                    kind = "";
                }
                boolean trigDif = false;
                for (int i = 0; i < GENERAL.length; i++) {
                    if (GENERAL[i] == '^') {
                        trigDif = true;
                    }
                }
                if (kind.equals("elementary") && ((GENERAL[0] == 's') | (GENERAL[0] == 'c') | (GENERAL[0] == 'l') | (GENERAL[0] == 't') | (GENERAL[0] == 'a')) && trigDif) {
                    kind = "trigonom";
                }
            }

            ///////////////////////////////////////////////////////////////////////////
            if (!kind.equals("elementary") && !kind.equals("trigonom")) {
                if ((GENERAL[0] == 's') | (GENERAL[0] == 'c') | (GENERAL[0] == 'l') | (GENERAL[0] == 't') | (GENERAL[0] == 'a') | (GENERAL[0] == '(') | (GENERAL[0] == 'e')) {
                    if ((GENERAL.length > 1) && ((GENERAL[1] == 's') | (GENERAL[1] == 'c') | (GENERAL[1] == 'l') | (GENERAL[1] == 't') | (GENERAL[1] == 'a'))) {
                        kind = "trigonom";
                    } else {
                        if (GENERAL[0] != '(') {
                            kind = "trigonom";
                        }
                    }
                }
                int amount = 1;
                int j = 0;
                int numberBreaks = 0;
                int ind = 0;
                int endK = GENERAL.length;
                if (GENERAL[0] == '(') {
                    j = 1;
                    endK = endK - 1;
                }
                for (int i = j; i < endK; i++) {
                    if (GENERAL[i] == '(') {
                        numberBreaks = i;
                        break;
                    }
                }

                if (kind.equals("trigonom")) {
                    for (int i = j; i < GENERAL.length; i++) {
                        aX_Trigonom_Difficult += GENERAL[i];
                        if (i == numberBreaks) {
                            amount = 1;
                        } else {
                            if (GENERAL[i] == '(') amount++;
                            if (GENERAL[i] == ')') amount--;
                        }
                        if (amount == 0) {
                            trigonom = i;
                            ind = i;
                            break;
                        }
                    }
                    if (GENERAL.length > ind + 1) {
                        kind = "difficult";
                    } else {
                        trigonom = 0;
                    }
                }

                ///////////////////////////////////////////////////////////////////////////
                if (kind.equals("")) {
                    flag = false;
                    aX = 0;
                    ind = 0;
                    for (int i = 0; i < GENERAL.length; i++) {
                        if (GENERAL[i] == '^') {
                            flag = true;
                            ind = i;
                            break;
                        }
                    }
                    if (flag) {
                        kind = "aX";
                        for (int i = 0; i < ind; i++) {
                            if ((GENERAL[i] == '+' || GENERAL[i] == '-' || GENERAL[i] == '*' || GENERAL[i] == '/' || GENERAL[i] == 'x')) {
                                kind = "tmp";
                                break;
                            }
                        }
                    }

                    if (kind.equals("tmp")) {/////для xN
                        int ind1 = 1;
                        if (GENERAL[ind - 1] == ')') {
                            amount = 1;
                            for (int k = ind - 2; k > -1; k--) {
                                if (GENERAL[k] == ')') amount++;
                                if (GENERAL[k] == '(') amount--;
                                if (amount == 0) {
                                    ind1 = 0;
                                    break;
                                }
                            }
                        }
                        if (ind1 == 0) {
                            kind = "xN";
                        } else kind = "";
                    }////////

                    amount = 1;
                    j = 0;
                    numberBreaks = 0;
                    ind = 0;
                    if (GENERAL[0] == '(') j = 1;
                    for (int i = j; i < GENERAL.length; i++) {
                        if (GENERAL[i] == '(') {
                            numberBreaks = i;
                            break;
                        }
                    }
                    if (kind.equals("aX")) {
                        for (int i = j; i < GENERAL.length; i++) {
                            aX_Trigonom_Difficult += GENERAL[i];
                            if (i == numberBreaks) {
                                amount = 1;
                            } else {
                                if (GENERAL[i] == '(') amount++;
                                if (GENERAL[i] == ')') amount--;
                            }
                            if (amount == 0) {
                                aX = i;
                                ind = i;
                                break;
                            }
                        }
                        if (GENERAL.length > ind + 1) {
                            kind = "difficult";
                        } else {
                            aX = 0;
                        }
                    }
                    if (kind.equals("")) {
                        kind = "difficult";
                    }
                }
            }
        }
        return kind;
    }


    public void createTree(String formula) {
        String kind = defineKindFunction(formula);
        System.out.println(formula + " " + kind);

        if (kind.equals("trigonom")) {
            //  System.out.println("ok");
            findingTrigonomDiff(formula);
        }
        if (kind.equals("aX")) {
            findingAX(formula);
        }
        if (kind.equals("xN")) {
            findingXn(formula);
        }
        if (kind.equals("elementary")) {
            findingElementary(formula, 1);
        }
        if (kind.equals("difficult")) {
            char[] GENERAL = formula.toCharArray();
            if (GENERAL[0] == '(') {
                Vector<String> twoExpression = defineBE(formula);
                right = new Tree(twoExpression.get(0));
                right.createTree(twoExpression.get(0));
                left = new Tree(twoExpression.get(1));
                left.createTree(twoExpression.get(1));

            } else {
                if (trigonom != 0) {
                    String expression = "";
                    right = new Tree(aX_Trigonom_Difficult);
                    right.findingTrigonomDiff(aX_Trigonom_Difficult);
                    int begin2 = trigonom + 2;
                    int end2 = GENERAL.length;
                    if (GENERAL.length >= trigonom + 3) {
                        if (GENERAL[trigonom + 2] == '(') {
                            begin2 = trigonom + 3;
                            end2 = GENERAL.length - 1;
                        }
                    }
                    for (int i = begin2; i < end2; i++) {
                        expression += GENERAL[i];
                    }
                    left = new Tree(expression);
                    left.createTree(expression);
                } else if (aX != 0) {
                    String expression = "";
                    right = new Tree(aX_Trigonom_Difficult);
                    right.findingAX(aX_Trigonom_Difficult);
                    int begin2 = aX + 2;
                    int end2 = GENERAL.length;
                    if (GENERAL.length >= aX + 2) {
                        if (GENERAL[aX + 2] == '(') {
                            begin2 = 3;
                            end2 = GENERAL.length - 1;
                        }
                    }
                    for (int i = begin2; i < end2; i++) {
                        expression += GENERAL[i];
                    }
                    left = new Tree(expression);
                    left.createTree(expression);
                } else {
                    boolean difWithoutTrigonom = false;
                    int ind = 0;
                    int amount = 0;
                    for (int i = 0; i < GENERAL.length; i++) {
                        if (GENERAL[i] == '(') {
                            difWithoutTrigonom = true;
                            ind = i;
                            amount = 1;
                            break;
                        }
                    }
                    int end = 0;
                    for (int i = ind + 1; i < GENERAL.length; i++) {
                        if (GENERAL[i] == '(') amount++;
                        if (GENERAL[i] == ')') amount--;
                        if (amount == 0) {
                            end = i;
                            break;
                        }
                    }
                    if (GENERAL.length > end + 1) {
                        difWithoutTrigonom = false;
                    }
                    if (difWithoutTrigonom) {
                        String expression = "";
                        int index = 0;
                        for (int i = 0; i < GENERAL.length; i++) {
                            if (GENERAL[i] == '*' || GENERAL[i] == '/') {
                                right = new Tree(expression);
                                hash.add(expression, "0");
                                index = i + 1;
                                break;
                            }
                            expression += GENERAL[i];
                        }
                        expression = "";
                        for (int i = index + 1; i < GENERAL.length - 1; i++) {
                            expression += GENERAL[i];
                        }
                       // System.out.println("Exp " + expression);
                        left = new Tree(expression);
                        left.createTree(expression);
                    } else {
                        boolean plus = false;
                        int number = 0;
                        String expression = "";
                        amount = 0;
                        boolean difBeforePlus = false;
                        ind = 0;
                        for (int i = 0; i < GENERAL.length; i++) {
                            if (GENERAL[i] == '(') {
                                difBeforePlus = true;
                                expression += GENERAL[i];
                                amount = 1;
                                ind = i;
                                break;
                            }
                            expression += GENERAL[i];
                        }
                        if (difBeforePlus) {
                            for (int i = ind + 1; i < GENERAL.length; i++) {
                                if (GENERAL[i] == '(') amount++;
                                if (GENERAL[i] == ')') amount--;
                                expression += GENERAL[i];
                                if (amount == 0) {
                                    ind = i;
                                    break;
                                }
                            }
                            right = new Tree(expression);
                            right.createTree(expression);
                            expression = "";
                            for (int i = ind + 2; i < GENERAL.length; i++) {
                                expression += GENERAL[i];
                            }
                            left = new Tree(expression);
                            left.createTree(expression);
                        } else {
                            expression="";
                            for (int i = 0; i < GENERAL.length; i++) {
                                if (GENERAL[i] == '+' || GENERAL[i] == '-') {
                                    plus = true;
                                    number = i + 1;
                                    break;
                                }
                                expression += GENERAL[i];
                            }
                            if (plus) {
                                right = new Tree(expression);
                                right.createTree(expression);

                                int begin2 = number;
                                int end2 = GENERAL.length;
                                if (GENERAL.length > number) {
                                    if (GENERAL[number] == '(') {
                                        begin2++;
                                        end2--;
                                    }
                                }
                                expression = "";
                                for (int i = begin2; i < end2; i++) {
                                    expression += GENERAL[i];
                                }
                                left = new Tree(expression);
                                left.createTree(expression);
                                //  System.out.println(expression);

                            } else {
                                expression = "";
                                for (int i = 0; i < GENERAL.length; i++) {
                                    if (GENERAL[i] == '*' || GENERAL[i] == '/') {
                                        number = i + 1;
                                        break;
                                    }
                                    expression += GENERAL[i];
                                }
                                right = new Tree(expression);
                                right.createTree(expression);
                                //System.out.println(expression);

                                int begin2 = number;
                                int end2 = GENERAL.length;
                                if (GENERAL.length > number) {
                                    if (GENERAL[number] == '(') {
                                        begin2++;
                                        end2--;
                                    }
                                }
                                expression = "";
                                for (int i = begin2; i < end2; i++) {
                                    expression += GENERAL[i];
                                }
                                left = new Tree(expression);
                                left.createTree(expression);
                                // System.out.println(expression);

                            }
                        }
                    }
                }
            }
        }
    }


    private  String multiply(String x,String y,String x1,String y1){
        String resDiff;
        StandartFormul formul = new StandartFormul();
        resDiff= formul.multi(x,y,x1,y1);
        return resDiff;
    }

    private String summa(String x,String y){
        String resDiff;
        StandartFormul formul = new StandartFormul();
        resDiff = formul.sum(x, y);
        return  resDiff;
    }

    private String minus(String x,String y){
        String resDiff;
        StandartFormul formul = new StandartFormul();
        resDiff= formul.minus(x,y);
        return  resDiff;
    }

    private String devision(String x,String y,String x1,String y1){
        String resDiff;
        StandartFormul formul = new StandartFormul();
        resDiff =formul.division(x, y, x1, y1);
        return  resDiff;
    }


    private Vector<String> defineBE(String formula){
        Vector<String> vector = new Vector<String>();
        char [] GENERAL = formula.toCharArray();
        String expression="";
        int begin2;
            int amount=1;
            int ind=0;
            for(int i=1;i<GENERAL.length;i++){
                if(GENERAL[i]=='(')amount++;
                if(GENERAL[i]==')')amount--;
                if(amount==0){
                    ind =i;
                    break;
                }
                expression+=GENERAL[i];
            }
            begin2=ind+2;
        int end2=GENERAL.length;
        if(GENERAL.length>=ind+2) {
            if (GENERAL[ind + 2] == '(') {
                begin2 = ind + 3;
                end2 = GENERAL.length - 1;
            }
        }
            vector.add(0,expression);
            expression="";
            for(int i=begin2;i<end2;i++){
                 expression+=GENERAL[i];
            }
            vector.add(1,expression);
        return vector;
    }

    private String multiDiff(Tree tree,String genFormula,String formula1,String formula2, String difFL, String difFR){
       String tmpFormula = genFormula;
        String result="";
       // System.out.println(genFormula);
        int index = formula1.length();
        char[] chTmp = tmpFormula.toCharArray();
        if(chTmp[0]=='('){
            index=index+2;
        }
          if(chTmp[index]=='*'){
             result = multiply(formula1,formula2,difFL,difFR);
         }
            if(chTmp[index]=='/'){
                System.out.println(formula2);
                result = devision(formula1,formula2,difFL,difFR);
            }
            if(chTmp[index]=='+'){
                result = summa(difFL,difFR);
            }
            if(chTmp[index]=='-'){
                result = minus(difFL,difFR);
            }
        hash.add(genFormula,result);
        return result;
    }

    public String diffTrigDiff(String formula,Tree tree){
        String function = hash.getDiff(tree.getLeft().getFormula());
        String x = "(" + tree.getRight().getFormula() + ")";
        function = function.replaceFirst("x", x);
        function = function + "*" + hash.getDiff(tree.getRight().getFormula());
        return function;
    }

  private void diff(String formula, Tree tree){
    String kind = defineKindFunction(formula);
     // System.out.println(formula+" "+kind);
      if (kind.equals("koef")) {
          hash.add(formula, "0");
      }
      if(kind.equals("xN")){
          String function = hash.getDiff(tree.getLeft().getFormula());
          String x = "(" + tree.getRight().getFormula() + ")";
          function = function.replaceFirst("x", x);
          function = function + "*" + hash.getDiff(tree.getRight().getFormula());
          hash.add(formula, function);
      }
      if (kind.equals("trigonom")||kind.equals("aX")) {

          char[] chForm = formula.toCharArray();
          boolean flag = false;
          for (int i = 0; i < chForm.length; i++) {
              if (chForm[i] == '+' || chForm[i] == '-' || chForm[i] == '*' || chForm[i] == '/'||chForm[i] == '^') {//может неправильно добавление ^
                  flag = true;
              }
          }
          if (flag) {
              String function = hash.getDiff(tree.getLeft().getFormula());
              String x = "(" + tree.getRight().getFormula() + ")";
              function = function.replaceFirst("x", x);
              function = function + "*" + hash.getDiff(tree.getRight().getFormula());
              hash.add(formula, function);
          }
      }

        if (kind.equals("elementary")) {
            if(findingElementary(formula,0).equals("difficult")){
                String function= diffTrigDiff(formula,tree);
                hash.add(formula, function);
            }
            else {
                hash.add(formula, findingElementary(formula,0));
            }
        }
        if (kind.equals("difficult")) {
            String function= multiDiff(tree,formula,tree.getLeft().getFormula(),tree.getRight().getFormula(),hash.getDiff(tree.getLeft().getFormula()),hash.getDiff(tree.getRight().getFormula()));
            hash.add(formula, function);
      }
  }

    public void diffTree(Tree tree){
        if(tree!=null){
            if (tree.getLeft() != null)diffTree(tree.getLeft());
            if (tree.getRight() != null)diffTree(tree.getRight());
            //System.out.println(tree.getFormula());
          diff(tree.getFormula(), tree);
        }
    }

    public static void main(String[] args) {
        Tree beginTree = new Tree("(x+6+x)^4");
        beginTree.createTree("tg((cos(sin(ln(x+1)))^2)^3))");
        beginTree.diffTree(beginTree);
        System.out.println(beginTree.hash.getDiff("tg((cos(sin(ln(x+1)))^2)^3))"));
    }
}

