package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.repository.UserDocument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class UserServiceHashMap implements UserService{
    private final HashMap<String, UserDocument> usersMap = new HashMap<>();
    @Override
    public UserDocument create(UserDocument userDocument ){
        usersMap.put( userDocument.getId(), userDocument );
        return userDocument;
    }

    @Override
    public Optional<UserDocument> findById(String id )
    {
        return null;
    }

    @Override
    public List<UserDocument> all()
    {
        return new ArrayList<>( usersMap.values() );
    }

    @Override
    public boolean deleteById( String id )
    {
        return usersMap.remove( id ) != null;
    }

    @Override
    public UserDocument update( UserDto userDto, String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            UserDocument userDocument = usersMap.get( id );
            userDocument.update( userDto );
            return userDocument;
        }
        else
        {
            return null;
        }
    }


}
