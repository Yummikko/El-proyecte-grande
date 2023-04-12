package com.codecool.elproyectegrande1.mapper;


import com.codecool.elproyectegrande1.dto.dream.DreamDto;
import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.entity.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DreamMapperTest {

    private final DreamMapper dreamMapper = new DreamMapper();

    @Test
    void shouldMapEntityToDreamDto() {
        Dream dream = new Dream("Test", "test", new ArrayList<>(), new ArrayList<>(), new Image());
        dream.setId(1L);
        dream.setLikes(10);
        dream.setViews(200);

        List<String> hashtags = new ArrayList<>();
        hashtags.add("test");
        hashtags.add("test2");
        dream.setHashtags(hashtags);

        DreamDto actual = dreamMapper.mapEntityToDreamDto(dream);

        Assertions.assertNotNull(actual);

        Assertions.assertEquals(dream.getId(), actual.getId());
        Assertions.assertEquals(dream.getDreamTitle(), actual.getDreamTitle());
        Assertions.assertEquals(dream.getDreamDescription(), actual.getDreamDescription());
        Assertions.assertEquals(dream.getHashtags(), actual.getHashtags());
        Assertions.assertEquals(dream.getImage(), actual.getImage());


    }
}