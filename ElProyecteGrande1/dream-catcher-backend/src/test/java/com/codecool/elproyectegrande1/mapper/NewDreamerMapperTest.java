package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.dreamer.DreamerDto;
import com.codecool.elproyectegrande1.dto.dreamer.NewDreamerDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


class NewDreamerMapperTest {

    private final NewDreamerMapper newDreamerMapper = new NewDreamerMapper();

    @Test
    void shouldMapEntityToDreamerDto() {
        Dreamer dreamer = new Dreamer("Test", "test", new User(), new HashSet<>());
        dreamer.setId(1L);
        dreamer.setFollowers(10);

        HashSet<String> letters = new HashSet<>();
        letters.add("letter1");
        letters.add("letter2");
        dreamer.setLetters(letters);

        DreamerDto actual = newDreamerMapper.mapEntityToDreamerDto(dreamer);

        Assertions.assertEquals(dreamer.getId(), actual.getId());
        Assertions.assertEquals(dreamer.getNickname(), actual.getNickname());
        Assertions.assertEquals(dreamer.getEmail(), actual.getEmail());
        Assertions.assertEquals(dreamer.getFollowers(), actual.getFollowers());
        Assertions.assertEquals(dreamer.getUser(), actual.getUser());
        Assertions.assertEquals(dreamer.getLetters(), actual.getLetters());
    }

    @Test
    void shouldMapNewDreamerDtoToEntity() {

        NewDreamerDto newDreamerDto = new NewDreamerDto("test", "test", new User(), new HashSet<>());

        HashSet<String> letters = new HashSet<>();
        letters.add("letter1");
        letters.add("letter2");
        newDreamerDto.setLetters(letters);

        Dreamer actual = newDreamerMapper.mapNewDreamerDtoToEntity(newDreamerDto);

        Assertions.assertEquals(newDreamerDto.getNickname(), actual.getNickname());
        Assertions.assertEquals(newDreamerDto.getEmail(), actual.getEmail());
        Assertions.assertEquals(newDreamerDto.getLetters(), actual.getLetters());

    }


    @Test
    void shouldMapUserToDreamer() {
        User user = new User("Username", "email", "password");

        Dreamer actual = newDreamerMapper.mapUserToDreamer(user);

        Assertions.assertEquals(user.getUsername(), actual.getNickname());
        Assertions.assertEquals(user.getEmail(), actual.getEmail());
    }

}