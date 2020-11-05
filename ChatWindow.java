package GBJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ChatWindow extends JFrame {

    private JTextField jtfMessage;
    private JButton jbtnSend;
    private JScrollPane jsp;
    private JTextArea jta;
    private String newLine = "\n";

    public ChatWindow() {

        setSize(840, 480);
        setTitle("Chat Box");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);

        jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        JPanel btmPanel = new JPanel(new BorderLayout());
        add(btmPanel, BorderLayout.SOUTH);
        jbtnSend = new JButton("Send");
        btmPanel.add(jbtnSend, BorderLayout.EAST);
        jtfMessage = new JTextField("Enter your message...");
        btmPanel.add(jtfMessage, BorderLayout.CENTER);

        jbtnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtfMessage.getText().trim().isEmpty()) {
                    sendMsg();
                    jtfMessage.grabFocus();
                }
            }
        });
        jtfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtfMessage.getText().trim().isEmpty()) {
                    sendMsg();
                    jtfMessage.grabFocus();
                }
            }
        });
        jtfMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMessage.setText("");
            }
        });
        setVisible(true);
    }

    private void sendMsg() {
        String message = jtfMessage.getText();
        jta.append(message);
        jta.append(newLine);
    }
}
