package bouguern.tuto.demo.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bouguern.tuto.demo.dtos.PostDto;
import bouguern.tuto.demo.mappers.PostMapper;
import bouguern.tuto.demo.repository.PostRepository;
import bouguern.tuto.demo.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	private final ObjectsValidator<PostDto> postValidator;

	@Override
	@Transactional
	public String savePost(PostDto postDto) {

		postDto.setCreationDate(LocalDateTime.now());
		postDto.setLastModifiedDate(LocalDateTime.now());

		var violations = postValidator.validate(postDto);

		if (!violations.isEmpty()) {

			return String.join("\n", violations);
		}

		postRepository.save(PostMapper.toPostEntity(postDto));

		final String commentMessage = "POST Validated and Saved";

		return commentMessage;
	}

}
