package com.lyf.common.utils;

import com.lyf.common.enums.ErrorCode;
import com.lyf.common.exception.AppException;
import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;

public class ValidUtil {


    public static <T> void validate(@Valid T t) {
        Set<ConstraintViolation<@Valid T>> validateSet = Validation.buildDefaultValidatorFactory()
                .getValidator().validate(t, new Class[0]);
        if (!CollectionUtils.isEmpty(validateSet)) {
            throw new AppException(ErrorCode.ERR0001);
        }
    }


}
