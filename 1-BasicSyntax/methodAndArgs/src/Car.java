/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
public class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand) {
        this.brand = brand;
        this.model = "xxx";
        this.year = 0;
    }

    public void changeModel(String newModel) {
        this.model = newModel;
        System.out.println(this.model);
    }

    public void changeYear(int newYear) {
        this.year = newYear;
        System.out.println(this.year);
    }

    public String getInfo(){
        return String.format("Brand: %s, Model: %s, Year: %d", brand, model, year);
    }

    public static void main (String[] args) {
        Car bmw = new Car("BMW");
        bmw.changeModel("X37");
        bmw.changeYear(26);
        System.out.println(bmw.getInfo());
    }

}
