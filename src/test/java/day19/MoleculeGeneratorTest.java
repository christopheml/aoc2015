package day19;

import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoleculeGeneratorTest {


    @Test
    void acceptance_test() {
        MoleculeGenerator generator = new MoleculeGenerator();
        generator.addReplacement("H", "HO");
        generator.addReplacement("H", "OH");
        generator.addReplacement("O", "HH");

        Set<String> molecules = generator.from("HOH");
        assertThat(molecules).containsExactlyInAnyOrder("HOOH", "HOHO", "OHOH", "HHHH");
    }

}
