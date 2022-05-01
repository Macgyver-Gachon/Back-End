package com.project2022.macgyver.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
    /*
    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    LocalDate create_date = LocalDate.now();

    @Test
    public void 회원가입_테스트() {
        //given
        String user_id = "user1";
        String user_pwd = "1234";

        userRepository.save(User.builder()
                .user_id(user_id)
                .user_pwd(user_pwd)
                .user_name("홍길동")
                .tel("01012345678")
                .sex("M")
                .birth("20000101")
                .alert(0)
                .date(create_date)
                .role(Role.USER)
                .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getUser_id()).isEqualTo(user_id);
        assertThat(user.getUser_pwd()).isEqualTo(user_pwd);
    }

     */

}
