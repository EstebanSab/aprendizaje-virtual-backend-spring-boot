package com.campusVirtual.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.campusVirtual.model.Userdata;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@DataJpaTest
public class UserDataRepositoryTest {

    @Autowired
    private UserDataRepository userDataRepositoryTest;
    
    @AfterEach
    void tearDown() {
        userDataRepositoryTest.deleteAll();
    }

    @BeforeEach
    void setUp(){

        Userdata userdata = new Userdata(
            "ded13",
            "password",
          "jamila",
          "daz",
          "jamila@gmail.com",
          "ROLE_ADMIN"
    );
    userDataRepositoryTest.save(userdata);
        
    }


    
    @Test
    void itShouldCheckWhenStudentEmailExists() {
        // given
       

        // when
        boolean expected = userDataRepositoryTest.existsById("ded13");

        // then
        assertThat(expected).isTrue();
    }

     
    @Test
    void itShouldError() {
        // given
        String email = "jamila@gmail.com";

        // when
        boolean expected = userDataRepositoryTest.existsById(email);

        // then
        assertThat(expected).isFalse();
    }


}

