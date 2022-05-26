package hu.progmatic.model;

public class Cargo {
    private String date;
    private String source;
    private String destination;
    private String type;
    private int value;

    public Cargo() {
    }

    public Cargo(String date, String source, String destination, String type, int value) {
        this.date = date;
        this.source = source;
        this.destination = destination;
        this.type = type;
        this.value = value;
    }

    public Cargo(String csvLine) {
        String[] values = csvLine.split(";");
        this.date = values[0];
        this.source = values[1];
        this.destination = values[2];
        this.type = values[3];
        this.value = Integer.parseInt(values[4]);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getGrossValue() {
        return value + getTax();
    }

    public int getTax() {
        if (!type.equals("Élelmiszer")) {
            return (int) Math.round(value * 0.1);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "date='" + date + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
