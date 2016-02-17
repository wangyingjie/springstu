package com.jd.treasureshop.web.com.jd.dao;

import com.google.common.collect.Lists;
import com.jd.treasure.dao.card.CardDao;
import com.jd.treasure.domain.common.TreasureCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by wangyingjie1 on 2016/2/5.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config-test.xml")
public class TestTreasureCardDao {

    @Autowired
    @Qualifier("cardDao")
    private CardDao cardDao;

    @Test
    public void testInsert() {

        List<TreasureCard> cardList = Lists.newArrayList();
        for (long i=0; i<2; i++) {
            TreasureCard card = new TreasureCard();
            //card.setId(Long.valueOf(new Random().nextInt()));
            card.setItemId(i);
            card.setItemType(Integer.valueOf(100));
            card.setCreated(new Date());
            card.setCardNumber("812345600000111111");
            card.setCardPassword("11111111111");
            cardList.add(card);
        }

        cardDao.batchInsertCard(cardList);
    }
}
