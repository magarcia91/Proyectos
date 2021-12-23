package ec.gob.educacion.uploadfiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.uploadfiles.entity.UploadFiles;

public interface UploadFilesRepository extends JpaRepository<UploadFiles, Integer> {

}
