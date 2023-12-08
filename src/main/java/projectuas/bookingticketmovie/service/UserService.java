package projectuas.bookingticketmovie.service;

import projectuas.bookingticketmovie.dto.UserDto;
import projectuas.bookingticketmovie.data.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
