package com.falcon.falcon.Api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.falcon.falcon.dto.LoginDto;

public interface LoginApi {
	
	@PostMapping("api/v1/signin")
	LoginDto signin(@RequestBody LoginDto loginDto);
}
