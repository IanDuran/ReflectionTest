@TestInterface(hasAnnotation = true)
public class TestClass {
    private int x;
    private int y;
    private double z;

    public TestClass(int x, int y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public int sum(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public int factorial(int number){
        if(number == 1)
            return number;
        else
            return number * this.factorial(number - 1);
    }
}
