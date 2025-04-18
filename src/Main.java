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
                case 0:
                    break;

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
                    showCars(cars);
                    break;

                case 5:
                    menuSwap(scan, cars, engines, drivers);
                    break;
            
                default:
                    System.out.println("Digite uma opção disponível.");;
            }

            System.out.println();
        } while (userChoice != 0);

        scan.close();
    }

    // Display the options in the menu
    public static void showMenu() {
        System.out.println("===== Garagem =====");
        System.out.println("(1) Cadastrar carro");
        System.out.println("(2) Cadastrar motor");
        System.out.println("(3) Cadastrar condutor");
        System.out.println("(4) Listar carros");
        System.out.println("(5) Trocar motor/condutor");
        System.out.println("(0) Sair");
        System.out.print("Digite a opção: ");
    }   

    // Function to build read user informations and create a new car
    public static Car createCar(Scanner scan, ArrayList<Engine> engines, ArrayList<Driver> drivers) {
        String carBrand;
        String carModel;
        String carPlate;
        Engine carEngine; 
        Driver carDriver;
        Car newCar;

        System.out.print("- Marca: ");
        carBrand = scan.next();
        
        System.out.print("- Modelo: ");
        carModel = scan.next();

        System.out.print("- Placa: ");
        carPlate = scan.next();

        carEngine = selectEngine(scan, engines);

        carDriver = selectDriver(scan, drivers);

        if(carDriver == null) {
            newCar = new Car(carBrand, carModel, carPlate, carEngine);
        } else {
            newCar = new Car(carBrand, carModel, carPlate, carEngine, carDriver);     
        }

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

        System.out.print("- Carteira de Motorista (CNH): ");
        driverLicense = scan.nextInt();

        Driver newDriver = new Driver(name, driverLicense);

        return newDriver;
    }

    // Function called to select a engine while creating a car
    public static Engine selectEngine(Scanner scan, ArrayList<Engine> engines) {
        Integer userChoice;

        if(!engines.isEmpty()) {
            System.out.println("- (1) Adicionar motor");

            for (int i = 0; i < engines.size(); i++) {
                System.out.printf("- (%d) Motor %s, %d cv\n", i + 2, engines.get(i).getType(), engines.get(i).getPotency());
            }

            System.out.print("Digite a opção: ");
            userChoice = scan.nextInt();

            if(userChoice == 0) { // Se quiser adicionar motor, então retorna-se um objeto criado na função 'createEngine'
                return createEngine(scan);
            } else { // Senão retorna o motor relacionado com a opção que o usuário escolheu
                return engines.get(userChoice - 1);
            }

        } else {
            System.out.println("Você não possuí nenhum motor cadastrado. Adicione para continuar...");
            engines.add(createEngine(scan));

            return engines.get(0);
        }
    }

    // Function called to select a driver while creating a car
    public static Driver selectDriver(Scanner scan, ArrayList<Driver> drivers) {
        Driver driver;
        Integer userChoice;

        if(drivers.isEmpty()) {
            System.out.println("No momento você não possue nenhum condutor cadastrado...");
        }

        System.out.println("- (0) Continuar sem condutor");
        System.out.println("- (1) Adicionar condutor");
        
        for (int i = 0; i < drivers.size(); i++) {
            System.out.printf("- (%d) %s\n", i + 2, drivers.get(i).getName());
        }

        System.out.print("Digite a opção: ");
        userChoice = scan.nextInt();

        if(userChoice == 0) {
            return null;
        } else if(userChoice == 1) {
            return createDriver(scan);
        } else {
            driver = drivers.get(scan.nextInt() - 1);
            return driver;
        }

    }

    public static void showCars(ArrayList<Car> cars) {
        if(!cars.isEmpty()) {
            for (int i = 0; i < cars.size(); i++) {
                System.out.printf("*** Carro [%d] ***\n", i + 1);
                System.out.println(cars.get(i).toString());

                if(i != cars.size() - 1) { // Último carro na lista
                    System.out.println();
                }
            }
        } else {
            System.out.println("Nenhum carro está cadastrado.");
        }
    }

    public static void menuSwap(Scanner scan, ArrayList<Car> cars, ArrayList<Engine> engines, ArrayList<Driver> drivers) {
        Integer carChoice;
        Integer swapChoice;

        if(!cars.isEmpty()) {
            showCars(cars);
    
            System.out.print("Selecione o carro a alterar: ");
            carChoice = scan.nextInt();
    
            System.out.println("(1) Trocar motor");
            System.out.println("(2) Trocar/adicionar condutor");
    
            System.out.println("Digite a opção: ");
            swapChoice = scan.nextInt();
    
            if(swapChoice == 1) {
                cars.get(carChoice - 1).setEngine(selectEngine(scan, engines));
            } else {
                cars.get(carChoice - 1).setDriver(selectDriver(scan, drivers));
            }
        } else {
            System.out.println("Não é possível alterar um carro, pois, não há carros cadastrados no momento.");
        }

    }
}
