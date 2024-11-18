package com.example.crudf.repository;

import com.example.crudf.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FriendRepository extends JpaRepository<Friend, Long>{

}
