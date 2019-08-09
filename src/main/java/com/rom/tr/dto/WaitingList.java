package com.rom.tr.dto;

import com.rom.tr.document.Customer;
import lombok.Builder;

import java.util.List;

@Builder
public class WaitingList {
    private List<Customer> customerList;
}
