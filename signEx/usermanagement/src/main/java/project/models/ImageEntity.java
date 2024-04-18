package project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Lob
    @Column(name = "pic_Byte",columnDefinition = "bytea")
    byte[] picByte;

    @JsonIgnore
    @OneToOne
    @JoinTable(name="user_image_assoiation")
    private UserEntity userEntity;
}
