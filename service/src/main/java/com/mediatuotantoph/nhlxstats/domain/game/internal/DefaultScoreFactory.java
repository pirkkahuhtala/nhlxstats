package com.mediatuotantoph.nhlxstats.domain.game.internal;

import org.springframework.stereotype.Component;

import com.mediatuotantoph.nhlxstats.domain.game.Score;
import com.mediatuotantoph.nhlxstats.domain.game.ScoreFactory;
import com.mediatuotantoph.nhlxstats.domain.game.Stats;

/**
 * Class for score factory implementation
 * 
 * @author Pirkka Huhtala
 *
 */
@Component
public class DefaultScoreFactory implements ScoreFactory {

    @Override
    public Score create(Stats home, Stats visitor) {
        return new Score(home, visitor);
    }

}