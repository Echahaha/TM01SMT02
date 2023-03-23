import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        GUIRespon content = new GUIRespon();
        frame.setContentPane(content.getTugas());

        content.getMinimize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setExtendedState(frame.getExtendedState()|frame.ICONIFIED);
            }
        });
            frame.setSize(400,300);
            frame.setLocationRelativeTo(null);
            frame.setUndecorated(true);
            frame.pack();
            frame.setVisible(true);
        }

    }

