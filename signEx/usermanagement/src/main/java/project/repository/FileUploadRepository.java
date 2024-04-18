package project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.FileUploadEntity;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadEntity, Long> {


}
