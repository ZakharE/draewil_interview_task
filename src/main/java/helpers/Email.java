package helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {
    private final String subject;
    private final String sender;
    private final String content;
}