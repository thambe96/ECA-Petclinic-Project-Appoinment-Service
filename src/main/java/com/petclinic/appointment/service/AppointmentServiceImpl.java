package com.petclinic.appointment.service;

import com.petclinic.appointment.dto.AppointmentRequestDto;
import com.petclinic.appointment.dto.AppointmentResponseDto;
import com.petclinic.appointment.model.Appointment;
import com.petclinic.appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentResponseDto getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .map(this::mapToResponseDto)
                .orElse(null);
    }

    @Override
    public AppointmentResponseDto createAppointment(AppointmentRequestDto requestDto) {
        Appointment appointment = Appointment.builder()
                .doctorId(requestDto.getDoctorId())
                .doctorName(requestDto.getDoctorName())
                .petId(requestDto.getPetId())
                .petName(requestDto.getPetName())
                .ownerName(requestDto.getOwnerName())
                .appointmentDate(requestDto.getAppointmentDate())
                .timeSlot(requestDto.getTimeSlot())
                .status(requestDto.getStatus() != null ? requestDto.getStatus() : "SCHEDULED")
                .reason(requestDto.getReason())
                .notes(requestDto.getNotes())
                .build();

        Appointment saved = appointmentRepository.save(appointment);
        return mapToResponseDto(saved);
    }

    @Override
    public AppointmentResponseDto updateStatus(Long id, String status) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setStatus(status);
            Appointment saved = appointmentRepository.save(appointment);
            return mapToResponseDto(saved);
        }).orElse(null);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    private AppointmentResponseDto mapToResponseDto(Appointment appointment) {
        return AppointmentResponseDto.builder()
                .id(appointment.getId())
                .doctorId(appointment.getDoctorId())
                .doctorName(appointment.getDoctorName())
                .petId(appointment.getPetId())
                .petName(appointment.getPetName())
                .ownerName(appointment.getOwnerName())
                .appointmentDate(appointment.getAppointmentDate())
                .timeSlot(appointment.getTimeSlot())
                .status(appointment.getStatus())
                .reason(appointment.getReason())
                .notes(appointment.getNotes())
                .build();
    }
}
