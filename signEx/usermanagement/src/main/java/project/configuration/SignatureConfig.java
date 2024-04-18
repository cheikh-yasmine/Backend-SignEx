package project.configuration;

import org.springframework.context.annotation.Bean;
import project.Esignature.CreateSignature;

import java.security.NoSuchAlgorithmException;

public class SignatureConfig {
    @Bean
    public CreateSignature createSignature() throws NoSuchAlgorithmException {
        return new CreateSignature();
    }
}
