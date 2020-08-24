package com.example.study.repository;

import com.example.study.StudyApplicationTests2;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests2 {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create()
    {
        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
    }

    @Test
    public void read()
    {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-3333");
        //user.getOrderGroupList().stream().forEach(orderGroup ->{

         //   System.out.println("수령인 : "+orderGroup.getRevName());
         //   System.out.println("수령지 : "+orderGroup.getRevAddress());
          //  System.out.println("총금액 : "+orderGroup.getTotalPrice());
          //  System.out.println("총수량 : "+orderGroup.getTotalQuantity());

           //     });
        Assert.assertNotNull(user);
    }

}
