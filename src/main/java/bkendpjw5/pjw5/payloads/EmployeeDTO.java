package bkendpjw5.pjw5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record EmployeeDTO(
        @NotEmpty(message = "devi mettere uno username")
        @Size(min = 2, max = 30, message = "il nome deve contenere da un minimo di 2 caratteri and un massimo di 30")
        String username,

        @NotEmpty(message = "devi mettere un nome")
        @Size(min = 2, max = 30, message = "il nome deve contenere da un minimo di 2 caratteri and un massimo di 30")
        String name,

        @NotEmpty(message = "devi mettere un cognome")
        @Size(min = 2, max = 30, message = "il nome deve contenere da un minimo di 2 caratteri and un massimo di 30")
        String surname,

        @NotEmpty(message = "devi mettere un email")
        @Email(message = "L'email inserita non è valida")
        String email) {
}