import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Engine> engines = new ArrayList<>();
        ArrayList<Driver> drivers = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        int userChoice;

        displayMenu();
        
        for(int i = 0; i < cars.size(); i++) {
            carsInfo(cars.get(i));
        }   

        userChoice = scan.nextInt();

        switch(userChoice) {
            case 1:
                cars.add(addNewCar(scan, engines));
        }

        scan.close();
    }

    public static void displayMenu() {
        System.out.println("\tGaragem\n");
        System.out.println("(1) Adicionar Carros");
        System.out.println("(2) Adicionar Motores");
        System.out.println("(3) Adicionar Motoristas");
        System.out.println("(4) Listar Dados da Garagem");
        System.out.print("Digite a opção: ");
    }

    public static Car addNewCar(Scanner scan, ArrayList<Engine> engines) {
        String brand;
        String model;
        String plate;
        Engine engine;
        Driver driver;

        System.out.print("Marca: ");
        brand = scan.next();
        
        System.out.print("Modelo: ");
        model = scan.next();

        System.out.print("Placa: ");
        plate = scan.next();

        System.out.print("Motor: ");
        showEngines(engines);
        

        Car newCar = new Car(brand, model, plate, null, null);
        
        return newCar;
    }   

    public static void carsInfo(Car car) {
        System.out.println(car.getBrand());
        System.out.println(car.getModel());
        System.out.println(car.getPlate());

        enginesInfo(car.getEngine());

        if(car.getDriver() != null) {
            driversInfo(car.getDriver());
        }
    }
    public static void enginesInfo(Engine engine) {
        System.out.println(engine.getType());
        System.out.println(engine.getPotency());
    }

    public static void driversInfo(Driver driver) {
        System.out.println(driver.getName());
        System.out.println(driver.getDriverLicense());
    }   

    public static void showEngines(ArrayList<Engine> engines) {
        for(int i = 0; i < engines.size(); i++) {
            System.out.printf("(%d) %s, %d", i + 1, engines.get(i).getType(), engines.get(i).getPotency());
        }
    }
}
