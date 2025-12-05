package tradebot.service;

import tradebot.dto.UserDto;
import tradebot.domain.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
