package com.rom.tr.service;


import com.rom.tr.document.Customer;
import com.rom.tr.document.Inventory;
import com.rom.tr.document.User;
import com.rom.tr.dto.LoginResponse;
import com.rom.tr.dto.ReservationResponse;
import com.rom.tr.dto.WaitingList;

public interface ApiService {

    Inventory addInventory(Inventory inventory);

    ReservationResponse reserveNewTable(Customer customer, String tableNo, String propertyId);

    WaitingList fetchWaitingListForProperty(String propertyId);

    LoginResponse loginUser(String email, String password);

    Void logoutUser(String token);

    User validateUser(String token);
}
