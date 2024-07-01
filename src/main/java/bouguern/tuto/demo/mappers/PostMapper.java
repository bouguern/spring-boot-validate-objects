package bouguern.tuto.demo.mappers;

import org.springframework.stereotype.Component;

import bouguern.tuto.demo.dtos.PostDto;
import bouguern.tuto.demo.models.Post;

@Component
public class PostMapper {

	public static PostDto toPostDto(Post post) {

		if (post == null)
			return null;

		return PostDto.builder()
				.content(post.getContent())
				.creationDate(post.getCreationDate())
				.lastModifiedDate(post.getCreationDate())
				.comments(CommentMapper.toListCommentDTO(post.getComments()))
				.build();
	}

	public static Post toPostEntity(PostDto postDto) {

		if (postDto == null)
			return null;

		Post postEntity = new Post();
		
		postEntity.setContent(postDto.getContent());
		postEntity.setCreationDate(postDto.getCreationDate());
		postEntity.setLastModifiedDate(postDto.getLastModifiedDate());
		postEntity.setComments(CommentMapper.toListCommentEntity(postDto.getComments()));

		return postEntity;
	}
}
