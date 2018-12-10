package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:04
 * description:
 */
@Data
@Entity
@Table(name = "t_message_read")
public class SourceMessageRead {

    @EmbeddedId
    private SourceMessageReadKey id;
    /**
     *
     */
    private LocalDateTime time;


}
