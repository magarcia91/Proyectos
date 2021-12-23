package ec.gob.educacion.uploadfiles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ec.gob.educacion.uploadfiles.message.ResponseMessageUploadFiles;

@ControllerAdvice
public class UploadFilesExceptionAdvice extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<ResponseMessageUploadFiles> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageUploadFiles("File too large!"));
	  }
}
