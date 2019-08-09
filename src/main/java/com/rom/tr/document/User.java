package com.rom.tr.document;

import com.rom.tr.dto.UserType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Document
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    private String id;
    @NotBlank
    private String userName;
    @NotBlank
    private String propertyId;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String mobile;
    private String token;
    private UserType userType;
    private boolean isActive;
}
