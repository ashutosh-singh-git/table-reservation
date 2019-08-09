package com.rom.tr.document;

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
public class Customer extends BaseEntity {
    @Id
    private String id;
    @NotBlank
    private String propertyId;
    private String customerName;
    @Min(1)
    private int memberCount;
    private Date expectedAvailabilityTime;

}
