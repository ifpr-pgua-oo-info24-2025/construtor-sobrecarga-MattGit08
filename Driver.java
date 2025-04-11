public class Driver {
    private String name;
    private int driverLicence;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDriverLicense() {
        return this.driverLicence;
    }
    public void setDriverLicense(int driverLicence) {
        this.driverLicence = driverLicence;
    }

    public Driver(String name, int driverLicence) {
        this.name = name;
        this.driverLicence = driverLicence;
    }

    public String toString() {
        return "Name: " + name + "\n" +
               "Driver License: " + driverLicence;
    }
}
