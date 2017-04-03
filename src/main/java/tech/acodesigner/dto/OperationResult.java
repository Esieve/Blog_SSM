package tech.acodesigner.dto;

/**
 * Created by 77239 on 2017/4/2/0002.
 */
public class OperationResult<T> {

    private boolean success;
    private String info;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
