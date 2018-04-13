//package com.test.web.controller;
//
//import com.test.mysql.entity.Goods;
//import com.test.mysql.entity.Storage;
//import com.test.mysql.model.GoodsQo;
//import com.test.mysql.model.StorageQo;
//import com.test.mysql.repository.GoodsRepository;
//import com.test.mysql.repository.StorageRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//@RequestMapping("/storage")
//public class StorageController {
//    private static Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    private StorageRepository storageRepository;
//
//    @Value("${securityconfig.urlroles}")
//    private String urlroles;
//
//    @RequestMapping("/index")
//    public String index(ModelMap model, Principal user) throws Exception {
//        Authentication authentication = (Authentication)user;
//        List<String> userroles = new ArrayList<>();
//        for(GrantedAuthority ga : authentication.getAuthorities()){
//            userroles.add(ga.getAuthority());
//        }
//
//        boolean newrole=false,editrole=false,deleterole=false;
//        if(!StringUtils.isEmpty(urlroles)) {
//            String[] resouces = urlroles.split(";");
//            for (String resource : resouces) {
//                String[] urls = resource.split("=");
//                if(urls[0].indexOf("new") > 0){
//                    String[] newroles = urls[1].split(",");
//                    for(String str : newroles){
//                        str = str.trim();
//                        if(userroles.contains(str)){
//                            newrole = true;
//                            break;
//                        }
//                    }
//                }else if(urls[0].indexOf("edit") > 0){
//                    String[] editoles = urls[1].split(",");
//                    for(String str : editoles){
//                        str = str.trim();
//                        if(userroles.contains(str)){
//                            editrole = true;
//                            break;
//                        }
//                    }
//                }else if(urls[0].indexOf("delete") > 0){
//                    String[] deleteroles = urls[1].split(",");
//                    for(String str : deleteroles){
//                        str = str.trim();
//                        if(userroles.contains(str)){
//                            deleterole = true;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        model.addAttribute("newrole", newrole);
//        model.addAttribute("editrole", editrole);
//        model.addAttribute("deleterole", deleterole);
//        model.addAttribute("user", user);
//        return "storage/index";
//    }
//
//    @RequestMapping(value="/{stroageid}")
//    public String show(ModelMap model,@PathVariable Long storageid) {
//        Storage storage = storageRepository.findOne(storageid);
//        model.addAttribute("storage",storage);
//        return "storage/show";
//    }
//
//    @RequestMapping(value = "/list")
//    @ResponseBody
//    public Page<Storage> getList(StorageQo storageQo) {
//        try {
//            Pageable pageable = new PageRequest(storageQo.getPage(), storageQo.getSize(), new Sort(Sort.Direction.ASC, "storageid"));
//            return storageRepository.findByGoodname(storageQo.getStorageid()==null?"%":"%"+storageQo.getStorageid()+"%", pageable);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @RequestMapping("/new")
//    public String create(ModelMap model,Goods good){
//        return "goods/new";
//    }
//
//    @RequestMapping(value="/save", method = RequestMethod.POST)
//    @ResponseBody
//    public String save(Goods good) throws Exception{
//        good.setCreatedate(new Date());
////        good.setcreateman(user);
//        goodsRepository.save(good);
//        logger.info("新增->ID="+good.getGoodid());
//        return "1";
//    }
//
//    @RequestMapping(value="/edit/{goodid}")
//    public String update(ModelMap model,@PathVariable Long goodid){
//        Goods good = goodsRepository.findOne(goodid);
//        List<Long> rids = new ArrayList<Long>();
//        model.addAttribute("goods",good);
//        model.addAttribute("rids", rids);
//        return "goods/edit";
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value="/update")
//    @ResponseBody
//    public String update(Goods good) throws Exception{
//        goodsRepository.save(good);
//        logger.info("修改->ID="+good.getGoodid());
//        return "1";
//    }
//
//    @RequestMapping(value="/delete/{goodid}",method = RequestMethod.GET)
//    @ResponseBody
//    public String delete(@PathVariable Long goodid) throws Exception{
//        goodsRepository.delete(goodid);
//        logger.info("删除->ID="+goodid);
//        return "1";
//    }
//}
