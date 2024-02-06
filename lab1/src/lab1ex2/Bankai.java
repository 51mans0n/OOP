package lab1ex2;

public class Bankai {
    private  String zanpakutoName;
    private  String bankaiName;
    private  String bankaiOwner;
    public static int bankaiOwnersCount = 0;
    public static final int COUNT_OF_OWNERS = 1;
    private final BankaiType type;
    {
        bankaiOwnersCount++;
    }
    public Bankai (String bankaiOwner, String zanpakutoName, BankaiType type, String bankaiName) {
        this.bankaiName = bankaiName;
        this.bankaiOwner = bankaiOwner;
        this.type = type;
        this.zanpakutoName = zanpakutoName;
        displayAllData();
    }
    public String getBankaiName() {
        return bankaiName;
    }
    public static int getBankaiOwnerNum(){
        return bankaiOwnersCount;
    }
    public String getBankai(String bankaiName) {
        return bankaiName;
    }
    public BankaiType getBankai(BankaiType type) {
        return type;
    }
    public void displayAllData() {
        System.out.print("Number: ");
        System.out.println(getBankaiOwnerNum());
        System.out.print("Owner: ");
        System.out.println(this.bankaiOwner);
        System.out.print("Name: ");
        System.out.println(this.zanpakutoName);
        System.out.print("Type: ");
        System.out.println(type);
        System.out.print("Bankai: ");
        System.out.println(getBankaiName() + "\n");
        System.out.println(getBankai(type));
        System.out.println(getBankai(bankaiName + "\n"));
    }
}
