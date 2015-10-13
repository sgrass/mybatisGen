package com.iever.dao;

import com.iever.model.EveryDaySpecial;
import java.util.List;

public interface EveryDaySpecialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EveryDaySpecial everyDaySpecial);

    List<EveryDaySpecial> selectByParam(EveryDaySpecial everyDaySpecial);

    EveryDaySpecial selectByPrimaryKey(Integer id);

    int updateById(EveryDaySpecial everyDaySpecial);
}