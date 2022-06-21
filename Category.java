public class Category {

    private String name;
    private double allocated;
    private double spent;

    public Category(String name, double allocated, double spent) {
        this.name = name;
        this.allocated = allocated;
        this.spent = spent;
    }

    public String getName() {
        return name;
    }

    public double getAlloc() {
        return allocated;
    }

    public double getSpent() {
        return spent;
    }

    public void setAlloc(double allocated) {
        this.allocated = allocated;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }
}
