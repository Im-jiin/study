package com.example.study.repository;

import com.example.study.StudyApplicationTests2;
import com.example.study.model.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemRepositoryTest extends StudyApplicationTests2 {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create()
    {
        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북 입니다");
        item.setPrice(BigDecimal.valueOf(900000));
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        item.setPartnerId(1L);  // Long -> Partner

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }
}
