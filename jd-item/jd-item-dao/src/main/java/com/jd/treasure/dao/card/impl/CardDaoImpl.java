package com.jd.treasure.dao.card.impl;

import com.jd.treasure.dao.base.GenericBaseDaoImpl;
import com.jd.treasure.dao.card.CardDao;
import com.jd.treasure.domain.card.param.CardQuery;
import com.jd.treasure.domain.common.TreasureCard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 卡密表Dao
 * User: guohaifei
 * Date: 2015/12/9
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
@Repository("cardDao")
public class CardDaoImpl extends GenericBaseDaoImpl implements CardDao {

    /**
     * @see com.jd.treasure.dao.card.CardDao#selectCardByItem
     */
    @Override
    public TreasureCard selectCardByItem(CardQuery cardQuery){
        return executeForObject("TreasureCard.selectCardByItem",cardQuery,TreasureCard.class);
    }

    /**
     * @see com.jd.treasure.dao.card.CardDao#updateCardStatusUsed
     */
    @Override
    public int updateCardStatusUsed(Long cardId){
        return execute("TreasureCard.updateCardStatusUsed",cardId);
    }

    @Override
    public int countByCardNo(String cardNo) {
        return executeForObject("TreasureCard.countByCardNo", cardNo, Integer.class);
    }

    @Override
    public void batchInsertCard(List<TreasureCard> cardList) {
        this.execute("TreasureCard.batchInsert", cardList);
    }

    @Override
    public TreasureCard getCardByUniqueId(String uniqueId) {
        return executeForObject("TreasureCard.getCardByUniqueId", uniqueId, TreasureCard.class);
    }

    @Override
    public TreasureCard getAllById(Long id) {
        return executeForObject("TreasureCard.getAllById", id, TreasureCard.class);
    }
}
