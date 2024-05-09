package project.models;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Files")
@Component
@ConfigurationProperties(prefix = "file")
public class FileUploadEntity implements Serializable {
    @Id
    @Column(name = "file_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;
    @Column(name = "file_name", length = 255)
    private String name;
    @Column(name = "file_type", length = 255)
    private String type;
    @Column(name = "file_description", length = 255)
    private String description;

    @Lob
    private byte[] file;
    @Column(name = "upload_dir")
    private String uploadDir;


}
