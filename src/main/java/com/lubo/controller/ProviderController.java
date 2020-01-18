package com.lubo.controller;

import com.lubo.pojo.Bill;
import com.lubo.pojo.Data;
import com.lubo.pojo.Provider;
import com.lubo.service.BillService;
import com.lubo.service.ProviderService;
import com.lubo.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;
    @Autowired
    private BillService billService;
    @RequestMapping(value = "/providerlist",method = RequestMethod.GET)
    public String providerlist(HttpSession session){
        System.out.println("全查询");
        PageUtil<Provider> pageUtil=providerService.findAllByPage(1);
        List<Provider> proList=pageUtil.getLists();
        session.setAttribute("totalCount",providerService.findAll().size());
        session.setAttribute("pageIndex",1);
        session.setAttribute("maxPage",pageUtil.getMaxPage());
        session.setAttribute("proList",proList);
        return "pro/providerlist";
    }
    @RequestMapping(value = "/providerSearch",method = RequestMethod.GET)
    public String providersearch(HttpSession session, @RequestParam(required = false)String proName,@RequestParam(required = false)String proCode,@RequestParam(required = false) Integer pageNo){
        if(pageNo==1){
            session.removeAttribute("proCode");
            session.removeAttribute("proName");
            Provider provider=new Provider();
            provider.setProCode(proCode);
            provider.setProName(proName);
            PageUtil<Provider>  pageUtil=providerService.findBySome(provider,pageNo);
            session.setAttribute("totalCount",providerService.findBy(proCode,proName).size());
            session.setAttribute("pageIndex",1);
            session.setAttribute("maxPage",pageUtil.getMaxPage());
            session.setAttribute("proList",pageUtil.getLists());
            session.setAttribute("proCode",proCode);
            session.setAttribute("proName",proName);
        }else{
            System.out.println("查找页:"+pageNo);
            proName=Objects.requireNonNullElse(session.getAttribute("proName"),"").toString();
            proCode=Objects.requireNonNullElse(session.getAttribute("proCode"),"").toString();
            Provider provider=new Provider();
            provider.setProCode(proCode);
            provider.setProName(proName);
            PageUtil<Provider> pageUtil=providerService.findBySome(provider,pageNo);
            session.setAttribute("proList",pageUtil.getLists());
            session.setAttribute("pageIndex",pageNo);
        }
        return "pro/providerlist";
    }

    @RequestMapping("/provideradd")
    public String providerAdd(){
        return "pro/provideradd";
    }
    @RequestMapping(value = "/provideraddsave",method = RequestMethod.POST)
    public String provideraddsave(Provider provider){
        providerService.addOne(provider);
        return "redirect:/provider/providerlist";
    }

    @RequestMapping("/proview")
    public String proview(HttpSession session,Long proid){
        Provider provider=providerService.selectOne(proid);
        session.setAttribute("provider",provider);
        return "pro/providerview";
    }

    @RequestMapping("/providermodify")
    public String providermodify(HttpSession session,Long proid){
        Provider provider=providerService.selectOne(proid);
        session.setAttribute("provider",provider);
        return "pro/providermodify";
    }
    @RequestMapping(value = "/providermodifysave",method = RequestMethod.POST)
    public String providermodifysave(HttpSession session,Provider provider){
        System.out.println("更新后的provider:"+provider);
        providerService.updateOne(provider);
        System.out.println("更新结束");
        return "redirect:/provider/providerlist";
    }
    @RequestMapping("/delprovider")
    @ResponseBody
    public Object delprovider(Long proid){
        Data data=new Data();
        Provider provider=new Provider();
        provider.setId(proid);
        Bill bill=new Bill();
        bill.setProviderId(proid);
        List<Bill> lists=billService.selectList(bill);
        if(lists.size()!=0){
            data.setDelResult(String.valueOf(lists.size()));
        }else{
            if(providerService.deleteOne(provider)==1){
                data.setDelResult("true");
            }else{
                data.setDelResult("false");
            }
        }
        return data;
    }
}
