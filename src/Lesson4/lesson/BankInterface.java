package Lesson4.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class BankInterface extends JFrame {
    private Account currentAccount;
    private Bank bank;

    public BankInterface(Bank bank){
        this.bank = bank;
        this.setTitle("GB Bank");
        this.setSize(500, 500);
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {

                                   @Override
                                   public void windowClosing(WindowEvent event) {
                                       bank.saveData();
                                       super.windowClosing(event);
                                   }
                               }
        );
        this.add(loginJPanel());
        this.setVisible(true);
    }

    public static void main(String ...args) throws IOException {
        Bank bank = new Bank("clientsMap");
        BankInterface bi = new BankInterface(bank);
    }

    private JPanel loginJPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.white);
        loginPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        loginPanel.setPreferredSize(new Dimension(300, 150));
        loginPanel.setBorder(BorderFactory.createTitledBorder("Authorization"));
        JTextField login = new JTextField("Maria");
        JLabel loginLabel = new JLabel("Your connection identifier : ");
        JLabel passwordLabel = new JLabel("Your password : ");
        JPasswordField password = new JPasswordField("pass");
        login.setPreferredSize(new Dimension(100, 25));
        password.setPreferredSize(new Dimension(100, 25));
        loginPanel.add(loginLabel);
        loginPanel.add(login);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(280, 35));
        buttonPanel.setBackground(Color.WHITE);
        JButton button = new JButton("Submit");
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAccount = bank.getAccount(login.getText(), String.valueOf(password.getPassword()));
                if(currentAccount !=null) {
                    createUserPanel();
                }
                loginPanel.setVisible(false);
            }
        });
        loginPanel.add(buttonPanel);
        loginPanel.setVisible(true);
        return loginPanel;
    }

    private void createUserPanel() {
        JPanel userPanel = new JPanel();
        if(currentAccount != null) {
            // obshaya panel dlya polzovatelya
            userPanel.setBackground(Color.white);
            userPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            userPanel.setPreferredSize(new Dimension(490, 490));
            // informatsiya ob akkaunte
            JLabel userLabel = new JLabel("Account of "+currentAccount.getIdentifiantClient());
            JPanel balancePanel = new JPanel();
            JLabel balanceLabel = new JLabel("Actual balance is "+currentAccount.getBalance());
            balancePanel.add(balanceLabel);
            balancePanel.setPreferredSize(new Dimension(490, 40));
            userPanel.add(userLabel);
            userPanel.add(balancePanel);
            JPanel accountManagement = new JPanel();
            accountManagement.setBackground(Color.white);
            accountManagement.setPreferredSize(new Dimension(220, 100));
            accountManagement.setBorder(BorderFactory.createTitledBorder("Account management"));
            JTextField sum = new JTextField();
            sum.setPreferredSize(new Dimension(150, 25));
            JButton credit = new JButton("Credit");
            JButton debit = new JButton("Debit");
            accountManagement.add(sum);
            accountManagement.add(credit);
            accountManagement.add(debit);
            userPanel.add(accountManagement);
            JPanel historyPanel = new JPanel();
            historyPanel.setBackground(Color.white);
            historyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            historyPanel.setPreferredSize(new Dimension(480, 250));
            historyPanel.setBorder(BorderFactory.createTitledBorder("Your operations"));
            JTextArea historyArea = new JTextArea(currentAccount.getHistory());
            credit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double sumToCredit = 0;
                    try {
                        sumToCredit = Double.parseDouble(sum.getText());
                        currentAccount.credit(sumToCredit);
                        refreshBalanceLabel(balanceLabel);
                        historyArea.setText(currentAccount.getHistory());
                    }
                    catch(NumberFormatException exception){
                        sum.setText("");
                    }
                    catch(NegatifSumException | ImpossibleOperationException exception) {
                        alert(exception.getMessage());
                    }

                }
            });
            debit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double sumToDebit = 0;
                    try {
                        sumToDebit = Double.parseDouble(sum.getText());
                        currentAccount.debit(sumToDebit);
                        refreshBalanceLabel(balanceLabel);
                        historyArea.setText(currentAccount.getHistory());
                    }
                    catch(NumberFormatException | NegatifSumException exception) {
                        sum.setText("");
                    }

                }
            });
            historyArea.setEditable(false);
            JScrollPane scroll= new JScrollPane(historyArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.setPreferredSize(new Dimension(450, 220));
            historyPanel.add(scroll);
            userPanel.add(historyPanel);
            this.setVisible(true);
            this.add(userPanel);
        }
    }

    public void refreshBalanceLabel(JLabel label) {
        label.setText("Actual balance : "+currentAccount.getBalance());
    }

    public static void alert(String message) {
        JOptionPane.showMessageDialog(null, message, "Impossible operation", JOptionPane.ERROR_MESSAGE);
    }
}