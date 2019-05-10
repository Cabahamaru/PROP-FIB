package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {


    private JPanel MyGUIMain;
    private JButton jugarButton;
    private JButton rankingButton;
    private JButton gestióUsuariButton;
    private JButton gestióProblemaButton;

    public GUIMain() {

        gestióUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame user = frame.getInstance();

                GUIUsuari user1 = new GUIUsuari();

                user.setContentPane(user1.getMyGUIUsuari());
                user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                user.setBounds(500,300,250,250);
                user.setVisible(true);

            }
        });

        gestióProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame prob = frame.getInstance();

                GUIProblema prob1 = new GUIProblema();

                prob.setContentPane(prob1.getMyGUIProblema());
                prob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                prob.setBounds(500,300,250,250);
                prob.setVisible(true);


            }
        });

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    public JPanel getMyGUIMain() {
        return MyGUIMain;
    }
}
