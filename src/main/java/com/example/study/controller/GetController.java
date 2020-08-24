package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //localhost :8080/api/getmethod
    public  String getRequest (){
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //locatlhost:8080/api/getparameter?id=123&password=abcd
    public String getParameter(@RequestParam String id,@RequestParam String password)
    {
        System.out.println("id : " +id);
        System.out.println(("password : " +password));

        return id+password;
    }

    @GetMapping("/getMultiParameter")
   public SearchParam getMeltiParameter(SearchParam searchParam){

        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }

}
