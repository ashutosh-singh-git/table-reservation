package com.rom.tr.repository;

import com.rom.tr.document.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
    Inventory findByTableNoAndPropertyId(String tableNo, String propertyId);
}
