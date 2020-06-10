package com.vincent.demo.web.knife4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller 测试功能接口")
@RestController
public class SwaggerController {
	@ApiImplicitParams({@ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "String", paramType = "path", example = "blues")})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "接口返回成功状态"),
			@ApiResponse(code = 500, message = "未知错误，请联系开发人员调试")
	})
	@ApiOperation(value = "Hello 测试接口", notes = "访问此接口，返回hello,测试接口")
	@GetMapping("/hello/{name}")
	public Results<UserVO> hello(@PathVariable String name){
		System.out.println("测试路径参数:" + name);
		UserVO userVO = new UserVO(name, "hello " + name);
		Results<UserVO> results = new Results<UserVO>(200, "SUCCESS", userVO);
		return results;
	}
}
