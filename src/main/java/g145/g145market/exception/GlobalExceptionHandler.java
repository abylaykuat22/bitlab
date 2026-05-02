package g145.g145market.exception;


import g145.g145market.dto.HttpExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpExceptionResponse> handleHttpMessageNotReadableException(MethodArgumentNotValidException e) {
        Map<String, String> errors = e.getBindingResult().getFieldErrors().stream()
                .collect(LinkedHashMap::new, (map, error) -> {
                    String jsonFieldName = error.getField();
                    map.put(jsonFieldName, error.getDefaultMessage());
                }, LinkedHashMap::putAll);

        return ResponseEntity.badRequest().body(HttpExceptionResponse.builder()
                .status(400)
                .message(errors.toString())
                .exception(e.getClass().getName())
                .build());

    }


    @ExceptionHandler(EmailUniqueException.class)
    public ResponseEntity<HttpExceptionResponse> handleEmailUniqueException(EmailUniqueException e) {
        return ResponseEntity.badRequest().body(
                HttpExceptionResponse.builder()
                        .status(400)
                        .message(e.getMessage())
                        .exception(e.getClass().getName())
                        .build());
    }

    @ExceptionHandler(PhoneNumberUniqueException.class)
    public ResponseEntity<HttpExceptionResponse> handlePhoneNumberUniqueException(PhoneNumberUniqueException e) {
        return ResponseEntity.badRequest().body(
                HttpExceptionResponse.builder()
                        .status(400)
                        .message(e.getMessage())
                        .exception(e.getClass().getName())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpExceptionResponse> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().body(
                HttpExceptionResponse.builder()
                        .status(500)
                        .message("SERVER ERROR")
                        .exception(e.getClass().getName())
                        .build());
    }
    @ExceptionHandler(EnumException.class)
    public ResponseEntity<HttpExceptionResponse> handleEnumException(EnumException e){
        return ResponseEntity.badRequest().body(
                HttpExceptionResponse.builder()
                        .status(400)
                        .message("CHOOSE ONE OF THEM: AVAILABLE/WAITING/NOT_AVAILABLE")
                        .exception(e.getClass().getName())
                        .build());
    }
    @ExceptionHandler(CodeUniqueException.class)
    public ResponseEntity<HttpExceptionResponse> handleCodeUniqueException(CodeUniqueException e) {
        return ResponseEntity.badRequest().body(
                HttpExceptionResponse.builder()
                        .status(400)
                        .message(e.getMessage())
                        .exception(e.getClass().getName())
                        .build());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<HttpExceptionResponse> handleAccessDeniedException(AccessDeniedException e) {
        return ResponseEntity.status(403).body(
                HttpExceptionResponse.builder()
                        .status(403)
                        .message(e.getMessage())
                        .exception(e.getClass().getName())
                        .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<HttpExceptionResponse> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(400).body(
                HttpExceptionResponse.builder()
                        .status(400)
                        .message(e.getMessage())
                        .exception(e.getClass().getName())
                        .build());
    }
}
