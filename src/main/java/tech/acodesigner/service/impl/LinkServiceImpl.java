package tech.acodesigner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.acodesigner.dao.LinkDao;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.entity.Link;
import tech.acodesigner.service.LinkService;

import java.util.List;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;

    public OperationResult<Link> getLinkById(int linkId) {
        OperationResult<Link> or = new OperationResult<Link>();
        Link link = linkDao.getLinkById(linkId);
        if (link == null) {
            or.setSuccess(false);
            or.setInfo("该链接不存在");
        } else {
            or.setSuccess(true);
            or.setData(link);
        }
        return or;
    }

    public List<Link> getLinks() {
        return linkDao.getLinks();
    }

    public OperationResult saveLink(Link link) {
        OperationResult or = new OperationResult();
        int result = linkDao.saveLink(link);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("添加链接失败");
        } else {
            or.setSuccess(true);
            or.setInfo("添加链接成功");
        }
        return or;
    }

    public OperationResult updateLink(Link link) {
        OperationResult or = new OperationResult();
        int result = linkDao.updateLink(link);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("修改链接失败");
        } else {
            or.setSuccess(true);
            or.setInfo("修改链接成功");
        }
        return or;
    }

    public OperationResult deleteLink(int linkId) {
        OperationResult or = new OperationResult();
        int result = linkDao.deleteLink(linkId);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("删除链接失败");
        } else {
            or.setSuccess(true);
            or.setInfo("删除链接成功");
        }
        return or;
    }

}
