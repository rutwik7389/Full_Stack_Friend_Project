package com.example.crudf.controller;

import com.example.crudf.model.Friend;
import com.example.crudf.exception.ResourceNotFoundException; // Ensure this import is present

import com.example.crudf.repository.FriendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api/friends")


public class FriendController {
	
	 @Autowired
	    private FriendRepository friendRepository;

	    @GetMapping("/friends")
	    public List<Friend> getAllFriends() {
	        return friendRepository.findAll();
	    }
	    
	    @PostMapping("/friends")
	    public Friend createFriend(@RequestBody Friend friend) {
	    	return  friendRepository.save(friend);
	    }
	    
	    @GetMapping("/friends/{id}")
	    public ResponseEntity<Friend> getFriendById(@PathVariable Long id) {
	    	
	Friend friend = friendRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Friend does not exist with id"+id)); 	
	    	
	    	return ResponseEntity.ok(friend);
	    }
	    
	    @PutMapping("/friends/{id}")
	    public ResponseEntity<Friend> updateFriend(@PathVariable Long id, @RequestBody Friend friendDetails){
	    	Friend friend = friendRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Friend does not exist with id"+id));
	    	
	    	friend.setFirstName(friendDetails.getFirstName());
	    	friend.setLastName(friendDetails.getLastName());
	    	friend.setHabit(friendDetails.getHabit());
	    	friendRepository.save(friend);
	    	return ResponseEntity.ok(friend);
	    }
	    
	    @DeleteMapping("/friends/{id}")
	    public ResponseEntity<Map<String, Boolean>> deleteFriend(@PathVariable Long id) {
	    	
	    	Friend friend = friendRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Friend does not exist with id"+id));
	    	friendRepository.delete(friend);
	    	
	    	Map<String, Boolean>response=new HashMap<String, Boolean>();
	    	response.put("deleted", Boolean.TRUE);
	    	return ResponseEntity.ok(response);
	    	
	    	
	    }
	    
	    
	    
	

}
