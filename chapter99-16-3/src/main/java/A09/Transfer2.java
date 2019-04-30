package A09;

import javax.swing.*;
import java.util.concurrent.Callable;

public class Transfer2 implements Callable<Integer> {
    private Bank bank;
    private JTextArea textArea;

    public Transfer2(Bank bank, JTextArea textArea) {// 利用构造方法初始化变量
        this.bank = bank;
        this.textArea = textArea;
    }

    public Integer call() {
        for (int i = 0; i < 10; i++) {// 循环10次向账户中存钱
            bank.deposit(10);
            String text = textArea.getText();
            textArea.setText(text + "账户的余额是：" + bank.getAccount() + "\n");
        }
        return bank.getAccount();// 获得账户的余额
    }
}