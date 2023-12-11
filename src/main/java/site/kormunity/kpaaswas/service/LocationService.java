package site.kormunity.kpaaswas.service;

import site.kormunity.kpaaswas.model.Location;
import site.kormunity.kpaaswas.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final RestTemplate restTemplate;

    @Autowired
    public LocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("locations")
    public List<Location> getAllLocations() {
        String apiUrl = "https://map.seoul.go.kr/smgis/apps/mapsvr.do?cmd=getMapInfo&key=f0efc9079d4c410c8f2e32a233aa94ba"; // API URL

        try {
            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(apiUrl, ApiResponse.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return convertToLocations(response.getBody());
            }
        } catch (HttpClientErrorException e) {
            // 로깅 및 예외 처리
            // 예: 로그 기록, 사용자에게 표시할 오류 메시지 설정 등
        }
        return Collections.emptyList();
    }

    private List<Location> convertToLocations(ApiResponse apiResponse) {
        // API 응답을 Location 객체 리스트로 변환
        return apiResponse.getData().stream()
                .map(data -> new Location(data.getName(), data.getLatitude(), data.getLongitude()))
                .collect(Collectors.toList());
    }
}
