package tech.acodesigner.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesigner.entity.Link;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 77239 on 2017/3/28/0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/dao.xml"})
public class LinkDaoTest {

    @Autowired
    private LinkDao linkDao;

    @Test
    public void getLinkById() throws Exception {
        Link link = linkDao.getLinkById(1);
        System.out.println(link.getLinkName());
    }

    @Test
    public void getLinks() throws Exception {
        List<Link> links = linkDao.getLinks();
        for (Link link : links) {
            System.out.println(link.getLinkName());
        }
    }

    @Test
    public void saveLink() throws Exception {
        Link link = new Link();
        link.setLinkName("444");
        link.setUrl("444");
        int result = linkDao.saveLink(link);
        System.out.println(result);
    }

    @Test
    public void updateLink() throws Exception {
        Link link = new Link();
        link.setLinkId(1);
        link.setLinkName("444");
        link.setUrl("444");
        int result = linkDao.updateLink(link);
        System.out.println(result);
    }

    @Test
    public void deleteLink() throws Exception {
        int result = linkDao.deleteLink(6);
        System.out.println(result);
    }

}