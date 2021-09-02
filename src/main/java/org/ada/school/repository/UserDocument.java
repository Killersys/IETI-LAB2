package org.ada.school.repository;

import org.ada.school.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.UUID;

@Document
public class UserDocument
{
    @Id
    String id;
    String name;
    @Indexed (unique = true)
    String email;
    String lastName;
    Date createAdt;
    public UserDocument(){}
    public UserDocument(UserDto userDto){
        id = UUID.randomUUID().toString();
        name = userDto.getName();
        email = userDto.getEmail();
        lastName = userDto.getLastName();}

    public void update(UserDto userDto) {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }

    public String getId() {
        return id;
    }
}
