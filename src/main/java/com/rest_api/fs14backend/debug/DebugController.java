package com.rest_api.fs14backend.debug;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("testing")
public class DebugController {

  @GetMapping("/")
  public HashMap<String, String> testApi() {
    HashMap<String,String> response =new HashMap<String,String>();
    response.put("message","api is working yes");
    return response;
  }
}
