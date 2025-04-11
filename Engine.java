public class Engine {
    private String type;
    private Integer potency;

    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Integer getPotency() {
        return this.potency;
    }
    public void setPotency(Integer potency) {
        this.potency = potency;
    }

    public Engine(String type, Integer potency) {
        this.type = type;
        this.potency = potency;
    }

    public String toString() {
        return "Type: " + type + "\n" +
               "Potency: " + potency;
    }
}
