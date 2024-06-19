package com.sv.iuh.server;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sv.iuh.entity.LopHoc;

@Service
public class LopHocServerImpl implements LopHocServer {

	private RestTemplate restTemplate;
	private String crmUrl;

	@Autowired
	public LopHocServerImpl(RestTemplate restTemplate,@Value("${lopHoc.rest.url}")  String crmUrl) {
	
		this.restTemplate = restTemplate;
		this.crmUrl = crmUrl;
	}

	@Override
	public List<LopHoc> getALl() {
		ResponseEntity<List<LopHoc>> responseEntity= restTemplate.exchange(crmUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<LopHoc>> () {
				});
		List<LopHoc> list= responseEntity.getBody();
		return list;
	}

	@Override
	public LopHoc getById(int maLopHoc) {
		LopHoc lopHoc= restTemplate.getForObject(crmUrl+"/"+maLopHoc, LopHoc.class);
		return lopHoc;
	}

	@Override
	public void save(LopHoc lopHoc) {
		int maLopHoc=lopHoc.getMaLopHoc();
		if(maLopHoc==0) {
			restTemplate.postForEntity(crmUrl, lopHoc, String.class);
		}else {
			restTemplate.put(crmUrl, lopHoc);
		}
	}

	@Override
	public void delete(int maLopHoc) {
		restTemplate.delete(crmUrl+"/"+maLopHoc);
		
	}
	
	
	

}
