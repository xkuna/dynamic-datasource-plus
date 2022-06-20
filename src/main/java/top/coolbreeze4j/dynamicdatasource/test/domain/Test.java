package top.coolbreeze4j.dynamicdatasource.test.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CoolBreeze
 * @date 2022/6/20 15:59.
 */
@Data
public class Test implements Serializable {
    private static final long serialVersionUID = -8563927982531381459L;

    private String id;
    private String name;
}
