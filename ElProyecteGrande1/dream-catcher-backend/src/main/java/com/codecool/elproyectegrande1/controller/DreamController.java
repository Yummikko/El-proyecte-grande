package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.CommentDto;
import com.codecool.elproyectegrande1.dto.DreamDto;
import com.codecool.elproyectegrande1.dto.NewCommentDto;
import com.codecool.elproyectegrande1.dto.NewDreamDto;
import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.payload.response.MessageResponse;
import com.codecool.elproyectegrande1.service.CommentService;
import com.codecool.elproyectegrande1.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dreams")
public class DreamController {

    private final DreamService dreamService;
    private final CommentService commentService;

    @Autowired
    public DreamController(DreamService dreamService, CommentService commentService) {
        this.dreamService = dreamService;
        this.commentService = commentService;
    }

    @PostMapping
    public DreamDto createNewDream(@RequestBody NewDreamDto newDreamDto) {
        return dreamService.addDream(newDreamDto);
    }

    @GetMapping("/{id}")
    public DreamDto getDreamById(@PathVariable("id") Long id) {
        return dreamService.getDreamById(id);
    }


    @PutMapping("/{id}/like")
    public void likeDream(@PathVariable Long id) {
        dreamService.likeDream(id);
    }

    @GetMapping("/most-liked")
    public Dream getDreamWithMostLikes() {
        return dreamService.getDreamWithMostLikes();
    }

    @RolesAllowed({"ROLE_DREAMER", "ROLE_MENTOR", "ROLE_ADMIN"})
    @GetMapping("/most-viewed")
    public Dream getDreamWithMostViews() {
        return dreamService.getDreamWithMostViews();
    }

    @PutMapping("{id}/dream-status/{status}")
    public void updateStatus(@PathVariable Long id, @PathVariable String status) { dreamService.updateDreamStatus(id, status); }

    @GetMapping("/{id}/dream")
    public void viewDream(@PathVariable Long id) {
        dreamService.viewsDream(id);
    }

    @PutMapping("{id}/update-dream/{title}/{description}/{status}")
    public void updateStatus(@PathVariable Long id, @PathVariable String title, @PathVariable String description, @PathVariable String status) {
        dreamService.updateDream(id, title, description, status);
    }

    @GetMapping("/search/{hashtag}")
    public List<DreamDto> searchDreamsByHashtag(@PathVariable String hashtag) {
        return dreamService.searchDreamsByHashtag(hashtag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteDreamById(@PathVariable("id") Long id) {
        dreamService.deleteDreamById(id);
        return ResponseEntity.ok().body(new MessageResponse("Dream deleted successfully!"));
    }

    @PostMapping("/{id}/comment")
    public CommentDto addComment(@RequestBody NewCommentDto newCommentDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return commentService.addComment(newCommentDto, username);
    }
}
