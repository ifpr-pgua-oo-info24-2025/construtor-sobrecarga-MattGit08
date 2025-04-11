public class Main {
    public static void main(String[] args) {
        Engine motor = new Engine("Elétrico", 150);
        Driver motorista = new Driver("Julio", 123456789);
        Car carro = new Car("Honda", "Civic", "AYZ2025", motor, motorista);

        System.out.println(carro.toString());

        carro.getDriver().setName("Matheus");

        System.out.println(carro.toString());
    }
}