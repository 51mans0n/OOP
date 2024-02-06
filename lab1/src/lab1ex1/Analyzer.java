package lab1ex1;
import java.util.Scanner;
public class Analyzer {
    Scanner scan = new Scanner(System.in);
    public Data data;
    public void inputData() {
        while(true) {
            System.out.println("Enter number (Q to quit): ");
            String val = scan.nextLine();
            if(val.equals("Q")){
                System.out.println("Average= " + data.getAverageVal());
                System.out.println("Max = " + data.getMaxVal());
                break;
            }
            else data.addData(Double.parseDouble(val));
        }
    }

    public Analyzer(Data data){
        this.data = data;
    }
    public Analyzer() {

    }
}
