package SymbolDiff;

import javax.swing.*;
import java.awt.*;

/**
 * Created by anna on 28.02.16.
 */
public class ReadInstruction {
    private JFrame frame;
    private JTextArea textArea1;
    private JPanel panel;
    public ReadInstruction(){
        frame = new JFrame();
        frame.setContentPane(panel);
        panel.setBackground(Color.GREEN);
        frame.setSize(500, 300);
        frame.setVisible(true);
        panel.setBackground(Color.WHITE);
        textArea1.setText(toStringInstruction());
    }

    private String toStringInstruction(){
        String instruction = "1. Если хотите ввести отрицаетльное число, вводите в формате -1*х"+"\n";
        instruction+="2. Экспонента e^(x)"+"\n";
        instruction+="3. Арксинус, арккосинус arcsin(x),arccos(x)"+"\n";
        instruction+="4. Корень sqrt(x)"+"\n";
        instruction+="5. Если хотите ввести сложную функцию, берите ее в скобки. Например:"+"\n";
        instruction+="7 в степени 1+х будет выглядеть так: 7^(1+x)"+"\n";
        instruction+="или ln(sin(x))"+"\n";
        instruction+="или (ln(cos(x)+2*x)*sin(x))+2^x"+"\n";
        instruction+="также если в функции,например, несколько"+"\n"+"знаков * подряд, затем + - "+"\n";
        instruction+="тоже берите в скобки";
        return instruction;
    }

}
