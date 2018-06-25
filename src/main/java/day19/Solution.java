package day19;

import common.PuzzleInput;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String... args) {
        List<String> lines = PuzzleInput.read("/day19.txt").lines();

        MoleculeGenerator generator = new MoleculeGenerator();
        String molecule = "";

        for (String line : lines) {
            if (line.contains("=>")) {
                String[] parts = line.split(" => ");
                generator.addReplacement(parts[0], parts[1]);
            } else if (!line.isEmpty()) {
                molecule = line;
            }
        }

        Set<String> generatedMolecules = generator.from(molecule);
        System.out.println("There are " + generatedMolecules.size() + " generated molecules");
    }

}
