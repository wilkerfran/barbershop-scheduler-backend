package com.barbershop.scheduler.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private LocalDateTime dateTime;
    private String serviceType;
    private String clientName;
    private String employeeName;

    public AppointmentDTO(LocalDateTime dateTime, String serviceType, String clientName, String employeeName) {
        this.dateTime = dateTime;
        this.serviceType = serviceType;
        this.clientName = clientName;
        this.employeeName = employeeName;
    }

    public LocalDateTime getDateTime() { return dateTime; }
    public String getServiceType() { return serviceType; }
    public String getClientName() { return clientName; }
    public String getEmployeeName() { return employeeName; }
}
