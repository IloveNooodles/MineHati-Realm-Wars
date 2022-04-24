package com.aetherwars.models.game;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.enums.LVLSpell;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.*;
import com.aetherwars.models.extras.Type;
import com.aetherwars.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IO {
    public static final String CSV_FILE_PATH = "/com/aetherwars/card/data";
    private Map<Integer, Character> Characters;
    private Map<Integer, Spell> Spells;

    public IO() throws IOException, URISyntaxException {
        this.Characters = new HashMap<>();
        this.Spells = new HashMap<>();
        this.loadCharacter();
        this.loadSpells();
        //this.loadDeck();
    }

    public Map<Integer, Character> getCharacters() {
        return this.Characters;
    }

    public Map<Integer, Spell> getSpells() {
        return this.Spells;
    }

    private void loadCharacter() throws IOException, URISyntaxException, NullPointerException {
        URL resource = getClass().getResource(CSV_FILE_PATH + "/character.csv");
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

    private void loadSpells() throws IOException, URISyntaxException {
        final String[] kinds = {"morph", "ptn", "swap", "lvl"};
        for (String kind : kinds) {
            if (kind.equals("lvl")) {
                LVL lvl = new LVL("LVLUP", "Stonks!", "card/image/spell/lvl/lvlup.jpg", LVLSpell.LVLUP);
                this.Spells.put(401, lvl);
                LVL lvl2 = new LVL("LVLDOWN", "Not stonks!", "card/image/spell/lvl/lvldown.jpg", LVLSpell.LVLDOWN);
                this.Spells.put(402, lvl2);
                continue;
            }
            File csvFile = new File(getClass().getResource(CSV_FILE_PATH + "/spell_" + kind + ".csv").toURI());
            CSVReader reader = new CSVReader(csvFile, "\t");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                switch (kind) {
                    case "morph":
                        MORPH morph = new MORPH(line[1], line[2], line[3], this.Characters.get(Integer.valueOf(line[4])), Integer.parseInt(line[5]));
                        this.Spells.put(Integer.valueOf(line[0]), morph);
                        break;
                    case "ptn":
                        PTN ptn = new PTN(line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]));
                        this.Spells.put(Integer.valueOf(line[0]), ptn);
                        break;
                    case "swap":
                        SWAP swap = new SWAP(line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]));
                        this.Spells.put(Integer.valueOf(line[0]), swap);
                        break;
                }
            }
        }
    }
}
