package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PersonSummary {

     Integer id;
     String firstName;
     String lastName;
     Integer age;
     Date birthDate;

}
