package com.petclinic.appointment.service;

import com.petclinic.appointment.dto.AppointmentRequestDto;
import com.petclinic.appointment.dto.AppointmentResponseDto;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponseDto> getAllAppointments();
    AppointmentResponseDto getAppointmentById(Long id);
    AppointmentResponseDto createAppointment(AppointmentRequestDto requestDto);
    AppointmentResponseDto updateStatus(Long id, String status);
    void deleteAppointment(Long id);
}
