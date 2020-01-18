package com.lubo.controller;

import com.lubo.pojo.Bill;
import com.lubo.pojo.Data;
import com.lubo.pojo.Provider;
import com.lubo.service.BillService;
import com.lubo.service.ProviderService;
import com.lubo.service.VbillService;
import com.lubo.util.PageUtil;
import com.lubo.vo.Vbill;
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
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private VbillService vbillService;
    @Autowired
    private BillService billService;
    @Autowired
    private ProviderService providerService;
    //首次登录界面，全查询
    @RequestMapping("/billlist")
    public String billlist(HttpSession session){
        List<Provider> plist=providerService.findAll();
        PageUtil pu=vbillService.findAllByPage(1);
        session.setAttribute("plist",plist);
        session.setAttribute("blist",pu.getLists());
        session.setAttribute("totalCount",pu.getTotalCount());//总条目数
        session.setAttribute("pageIndex",pu.getPageNo());//页码数
        session.setAttribute("maxPage",pu.getMaxPage());//最大页码数
        return "bill/billlist";
    }
    //任意跳转，转到该控制器重新查询，设置session
    @RequestMapping("/search")
    public String search(HttpSession session, @RequestParam(required = false) String productName,@RequestParam(required = false) Long providerId,@RequestParam(required = false) Long isPayment,@RequestParam(required = false)Integer pageNo){
        System.out.println("入参："+productName+","+providerId+","+isPayment+","+pageNo);
        PageUtil pu=new PageUtil();
        if(pageNo==1){
            session.removeAttribute("productName");
            session.removeAttribute("providerId");
            session.removeAttribute("isPayment");
            pu=vbillService.findByPage(productName,providerId,isPayment,pageNo);
        }else{
            productName= Objects.requireNonNullElse(session.getAttribute("producName"),"").toString();
            providerId= (Long) Objects.requireNonNullElse(session.getAttribute("providerId"),0L);
            isPayment= (Long) Objects.requireNonNullElse(session.getAttribute("isPayment"),0L);
            pu=vbillService.findByPage(productName,providerId,isPayment,pageNo);
        }
        session.setAttribute("blist",pu.getLists());
        session.setAttribute("pageIndex",pu.getPageNo());
        session.setAttribute("totalCount",pu.getTotalCount());
        session.setAttribute("maxPage",pu.getMaxPage());
        //System.out.println("查询结束");
        session.setAttribute("productName",productName);
        session.setAttribute("providerId",providerId);
        session.setAttribute("isPayment",isPayment);
        return "bill/billlist";
    }
    @RequestMapping("/addBill")
    public String addBill(){
        return "bill/billadd";
    }
    @RequestMapping("/dobilladd")
    public String doBillAdd(Bill bill){
        billService.addOne(bill);
        System.out.println("添加订单成功");
        return "redirect: /bill/billlist";
    }
    @RequestMapping(value = "/billselect",method = RequestMethod.GET)
    @ResponseBody
    public Object selectBill(){
        System.out.println("供应商全查询");
        List<Provider> list=providerService.findAll();
        return list;
    }
    @RequestMapping("/billview")
    public String billview(HttpSession session,Long billid){
        Vbill vbill=vbillService.findById(billid);
        session.setAttribute("bill",vbill);
        return "bill/billview";
    }
    @RequestMapping("/billmodify")
    public String billmodify(HttpSession session,Long billid){
        Vbill vbill=vbillService.findById(billid);
        session.setAttribute("bill",vbill);
        return "bill/billmodify";
    }
    @RequestMapping("/dobillmodify")
    public String dobillmodify(Bill bill){
        billService.updateOne(bill);
        return "bill/billlist";
    }
    @RequestMapping("/billdelete")
    @ResponseBody
    public Object billdelete(Long billid){
        Data data=billService.deleteOne(billid);
        System.out.println("删除成功");
        return data;
    }
}
