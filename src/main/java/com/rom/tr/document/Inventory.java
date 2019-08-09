package com.rom.tr.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@Document
@Getter
@Setter
@CompoundIndex(def = "{'restaurantId':1, 'tableNo':1}", name = "c_i_inventory", unique = true)
public class Inventory extends BaseEntity {
    @Id
    private String id;
    @NotBlank
    private String propertyId;
    private String tableNo;
    @Min(1)
    private int size;
    @Min(1)
    @Max(20)
    private int maxSize;
    @NotNull
    private boolean isBooked;
    private Date estimatedWaitingPeriod;
    private Map<String, String> extraInfo;
    private String currentToken;
}
