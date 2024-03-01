package com.stuadvisor.services;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stuadvisor.model.BlogsData;
import com.stuadvisor.model.CollegesData;
import com.stuadvisor.model.CourseData;
import com.stuadvisor.model.TopCollegesData;

@Service
@Scope("prototype")
public class JsonFileReaderService {
	
	public List<CollegesData> readJsonFile(String fileName) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource(fileName);
        if (resource.exists()) {
            return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<CollegesData>>() {});
        } else {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
    }
	
	public List<TopCollegesData> readTopJsonFile(String fileName) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Resource resource = new ClassPathResource(fileName);
		if (resource.exists()) {
			return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<TopCollegesData>>() {});
		} else {
			throw new IllegalArgumentException("File not found: " + fileName);
		}
	}
	public List<CourseData> readCourseJsonFile(String fileName) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Resource resource = new ClassPathResource(fileName);
		if (resource.exists()) {
			return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<CourseData>>() {});
		} else {
			throw new IllegalArgumentException("File not found: " + fileName);
		}
	}
	public List<BlogsData> readBlogsDataJsonFile(String fileName) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Resource resource = new ClassPathResource(fileName);
		if (resource.exists()) {
			return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<BlogsData>>() {});
		} else {
			throw new IllegalArgumentException("File not found: " + fileName);
		}
	}
}
