package com.example.DiningReviewProject.controller;

import java.lang.Iterable;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.DiningReviewProject.model.Users;
import com.example.DiningReviewProject.repository.UsersRepository;

@RequestMapping("/users")
@RestController
public class UsersController {

  private final UsersRepository usersRepository;

  public UsersController(final UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @GetMapping
  public Iterable<Users> getAllUsers() {
    return this.usersRepository.findAll();
  }

  @PostMapping
  public Users CreateNewUsers(@RequestBody Users userBody) {
    validateUsers(userBody);
    
    Users newUsers = this.usersRepository.save(userBody);
    return newUsers;
  }

  @GetMapping("/{username}")
  public Users getUsersByUsername(@PathVariable("username") String username) {
    Optional<Users> optionalExistingUsers = this.usersRepository.findUsersByUsername(username);
    Users existingUsers = optionalExistingUsers.get();

    if (!optionalExistingUsers.isPresent()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    return existingUsers;
  }

  @PutMapping("/{username}")
  public Users updateUsers(@PathVariable("username") String username, @RequestBody Users userBody) {
    Optional<Users> optionalUserToUpdate = this.usersRepository.findUsersByUsername(username);

    if(!optionalUserToUpdate.isPresent()){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    Users userToUpdate = optionalUserToUpdate.get();

    if (userBody.getCity() != null){
      userToUpdate.setCity(userBody.getCity());
    }

    if (userBody.getCity() != null){
      userToUpdate.setCity(userBody.getCity());
    }

    if (userBody.getState() != null){
      userToUpdate.setState(userBody.getState());
    }

    if (userBody.getZipcode() != null){
      userToUpdate.setZipcode(userBody.getZipcode());
    }

    if (userBody.getPeanutAllergy() != null){
      userToUpdate.setPeanutAllergy(userBody.getPeanutAllergy());
    }

    if (userBody.getEggAllergy() != null){
      userToUpdate.setEggAllergy(userBody.getEggAllergy());
    }

    if (userBody.getDairyAllergy() != null){
      userToUpdate.setDairyAllergy(userBody.getDairyAllergy());
    }

    Users updatedUser = this.usersRepository.save(userToUpdate);

    return updatedUser;
    
  }

  public void validateUsers(Users userBody){
    Optional<Users> optionalExistingUsers = this.usersRepository.findUsersByUsername(userBody.getUsername());
    Users existingUsers = optionalExistingUsers.get();

    if (optionalExistingUsers.isPresent()) {
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
  }

}