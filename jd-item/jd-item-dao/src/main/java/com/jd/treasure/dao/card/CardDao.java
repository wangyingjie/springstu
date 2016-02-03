package com.jd.treasure.dao.card;

import com.jd.treasure.domain.card.param.CardQuery;
import com.jd.treasure.domain.common.TreasureCard;

import java.util.List;

/**
 * 卡密表Dao
 * User: guohaifei
 * Date: 2015/12/9
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public interface CardDao {
    /**
     * 根据夺宝项查找绑定的卡密
     * @param cardQuery
     * @return
     */
    TreasureCard selectCardByItem(CardQuery cardQuery);

    /**
     * 更新卡密状态为已使用
     * @param cardId
     * @return
     */
    int updateCardStatusUsed(Long cardId);

    /**
     * 查询卡号记录数
     * @param cardNo
     * @return
     */
    int countByCardNo(String cardNo);

    /**
     * 批量插入卡密信息
     * @param cardList
     */
    void batchInsertCard(List<TreasureCard> cardList);

    /**
     * 根据uuid查询卡密信息
     * @param uniqueId
     * @return
     */
    TreasureCard getCardByUniqueId(String uniqueId);

    /**
     * 根据id
     * @param id
     * @return
     */
    TreasureCard getAllById(Long id);
}
