package cursoSpringBoot.domain;

import jakarta.validation.constraints.NotEmpty;

public record ProductRecordDto(
        Integer serial,

        @NotEmpty(message = "This field must be filled")
        String name,
        Double price,
        Integer stock,
        String some_colum,
        Images images,
        Integer categoryId
) {
}
