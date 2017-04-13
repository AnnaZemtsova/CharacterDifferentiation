package SymbolDiff;

/**
 * Created by anna on 20.02.16.
 */
public class StandartTable{

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String kXn(String formula) {
        if (formula.equals("x")) {
            return "1";
        }
      String[] koefAndPower = formula.split("x");
        String resultDifferencial="";
        int koef=1;
        boolean flag = false;
        Integer pow=1;
        if(koefAndPower.length==2) {
            if(!koefAndPower[0].equals("")) {
                String powBegin = koefAndPower[1].substring(1, koefAndPower[1].length());
                String koefBegin;
                char[] tmp1 = koefAndPower[0].toCharArray();
                if (tmp1[0]=='-'&&tmp1.length==1){
                    koefBegin="-1";
                }
                else koefBegin = koefAndPower[0].substring(0, koefAndPower[0].length()-1);
                if(koefBegin.equals("0")){
                    resultDifferencial = "0";
                    return resultDifferencial;
                }
                char []tmp = powBegin.toCharArray();
                if(tmp[0]=='('){
                    powBegin="";
                  for(int i=tmp.length-1;i>1;i--){
                      powBegin+=tmp[tmp.length-i];
                  }
                }
                char []tmpK = koefBegin.toCharArray();
                if(tmpK[0]=='('){
                    koefBegin="";
                    for(int i=tmpK.length-1;i>1;i--){
                        koefBegin+=tmpK[tmpK.length-i];
                    }
                }
                try {
                    pow = new Integer(powBegin);
                    koef = new Integer(koefBegin);
                    if(pow==0){
                        resultDifferencial+=0;
                        return resultDifferencial;
                    }
                    koef = pow*koef;
                    pow = pow-1;
                    if((pow!=0&&pow!=1)) {
                        if (koef!=0&&koef!=1) {
                            resultDifferencial += koef + "*x^";
                            if(pow<0){
                                resultDifferencial+="("+pow+")";
                            }else resultDifferencial+=pow;
                        }else resultDifferencial +="x";
                    }else  resultDifferencial+=koef+"*x";
                }catch (NumberFormatException e) {
                    System.err.println("Неверный формат строки!");
                }
            }else{
                String powBegin = koefAndPower[1].substring(1, koefAndPower[1].length());
                char []tmp = powBegin.toCharArray();
                if(tmp[0]=='(') {
                    powBegin = "";
                    for (int i = tmp.length - 1; i > 1; i--) {
                        powBegin += tmp[tmp.length - i];
                    }
                }
                try {
                     pow = new Integer(powBegin);
                    if(pow==0) {
                        resultDifferencial += 0;
                        return resultDifferencial;
                    }
                     koef = pow;
                     pow = pow-1;
                }catch (NumberFormatException e) {
                    System.err.println("Неверный формат строки!");
                }
                if((pow!=1&&pow!=0)) {
                    if (koef != 1&& koef!=0) {
                        resultDifferencial += koef + "*x^";
                        if(pow<0){
                            resultDifferencial += "("+pow+")";
                        }else resultDifferencial+=pow;
                    } else resultDifferencial +="x";
                }else  resultDifferencial+=koef+"*x";
            }
            }else {
            String tmp = koefAndPower[0].substring(0,koefAndPower[0].length()-1);
            char []tmpK = tmp.toCharArray();
            if(tmpK[0]=='('){
                tmp="";
                for(int i=tmpK.length-1;i>1;i--){
                   tmp+=tmpK[tmpK.length-i];
                }
            }
            resultDifferencial+=tmp;
        }
        return  resultDifferencial;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public String cos1(String cos){
         boolean flag = false;
         String resultDifferencial="";
         if(cos.equals("cos(x)")){
             resultDifferencial+="-sin(x)";
             return resultDifferencial;
         }else if (cos.equals("-cos(x)")) {
                 resultDifferencial += "sin(x)";
                 return resultDifferencial;
             }else{
             String x="";
             String[] koefInd = cos.split("cos");
             if(koefInd.length==2) {
                 if (!koefInd[0].equals("")) {
                     char[] minus = koefInd[0].toCharArray();
                     if(minus[minus.length-1]=='-'){
                         flag = true;
                         x+='-';
                         koefInd[0]=koefInd[0].substring(0,koefInd[0].length()-2);
                     }else koefInd[0]=koefInd[0].substring(0,koefInd[0].length()-1);
                     char []tmp= koefInd[1].toCharArray();
                     if(tmp[tmp.length-2]!='x') {
                         if(flag){
                             koefInd[1] = koefInd[1].substring(4, koefInd[1].length());
                         }else
                         koefInd[1] = koefInd[1].substring(4, koefInd[1].length());
                         x += koefInd[0] + "x" + koefInd[1];
                     }else{
                         x += koefInd[0] + "*x";
                     }

                 } else {
                    if(flag){
                         koefInd[1] = koefInd[1].substring(4, koefInd[1].length());
                     }else
                     koefInd[1]=koefInd[1].substring(3,koefInd[1].length());
                     x += "x" + koefInd[1];
                 }
             }else{
                 char[] tmp = koefInd[0].toCharArray();
                 if(tmp[tmp.length]=='(') {
                     koefInd[0] = koefInd[0].substring(0, koefInd[0].length() - 1);
                 }
                 x+=koefInd[0]+"*x";
             }
             String difCos = kXn(x);
             difCos= difCos.replace("x","(cos(x))");
             resultDifferencial = difCos+"*sin(x)";
             }
      return resultDifferencial;
     }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public String sin1(String sin){
    boolean flag = false;
    String resultDifferencial="";
    if(sin.equals("sin(x)")){
        resultDifferencial+="cos(x)";
        return resultDifferencial;
    }else if (sin.equals("-sin(x)")) {
        resultDifferencial += "-cos(x)";
        return resultDifferencial;
    }else{
        String x="";
        String[] koefInd = sin.split("sin");
        if(koefInd.length==2) {
            if (!koefInd[0].equals("")) {
                char[] minus = koefInd[0].toCharArray();
                if(minus[minus.length-1]=='-'){
                    flag = true;
                    x+='-';
                    koefInd[0]=koefInd[0].substring(0,koefInd[0].length()-2);
                }else koefInd[0]=koefInd[0].substring(0,koefInd[0].length()-1);
                char []tmp= koefInd[1].toCharArray();
                if(tmp[tmp.length-2]!='x') {
                    if(flag){
                        koefInd[1] = koefInd[1].substring(4, koefInd[1].length());
                    }else
                        koefInd[1] = koefInd[1].substring(4, koefInd[1].length());
                    x += koefInd[0] + "x" + koefInd[1];
                }else{
                    x += koefInd[0] + "*x";
                }

            } else {
                if(flag){
                    koefInd[1] = koefInd[1].substring(4, koefInd[1].length());
                }else
                    koefInd[1]=koefInd[1].substring(3,koefInd[1].length());
                x += "x" + koefInd[1];
            }
        }else{
            char[] tmp = koefInd[0].toCharArray();
            if(tmp[tmp.length]=='(') {
                koefInd[0] = koefInd[0].substring(0, koefInd[0].length() - 1);
            }
            x+=koefInd[0]+"*x";
        }
        String difCos = kXn(x);
        difCos= difCos.replace("x","(sin(x))");
        resultDifferencial = difCos+"*cos(x)";
    }
    return resultDifferencial;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public  String exp1(String exp){
    String resultDifferencial="";
    if(exp.equals("e^x")){
        resultDifferencial="e^x";
        return resultDifferencial;
    }else{
        String[] power = exp.split("e");
        if(!power[0].equals("")){
            char[] koef = power[0].toCharArray();
            for(int i=0;i<power[0].length()-1;i++)
            resultDifferencial+=koef[i];
        }
        if(power.length==2) {
            char[] skobki = power[1].toCharArray();
            int amount=0;
            String innerX ="";
            for(int i=1;i<skobki.length;i++){
                innerX+=skobki[i];
                if(skobki[i]=='(') amount++;
                if(skobki[i]==')') amount--;
                if (amount==0) break;
            }
            char[]inner = innerX.toCharArray();
            innerX="";
            for(int i=1;i<inner.length-1;i++){
                innerX+=inner[i];
            }
            System.out.println(innerX);//innerX - внутренняя функция! НУЖНО ВЫЧИСЛИТЬ ЕЕ ПРОИЗВОДНУЮ
        }
       String tmp = exp.replace("e^x","x");
    }
  return resultDifferencial;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String ln() {
        return "1/x";
}

    public String exp(){
        return "e^(x)";
}

    public String cos(){
        return "(-sin(x))";
}

    public String sin(){
        return "cos(x)";
    }

    public String constant(){
        return "0";
    }

    public String xN(String xN){
        char []x = xN.toCharArray();
        String koefS="";
        String diffRes="";
        int i;
        int end;
        if(xN.equals("x")){
            return "1";
        }
        int ind =2;
            if (x[ind] == '(') {
                i = ind + 1;
                end = x.length - 1;
            } else {
                i = ind;
                end = x.length;
            }
            for (int j = i; j < end; j++) {
                if (x[i] == 'x') {
                    return "Не удалось вычислить дифференциал";
                }
                koefS += x[j];
            }
            Integer power;
            Integer koef;
            try {
                koef = new Integer(koefS);
                power = koef - 1;
                if (koef != 0) {
                    if (power != 1) {
                            diffRes =  koef + "*x^" + power;
                    } else {
                            diffRes = koef + "*x";
                    }
                } else {
                    return "0";
                }
            } catch (NumberFormatException e) {
                return "Неверный формат строки!";
            }
       return diffRes;
    }

    public String aX(String aX){//+учесть, что степеньм может быть с иксами
        char []a = aX.toCharArray();
        String koefS ="";
        String resultString="";
        for(int i=0;i<a.length-2;i++){
          koefS+=a[i];
        }
        Integer koef;
        try {
             koef = new Integer(koefS);
             resultString+=aX+"*ln("+koef+")";
        }catch (NumberFormatException e) {
            return "Неверный формат строки!";
        }
        return resultString;
    }

    public String log(String log){
        char []lg =log.toCharArray();
        String index="";
        String value="";
        String resultString="";
        for(int i=3;i<lg.length;i++){
            if(lg[i]!='('){
                index+=lg[i];
            }else break;
        }
        Integer a;
        try{
            a = new Integer(index);
            resultString+="1/x*ln"+a;
        }catch (NumberFormatException e) {
            return "Неверный формат строки!";
        }
      return resultString;
    }

    public String tg(){
        return "1/(cos(x))^2";
    }

    public String ctg(){
        return "(-1)/(sin(x))^2";
    }

    public String arcsin(){
        return "1/(1-x^2)^1/2";
    }

    public String arccos(){
        return "(-1)/(1-x^2)^1/2";
    }

    public String arctg(){
        return "1/(1+x^2)";
    }

    public String arcctg(){
        return "(-1)/(1+x^2)";
    }

    public String sh(){
        return "ch(x)";
    }

    public String ch(){
        return "sh(x)";
    }

    public String th(){
        return "1/(ch(x))^2";
    }

    public String cth(){
        return "(-1)/(sh(x))^2";
    }

    public String sqrt(){
        return "1/(2*sqrtx)";
    }
    public String devX(){
        return "(-1/x^2)";
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String DIFFERENCIAL(String str){
    char partition[]=str.toCharArray();
    String expression="";
    int f=0;
    boolean flag;
    int[]amount= new int[100];
    for(int i=0;i<str.length();i++) {
        if (partition[i] == '(') {
            expression += "(";
            amount[f] = i;
            f++;
        }
        if (partition[i] == ')') {
            for (int j = amount[f]; j < i; j++) {
                expression += partition[j];
            }
            expression += ')';
            f--;
            flag = true;
        }
    }
        return null;
    }


    public static  void main(String[] args){
        StandartTable table = new StandartTable();
        System.out.println(table.xN("x^(-4)"));
    }
}
