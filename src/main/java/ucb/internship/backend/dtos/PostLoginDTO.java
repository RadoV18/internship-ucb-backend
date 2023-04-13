package ucb.internship.backend.dtos;


import jakarta.validation.constraints.NotNull;

public record PostLoginDTO(
        @NotNull(message = "Email is required")
        String email,
        @NotNull(message = "Password is required")
        String password
)
{
}
