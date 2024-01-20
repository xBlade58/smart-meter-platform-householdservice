package at.fhv.se.platform.adapter.dto;

public class UnassignMeterDTO {
    private String meterId;

    private UnassignMeterDTO() {}

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }
}
