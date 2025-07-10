package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateUserModel {
    private Integer id;
    private String name;
    private String job;
}
