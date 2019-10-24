package bupt.fnl.dht.controller;

import bupt.fnl.dht.controller.ViewModel.IdentityViewModel;
import bupt.fnl.dht.pojo.Identity;
import bupt.fnl.dht.service.IdentityService;
import bupt.fnl.dht.service.NodeListService;
import bupt.fnl.dht.service.serviceModel.IdentityServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/test")
public class htmlController {
    @Autowired
    private IdentityService identityService;
    @Autowired
    private NodeListService nodeListService;

    public IdentityViewModel convertFromServiceModel(IdentityServiceModel serviceModel) {
        IdentityViewModel result = new IdentityViewModel();
        BeanUtils.copyProperties(serviceModel, result);
        return result;
    }

    @RequestMapping(value = "/query")
    public String queryByIdentity(String prefix, String suffix, Map<String, Object> map) {
        Identity in = new Identity();
        in.setTop(prefix);
        in.setSecond(suffix);
        IdentityServiceModel serviceModel = identityService.queryByIdentity(in);
        IdentityViewModel result = convertFromServiceModel(serviceModel);
        map.put("result", result);
        return "result";
    }

    @RequestMapping(value = "/parameter")
    public String operationType() {
        return "operation_type_selection";
    }

    @RequestMapping(value = "/querypara")
    public String queryParameter() {
        return "query_input";
    }

    @RequestMapping(value = "/addpara")
    public String addParameter() {
        return "add_input";
    }

    @RequestMapping(value = "/deletepara")
    public String deleteParameter() {
        return "delete_input";
    }

    @RequestMapping(value = "/updatepara")
    public String updateParameter() {
        return "update_input";
    }

   /* @RequestMapping(value = "/query")
    public String query() {
        //HttpServletRequest request --> request.getParameter 获取参数值
        //将查询结果放入model中
        return "query_result";
    }*/

    @RequestMapping(value = "/add")
    public String add() {
        //HttpServletRequest request --> request.getParameter 获取参数值
        //将查询结果放入model中
        return "add_result";
    }

    @RequestMapping(value = "/update")
    public String update() {
        //HttpServletRequest request --> request.getParameter 获取参数值
        //将查询结果放入model中
        return "update_result";
    }

    @RequestMapping(value = "/delete")
    public String delete() {
        //HttpServletRequest request --> request.getParameter 获取参数值
        //将查询结果放入model中
        return "delete_result";
    }


}