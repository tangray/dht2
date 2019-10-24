package bupt.fnl.dht.controller;

import bupt.fnl.dht.controller.ViewModel.IdentityViewModel;
import bupt.fnl.dht.pojo.Identity;
import bupt.fnl.dht.pojo.NodeAlive;
import bupt.fnl.dht.service.IdentityService;
import bupt.fnl.dht.service.NodeListService;
import bupt.fnl.dht.service.serviceModel.IdentityServiceModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/admin")
public class Controller {
    @Autowired
    private IdentityService identityService;
    @Autowired
    private NodeListService nodeListService;

    public IdentityViewModel convertFromServiceModel(IdentityServiceModel serviceModel) {
        IdentityViewModel result = new IdentityViewModel();
        BeanUtils.copyProperties(serviceModel, result);
        return result;
    }

    public List<IdentityViewModel> convertFromServiceModelList(List<IdentityServiceModel> list) {
        List<IdentityViewModel> result = new ArrayList<IdentityViewModel>();
        for (IdentityServiceModel i : list) {
            IdentityViewModel temp = new IdentityViewModel();
            BeanUtils.copyProperties(i, temp);
            result.add(temp);
        }
        return result;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Map<String, Object> queryByIdentity(String top, String second) {
        Map<String, Object> result = new HashMap<String, Object>();
        Identity in = new Identity();
        in.setTop(top);
        in.setSecond(second);
        IdentityServiceModel serviceModel = identityService.queryByIdentity(in);
        result.put("result", convertFromServiceModel(serviceModel));
        return result;
    }

    @Async("webTaskExecutor")
    @RequestMapping(value = "/queryall", method = RequestMethod.GET)
    public Map<String, Object> queryAll() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<IdentityServiceModel> list = identityService.queryAll();
        result.put("全部映射", convertFromServiceModelList(list));
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(String top, String second) {
        Identity del = new Identity();
        del.setTop(top);
        del.setSecond(second);
        int receice = identityService.deleteByIdentity(del);
        if (receice > 0) {
            return "删除成功";
        } else {
            return "删除失败，标识不存在";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(String top, String second, String content) {
        Identity ins = new Identity();
        ins.setTop(top);
        ins.setSecond(second);
        ins.setUrl(content);
        ins.setCreateDate(new Date());
        ins.setUpdateDate(new Date());
        int receive = identityService.insert(ins);
        if (receive > 0) {
            return "插入成功";
        } else {
            return "插入失败";
        }
    }

    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public String update(String top, String second, String content) {
        Identity ins = new Identity();
        ins.setTop(top);
        ins.setSecond(second);
        ins.setUrl(content);
        ins.setUpdateDate(new Date());
        int receive = identityService.updateByIdentity(ins);
        if (receive > 0) {
            return "更新成功";
        } else {
            return "更新失败,标识不存在";
        }
    }

    @RequestMapping(value = "/querynodelist", method = RequestMethod.GET)
    public List<NodeAlive> queryNodeList() {
        return nodeListService.selectAll();
    }
}
