package com.aetherwars.models.game;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.enums.LVLSpell;
import com.aetherwars.exception.InvalidNumberException;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.*;
import com.aetherwars.models.extras.Type;
import com.aetherwars.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class IO {
    public static final String DATA_FILE_PATH = "/com/aetherwars/card/data";
    private final Map<Integer, Character> Characters;
    private final Map<Integer, Spell> Spells;

    public IO(Player player1, Player player2) throws IOException, URISyntaxException, InvalidNumberException {
        this.Characters = new HashMap<>();
        this.Spells = new HashMap<>();
        this.loadCharacter();
        this.loadSpells();
        this.loadDeck(player1);
        this.loadDeck(player2);
    }

    public Map<Integer, Character> getCharacters() {
        return this.Characters;
    }

    public Map<Integer, Spell> getSpells() {
        return this.Spells;
    }

    private void loadCharacter() throws IOException, URISyntaxException, NullPointerException {
        URL resource = getClass().getResource(DATA_FILE_PATH + "/character.csv");
        assert resource != null;
        File characterCSVFile = new File(resource.toURI());
        CSVReader reader = new CSVReader(characterCSVFile, "\t");
        reader.setSkipHeader(true);
        List<String[]> lines = reader.read();
        for (String[] line : lines) {
            Character chara = new Character(
                    line[1],
                    line[3],
                    Type.getInstance(CharacterType.valueOf(line[2])),
                    line[4],
                    Integer.parseInt(line[5]),
                    Integer.parseInt(line[6]),
                    Integer.parseInt(line[7]),
                    Integer.parseInt(line[8]),
                    Integer.parseInt(line[9])
            );
            this.Characters.put(Integer.valueOf(line[0]), chara);
        }
    }

    private void loadSpells() throws IOException, URISyntaxException, InvalidNumberException {
        final String[] kinds = {"morph", "ptn", "swap", "lvl"};
        for (String kind : kinds) {
            if (kind.equals("lvl")) {
                LVL lvl = new LVL("LVLUP", "Stonks!", "card/image/spell/lvl/lvlup.jpg", LVLSpell.LVLUP);
                this.Spells.put(401, lvl);
                LVL lvl2 = new LVL("LVLDOWN", "Not stonks!", "card/image/spell/lvl/lvldown.png", LVLSpell.LVLDOWN);
                this.Spells.put(402, lvl2);
                continue;
            }
            URL resource = getClass().getResource(DATA_FILE_PATH + "/spell_" + kind + ".csv");
            assert resource != null;
            File csvFile = new File(resource.toURI());
            CSVReader reader = new CSVReader(csvFile, "\t");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                switch (kind) {
                    case "morph":
                        MORPH morph = new MORPH(
                                line[1],
                                line[2],
                                line[3],
                                this.Characters.get(Integer.valueOf(line[4])),
                                Integer.parseInt(line[5])
                        );
                        this.Spells.put(Integer.valueOf(line[0]), morph);
                        break;
                    case "ptn":
                        PTN ptn = new PTN(
                                line[1],
                                line[2],
                                line[3],
                                Integer.parseInt(line[4]),
                                Integer.parseInt(line[5]),
                                Integer.parseInt(line[6]),
                                Integer.parseInt(line[7])
                        );
                        this.Spells.put(Integer.valueOf(line[0]), ptn);
                        break;
                    case "swap":
                        SWAP swap = new SWAP(
                                line[1],
                                line[2],
                                line[3],
                                Integer.parseInt(line[4]),
                                Integer.parseInt(line[5])
                        );
                        this.Spells.put(Integer.valueOf(line[0]), swap);
                        break;
                }
            }
        }
    }

    private void loadDeck(Player player) throws IOException, URISyntaxException {
        Random rand = new Random();
        URL resource = getClass().getResource(DATA_FILE_PATH + "/deck_" + player.getName() + ".txt");
        assert resource != null;
        int totalCharacter = 0;
        int totalSpell = 0;
        List<String> lines = Files.readAllLines(Paths.get(resource.toURI()), StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            if (Integer.parseInt(lines.get(i)) >= 100) {
                player.getDeck().add(this.Spells.get(Integer.parseInt(lines.get(i))).createCard());
                totalSpell++;
            } else {
                player.getDeck().add(this.Characters.get(Integer.parseInt(lines.get(i))).createCard());
                totalCharacter++;
            }
        }
        if (totalSpell + totalCharacter > 45) {
            return;
        }
        int remaining = 45 - totalSpell - totalCharacter;
        int remainingCharacter = 20 - totalCharacter;
        if (remainingCharacter < 0) {
            remainingCharacter = 0;
        }
        int remainingSpell = remaining - remainingCharacter;
        for (int i = 0; i < remainingCharacter; i++) {
            int x = rand.nextInt(18) + 1;
            player.getDeck().add(this.Characters.get(x).createCard());
        }
        for (int i = 0; i < remainingSpell; i++) {
            int type_spell = rand.nextInt(4) + 1;
            if (type_spell == 1) {
                int new_spell = rand.nextInt(18) + 1;
                player.getDeck().add(this.Spells.get(100*type_spell + new_spell).createCard());
            }
            else if (type_spell == 2) {
                int new_spell = rand.nextInt(10) + 1;
                player.getDeck().add(this.Spells.get(100*type_spell + new_spell).createCard());
            }
            else if (type_spell == 3) {
                int new_spell = rand.nextInt(6) + 1;
                player.getDeck().add(this.Spells.get(100*type_spell + new_spell).createCard());
            }
            else if (type_spell == 4) {
                int new_spell = rand.nextInt(2) + 1;
                player.getDeck().add(this.Spells.get(100*type_spell + new_spell).createCard());
            }
        }
        player.getDeck().shuffle();
    }
}
