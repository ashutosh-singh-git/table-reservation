package com.rom.tr.service.impl;

import com.rom.tr.document.Customer;
import com.rom.tr.document.Inventory;
import com.rom.tr.document.User;
import com.rom.tr.dto.LoginResponse;
import com.rom.tr.dto.ReservationResponse;
import com.rom.tr.dto.WaitingList;
import com.rom.tr.repository.CustomerRepository;
import com.rom.tr.repository.InventoryRepository;
import com.rom.tr.repository.UserRepository;
import com.rom.tr.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
class ApiServiceImplementation implements ApiService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public ReservationResponse reserveNewTable(Customer customer, String tableNo, String propertyId) {
        Inventory inventory = inventoryRepository.findByTableNoAndPropertyId(tableNo, propertyId);
        if (inventory.isBooked()) {
            return null;
        } else {
            var token = UUID.randomUUID().toString();
            inventory.setBooked(true);
            inventory.setCurrentToken(token);
            inventoryRepository.save(inventory);
            return ReservationResponse.builder()
                    .isReserved(true)
                    .token(token)
                    .build();
        }
    }

    @Override
    public WaitingList fetchWaitingListForProperty(String propertyId) {
        List<Customer> customerList = customerRepository.findAllByPropertyId(propertyId);
        return WaitingList.builder()
                .customerList(customerList)
                .build();
    }

    @Override
    public LoginResponse loginUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid credentials. Password or email is incorrect");
        }else {
            var token = UUID.randomUUID().toString();
            user.setToken(token);
            userRepository.save(user);
            return LoginResponse.builder()
                    .token(token)
                    .uid(user.getId())
                    .build();
        }
    }

    @Override
    public Void logoutUser(String token) {
        User user = userRepository.findByToken(token);
        if (user == null) {
            throw new BadCredentialsException("Invalid request. Token not valid");
        }else {
            user.setToken("");
            userRepository.save(user);
        }
        return null;
    }

    @Override
    public User validateUser(String token) {
        User user = userRepository.findByToken(token);
        if (user == null) {
            throw new BadCredentialsException("Invalid request. Token not valid");
        }
        return user;
    }
}
