package SymbolDiff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by anna on 28.02.16.
 */
public class DifferencialForm {
    private JFrame frame;
    private JPanel panel;
    private JButton readInstruction;
    private JTextField fieldFunction;
    private JTextArea diffResult;
    private JButton diffButton;

    public DifferencialForm(){
        frame = new JFrame();
        frame.setContentPane(panel);
        frame.setSize(700, 800);
        frame.setVisible(true);
        panel.setBackground(Color.GREEN);

        readInstruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReadInstruction();
            }
        });

        diffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fieldFunction.getText()!=null){
                    Tree tree=  new Tree(fieldFunction.getText());
                    tree.createTree(fieldFunction.getText());
                    tree.diffTree(tree);
                    String difference = tree.getHash().getDiff(fieldFunction.getText());
                    Decrease decrease = new Decrease();
                    decrease.setResult(difference);
                    decrease.decrease(difference);
                    String fullDiff = decrease.getResult();
                    Decrease1 decrease1 = new Decrease1();
                    decrease1.decrease(fullDiff);
                    String endDiff = decrease1.getResult();
                    diffResult.setText(endDiff);
                }

            }
        });
    }

    public static void main(String[]args){
        DifferencialForm differencialForm = new DifferencialForm();
    }
}
