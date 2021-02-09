package Lesson4.HW4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatInterface extends JFrame {
    private Chat currentUser;
    private Chat chat;


    public ChatInterface(Chat chat){
        this.chat = chat;
        this.setTitle("Chat");
        this.setSize(500,500);
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(loginJPanel());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Chat chat = new Chat();
        ChatInterface ci = new ChatInterface(chat);

    }

    private JPanel loginJPanel(){
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.white);
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginPanel.setPreferredSize(new Dimension(300,200));
        loginPanel.setBorder(BorderFactory.createTitledBorder("Hello!"));
        JLabel loginLabel = new JLabel("Welcome to chat!");
        loginPanel.add(loginLabel);
        JPanel buttonPanel= new JPanel();
        buttonPanel.setPreferredSize(new Dimension(280,35));
        buttonPanel.setBackground(Color.white);
        JButton button = new JButton("OK");
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUserPanel();
                loginPanel.setVisible(false);
            }
        });

        loginPanel.add(buttonPanel);
        loginPanel.setVisible(true);
        return loginPanel;
    }

    private void createUserPanel(){
        JPanel userPanel = new JPanel();
        userPanel.setBackground(Color.white);
        userPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        userPanel.setPreferredSize(new Dimension(490,490));

        //панель для отображения переписки
        JPanel historyPanel = new JPanel();
        historyPanel.setBackground(Color.white);
        historyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        historyPanel.setPreferredSize(new Dimension(490,350));
        historyPanel.setBorder(BorderFactory.createTitledBorder("Your chat"));

        //создаем  текстовое поле для отображения переписки
        JTextArea historyArea = new JTextArea();

        //односточное текстовое поле для ввода сообщений
        JTextField messageField = new JTextField();
        messageField.setPreferredSize(new Dimension(400,120));
        messageField.setLayout(new FlowLayout(FlowLayout.TRAILING));
        messageField.setBorder(BorderFactory.createTitledBorder("Enter your message..."));

        //кнопка отправить
        JButton sendButton = new JButton("Send");
        sendButton.setLayout(new FlowLayout(FlowLayout.TRAILING));

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    historyArea.setText(currentUser.getChatHistory());

            }
        });

        historyArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(historyArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(480,320));
        historyPanel.add(scroll);
        userPanel.add(historyPanel);
        userPanel.add(messageField);
        userPanel.add(sendButton);
        this.setVisible(true);
        this.add(userPanel);





   }
}
