package bouguern.tuto.demo.services;

import bouguern.tuto.demo.dtos.CommentDto;

import bouguern.tuto.demo.exceptions.ResourceNotFoundException;

public interface CommentService {

	public String saveComment(Long postId, CommentDto commentDto) throws ResourceNotFoundException;

}
