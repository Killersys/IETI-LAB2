package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService{
    private final UserRepository userRepository;
    public UserServiceMongoDB(@Autowired UserRepository userRepository ){
        this.userRepository = userRepository;}
    @Override
    public UserDocument create(UserDocument userDocument) {
        return userRepository.save(userDocument);}
    @Override
    public Optional<UserDocument> findById(String id ){
        return userRepository.findById(id);}
    @Override
    public List<UserDocument> all(){
        return userRepository.findAll();}
    @Override
    public boolean deleteById( String id ){
        boolean response = false;
        if(userRepository.existsById(id)){ userRepository.deleteById(id); response = true;}
        return response;}
    @Override
    public UserDocument update(UserDto userDto, String id) {
        UserDocument userDocument = null;
        if(userRepository.existsById(id)){userDocument = userRepository.findById(id).get();userDocument.update(userDto);userRepository.save(userDocument);}
        return userDocument;}
}
