package model;

import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Person {

     Integer id;
     String firstName;
     String lastName;
     Integer age;
     String gender;
     String email;
     String phone;
     String username;
     String favoriteColor;
     String birthDate;
     String ipv4;
     String ipv6;
}
