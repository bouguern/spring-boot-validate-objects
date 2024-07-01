package bouguern.tuto.demo.dtos;

import java.time.LocalDateTime;

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
public class CommentDto {

	@NotBlank(message = "The comment text must not be null and must contain at least one non-whitespace character")
	@Size(min = 1, max = 100, message = "Comment text must be at most 100 characters, and has at least one character")
	private String text;

	private LocalDateTime creationDate;

	private LocalDateTime lastModifiedDate;

}
