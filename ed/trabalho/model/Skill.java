package ed.trabalho.model;

/**
 * Skill model. Represent a skill of a Person.
 */
public class Skill {

    /**
     * Skill name.
     */
    private String skill;

    /**
     * Instantiate with parameters.
     *
     * @param skill name of skill
     */
    public Skill(String skill) {
        this.skill = skill;
    }

    /**
     * Get skill name.
     *
     * @return name of skill
     */
    public String getSkill() {
        return skill;
    }

    /**
     * Sets the skill name.
     *
     * @param skill name of skill
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * Return a string representation of a Skill
     *
     * @return a string representation of a Skill
     */
    @Override
    public String toString() {
        return this.skill;
    }
}
