package com.test.web.controller;

import com.test.mysql.entity.Warehouse;
import com.test.mysql.model.WarehouseQo;
import com.test.mysql.repository.WarehouseRepository;
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
@RequestMapping("/warehouse")
public class WarehouseController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private WarehouseRepository warehouseRepository;

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
        return "warehouse/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Page<Warehouse> getList(WarehouseQo warehouseQo) {
        try {
            Pageable pageable = new PageRequest(warehouseQo.getPage(), warehouseQo.getSize(), new Sort(Sort.Direction.ASC, "storageid"));
            return warehouseRepository.findByStoragename(warehouseQo.getStoragename()==null?"%":"%"+warehouseQo.getStoragename()+"%", pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/new")
    public String create(ModelMap model,Warehouse warehouse){
        return "warehouse/new";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(Warehouse warehouse) throws Exception{
        warehouseRepository.save(warehouse);
        logger.info("新增->ID="+warehouse.getStorageid());
        return "1";
    }

    @RequestMapping(value="/edit/{storageid}")
    public String update(ModelMap model,@PathVariable Long storageid,Principal user){
        Warehouse warehouse = warehouseRepository.findOne(storageid);
        List<Long> rids = new ArrayList<Long>();
        model.addAttribute("user", user);
        model.addAttribute("warehouse",warehouse);
        model.addAttribute("rids", rids);
        return "warehouse/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value="/update")
    @ResponseBody
    public String update(Warehouse warehouse) throws Exception{
        warehouseRepository.save(warehouse);
        logger.info("修改->ID="+warehouse.getStorageid());
        return "1";
    }

    @RequestMapping(value="/delete/{storageid}",method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable Long storageid) throws Exception{
        warehouseRepository.delete(storageid);
        logger.info("删除->ID="+storageid);
        return "1";
    }


}
