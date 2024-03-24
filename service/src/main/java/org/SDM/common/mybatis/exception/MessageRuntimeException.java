package org.SDM.common.mybatis.exception;

public class MessageRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Object entity = null;

    public MessageRuntimeException(String message, Object entity){
        super(message);
        this.entity = entity;
    }

    public MessageRuntimeException(String message, Throwable cause, Object entity){
        super(message, cause);
        this.entity = entity;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }
}
