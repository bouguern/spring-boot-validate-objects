package bouguern.tuto.demo.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bouguern.tuto.demo.dtos.CommentDto;
import bouguern.tuto.demo.exceptions.ResourceNotFoundException;
import bouguern.tuto.demo.mappers.CommentMapper;
import bouguern.tuto.demo.models.Comment;
import bouguern.tuto.demo.models.Post;
import bouguern.tuto.demo.repository.CommentRepositories;
import bouguern.tuto.demo.repository.PostRepository;
import bouguern.tuto.demo.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final ObjectsValidator<CommentDto> commentValidator;

	private final CommentRepositories commentRepository;

	private final PostRepository postRepository;

	@Transactional
	public String saveComment(Long postId, CommentDto commentDto) throws ResourceNotFoundException {

		//
		commentDto.setCreationDate(LocalDateTime.now());
		commentDto.setLastModifiedDate(LocalDateTime.now());

		var violations = commentValidator.validate(commentDto);

		if (!violations.isEmpty()) {

			return String.join("\n", violations);
		}

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found"));
		
		Comment commentEntity = CommentMapper.toCommentEntity(commentDto);
		commentEntity.setPost(post);
		
		commentRepository.save(commentEntity);
		
		final String commentMessage = "COMMENT Validated and Saved";

		return commentMessage;
	}

}
