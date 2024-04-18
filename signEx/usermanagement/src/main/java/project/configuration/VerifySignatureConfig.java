package project.configuration;

import org.springframework.context.annotation.Bean;
import project.Esignature.VerifySignature;

public class VerifySignatureConfig {
    @Bean
    public VerifySignature verifySignature() {
        return new VerifySignature();
    }
}
