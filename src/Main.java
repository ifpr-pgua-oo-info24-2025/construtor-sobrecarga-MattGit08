// Atividade de Matheus Santos da Silva

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Engine> engines = new ArrayList<>();
        ArrayList<Driver> drivers = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        Integer userChoice;

        do {
            showMenu();
            userChoice = scan.nextInt();
            System.out.println();
    
            switch (userChoice) {
                case 1:
                    cars.add(createCar(scan, engines, drivers));
                    break;
                
                case 2:
                    engines.add(createEngine(scan));
                    break;
    
                case 3:
                    drivers.add(createDriver(scan));
                    break;

                case 4:
                    break;
            
                default:
                    System.out.println("Digite uma opção disponível.");;
            }

            System.out.println();
        } while (userChoice != 4);

        scan.close();
    }

    // Display the options in the menu
    public static void showMenu() {
        System.out.println("===== Garagem =====");
        System.out.println("(1) Cadastrar carro");
        System.out.println("(2) Cadastrar motor");
        System.out.println("(3) Cadastrar motorista");
        System.out.println("(4) Sair");
        System.out.print("Digite a opção: ");
    }   

    // Function to build read user informations and create a new car
    public static Car createCar(Scanner scan, ArrayList<Engine> engines, ArrayList<Driver> drivers) {
        String carBrand;
        String carModel;
        String carPlate;
        Engine carEngine; 
        Driver carDriver;

        System.out.print("- Marca: ");
        carBrand = scan.next();
        
        System.out.print("- Modelo: ");
        carModel = scan.next();

        System.out.print("- Placa: ");
        carPlate = scan.next();

        carEngine = selectEngine(scan, engines);

        Car newCar = new Car(carBrand, carModel, carPlate, carEngine);

        return newCar;
    }

    // Function to build read user informations and create a new engine
    public static Engine createEngine(Scanner scan) {
        String type;
        Integer potency;

        System.out.print("- Tipo (ex: gasolina, elétrico, diesel): ");
        type = scan.next();

        System.out.print("- Potência: ");
        potency = scan.nextInt();

        Engine newEngine = new Engine(type, potency);

        return newEngine;
    }

    // Function to build read user informations and create a new driver user
    public static Driver createDriver(Scanner scan) {
        String name;
        Integer driverLicense;

        System.out.print("- Nome: ");
        name = scan.next();

        System.out.print("- Carteira de Motorista CNH: ");
        driverLicense = scan.nextInt();

        Driver newDriver = new Driver(name, driverLicense);

        return newDriver;
    }

    // Function called to select a engine while creating a car
    public static Engine selectEngine(Scanner scan, ArrayList<Engine> engines) {
        Engine engine;

        if(!engines.isEmpty()) {
            for (int i = 0; i < engines.size(); i++) {
                System.out.printf("- (%d) Motor %s, %d cv\n", i + 1, engines.get(i).getType(), engines.get(i).getPotency());
            }

            System.out.print("Digite a opção: ");
            engine = engines.get(scan.nextInt() - 1);
        } else {
            System.out.println("Você não possuí nenhum motor cadastrado. Adicione para continuar...");
            engines.add(createEngine(scan));

            engine = engines.get(0);
        }

        return engine;
    }
}
