package ec.gob.educacion.uploadfiles.message;

public class ResponseMessageUploadFiles {
	
	  private String message;

	  public ResponseMessageUploadFiles(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

}
