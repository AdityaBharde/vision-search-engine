package org.vision.imageservice.client;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.vision.imageservice.dto.MLResponseDto;
import org.springframework.beans.factory.annotation.Value;

@Component
public class MLServiceClient {

    private final RestTemplate restTemplate;

    @Value("${ml.service.url}")
    private String ML_EMBED_URL ;

    public MLServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MLResponseDto getEmbedding(byte[] imageBytes, String filename) {

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", new ByteArrayResource(imageBytes) {
            @Override
            public String getFilename() {
                return filename;
            }
        });

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<MLResponseDto> response =
                restTemplate.postForEntity(
                        ML_EMBED_URL,
                        request,
                        MLResponseDto.class
                );

        return response.getBody();
    }
}
