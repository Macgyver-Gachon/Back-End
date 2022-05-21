package com.project2022.macgyver.domain.prefer;

import com.project2022.macgyver.domain.prefer.Prefer;
import com.project2022.macgyver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PreferRepository extends JpaRepository<Prefer, Long> {
    //Optional<Prefer> findByUser(User user);

    boolean existsByUser(User user);

    //@Query("SELECT p FROM Prefer p WHERE p.userid=:userid")
    //boolean exist(@Param("id") Long id);

}
