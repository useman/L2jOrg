package org.l2j.gameserver.model.events.impl.character.player;

import org.l2j.gameserver.enums.ShotType;
import org.l2j.gameserver.model.actor.Playable;
import org.l2j.gameserver.model.actor.instance.Player;
import org.l2j.gameserver.model.events.EventType;
import org.l2j.gameserver.model.events.impl.IBaseEvent;

import static org.l2j.gameserver.model.events.EventType.ON_PLAYER_CHARGE_SHOTS;

/**
 * @author JoeAlisson
 */
public class OnPlayeableChargeShots implements IBaseEvent {

    private final Playable playable;
    private final ShotType shotType;

    public OnPlayeableChargeShots(Playable playable, ShotType shotType) {
        this.playable = playable;
        this.shotType = shotType;
    }

    public Playable getPlayable() {
        return playable;
    }

    public ShotType getShotType() {
        return shotType;
    }

    @Override
    public EventType getType() {
        return ON_PLAYER_CHARGE_SHOTS;
    }
}