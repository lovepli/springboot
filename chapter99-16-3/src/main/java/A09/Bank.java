package A09;

public class Bank {

    // ʹ��ThreadLocal�������������account������дinitialValue()��������account�ĳ�ʼֵ��Ϊ100
    private static ThreadLocal<Integer> account = ThreadLocal.withInitial(()->100);
    
    public void deposit(int money) {
        account.set(account.get() + money);// ����account��get()��set()����ʵ�ִ�Ǯ
    }
    
    public int getAccount() {// ����˻����
        return account.get();
    }
}
