package cursoSpringBoot.domain;

public record ProductRecordDto(
        Integer serial,
        String name,
        Double price,
        Integer stock,
        String some_colum,
        Images images,
        Integer categoryId
) {
}
