package it.dnd.game_elements_service.model.common;

public class AbilityModifierCalculator {

    /**
     * Calcola il modificatore di caratteristica secondo le regole di D&D 3.5.
     *
     * @param abilityScore Il punteggio di caratteristica (tipicamente tra 1 e 30)
     * @return Il modificatore di caratteristica
     */
    public static int calculateAbilityModifier(int abilityScore) {
        return (abilityScore - 10) / 2;
    }

    /**
     * Versione overloaded che accetta un punteggio di caratteristica come stringa.
     *
     * @param abilityScore Il punteggio di caratteristica come stringa
     * @return Il modificatore di caratteristica
     * @throws NumberFormatException se la stringa non può essere convertita in un intero
     */
    public static int calculateAbilityModifier(String abilityScore) throws NumberFormatException {
        return calculateAbilityModifier(Integer.parseInt(abilityScore));
    }
}