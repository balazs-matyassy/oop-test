package hu.progmatic;

import hu.progmatic.model.Cargo;

import java.util.Collection;
import java.util.Iterator;

public class CargoFilter {
    private String dateFrom;
    private String dateTo;
    private String type;

    public CargoFilter() {
    }

    public CargoFilter(String dateFrom, String dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public CargoFilter(String dateFrom, String dateTo, String type) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.type = type;
    }

    public CargoFilter(String line) {
        String[] values = line.split(",");

        if (values.length >= 1 && !values[0].isBlank()) {
            this.dateFrom = values[0].trim();
        } else {
            // ha a felhasználó nem ad meg egy értéket (üres string),
            // akkor null-ra állítjuk az értéket
            this.dateFrom = null;
        }

        if (values.length >= 2 && !values[1].isBlank()) {
            this.dateTo = values[1].trim();
        } else {
            this.dateTo = null;
        }

        if (values.length >= 3 && !values[2].isBlank()) {
            this.type = values[2].trim();
        } else {
            this.type = null;
        }
    }

    public void filter(Collection<Cargo> cargos) {
        Iterator<Cargo> iterator = cargos.iterator();

        while (iterator.hasNext()) {
            Cargo cargo = iterator.next();

            if (dateFrom != null && dateFrom.compareTo(cargo.getDate()) > 0) {
                iterator.remove();
            } else if (dateTo != null && dateTo.compareTo(cargo.getDate()) < 0) {
                iterator.remove();
            } else if (type != null && !type.equals(cargo.getType())) {
                iterator.remove();
            }
        }
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
