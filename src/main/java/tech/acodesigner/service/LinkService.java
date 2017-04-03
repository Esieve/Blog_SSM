package tech.acodesigner.service;

import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.entity.Link;

import java.util.List;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
public interface LinkService {

    public OperationResult<Link> getLinkById(int linkId);

    public List<Link> getLinks();

    public OperationResult saveLink(Link link);

    public OperationResult updateLink(Link link);

    public OperationResult deleteLink(int linkId);

}
