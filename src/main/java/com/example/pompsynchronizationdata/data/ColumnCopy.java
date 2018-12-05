package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceColumn;
import com.example.pompsynchronizationdata.source.service.SourceColumnService;
import com.example.pompsynchronizationdata.target.entity.TargetColumn;
import com.example.pompsynchronizationdata.target.service.TargetColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/4 18:00
 * description:
 */
@Component
public class ColumnCopy extends PageHandler<SourceColumn> {
    @Autowired
    private SourceColumnService sourceColumnService;

    @Autowired
    private TargetColumnService targetColumnService;

    @Override
    protected int handleDataOfPerPage(List<SourceColumn> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');

        for (int i = 0; i < size; i++) {
            cpb.show(i);

            SourceColumn sourceColumn = list.get(i);
            Long sourceColumnId = sourceColumn.getId();
            String sourceColumnName = sourceColumn.getName();
            Integer sourceColumnOrderBy = sourceColumn.getOrderBy();
            Integer sourceColumnShowStatus = sourceColumn.getShowStatus();
            Integer sourceColumnUserId = sourceColumn.getUserId();
            LocalDateTime sourceColumnTime = sourceColumn.getTime();
            Integer sourceColumnCode = sourceColumn.getCode();
            Integer sourceColumnPosition = sourceColumn.getPosition();

            TargetColumn targetColumn = new TargetColumn();
            targetColumn.setId(sourceColumnId);
            targetColumn.setUserId(Long.valueOf(sourceColumnUserId));
            targetColumn.setColumnName(sourceColumnName);
            targetColumn.setOrderBy(sourceColumnOrderBy);
            targetColumn.setShowState(sourceColumnShowStatus);
            targetColumn.setCreatedTime(sourceColumnTime);
            targetColumn.setPosition(sourceColumnPosition);
            targetColumn.setCode(sourceColumnCode);
            targetColumn.setDeleteState(SysConst.DeleteState.UN_DELETED.getCode());
            targetColumnService.save(targetColumn);

        }
        return size;
    }

    @Override
    protected Page<SourceColumn> getPageList(int pageNumber) {
        return sourceColumnService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}
