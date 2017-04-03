package tech.acodesigner.dao;

import tech.acodesigner.entity.Link;

import java.util.List;

/**
 * Created by 77239 on 2017/3/28/0028.
 */
public interface LinkDao {

    public Link getLinkById(int linkId);

    public List<Link> getLinks();

    public int saveLink(Link link);

    public int updateLink(Link link);

    public int deleteLink(int linkId);

}
