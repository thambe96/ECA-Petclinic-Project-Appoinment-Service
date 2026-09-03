package com.petclinic.appointment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long doctorId;
    private String doctorName;
    private String petId;
    private String petName;
    private String ownerName;
    private LocalDate appointmentDate;
    private String timeSlot;
    private String status; // SCHEDULED, COMPLETED, CANCELLED
    private String reason;
    private String notes;
}
