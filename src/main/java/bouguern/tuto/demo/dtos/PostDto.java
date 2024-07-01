package bouguern.tuto.demo.dtos;

import java.time.LocalDateTime;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

	@NotBlank(message = "The content must not be null and must contain at least one non-whitespace character")
	@Size(min = 1, max = 500, message = "content must be at most 500 characters, and has at least one character")
	private String content;

	private LocalDateTime creationDate;

	private LocalDateTime lastModifiedDate;

	private List<CommentDto> comments;

}
