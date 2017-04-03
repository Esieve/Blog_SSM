package tech.acodesigner.service;

import tech.acodesigner.dto.AboutDto;
import tech.acodesigner.dto.OperationResult;

/**
 * Created by 77239 on 2017/4/2/0002.
 */
public interface AboutService {

    public AboutDto getAbout();

    public OperationResult updateAbout(String content);

}
