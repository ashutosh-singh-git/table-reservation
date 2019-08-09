package com.rom.tr.controllers;

import com.rom.tr.document.Customer;
import com.rom.tr.document.Inventory;
import com.rom.tr.document.User;
import com.rom.tr.dto.ApiResponse;
import com.rom.tr.dto.LoginResponse;
import com.rom.tr.dto.ReservationResponse;
import com.rom.tr.dto.WaitingList;
import com.rom.tr.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping("/inventory")
    public Inventory addInventory(@RequestBody @Valid Inventory inventoryMono, @RequestHeader String token) {
        apiService.validateUser(token);
        return apiService.addInventory(inventoryMono);
    }

    @PutMapping("/inventory")
    public Inventory editInventory(@RequestBody Inventory inventory, @RequestHeader String token) {
        apiService.validateUser(token);
        return apiService.addInventory(inventory);
    }

    @PostMapping("/reserve")
    public ApiResponse<ReservationResponse> reserveTable(@RequestBody @Valid Customer customer, @RequestParam String tableNo, @RequestHeader String token) {
        User user = apiService.validateUser(token);
        return ApiResponse.<ReservationResponse>builder()
                .data(apiService.reserveNewTable(customer, tableNo, user.getPropertyId()))
                .build();
    }

    @GetMapping("/waiting")
    public ApiResponse<WaitingList> fetchWaitingList(@RequestParam String propertyId, @RequestHeader String token) {
        apiService.validateUser(token);
        return ApiResponse.<WaitingList>builder()
                .isSuccess(true)
                .data(apiService.fetchWaitingListForProperty(propertyId))
                .build();
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestParam String email, @RequestParam String password) {
        return ApiResponse.<LoginResponse>builder()
                .message("Login Successful")
                .isSuccess(true)
                .data(apiService.loginUser(email, password))
                .build();
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestHeader String token) {
        return ApiResponse.<Void>builder()
                .message("Logout Successful")
                .data(apiService.logoutUser(token))
                .isSuccess(true)
                .build();
    }

}
