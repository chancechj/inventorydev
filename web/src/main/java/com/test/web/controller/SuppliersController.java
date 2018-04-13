package com.test.web.controller;

import com.test.mysql.entity.Goods;
import com.test.mysql.entity.Suppliers;
import com.test.mysql.model.GoodsQo;
import com.test.mysql.model.SuppliersQo;
import com.test.mysql.repository.GoodsRepository;
import com.test.mysql.repository.SuppliersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SuppliersController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SuppliersRepository suppliersRepository;

    @Value("${securityconfig.urlroles}")
    private String urlroles;

    @RequestMapping("/index")
    public String index(ModelMap model, Principal user) throws Exception{
        Authentication authentication = (Authentication)user;
        List<String> userroles = new ArrayList<>();
        for(GrantedAuthority ga : authentication.getAuthorities()){
            userroles.add(ga.getAuthority());
        }

        boolean newrole=false,editrole=false,deleterole=false;
        if(!StringUtils.isEmpty(urlroles)) {
            String[] resouces = urlroles.split(";");
            for (String resource : resouces) {
                String[] urls = resource.split("=");
                if(urls[0].indexOf("new") > 0){
                    String[] newroles = urls[1].split(",");
                    for(String str : newroles){
                        str = str.trim();
                        if(userroles.contains(str)){
                            newrole = true;
                            break;
                        }
                    }
                }else if(urls[0].indexOf("edit") > 0){
                    String[] editoles = urls[1].split(",");
                    for(String str : editoles){
                        str = str.trim();
                        if(userroles.contains(str)){
                            editrole = true;
                            break;
                        }
                    }
                }else if(urls[0].indexOf("delete") > 0){
                    String[] deleteroles = urls[1].split(",");
                    for(String str : deleteroles){
                        str = str.trim();
                        if(userroles.contains(str)){
                            deleterole = true;
                            break;
                        }
                    }
                }
            }
        }

        model.addAttribute("newrole", newrole);
        model.addAttribute("editrole", editrole);
        model.addAttribute("deleterole", deleterole);
        model.addAttribute("user", user);
        return "suppliers/index";
    }

    @RequestMapping(value="/{suppliersid}")
    public String show(ModelMap model, @PathVariable Long suppliersid, Principal user) {
        Suppliers suppliers = suppliersRepository.findOne(suppliersid);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("user", user);
        return "suppliers/show";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Page<Suppliers> getList(SuppliersQo suppliersQo) {
        try {
            Pageable pageable = new PageRequest(suppliersQo.getPage(), suppliersQo.getSize(), new Sort(Sort.Direction.ASC, "suppliersid"));
            return suppliersRepository.findBySuppliersname(suppliersQo.getSuppliersname()==null?"%":"%"+suppliersQo.getSuppliersname()+"%", pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/new")
    public String create(ModelMap model,Suppliers suppliers){
        return "suppliers/new";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(Suppliers suppliers,Principal user) throws Exception{
//        suppliers.setCreatedate(new Date());
//        suppliers.setCreateman(user.getName());
//        suppliers.setLasteditman(user.getName());
//        suppliers.setLasteditdete(new Date());
        suppliersRepository.save(suppliers);
        logger.info("新增->ID="+suppliers.getSuppliersid());
        return "1";
    }

    @RequestMapping(value="/edit/{suppliersid}")
    public String update(ModelMap model,@PathVariable Long suppliersid,Principal user){
        Suppliers suppliers = suppliersRepository.findOne(suppliersid);
        List<Long> rids = new ArrayList<Long>();

        model.addAttribute("user", user);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("rids", rids);
        return "suppliers/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value="/update")
    @ResponseBody
    public String update(Suppliers suppliers) throws Exception{
        suppliersRepository.save(suppliers);
        logger.info("修改->ID="+suppliers.getSuppliersid());
        return "1";
    }

    @RequestMapping(value="/delete/{suppliersid}",method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable Long suppliersid) throws Exception{
        suppliersRepository.delete(suppliersid);
        logger.info("删除->ID="+suppliersid);
        return "1";
    }

}
