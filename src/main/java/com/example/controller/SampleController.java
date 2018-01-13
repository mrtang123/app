package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.City;
import com.example.domain.HotelSummary;
import com.example.repository.CitySearchCriteria;
import com.example.service.CityService;

@Controller
public class SampleController {

	@Autowired
	private CityService cityService;

	@GetMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		return this.cityService.getCity("Bath", "UK").getName();
	}
	
	@GetMapping("/{cityWithCountryCommaSeprated}")
	@ResponseBody
	@Transactional(readOnly = true)
	public Page<City> findCities(@PathVariable(value="cityWithCountryCommaSeprated") String cityWithCountry) {
		CitySearchCriteria criteria = new CitySearchCriteria(cityWithCountry);
		return this.cityService.findCities(criteria, new PageRequest(0, 10));
	}
	
	@GetMapping("/getHotel")
	@ResponseBody
	@Transactional(readOnly = true)
	public Page<HotelSummary> getHotels() {
		//City city = new City("Brisbane","Australia");
		City city = cityService.getCity("Brisbane", "Australia");
		System.out.println("city: "+ city);
		return this.cityService.getHotels(city, new PageRequest(0, 10));
	}

	@GetMapping("/app")
	public String app() {
		return "app/app";
	}
}
