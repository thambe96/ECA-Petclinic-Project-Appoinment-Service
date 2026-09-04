# Appointment Service - Pet Clinic Microservices

## 👤 Student & Project Metadata

- **Student Name**: Oshadha Sankalpa Thambavita
- **Student Number**: 241711043
- **Slack Handle**: Oshadha Thambavita
- **GCP ID**: eca-petclinic-241711043

Microservice managing clinic visit scheduling, doctor-pet links, and appointment status lifecycle for the Pet Clinic application, built with **Spring Boot 3.4.3**, **Spring Data JPA**, **MySQL**, **Lombok**, and **Java 25**.

## Architecture & Features

- **Entity-DTO Pattern**: Strict separation between JPA entity (`Appointment`) and API Data Transfer Objects (`AppointmentRequestDto`, `AppointmentResponseDto`).
- **Lombok Integration**: Uses `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`, and `@Builder` annotations.
- **Status Lifecycle Management**: Supports appointment state transitions (`SCHEDULED`, `COMPLETED`, `CANCELLED`).

## Database & Port

- **Port**: `8083`
- **Database**: MySQL (`localhost:14500/appointmentdb`)

## REST API Endpoints

| Method | Endpoint | Description | Payload / Query |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/appointments` | Get all appointment DTOs | N/A |
| `GET` | `/api/appointments/{id}` | Get appointment DTO by ID | N/A |
| `POST` | `/api/appointments` | Schedule new appointment | `AppointmentRequestDto` JSON |
| `PUT` | `/api/appointments/{id}/status` | Update status | Query param `?status=COMPLETED` |
| `DELETE` | `/api/appointments/{id}` | Delete appointment record | N/A |

## How to Run

```bash
mvn clean spring-boot:run
```
