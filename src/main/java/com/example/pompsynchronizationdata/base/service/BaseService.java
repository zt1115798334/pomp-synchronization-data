package com.example.pompsynchronizationdata.base.service;

import com.example.pompsynchronizationdata.custom.SysConst;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/9 11:40
 * description:
 */
public interface BaseService<T> {


    /**
     * 未删除
     */
    Integer UN_DELETED = SysConst.DeleteState.UN_DELETED.getCode();

    /**
     * 删除
     */
    Integer DELETED = SysConst.DeleteState.DELETE.getCode();

    /**
     * 隐藏
     */
    Integer HIDE = SysConst.ShowState.HIDE.getCode();

    /**
     * 显示
     */
    Integer DISPLAY = SysConst.ShowState.DISPLAY.getCode();

    /**
     * 置顶
     */
    Integer TOP = SysConst.TopState.TOP.getCode();

    /**
     * 不置顶
     */
    Integer UN_TOP = SysConst.TopState.UN_TOP.getCode();

    /**
     * 关
     */
    Integer OFF = SysConst.EnabledState.OFF.getCode();

    /**
     * 开
     */
    Integer ON = SysConst.EnabledState.ON.getCode();

    default T save(T t) {
        return null;
    }

    default Iterable<T> saveAll(Iterable<T> t) {
        return t;
    }


    default Page<T> findPageByEntity(int pageNumber, int pageSize) {
        return null;
    }

    default Optional<T> findById(Long id) {
        return Optional.empty();
    }

}
