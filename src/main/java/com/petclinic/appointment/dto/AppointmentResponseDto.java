package com.petclinic.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponseDto {
    private Long id;
    private Long doctorId;
    private String doctorName;
    private String petId;
    private String petName;
    private String ownerName;
    private LocalDate appointmentDate;
    private String timeSlot;
    private String status;
    private String reason;
    private String notes;
}
