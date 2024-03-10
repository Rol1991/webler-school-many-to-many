package hu.webler.weblerschoolmanytomany.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoSuchElementException extends RuntimeException{

    private String message;
}
