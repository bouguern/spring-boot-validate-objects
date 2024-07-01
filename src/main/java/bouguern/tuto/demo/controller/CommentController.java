package bouguern.tuto.demo.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bouguern.tuto.demo.dtos.CommentDto;
import bouguern.tuto.demo.exceptions.ResourceNotFoundException;
import bouguern.tuto.demo.services.CommentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping(value = "/create-comment/{postId}")
	public ResponseEntity<String> createComment(@PathVariable Long postId, @RequestBody CommentDto commentDto)
			throws ResourceNotFoundException {

		final String commentMessage = commentService.saveComment(postId, commentDto);

		return ResponseEntity.accepted().body(commentMessage);
	}

}
