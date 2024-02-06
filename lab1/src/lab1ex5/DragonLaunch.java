package lab1ex5;
import java.util.Vector;

public class DragonLaunch {
    private Vector<Person> kidnapedPeople = new Vector<Person>();
    public void kidnap(Person person){
        kidnapedPeople.add(person);
    }
    public boolean willDragonEatOrNot(){
        int counter = 0;
        for(Person person : kidnapedPeople){
            if(counter < 0){
                return true;
            }
            if(person.getGender() == Gender.BOY){
                counter++;
            }
            else counter--;
        }
        if(counter != 0){
            return true;
        }
        return false;
    }
}
