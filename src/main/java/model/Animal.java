package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Animal {
    private String name;
    private String breed;
    private Boolean tail;
    private Integer age;

}
