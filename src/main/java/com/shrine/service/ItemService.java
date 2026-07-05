package com.shrine.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shrine.entity.ItemEntity;
import com.shrine.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> findAllItems() {
        return itemRepository.findAll();
    }

    public List<ItemEntity> findActiveItems() {
        return itemRepository.findByActiveTrueOrderBySortOrderAsc();
    }

    public ItemEntity findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void createItem(ItemEntity item) {
        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());
        item.setActive(true);

        itemRepository.save(item);
    }

    public void updateItem(ItemEntity item) {
        item.setUpdatedAt(LocalDateTime.now());

        itemRepository.save(item);
    }

    public void hideItem(Long id) {
        ItemEntity item = itemRepository.findById(id).orElse(null);

        if (item == null) {
            return;
        }

        item.setActive(false);
        item.setUpdatedAt(LocalDateTime.now());

        itemRepository.save(item);
    }
}