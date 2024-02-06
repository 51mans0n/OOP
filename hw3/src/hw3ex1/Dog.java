package hw3ex1;
public class Dog extends Animal{
    private boolean isAggressive;
    protected Dog(String name, int age, int weight) {
        super(name, age, weight);
    }
    protected Dog(String name, int age, int weight, boolean isAggressive) {
        super(name, age, weight);
        this.isAggressive = isAggressive;
    }
    public void setAggressive(boolean isAggressive) {
        this.isAggressive = isAggressive;
    }
    public String getAggressive() {
        if(isAggressive) {
            return (name) + " агрессивный";
        }
        else return (name) + " не агрессивный";
    }
    public String getAggressive(boolean isAggressive) {
        if (isAggressive) return " агрессивный";
        else return " не агрессивный";
    }

    @Override
    public String getValues() {
        return super.getValues() + getAggressive() + "\n";
    }
}
