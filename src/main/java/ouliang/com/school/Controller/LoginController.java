package ouliang.com.school.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("login")
    public String login(){
        return "admin/login";
    }


    @PostMapping("User")
    public String user(@RequestParam String name, @RequestParam String password, HttpServletRequest request){
        if (name.equals("40019")&&password.equals("YN40019")) {
            return "admin/user";
        }
        return "redirect:/login";

    }

    @GetMapping("26d9a9b077d03324659ea35c024648a6")
    public String essaySubmit(){
        return "admin/essaySubmit";
    }

    @GetMapping("6a295e846d2532d2248ff5d8a35448f4")
    public String videoSubmit(){
        return "admin/videoSubmit";
    }

    @GetMapping("abf9912304b563dbe8eefa486eeab924")
    public String publicSubmit(){
        return "admin/publicSubmit";
    }

    @GetMapping("85362944cd0681a3e7631af7b5bc9770")
    public String coverLoad(){
        return "admin/coverLoad";
    }

    @GetMapping("d15aa0f48fcbd1338d51013daffbbc15")
    public String coverUptown(){
        return "admin/coverUpDown";
    }
}
