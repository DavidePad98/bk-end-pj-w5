package bkendpjw5.pjw5.payloads;

import bkendpjw5.pjw5.entities.Employee;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DeviceDTO(

        @NotEmpty(message = "devi mettere un tipo")
        @Size(min = 2, max = 15, message = "il nome deve contenere da un minimo di 2 caratteri and un massimo di 15")
        String type,

        @NotEmpty(message = "devi mettere uno stato")
        @Size(min = 2, max = 15, message = "il nome deve contenere da un minimo di 2 caratteri and un massimo di 15")
        String status,

        @NotNull(message = "devi mettere un dipendete per assegnare il dispositivo")
//        @Size(min = 1, message = "il nome deve contenere da un minimo di 2 caratteri and un massimo di 15") // <-- @Size funziona solo con stringhe, array ecc
        @Min(value = 1, message = "puoi mettere un valore partendo da 1")
        long employee
) {
}
