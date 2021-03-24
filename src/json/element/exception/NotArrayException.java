package json.element.exception;

public class NotArrayException extends ElementException {

    @Override
    public void showMessage() {
        System.out.println("不是Array类型，无法使用at方法");
    }
}
