package com.pqh.basic.email.error;

import com.pqh.basic.email.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ControllerErrorAdvice {

    /**
     * 参数验证不通过的异常处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RestResponse errorHandler(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage());
        return RestResponse.error(ServiceError.findByCode(ex.getBindingResult().getFieldError().getDefaultMessage()));
    }

    /**
     *  自定义异常，用于工作流期间产生的问题
     * @param be
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BasicEmailException.class)
    public RestResponse errorWorkflow(BasicEmailException be) {
        log.error(be.getServiceError().getErrorMessage());
        return RestResponse.error(be.getServiceError());
    }
}
