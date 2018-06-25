package day19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class MoleculeGenerator {

    private final Collection<Replacement> replacements;

    MoleculeGenerator() {
        replacements = new ArrayList<>();
    }

    private static class Replacement {

        private final String original;
        private final String replacement;

        Replacement(String original, String replacement) {
            this.original = original;
            this.replacement = replacement;
        }

        Set<String> applyTo(String molecule) {
            Set<String> alternatives = new HashSet<>();
            int sequencePosition = molecule.indexOf(original);
            while (sequencePosition >= 0) {
                alternatives.add(replaceSequence(molecule, sequencePosition));
                sequencePosition = molecule.indexOf(original, sequencePosition + 1);
            }

            return alternatives;
        }

        private String replaceSequence(String molecule, int sequencePosition) {
            if (sequencePosition == 0) {
                return replacement + molecule.substring(original.length());
            } else if (sequencePosition == molecule.length() - original.length()) {
                return molecule.substring(0, molecule.length() - original.length()) + replacement;
            } else {
                return molecule.substring(0, sequencePosition) + replacement + molecule.substring(sequencePosition + original.length());
            }
        }

    }

    void addReplacement(String original, String replacement) {
        replacements.add(new Replacement(original, replacement));
    }

    Set<String> from(String molecule) {
        Set<String> generated = new HashSet<>();
        for (Replacement replacement : replacements) {
            generated.addAll(replacement.applyTo(molecule));
        }
        return generated;
    }

}
