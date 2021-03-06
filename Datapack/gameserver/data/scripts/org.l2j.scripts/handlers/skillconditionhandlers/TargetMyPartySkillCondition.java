/*
 * Copyright © 2019-2020 L2JOrg
 *
 * This file is part of the L2JOrg project.
 *
 * L2JOrg is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * L2JOrg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package handlers.skillconditionhandlers;

import org.l2j.gameserver.engine.skill.api.Skill;
import org.l2j.gameserver.engine.skill.api.SkillCondition;
import org.l2j.gameserver.model.Party;
import org.l2j.gameserver.model.WorldObject;
import org.l2j.gameserver.model.actor.Creature;

import static org.l2j.gameserver.util.GameUtils.isPlayer;

/**
 * @author UnAfraid
 * @author JoeAlisson
 */
public class TargetMyPartySkillCondition implements SkillCondition {

    public final boolean includeCaster;

    protected TargetMyPartySkillCondition(boolean includeCaster) {
        this.includeCaster = includeCaster;
    }

    @Override
    public boolean canUse(Creature caster, Skill skill, WorldObject target) {

        if (!isPlayer(target)) {
            return false;
        }

        final Party party = caster.getParty();
        final Party targetParty = target.getActingPlayer().getParty();
        return ((party == null) ? (includeCaster && (caster == target)) : (includeCaster ? party == targetParty : (party == targetParty) && (caster != target)));
    }
}
