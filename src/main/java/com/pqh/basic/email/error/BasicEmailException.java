package com.pqh.basic.email.error;

/**
 * @ClassName: BasicWorkflowException
 * @Description:
 * @Author: jackson
 * @Date: 2019/11/12 14:37
 * @Version: v1.0
 */
public class BasicEmailException extends RuntimeException {

    private static final long serialVersionUID = -4742832112872227456L;

    private ServiceError serviceError;

    public BasicEmailException() {
        super();
    }

    public BasicEmailException(ServiceError serviceError) {
        this.serviceError = serviceError;
    }

    public BasicEmailException(String message, ServiceError serviceError) {
        super(message);
        this.serviceError = serviceError;
    }

    public BasicEmailException(Throwable cause, ServiceError serviceError) {
        super(cause);
        this.serviceError = serviceError;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ServiceError getServiceError() {
        return serviceError;
    }

    public void setServiceError(ServiceError serviceError) {
        this.serviceError = serviceError;
    }
}
