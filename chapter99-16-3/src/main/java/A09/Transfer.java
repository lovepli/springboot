package A09;

import javax.swing.*;

/** ���˻����Ǯ */
public class Transfer implements Runnable {

	private Bank bank;
	private JTextArea textArea;

	public Transfer(Bank bank, JTextArea textArea) {
		this.bank = bank;
		this.textArea = textArea;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			bank.deposit(10); // ÿ�����˻������10Ԫ
			textArea.setText(textArea.getText() + "�˻�������ǣ�" + bank.getAccount() + "\n");
		}
	}
}