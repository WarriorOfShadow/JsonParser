package json.element.exception;

public class NotObjException extends ElementException {

    @Override
    public void showMessage() {
        System.out.println("不是对象类型，无法使用get方法");
    }
}
