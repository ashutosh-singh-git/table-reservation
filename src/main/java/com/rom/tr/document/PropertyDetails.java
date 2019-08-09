package com.rom.tr.document;

import com.rom.tr.dto.PropertyType;
import com.rom.tr.dto.UserType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Getter
@Setter
public class PropertyDetails extends BaseEntity {
    @Id
    private String id;
    private String propertyName;
    private String location;
    private String Address;
    private PropertyType propertyType;
    private boolean isActive;
}
