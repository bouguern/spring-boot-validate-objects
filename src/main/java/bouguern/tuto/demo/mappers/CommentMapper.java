package bouguern.tuto.demo.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import bouguern.tuto.demo.dtos.CommentDto;
import bouguern.tuto.demo.models.Comment;


@Component
public class CommentMapper {
	
	public static CommentDto toCommentDto(Comment comment) {

		if (comment == null)
			return null;

		return CommentDto.builder()
				.text(comment.getText())
				.creationDate(comment.getCreationDate())
				.lastModifiedDate(comment.getCreationDate())
				.build();
	}
	
	public static Comment toCommentEntity(CommentDto commentDto) {

		if (commentDto == null)
			return null;
		
		Comment commentEntity = new Comment();
		
		commentEntity.setCreationDate(commentDto.getCreationDate());
		commentEntity.setLastModifiedDate(commentDto.getCreationDate());
		commentEntity.setText(commentDto.getText());

		return commentEntity;
	}
	
	public static List<CommentDto> toListCommentDTO(List<Comment> commentEntities) {

		List<CommentDto> list = new ArrayList<CommentDto>();

		if(commentEntities != null) {
			commentEntities.stream().forEach(comment -> {
				list.add(CommentMapper.toCommentDto(comment));
			});
		}

		return list;
	}

	public static List<Comment> toListCommentEntity(List<CommentDto> commentDtos) {

		List<Comment> list = new ArrayList<Comment>();

		if(commentDtos != null) {
			commentDtos.stream().forEach(comment -> {
				list.add(CommentMapper.toCommentEntity(comment));
			});
		}

		return list;
	}

}
