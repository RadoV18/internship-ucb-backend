package ucb.internship.backend.dtos;

public class ResponseDto<T> {
    private T data;
    private String message;
    private boolean success;

    public ResponseDto(){}

    public ResponseDto(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseDto [data=" + data + ", message=" + message + ", success=" + success + "]";
    }
}
