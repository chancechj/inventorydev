package com.test.web.controller;

import com.test.mysql.entity.Goods;
import com.test.mysql.model.GoodsQo;
import com.test.mysql.repository.GoodsRepository;
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
import java.util.*;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private GoodsRepository goodsRepository;

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
        return "goods/index";
    }

    @RequestMapping(value="/{goodid}")
    public String show(ModelMap model,@PathVariable Long goodid,Principal user) {
        Goods good = goodsRepository.findOne(goodid);
        model.addAttribute("good",good);
        model.addAttribute("user", user);
        return "goods/show";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Page<Goods> getList(GoodsQo goodQo) {
        try {
            Pageable pageable = new PageRequest(goodQo.getPage(), goodQo.getSize(), new Sort(Sort.Direction.ASC, "goodid"));
            return goodsRepository.findByGoodname(goodQo.getGoodname()==null?"%":"%"+goodQo.getGoodname()+"%", pageable);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/new")
    public String create(ModelMap model,Goods good){
        return "goods/new";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(Goods good,Principal user) throws Exception{
        good.setCreatedate(new Date());
        good.setCreateman(user.getName());
        good.setLasteditman(user.getName());
        good.setLasteditdete(new Date());
        goodsRepository.save(good);
        logger.info("新增->ID="+good.getGoodid());
        return "1";
    }

    @RequestMapping(value="/edit/{goodid}")
    public String update(ModelMap model,@PathVariable Long goodid,Principal user){
        Goods good = goodsRepository.findOne(goodid);
        List<Long> rids = new ArrayList<Long>();

        model.addAttribute("user", user);
        model.addAttribute("good",good);
        model.addAttribute("rids", rids);
        return "goods/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value="/update")
    @ResponseBody
    public String update(Goods good) throws Exception{
        goodsRepository.save(good);
        logger.info("修改->ID="+good.getGoodid());
        return "1";
    }

    @RequestMapping(value="/delete/{goodid}",method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable Long goodid) throws Exception{
        goodsRepository.delete(goodid);
        logger.info("删除->ID="+goodid);
        return "1";
    }

}
