public class Car {
    private String brand;
    private String model;
    private String plate;
    private Engine engine; 
    private Driver driver;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Car(String brand, String model, String plate, Engine engine, Driver driver) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;;
        this.engine = engine;
        this.driver = driver;
    }

    public Car(String brand, String model, String plate, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.engine = engine;
    }

    // (this.attr  == null) ? "" : this.attr; 

    public String toString() {
        return "Brand: " + this.brand + "\n" +
                "Model: " + this.model + "\n" +
                "Plate: " + this.plate + "\n" +
                "Engine type: " + this.engine.getType() + "\n" +
                "Engine potency: " + this.engine.getPotency() + "\n" +
                "Driver name: " + this.driver.getName() + "\n" +
                "Driver License: " + this.driver.getDriverLicense();
        
    }
}