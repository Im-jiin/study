package com.example.study.repository;


import com.example.study.StudyApplicationTests2; // 임시 test class 생성
import com.example.study.model.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests2 {

    @Autowired // 자동주입
    private CategoryRepository categoryRepository;

    @Test
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);

    }

    @Test
    public void read()
    {
        Optional<Category> optionalCategory = categoryRepository.findByType("COMTUPER"); // Optional -> NullpointerException  해결

        optionalCategory.ifPresent(category -> { //null 값이 있는 경우 출력하지 않음
            System.out.println(category.getId());
            System.out.println(category.getType());
            System.out.println(category.getTitle());
        });
    }

    @Test
    public void update()
    {
        Optional<Category> optionalCategory = categoryRepository.findById(1L);
        optionalCategory.ifPresent(category -> { //null 값이 있는 경우 출력하지 않음
            category.setTitle("컴퓨터");
            category.setCreatedAt(LocalDateTime.now());
            category.setUpdatedBy("UPDATE METHOD()");

            categoryRepository.save(category);
        });
    }

    @Test
    public void delete()
    {
        Optional<Category> optionalCategory = categoryRepository.findById(2L);

        optionalCategory.ifPresent(category -> { //null 값이 있는 경우 출력 하지 않음
            categoryRepository.delete(category);
        });

        Optional<Category> deleteCategory = categoryRepository.findById(2L);

        if(deleteCategory.isPresent()){
            System.out.println("데이터 존재 : " +deleteCategory.get());
        }else{
            System.out.println("데이터 삭제 없음");
        }
    }
}
