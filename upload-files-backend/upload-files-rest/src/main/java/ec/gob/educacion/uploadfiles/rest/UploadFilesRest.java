package ec.gob.educacion.uploadfiles.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.common.net.HttpHeaders;

import ec.gob.educacion.uploadfiles.entity.UploadFiles;
import ec.gob.educacion.uploadfiles.message.ResponseMessageUploadFiles;
import ec.gob.educacion.uploadfiles.message.ResponseUploadFiles;
import ec.gob.educacion.uploadfiles.service.UploadFilesService;

@RestController
public class UploadFilesRest {
	
	@Autowired
	  private UploadFilesService uploadfilesService;

	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessageUploadFiles> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    	uploadfilesService.store(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageUploadFiles(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageUploadFiles(message));
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseUploadFiles>> getListFiles() {
	    List<ResponseUploadFiles> files = uploadfilesService.getAllFiles().map(storeFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(storeFile.getId())
	          .toUriString();

	      return new ResponseUploadFiles(
	    	  storeFile.getName(),
	          fileDownloadUri,
	          storeFile.getType(),
	          storeFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Integer id) {
	    UploadFiles files = uploadfilesService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + UploadFiles.getName() + "\"")
	        .body(UploadFiles.getData());
	  }

}
