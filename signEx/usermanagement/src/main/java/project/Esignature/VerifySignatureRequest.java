package project.Esignature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifySignatureRequest {
    private String message;
    private String signature;
    private String publicKey;
}
