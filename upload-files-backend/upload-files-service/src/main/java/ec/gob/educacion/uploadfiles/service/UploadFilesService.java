package ec.gob.educacion.uploadfiles.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import ec.gob.educacion.uploadfiles.entity.UploadFiles;

public interface UploadFilesService {

	  public UploadFiles store(MultipartFile file) throws IOException;
	  public UploadFiles getFile(Integer id);	  
	  public Stream<UploadFiles> getAllFiles();	  
}
