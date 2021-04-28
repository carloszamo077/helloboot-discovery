package com.example.hellobootdiscovery;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CalculatorService {

	private static final Logger log = LoggerFactory.getLogger(CalculatorService.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	private RestTemplate restTemplate;

	public CalculatorService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String add(int n1, int n2) {
		String response = restTemplate.getForObject("http://simplecalculator/add/{n1}/{n2}", String.class, n1, n2);
		log.info("Response:{}", response);
		return response;
	}

	public String scheduler() {
		String response = restTemplate.getForObject("http://service-scheduler/scheduler/monitor", String.class);
		log.info("Scheduler Response:{}", response);
		return response;
	}

	public String getServices() {
		List<String> services = discoveryClient.getServices();
//		discoveryClient.getServices().forEach(id -> {
//            discoveryClient.getInstances(id).forEach(instance -> {
//                logger.info("/hello, host:" + instance.get+ ", service_id:" + instance.getServiceId());
//            });
//        });
		for (String ticketsService : services) {
			log.info(ticketsService);
		}

		return "OK";
	}

}