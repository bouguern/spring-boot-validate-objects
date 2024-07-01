package bouguern.tuto.demo.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bouguern.tuto.demo.dtos.PostDto;
import bouguern.tuto.demo.services.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@PostMapping(value = "/create-post")
	public ResponseEntity<String> createPost(@RequestBody PostDto postDto) {

		final String postMessage = postService.savePost(postDto);

		return ResponseEntity.accepted().body(postMessage);
	}

}
