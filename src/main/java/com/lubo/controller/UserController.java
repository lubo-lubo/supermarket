package com.lubo.controller;

import com.lubo.pojo.Data;
import com.lubo.pojo.Role;
import com.lubo.pojo.User;
import com.lubo.service.RoleService;
import com.lubo.service.UserService;
import com.lubo.service.VuserService;
import com.lubo.util.PageUtil;
import com.lubo.vo.Vuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private VuserService vuserService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/user/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/user/dologin",method = RequestMethod.POST)
    public String dologin(HttpSession session,String userCode,String password){
        User u=userService.login(userCode);
        if(u!=null&&u.getUserPassword().equals(password)){
            session.setAttribute("user",u);
            session.removeAttribute("error");//移出错误信息
            return "redirect:/frame";
        }else if(u!=null&&!u.getUserPassword().equals(password)){
            session.setAttribute("error","密码输入错误");
        }else{
            session.setAttribute("error","用户不存在");
        }
        return "redirect:/user/login";
    }
    @RequestMapping("/user/pwdmodify")
    public String pwdmodify(){
        return "user/pwdmodify";
    }
    @RequestMapping(value = "/user/checkpwd",method = RequestMethod.GET)
    @ResponseBody
    public Object checkpwd(HttpSession session,String oldpassword){
        System.out.println("检测输入原密码");
        Data data=new Data();
        User user=(User)session.getAttribute("user");
        if(user==null){
            data.setResult("sessionerror");
        }else if(oldpassword==null||"".equals(oldpassword)){
            data.setResult("error");
        }else if(!oldpassword.equals(user.getUserPassword())){
            data.setResult("false");
        }else{
            data.setResult("true");
        }
        return data;
    }
    @RequestMapping("/frame")
    public String frame(){
        return "frame";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/user/login";
    }
    @RequestMapping("/user/savepwdmodify")
    public String savemodify(HttpSession session,String rnewpassword){
        User user=(User)session.getAttribute("user");
        user.setUserPassword(rnewpassword);
        userService.updateOne(user);
        System.out.println("密码修改完毕");
        return "redirect: /user/login";
    }
    @RequestMapping("/user/userlist")
    public String userlist(HttpSession session){
        PageUtil<Vuser> pageUtil=vuserService.findAllByPage(1);
        System.out.println(pageUtil.getLists());
        session.setAttribute("roleList",roleService.findAll());
        session.setAttribute("userList",pageUtil.getLists());
        session.setAttribute("maxPage",pageUtil.getMaxPage());
        session.setAttribute("pageNo",pageUtil.getPageNo());
        session.setAttribute("totalCount",vuserService.findAll().size());
        return "user/userlist";
    }
    @RequestMapping("/user/search")
    public String search(HttpSession session,@RequestParam Integer pageNo,@RequestParam(required = false) String userName,@RequestParam(required = false) Long userRole){
        if(pageNo==1){
            System.out.println("条件查询");
            session.removeAttribute("userName");
            session.removeAttribute("userRole");
            PageUtil<Vuser> pageUtil=vuserService.findBy(userName,userRole,pageNo);
            session.setAttribute("userList",pageUtil.getLists());
            session.setAttribute("maxPage",pageUtil.getMaxPage());
            session.setAttribute("totalCount",pageUtil.getTotalCount());
            session.setAttribute("pageNo",pageUtil.getPageNo());
            session.setAttribute("userName",userName);
            session.setAttribute("userRole",userRole);
        }else{
            userName= Objects.requireNonNullElse(session.getAttribute("userName"),"").toString();
            userRole=Long.valueOf(Objects.requireNonNullElse(session.getAttribute("userRole"),0).toString());
            PageUtil<Vuser> pageUtil=vuserService.findBy(userName,userRole,pageNo);
            session.setAttribute("userList",pageUtil.getLists());
            session.setAttribute("pageNo",pageNo);
        }
        return "user/userlist";
    }
    @RequestMapping("/user/useradd")
    public String useradd(HttpSession session){
        List<Role> roleList=roleService.findAll();
        session.setAttribute("roleList",roleList);
        return "user/useradd";
    }
    @RequestMapping(value = "/user/saveuser",method = RequestMethod.POST)
    public String saveuser(User user){
        userService.saveOne(user);
     return "redirect: /user/userlist";
    }
    @RequestMapping(value = "/user/checkuser")
    @ResponseBody
    public Object checkuser(String userCode){
        Data data=new Data();
        User user=userService.selectOne(userCode);
        if(user!=null){
            data.setResult("exist");
        }
        return data;
    }

    @RequestMapping(value = "/user/viewUser")
    public String viewUser(HttpSession session,Long uid){
        Vuser vuser=vuserService.selectOne(uid);
        session.setAttribute("user",vuser);
        return "user/userview";
    }
    @RequestMapping(value = "/user/modifyUser")
    public String modifyUser(HttpSession session,Long uid){
        Vuser vuser=vuserService.selectOne(uid);
        session.setAttribute("user",vuser);
        return "user/usermodify";
    }
    @RequestMapping(value = "/user/getrolelist")
    @ResponseBody
    public Object getrolelist(){
        List<Role> roleList=roleService.findAll();
        return roleList;
    }
    @RequestMapping(value="/user/modifyusersave",method = RequestMethod.POST)
    public String modifyusersave(User user){
        userService.updateOne(user);
        return "redirect:/user/userlist";
    }

    @RequestMapping(value = "/user/deleteUser")
    @ResponseBody
    public Object deleteUser(HttpSession session,Long uid){
        Data data=new Data();
        User user=userService.getOne(uid);
        User u=(User) session.getAttribute("user");
        System.out.println("当前账户:"+u);
        System.out.println("删除账户:"+user);
        if(user==null){
            data.setDelResult("notexist");
        }else if(u.getId()!=user.getId()){
            if(userService.deleteOne(uid)==1){
                data.setDelResult("true");
            }else{
                data.setDelResult("false");
            }
        }else{
            data.setDelResult("forbidden");
        }
        return data;
    }
}
