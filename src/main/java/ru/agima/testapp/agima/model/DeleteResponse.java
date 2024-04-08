package ru.agima.testapp.agima.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Ответ сервиса удаления записей")
public class DeleteResponse {

    @SchemaProperty(name = "Количество удалённых записей")
    private Integer count;

}
